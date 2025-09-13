SELECT
    t1.request_at AS Day,
    ROUND(SUM(t1.status IN ('cancelled_by_driver', 'cancelled_by_client')) / COUNT(t1.id), 2) AS 'Cancellation Rate'
FROM
    Trips t1
JOIN
    Users u1 ON t1.client_id = u1.users_id AND u1.banned = 'No'
JOIN
    Users u2 ON t1.driver_id = u2.users_id AND u2.banned = 'No'
WHERE
    t1.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY
    t1.request_at;