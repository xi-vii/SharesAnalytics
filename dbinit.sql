CREATE TABLE shares (
    ticker VARCHAR(6) NOT NULL PRIMARY KEY,
    name CHARACTER(50) NOT NULL,
    years_pay_dividend INTEGER,
    all_time_average_div_growth DOUBLE PRECISION,
    share_type VARCHAR(9),
    test_field INTEGER
                    );

INSERT INTO shares(ticker, name, years_pay_dividend, all_time_average_div_growth, share_type, test_field) VALUES
                                                                                                              ('KAZTP', 'Kuybishevazot', '12', '60.90', 'preferred', 777);