package ru.grebennik.shares_analytics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.grebennik.shares_analytics.entity.Share;
import ru.grebennik.shares_analytics.entity.ShareGrowthHistory;
import ru.grebennik.shares_analytics.temp.ShareInfoForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

@Repository
public class ShareDAOImpl implements ShareDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Share> getAllShares() {

        // Получаем сессию
        Session session = sessionFactory.getCurrentSession();

        // С помощью Criteria API формируем запрос и получаем список всех алементов из БД
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Share> critQuery = builder.createQuery(Share.class);

        critQuery.select(critQuery.from(Share.class));  // - непосредственно сам запрос

        Query<Share> query = session.createQuery(critQuery);
        List<Share> allShares = query.getResultList();  // - список акций

        return allShares;
    }

    @Override
    public void saveShare(Share share, ShareGrowthHistory growthHistory) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(share);

        // Почему-то для класса ShareGrowthHistory просто saveOrUpdate не работает. Выдаёт ошибку. Пришлось разделить
        // на 2 метода. Проверяем, есть ли такой тикер в таблице. Если нет, сохраняем; если есть,
        // обновляем (через merge, т.к. Hibernate не даёт выполнить update, т.к. объект использовался в запросе к БД
        // в этой же сессии.
        if (doesTickerExist(share)) {
            session.save(growthHistory);
        } else {
            session.merge(growthHistory);
        }
    }


    @Override
    public void deleteShare(String ticker) {

        Session session = sessionFactory.getCurrentSession();

        // Удаляем объект из каждой таблицы (почему не работает Cascade, пока не понял)
        deleteShareFromShareGrowHistoryTable(session, ticker);
        deleteShareFromShareTable(session, ticker);
    }

    @Override
    public ShareInfoForm getShareByTicker(String ticker) {

        Session session = sessionFactory.getCurrentSession();
        Share share = session.get(Share.class, ticker);
        ShareGrowthHistory growthHistory = session.get(ShareGrowthHistory.class, ticker);

        ShareInfoForm shareInfoForm = new ShareInfoForm(share, growthHistory);

        return shareInfoForm;
    }

    @Override
    public ShareGrowthHistory getGrowthHistoryByTicker(String ticker) {

        Session session = sessionFactory.getCurrentSession();
        System.out.println(ticker);
        ShareGrowthHistory growthHistory = session.get(ShareGrowthHistory.class, ticker);

        return growthHistory;
    }

    // Метод проверяет, есть ли тикер в таблице ShareGrowthHistory
    private boolean doesTickerExist(Share share) {
        Session session = sessionFactory.getCurrentSession();

        String ticker = share.getTicker();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ShareGrowthHistory> critQuery = builder.createQuery(ShareGrowthHistory.class);
        Root<ShareGrowthHistory> root = critQuery.from(ShareGrowthHistory.class);

        critQuery.select(root).
                where(builder.equal(root.get("ticker"),ticker));

        Query<ShareGrowthHistory> query = session.createQuery(critQuery);
        List<ShareGrowthHistory> growthHistoryList = query.getResultList(); // Получаем список из акций с нужным тикером

        return growthHistoryList.isEmpty();
    }

    // Вспомогательный метод для удаления акции из таблицы Share
    private void deleteShareFromShareTable(Session session, String ticker) {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaDelete<Share> criteriaDelete = builder.createCriteriaDelete(Share.class);
        Root<Share> root2 = criteriaDelete.from(Share.class);

        criteriaDelete.where(builder.equal(root2.get("ticker"), ticker));

        session.createQuery(criteriaDelete).executeUpdate();
    }

    // Вспомогательный метод для удаления акции из таблицы ShareGrowHistory
    private void deleteShareFromShareGrowHistoryTable(Session session, String ticker) {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaDelete<ShareGrowthHistory> criteriaDelete = builder.createCriteriaDelete(ShareGrowthHistory.class);
        Root<ShareGrowthHistory> root = criteriaDelete.from(ShareGrowthHistory.class);

        criteriaDelete.where(builder.equal(root.get("ticker"), ticker));

        session.createQuery(criteriaDelete).executeUpdate();
    }
}
