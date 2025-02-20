# -- 코드를 작성해주세요
# SELECT 
#     YEAR(DIFFERENTIATION_DATE) AS YEAR,
#     MAX(SIZE_OF_COLONY) OVER (PARTITION BY YEAR(DIFFERENTIATION_DATE)) - SIZE_OF_COLONY AS YEAR_DEV,
#     MAX(SIZE_OF_COLONY) OVER (PARTITION BY YEAR(DIFFERENTIATION_DATE))AS 'MAX',
#      SIZE_OF_COLONY AS 'MIN',
   
#     ID
# FROM ECOLI_DATA
# ORDER BY YEAR, YEAR_DEV;

SELECT 
    YEAR(DIFFERENTIATION_DATE) AS YEAR,
    MAX(SIZE_OF_COLONY) OVER (PARTITION BY YEAR(DIFFERENTIATION_DATE)) - SIZE_OF_COLONY AS YEAR_DEV,
    # MAX(SIZE_OF_COLONY) OVER (PARTITION BY YEAR(DIFFERENTIATION_DATE)) AS 'MAX',
    # SIZE_OF_COLONY AS 'MIN',
    ID
FROM ECOLI_DATA
ORDER BY YEAR, YEAR_DEV; 
