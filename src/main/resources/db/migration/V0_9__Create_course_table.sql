CREATE TABLE IF NOT EXISTS "course"
(
    id          VARCHAR(255) NOT NULL primary key ,
    code        VARCHAR(255),
    name        VARCHAR(255),
    credits     INTEGER,
    total_hours INTEGER,
    teacher_id  VARCHAR(255) NOT NULL references "user"(id)
);