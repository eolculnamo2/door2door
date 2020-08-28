CREATE TABLE `users` (
    `email` varchar(155) UNIQUE,
    `password` varchar(500) DEFAULT NULL,
    `email` varchar(45) UNIQUE,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `organization_fk` varchar(155) DEFAULT NULL,
    `enabled` tinyint(1) DEFAULT NULL,
    `profile_pic` varchar(500) DEFAULT NULL,
    `authority` varchar(45) DEFAULT NULL,

    PRIMARY KEY (`email`),
    FOREIGN KEY(`organization_fk`)
    REFERENCES `organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `organization` (
    `id` VARCHAR(36)  UNIQUE,
    `name` varchar(155) NOT NULL,

    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;