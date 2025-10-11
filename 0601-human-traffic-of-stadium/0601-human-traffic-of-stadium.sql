# Write your MySQL query statement below
WITH filter AS (
	SELECT *,
    LEAD(id) OVER(ORDER BY id ASC) AS nextone,
    LAG(id) OVER(ORDER BY id ASC) AS prevone
    FROM Stadium
    WHERE people>=100
),
filter2 AS (
	SELECT id,nextone,prevone FROM filter
	WHERE nextone-id = 1 AND id-prevone=1
)
SELECT DISTINCT id,visit_date,people FROM Stadium
WHERE id IN (
    SELECT id FROM filter2 
    UNION
    SELECT nextone FROM filter2
    UNION
    SELECT prevone FROM filter2
    )
ORDER BY visit_date;