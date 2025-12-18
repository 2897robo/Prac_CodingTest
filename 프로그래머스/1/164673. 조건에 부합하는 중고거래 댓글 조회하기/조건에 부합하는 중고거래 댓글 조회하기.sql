SELECT
    b.title        AS title,
    b.board_id     AS board_id,
    r.reply_id     AS reply_id,
    r.writer_id    AS writer_id,
    r.contents     AS contents,
    DATE_FORMAT(r.created_date, '%Y-%m-%d') AS created_date
FROM used_goods_board b
INNER JOIN used_goods_reply r
    ON b.board_id = r.board_id
WHERE YEAR(b.created_date)  = 2022
  AND MONTH(b.created_date) = 10
ORDER BY
    r.created_date ASC,
    b.title ASC;
