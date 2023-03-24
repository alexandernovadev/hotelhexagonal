INSERT INTO rooms_type (state) VALUES ('Standard');
INSERT INTO rooms_type (state) VALUES ('Deluxe');
INSERT INTO rooms_type (state) VALUES ('Suite');

INSERT INTO rooms_state (state) VALUES ('Available');
INSERT INTO rooms_state (state) VALUES ('Booked');
INSERT INTO rooms_state (state) VALUES ('Under Maintenance');

INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (1, 1, 'Room 101', 'A standard room with a queen-size bed');
INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (2, 1, 'Room 201', 'A deluxe room with a king-size bed and a balcony');
INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES (3, 3, 'Room 301', 'A luxurious suite with a jacuzzi and a view of the city');

INSERT INTO users_state (state) VALUES ('Active');
INSERT INTO users_state (state) VALUES ('Inactive');

INSERT INTO users (user_type, name, user_state_id, email, password) VALUES ('admin', 'John Smith', 1, 'john.smith@example.com', 'password123');
INSERT INTO users (user_type, name, user_state_id, email, password) VALUES ('guest', 'Alice Johnson', 1, 'alice.johnson@example.com', 'password456');

INSERT INTO reservations (user_id, room_id, state) VALUES (1, 1, 'Confirmed');
INSERT INTO reservations (user_id, room_id, state) VALUES (2, 2, 'Pending');
INSERT INTO reservations (user_id, room_id, state) VALUES (1, 3, 'Cancelled');

INSERT INTO sales_state (state) VALUES ('Paid');
INSERT INTO sales_state (state) VALUES ('Unpaid');

INSERT INTO sales (user_id, reservation_id, sales_state_id) VALUES (1, 1, 1);
INSERT INTO sales (user_id, reservation_id, sales_state_id) VALUES (2, 2, 2);




