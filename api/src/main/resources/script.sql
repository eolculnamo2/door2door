
CREATE TABLE `contacts` (
    id VARCHAR(36)  UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    name VARCHAR(155) NOT NULL,

    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
    email VARCHAR(155) UNIQUE,
    password VARCHAR(500) DEFAULT NULL,
    first_name VARCHAR(45) DEFAULT NULL,
    last_name VARCHAR(45) DEFAULT NULL,
    contact_fk VARCHAR(155) DEFAULT NULL,
    enabled TINYINT(1) DEFAULT NULL,
    profile_pic VARCHAR(500) DEFAULT NULL,
    authority VARCHAR(45) DEFAULT NULL,

    PRIMARY KEY (`email`),
    FOREIGN KEY(`contact_fk`)
    REFERENCES `contacts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
