-- 코드를 입력하세요
SELECT 
    b.category,
    SUM(s.sales) as total_sales
FROM BOOK b
JOIN BOOK_SALES s
    ON b.book_id = s.book_id
WHERE DATE_FORMAT(s.sales_date, '%Y-%m') = '2022-01'
GROUP BY b.category
ORDER BY b.category asc;
