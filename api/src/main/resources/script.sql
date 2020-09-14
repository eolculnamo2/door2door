
CREATE TABLE `contacts` (
    id VARCHAR(36)  UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    phone VARCHAR(155) NOT NULL,

    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `teams` (
    email VARCHAR(155) UNIQUE,
    password VARCHAR(500) DEFAULT NULL,
    name VARCHAR(45) DEFAULT NULL,
    contact_fk VARCHAR(155) DEFAULT NULL,
    enabled TINYINT(1) DEFAULT NULL,
    profile_pic VARCHAR(500) DEFAULT NULL,
    website VARCHAR(500) DEFAULT NULL,
    description VARCHAR(500) DEFAULT NULL,
    address VARCHAR(500) DEFAULT NULL,
    city VARCHAR(500) DEFAULT NUll,
    state VARCHAR(500) DEFAULT NULL,
    zip VARCHAR(20) DEFAULT NULL,

    PRIMARY KEY (`email`),
    FOREIGN KEY(`contact_fk`)
    REFERENCES `contacts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
