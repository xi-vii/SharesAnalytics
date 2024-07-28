package ru.grebennik.shares_analytics.service;

import ru.grebennik.shares_analytics.entity.Share;
import ru.grebennik.shares_analytics.entity.ShareGrowthHistory;

import java.util.List;

public interface ShareService {

    public List<Share> getAllShares();

    public void saveShare(Share share);

    public void deleteShare(String ticker);

    public Share getShareByTicker(String ticker);

    public ShareGrowthHistory getGrowthHistoryByTicker(String ticker);
}
