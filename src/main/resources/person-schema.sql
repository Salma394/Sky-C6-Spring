DROP TABLE `person` CASCADE;
CREATE TABLE `person` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `age` INTEGER,
    `job_title` VARCHAR(255)
);