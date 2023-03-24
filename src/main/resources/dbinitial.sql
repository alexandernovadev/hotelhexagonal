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
  user_state INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_id),
  FOREIGN KEY (user_state) REFERENCES users_state(user_state_id)
);


CREATE TABLE reservations (
  reservation_id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  room_id INT NOT NULL,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (reservation_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (room_id) REFERENCES rooms(room_id)
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


INSERT INTO rooms_type (state) VALUES ('Single');
INSERT INTO rooms_type (state) VALUES ('Double');
INSERT INTO rooms_type (state) VALUES ('Twin');
INSERT INTO rooms_type (state) VALUES ('Queen');
INSERT INTO rooms_type (state) VALUES ('King');
INSERT INTO rooms_type (state) VALUES ('Suite');


INSERT INTO rooms_state (state) VALUES ('Available');
INSERT INTO rooms_state (state) VALUES ('Reserved');
INSERT INTO rooms_state (state) VALUES ('Occupied');
INSERT INTO rooms_state (state) VALUES ('Maintenance');
INSERT INTO rooms_state (state) VALUES ('Out of order');
INSERT INTO rooms_state (state) VALUES ('Cleaning');

INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (1, 1, '101', 'Single room with a twin bed');
INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (1, 1, '102', 'Single room with a queen bed');
INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (2, 1, '201', 'Double room with two twin beds');
INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (2, 1, '202', 'Double room with a queen bed');
INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (3, 1, '301', 'Twin room with two twin beds');
INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (4, 1, '401', 'Queen room with a queen bed');

INSERT INTO users_state (state) VALUES ('Active');
INSERT INTO users_state (state) VALUES ('Inactive');
INSERT INTO users_state (state) VALUES ('Suspended');
INSERT INTO users_state (state) VALUES ('Deleted');
INSERT INTO users_state (state) VALUES ('Pending');
INSERT INTO users_state (state) VALUES ('Blocked');

INSERT INTO users (user_type, user_state, name, email, password, state) VALUES ('admin', 1, 'John Doe', 'john.doe@example.com', 'password123', 'Active');
INSERT INTO users (user_type, user_state, name, email, password, state) VALUES ('guest', 1, 'Jane Smith', 'jane.smith@example.com', 'password456', 'Active');
INSERT INTO users (user_type, user_state, name, email, password, state) VALUES ('guest', 2, 'Bob Johnson', 'bob.johnson@example.com', 'password789', 'Inactive');

INSERT INTO sales_state (state) VALUES ('Pending');
INSERT INTO sales_state (state) VALUES ('Paid');
INSERT INTO sales_state (state) VALUES ('Refunded');
INSERT INTO sales_state (state) VALUES ('Cancelled');
INSERT INTO sales_state (state) VALUES ('Expired');
INSERT INTO sales_state (state) VALUES ('Fraud');


INSERT INTO reservations (user_id, room_id, state) VALUES (1, 1, 'Reserved');
INSERT INTO reservations (user_id, room_id, state) VALUES (2, 3, 'Reserved');
INSERT INTO reservations (user_id, room_id, state) VALUES (2, 4, 'Reserved');
INSERT INTO reservations (user_id, room_id, state) VALUES (3, 6, 'Reserved');
INSERT INTO reservations (user_id, room_id, state) VALUES (1, 3, 'Reserved');


INSERT INTO sales (user_id, reservation_id, sales_state_id) VALUES (1, 1, 2);
INSERT INTO sales (user_id, reservation_id, sales_state_id) VALUES (2, 2, 1);
INSERT INTO sales (user_id, reservation_id, sales_state_id) VALUES (2, 3, 1);
INSERT INTO sales (user_id, reservation_id, sales_state_id) VALUES (3, 4, 2);
INSERT INTO sales (user_id, reservation_id, sales_state_id) VALUES (1, 5, 1);
