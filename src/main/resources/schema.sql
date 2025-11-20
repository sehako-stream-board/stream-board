CREATE TABLE IF NOT EXISTS post
(
    `no`         INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`      VARCHAR(100) NULL,
    `content`    TEXT         NULL,
    `created_at` TIMESTAMP    NULL DEFAULT CURRENT_TIMESTAMP
);