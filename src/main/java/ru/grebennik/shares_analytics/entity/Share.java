package ru.grebennik.shares_analytics.entity;

import javax.persistence.*;

@Entity
@Table(name = "shares")
public class Share {

    @Id
    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name")
    private String name;

    @Column(name = "share_type")
    private String type;

    @Column(name = "years_pay_dividend")
    private int yearsPayDiv;

    @Column(name = "all_time_average_div_growth")
    private double averageDivGrowth;

    public Share() {
    }

    public Share(String ticker, String name, String type, int yearsPayDiv, double averageDivGrowth) {
        this.ticker = ticker;
        this.name = name;
        this.type = type;
        this.yearsPayDiv = yearsPayDiv;
        this.averageDivGrowth = averageDivGrowth;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearsPayDiv() {
        return yearsPayDiv;
    }

    public void setYearsPayDiv(int yearsPayDiv) {
        this.yearsPayDiv = yearsPayDiv;
    }

    public double getAverageDivGrowth() {
        return averageDivGrowth;
    }

    public void setAverageDivGrowth(double averageDivGrowth) {
        this.averageDivGrowth = averageDivGrowth;
    }

    @Override
    public String toString() {
        return "Share{" +
                "ticker='" + ticker + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
