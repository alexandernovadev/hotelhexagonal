INSERT INTO rooms_type (state) VALUES
('Single'),
('Double'),
('Triple'),
('Suite'),
('Penthouse'),
('Villa'),
('Bungalow'),
('Cabin'),
('Treehouse'),
('Houseboat');

INSERT INTO rooms_state (state) VALUES
('Available'),
('Occupied'),
('Under Maintenance'),
('Out of Service'),
('Reserved');


INSERT INTO rooms (type_room_id, state_room_id, name, description) VALUES
(1, 1, 'Room 101', 'A cozy single room with a queen-size bed.'),
(2, 1, 'Room 102', 'A spacious double room with two twin beds.'),
(3, 1, 'Room 201', 'A comfortable triple room with three twin beds.'),
(4, 1, 'Suite 301', 'A luxurious suite with a king-size bed and a living room.'),
(5, 3, 'Penthouse 401', 'An exclusive penthouse with a private terrace and a hot tub.'),
(6, 1, 'Villa 501', 'A private villa with a pool and a garden.'),
(7, 4, 'Bungalow 601', 'A cozy bungalow in the woods.'),
(8, 2, 'Treehouse 701', 'A unique treehouse with a view.'),
(9, 5, 'Houseboat 801', 'A charming houseboat on the river.'),
(10, 1, 'Room 202', 'A comfortable double room with a queen-size bed.');


INSERT INTO users_state (state) VALUES
('Active'),
('Inactive'),
('Suspended'),
('Banned'),
('Pending');


INSERT INTO users (user_type, name, user_state_id, email, password) VALUES
('admin', 'John Doe', 1, 'johndoe@example.com', 'password123'),
('guest', 'Jane Smith', 1, 'janesmith@example.com', 'password456'),
('guest', 'Bob Johnson', 1, 'bobjohnson@example.com', 'password789'),
('guest', 'Alice Williams', 1, 'alicewilliams@example.com', 'password101'),
('admin', 'Sarah Lee', 1, 'sarahlee@example.com', 'password202'),
('guest', 'Tom Wilson', 1, 'tomwilson@example.com', 'password303'),
('guest', 'Amy Brown', 1, 'amybrown@example.com', 'password404'),
('guest', 'David Davis', 1, 'daviddavis@example.com', 'password505'),
('admin', 'Emily Green', 1, 'emilygreen@example.com', 'password606'),
('guest', 'Mike Taylor', 1, 'miketaylor@example.com', 'password707');


INSERT INTO reservations_state (state) VALUES
('Reserved'),
('Checked In'),
('Checked Out'),
('Cancelled'),
('No Show');

INSERT INTO reservations (user_id, room_id, reservation_state_id) VALUES
(2, 2, 1),
(3, 4, 1),
(2, 8, 1),
(5, 9, 1),
(4, 10, 1),
(3, 1, 1),
(6, 2, 1),
(7, 3, 1),
(8, 4, 1),
(9, 5, 1),
(10, 6, 1);


INSERT INTO sales_state (state) VALUES
('Pending'),
('Paid'),
('Refunded'),
('Cancelled');



INSERT INTO sales (user_id, reservation_id, sales_state_id) VALUES
(2, 1, 2),
(3, 2, 2),
(4, 3, 2),
(5, 4, 2),
(6, 5, 2),
(7, 6, 2),
(8, 7, 2),
(9, 8, 2),
(10, 9, 2),
(2, 10, 2),
(3, 11, 2),
(4, 12, 2),
(5, 13, 2),
(6, 14, 2),
(7, 15, 2);


