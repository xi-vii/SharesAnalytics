package ru.grebennik.shares_analytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.grebennik.shares_analytics.dao.ShareDAO;
import ru.grebennik.shares_analytics.entity.Share;
import ru.grebennik.shares_analytics.entity.ShareGrowthHistory;
import ru.grebennik.shares_analytics.temp.ShareInfoForm;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareDAO shareDAO;

    @Override
    @Transactional
    public List<Share> getAllShares() {
        return shareDAO.getAllShares();
    }

    @Override
    @Transactional
    public void saveShare(Share share, ShareGrowthHistory growthHistory) {
        shareDAO.saveShare(share, growthHistory);
    }

    @Override
    @Transactional
    public void deleteShare(String ticker) {
        shareDAO.deleteShare(ticker);
    }

    @Override
    @Transactional
    public ShareInfoForm getShareByTicker(String ticker) {
        return shareDAO.getShareByTicker(ticker);
    }

    @Override
    @Transactional
    public ShareGrowthHistory getGrowthHistoryByTicker(String ticker) {
        return shareDAO.getGrowthHistoryByTicker(ticker);
    }
}
