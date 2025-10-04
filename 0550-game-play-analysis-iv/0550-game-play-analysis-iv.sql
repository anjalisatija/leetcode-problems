WITH temp AS(
    SELECT player_id, MIN(event_date) AS first_date FROM Activity
    GROUP BY player_id
    HAVING COUNT(*)>1
),
continues_days AS(
    SELECT DISTINCT a.player_id FROM Activity AS a JOIN temp AS t
    ON a.player_id = t.player_id
    WHERE DATEDIFF(a.event_date,t.first_date) = 1
)
SELECT ROUND( COUNT(player_id) / (SELECT COUNT(DISTINCT(player_id)) FROM Activity),2) AS fraction FROM continues_days;