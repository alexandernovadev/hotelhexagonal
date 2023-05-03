CREATE TABLE rooms_type (
  rooms_type_id INT NOT NULL AUTO_INCREMENT,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (rooms_type_id)
);

CREATE TABLE rooms_state (
  rooms_state_id INT NOT NULL AUTO_INCREMENT,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (rooms_state_id)
);

CREATE TABLE rooms (
  room_id INT NOT NULL AUTO_INCREMENT,
  type_room_id INT NOT NULL,
  state_room_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  PRIMARY KEY (room_id),
  FOREIGN KEY (state_room_id) REFERENCES rooms_state(rooms_state_id),
  FOREIGN KEY (type_room_id) REFERENCES rooms_type(rooms_type_id)
);

CREATE TABLE users_state (
  user_state_id INT NOT NULL AUTO_INCREMENT,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_state_id)
);

CREATE TABLE users (
  user_id INT NOT NULL AUTO_INCREMENT,
  user_type ENUM('admin', 'guest') NOT NULL,
  name VARCHAR(50) NOT NULL,
  user_state_id INT NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id),
  FOREIGN KEY (user_state_id) REFERENCES users_state(user_state_id)
);



CREATE TABLE reservations_state (
  reservation_state_id INT NOT NULL AUTO_INCREMENT,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (reservation_state_id)
);


CREATE TABLE reservations (
  reservation_id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  room_id INT NOT NULL,
  reservation_state_id INT NOT NULL,
  check_in_date DATE NOT NULL,
  check_out_date DATE NOT NULL,
  PRIMARY KEY (reservation_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (room_id) REFERENCES rooms(room_id),
  FOREIGN KEY (reservation_state_id) REFERENCES reservations_state(reservation_state_id)
);

CREATE TABLE sales_state (
  sales_state_id INT NOT NULL AUTO_INCREMENT,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (sales_state_id)
);

CREATE TABLE sales (
  sales_id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  reservation_id INT NOT NULL,
  sales_state_id INT NOT NULL,
  PRIMARY KEY (sales_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (reservation_id) REFERENCES reservations(reservation_id),
  FOREIGN KEY (sales_state_id) REFERENCES sales_state(sales_state_id)
);

-- -----------------------------------------------------------------------
--  =====================  23 Abril 2023 =====================

-- Add notes column to reservations table 
ALTER TABLE reservations ADD notes VARCHAR(500) NOT NULL DEFAULT 'Without observations';


-- Create payment_methods table 
CREATE TABLE payment_methods (
  payment_method_id INT NOT NULL AUTO_INCREMENT,
  method_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (payment_method_id)
);

-- Add payment_method_id column to sales table
ALTER TABLE sales ADD payment_method_id INT;

-- Add foreign key to payment_method_id column
ALTER TABLE sales
  ADD FOREIGN KEY (payment_method_id) REFERENCES payment_methods(payment_method_id);




CREATE TABLE traceability (
  id INT NOT NULL AUTO_INCREMENT,
  user VARCHAR(100) NOT NULL,
  eventname VARCHAR(100) NOT NULL,
  dateNow DATE NOT NULL,
  PRIMARY KEY (id)
);
