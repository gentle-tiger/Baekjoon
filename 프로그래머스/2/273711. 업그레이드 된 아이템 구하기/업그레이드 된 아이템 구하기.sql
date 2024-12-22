# 1. JOIN으로 테이블 구조 이해 
# SELECT *
# FROM ITEM_INFO I 
# INNER JOIN ITEM_TREE T
# ON I.ITEM_ID = T.ITEM_ID;

# 2. 부모가 RARE 아이템인 경우만 골라서 확인
# SELECT T.ITEM_ID, T.PARENT_ITEM_ID, I.RARITY
# FROM ITEM_INFO I 
#     INNER JOIN ITEM_TREE T
#         ON T.PARENT_ITEM_ID = I.ITEM_ID
# WHERE I.RARITY = 'RARE';


# 3. 중복 제거(DISTINCT) / 조인 과정에서 중복이 발생할 수 있기 때문에 안전하게 호출
# SELECT DISTINCT T.ITEM_ID, T.PARENT_ITEM_ID, I.RARITY
# FROM ITEM_INFO I 
#     INNER JOIN ITEM_TREE T
#         ON T.PARENT_ITEM_ID = I.ITEM_ID
# WHERE I.RARITY = 'RARE';


# 부모가 RARE인 아이템들의 "상세 정보"가져오기
# 위 쿼리는 자식 아이템의 ID만 알고 있고, 아직 자식 아이템(ITEM_ID)에 대한 ITEM_NAME 등은 모릅니다.따라서 ITEM_INFO에서 자식 아이템의 상세 정보를 가져와야 합니다. 이를 위해 ITEM_INFO A를 한 번 더 JOIN하는데, 즉, 서브쿼리 결과(부모가 RARE인 아이템의 ID 목록)를 B로 두고, 이 B와 ITEM_INFO A를 다시 JOIN해서 최종적으로 A.ITEM_NAME, A.RARITY, 기타 필요 정보를 얻을 수 있습니다.
SELECT A.ITEM_ID, A.ITEM_NAME, A.RARITY
FROM ITEM_INFO A 
JOIN(
    SELECT DISTINCT T.ITEM_ID, T.PARENT_ITEM_ID, I.RARITY
    FROM ITEM_TREE T 
        INNER JOIN ITEM_INFO I 
            ON T.PARENT_ITEM_ID = I.ITEM_ID
    WHERE I.RARITY = 'RARE'
) B
    ON A.ITEM_ID = B.ITEM_ID
ORDER BY A.ITEM_ID DESC;










