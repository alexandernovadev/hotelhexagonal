CREATE TABLE `users_state` (
  `user_state_id` BIGINT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_state_id`)
) ENGINE=InnoDB;

CREATE TABLE `users` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_type` VARCHAR(255),
  `user_state_id` BIGINT,
  `name` VARCHAR(255),
  `email` VARCHAR(255),
  `password` VARCHAR(255),
  PRIMARY KEY (`user_id`),
  FOREIGN KEY (`user_state_id`) REFERENCES `users_state`(`user_state_id`)
) ENGINE=InnoDB;

CREATE TABLE `traceability` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255),
  `eventname` VARCHAR(255),
  `datenow` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `sales_state` (
  `sales_state_id` BIGINT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`sales_state_id`)
) ENGINE=InnoDB;

CREATE TABLE `payment_methods` (
  `payment_method_id` BIGINT NOT NULL AUTO_INCREMENT,
  `method_name` VARCHAR(255),
  PRIMARY KEY (`payment_method_id`)
) ENGINE=InnoDB;

CREATE TABLE `rooms_type` (
  `rooms_type_id` BIGINT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(255),
  PRIMARY KEY (`rooms_type_id`)
) ENGINE=InnoDB;

CREATE TABLE `rooms_state` (
  `rooms_state_id` BIGINT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(255),
  PRIMARY KEY (`rooms_state_id`)
) ENGINE=InnoDB;

CREATE TABLE `rooms` (
  `room_id` BIGINT NOT NULL AUTO_INCREMENT,
  `type_room_id` BIGINT,
  `state_room_id` BIGINT,
  `name` VARCHAR(255),
  `description` VARCHAR(255),
  `cost` DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (`room_id`),
  FOREIGN KEY (`type_room_id`) REFERENCES `rooms_type`(`rooms_type_id`),
  FOREIGN KEY (`state_room_id`) REFERENCES `rooms_state`(`rooms_state_id`)
) ENGINE=InnoDB;

CREATE TABLE `reservations_state` (
  `reservation_state_id` BIGINT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(255),
  PRIMARY KEY (`reservation_state_id`)
) ENGINE=InnoDB;

CREATE TABLE `reservations` (
  `reservation_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT,
  `room_id` BIGINT,
  `reservation_state_id` BIGINT,
  `check_in_date` DATETIME,
  `check_out_date` DATETIME,
  PRIMARY KEY (`reservation_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
  FOREIGN KEY (`room_id`) REFERENCES `rooms`(`room_id`),
  FOREIGN KEY (`reservation_state_id`) REFERENCES `reservations_state`(`reservation_state_id`)
) ENGINE=InnoDB;

CREATE TABLE `sales` (
  `sales_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT,
  `reservation_id` BIGINT,
  `sales_state_id` BIGINT,
  `payment_method_id` BIGINT,
  `total_amount` DECIMAL(10, 2) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`sales_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
  FOREIGN KEY (`reservation_id`) REFERENCES `reservations`(`reservation_id`),
  FOREIGN KEY (`sales_state_id`) REFERENCES `sales_state`(`sales_state_id`),
  FOREIGN KEY (`payment_method_id`) REFERENCES `payment_methods`(`payment_method_id`)
) ENGINE=InnoDB;
