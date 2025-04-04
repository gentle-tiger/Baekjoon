SELECT COUNT(n.FISH_TYPE) as FISH_COUNT, n.FISH_NAME
FROM FISH_INFO f 
INNER JOIN FISH_NAME_INFO n
ON f.FISH_TYPE = n.FISH_TYPE
GROUP BY n.FISH_NAME
ORDER BY FISH_COUNT desc;
