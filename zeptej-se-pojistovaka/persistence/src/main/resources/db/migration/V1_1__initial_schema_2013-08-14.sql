USE zeptej_se_pojistovaka;

/**
 * Users and Authorities (= Rights).
 * 
 * The users table covers AbstractUser, VerifiedUser, AbstractUnverifiedUser,
 * UnverifiedContributionAuthor and UnverifiedMessageAuthor java classes.
 * 
 * Do not change username, password, enabled and authority since they are the
 * parts of the Spring Security's default database schema.
 * NOTE: Username is actually a generated user ID.
 *
 * The email is UNIQUE, hence it is necessary to use "null" as the default
 * value, not the empty string.
 */
DROP TABLE IF EXISTS `tag_thread_references`;
DROP TABLE IF EXISTS `contributions`;
DROP TABLE IF EXISTS `messages`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `username` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `password` VARCHAR(50),
    `enabled` BOOLEAN NOT NULL,
    `name` VARCHAR(50),
    `email` VARCHAR(100) UNIQUE,
    `sex` BOOLEAN,
    CONSTRAINT `email_validator` CHECK (`email` LIKE '_%@_%._%')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authorities` (
	`username` INT(11) NOT NULL,
	`authority` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`username`, `authority`),
	CONSTRAINT `FK_authorities_users`
		FOREIGN KEY (`username`)
		REFERENCES `users`(`username`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/**
 * Questions and Answers.
 * 
 * The contributions table covers AbstractContribution, Question and Answer
 * java classes.
 * 
 * DATETIME vs. TIMESTAMP ... see http://stackoverflow.com/questions/409286/datetime-vs-timestamp
 */
CREATE TABLE `contributions` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `author_id` INT(11) NOT NULL,
    `text` TEXT,
    `creation_timestamp` TIMESTAMP NOT NULL,
    `last_update_timestamp` TIMESTAMP,
    `thema` VARCHAR(255) NOT NULL,
    `question_id` INT(11),
    CONSTRAINT `FK_contributions_users`
        FOREIGN KEY (`author_id`)
        REFERENCES `users`(`username`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `FK_answers_questions`
        FOREIGN KEY (`question_id`)
        REFERENCES `contributions`(`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/**
 * Tags
 */
DROP TABLE IF EXISTS `tag_patterns`;
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tag_thread_references` (
    `tag_id` INT(11) NOT NULL,
    `thread_id` INT(11) NOT NULL,
    PRIMARY KEY (`tag_id`, `thread_id`),
    CONSTRAINT `FK_tag_thread_references_tags`
        FOREIGN KEY (`tag_id`)
        REFERENCES `tags`(`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `FK_tag_thread_references_threads`
        FOREIGN KEY (`thread_id`)
        REFERENCES `contributions`(`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tag_patterns` (
    `tag_id` INT(11) NOT NULL,
    `pattern` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`tag_id`, `pattern`),
    CONSTRAINT `FK_tag_patterns_tags`
        FOREIGN KEY (`tag_id`)
        REFERENCES `tags`(`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/**
 * Messages
 */
CREATE TABLE `messages` (
    `id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `type` VARCHAR(30) NOT NULL,
    `author_id` INT(11) NOT NULL,
    `text` TEXT,
    CONSTRAINT `FK_messages_users`
        FOREIGN KEY (`author_id`)
        REFERENCES `users`(`username`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
