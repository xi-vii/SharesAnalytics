package ru.grebennik.shares_analytics.entity;

import javax.persistence.*;

@Entity
@Table(name = "history_growth_data")
public class ShareGrowthHistory {

    @Id
    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name")
    private String name;

    @Column(name = "growth_from_00_till_10")
    private double growthFrom00To10;

    @Column(name = "growth_from_10_till_20")
    private double growthFrom10To20;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "ticker")    // Без этой аннотации почему-то выдавало ошибку, что столбец не существет
    private Share share;

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public ShareGrowthHistory() {
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrowthFrom00To10() {
        return growthFrom00To10;
    }

    public void setGrowthFrom00To10(double growthFrom00To10) {
        this.growthFrom00To10 = growthFrom00To10;
    }

    public double getGrowthFrom10To20() {
        return growthFrom10To20;
    }

    public void setGrowthFrom10To20(double growthFrom10To20) {
        this.growthFrom10To20 = growthFrom10To20;
    }

    @Override
    public String toString() {
        return "ShareGrowthHistory{" +
                "ticker= '" + ticker + '\'' +
                ", name= '" + name + '\'' +
                ", growthFrom00To10= " + growthFrom00To10 +
                ", growthFrom10To20= " + growthFrom10To20 +
                '}';
    }
}
