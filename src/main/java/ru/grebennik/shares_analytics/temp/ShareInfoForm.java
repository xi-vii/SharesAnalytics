package ru.grebennik.shares_analytics.temp;

import ru.grebennik.shares_analytics.entity.Share;
import ru.grebennik.shares_analytics.entity.ShareGrowthHistory;

public class ShareInfoForm {

    private Share share;
    private ShareGrowthHistory growthHistory;

    public ShareInfoForm() {
    }

    public ShareInfoForm(Share share, ShareGrowthHistory growthHistory) {
        this.share = share;
        this.growthHistory = growthHistory;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public ShareGrowthHistory getGrowthHistory() {
        return growthHistory;
    }

    public void setGrowthHistory(ShareGrowthHistory growthHistory) {
        this.growthHistory = growthHistory;
    }
}
