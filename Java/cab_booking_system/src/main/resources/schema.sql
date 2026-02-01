CREATE TABLE IF NOT EXISTS `cab`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(30) NOT NULL,
    `mobile_number` varchar(30) DEFAULT NULL,
    `location_id` int NOT NULL,
    `is_available` boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS `customer`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(30) NOT NULL,
    `mobile_number` varchar(30) DEFAULT NULL,
    `location_id` bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS `location`(
    `location_id` bigint AUTO_INCREMENT PRIMARY KEY,
    `x` int NOT NULL,
    `y` int NOT NULL
);

CREATE TABLE IF NOT EXISTS `trip`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY,
    `customer_id` bigint NOT NULL,
    `cab_id` bigint NOT NULL,
    `distance` double precision NOT NULL,
    `fare` double precision NOT NULL,
    `status` varchar(30) NOT NULL,
    `source_location_id` bigint NOT NULL,
    `destination_location_id` bigint NOT NULL,
    `trip_start_timestamp` timestamp DEFAULT NULL,
    `trip_end_timestamp` timestamp DEFAULT NULL
);