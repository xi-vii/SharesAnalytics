CREATE TABLE shares (
    ticker VARCHAR(6) NOT NULL PRIMARY KEY,
    name CHARACTER(50) NOT NULL,
    years_pay_dividend INTEGER,
    all_time_average_div_growth DOUBLE PRECISION,
    share_type VARCHAR(9)
                    );

INSERT INTO shares(ticker, name, years_pay_dividend, all_time_average_div_growth, share_type) VALUES
                                                            ('KAZTP', 'Kuybishevazot', '12', '60.90', 'preferred');

CREATE TABLE history_growth_data (
    ticker VARCHAR(6) NOT NULL PRIMARY KEY,
    name CHARACTER(50) NOT NULL,
    growth_from_00_till_10 DOUBLE PRECISION default 0.0,
    growth_from_10_till_20 DOUBLE PRECISION default 0.0,
    FOREIGN KEY (ticker) REFERENCES shares (ticker)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

INSERT INTO history_growth_data(ticker, name, growth_from_00_till_10, growth_from_10_till_20) VALUES
                                                                            ('KAZTP', 'Kuybishevazot', 0.0, 11206.67);