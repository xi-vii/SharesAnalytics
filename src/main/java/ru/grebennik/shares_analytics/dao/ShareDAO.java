package ru.grebennik.shares_analytics.dao;

import ru.grebennik.shares_analytics.entity.Share;
import ru.grebennik.shares_analytics.entity.ShareGrowthHistory;
import ru.grebennik.shares_analytics.temp.ShareInfoForm;

import java.util.List;

public interface ShareDAO {

    public List<Share> getAllShares();

    public void saveShare(Share share, ShareGrowthHistory growthHistory);

    public void deleteShare(String ticker);

    public ShareInfoForm getShareByTicker(String ticker);

    public ShareGrowthHistory getGrowthHistoryByTicker(String ticker);
}
