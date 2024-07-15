package ru.grebennik.shares_analytics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.grebennik.shares_analytics.entity.Share;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

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
}
