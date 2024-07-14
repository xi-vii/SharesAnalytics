package ru.grebennik.shares_analytics.dao;

import ru.grebennik.shares_analytics.entity.Share;

import java.util.List;

public interface ShareDAO {

    public List<Share> getAllShares();
}
