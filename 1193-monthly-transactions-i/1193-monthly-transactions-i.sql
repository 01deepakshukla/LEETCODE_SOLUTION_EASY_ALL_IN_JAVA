SELECT
    DATE_FORMAT(trans_date, '%Y-%m') AS month,   -- convert date to yyyy-mm
    country,
    COUNT(*) AS trans_count,                      -- total number of transactions
    SUM(CASE WHEN state = 'approved' THEN 1 ELSE 0 END) AS approved_count,  -- approved transactions
    SUM(amount) AS trans_total_amount,           -- total amount of all transactions
    SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) AS approved_total_amount  -- total approved amount
FROM Transactions
GROUP BY DATE_FORMAT(trans_date, '%Y-%m'), country;
