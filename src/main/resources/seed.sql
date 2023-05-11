-- Insert into users_state
INSERT INTO `users_state` (`state`) VALUES ('Active');
INSERT INTO `users_state` (`state`) VALUES ('Inactive');
INSERT INTO `users_state` (`state`) VALUES ('Suspended');
INSERT INTO `users_state` (`state`) VALUES ('Banned');
INSERT INTO `users_state` (`state`) VALUES ('Deleted');

-- Insert into sales_state
INSERT INTO `sales_state` (`state`) VALUES ('Pending');
INSERT INTO `sales_state` (`state`) VALUES ('Completed');
INSERT INTO `sales_state` (`state`) VALUES ('Cancelled');
INSERT INTO `sales_state` (`state`) VALUES ('In Process');
INSERT INTO `sales_state` (`state`) VALUES ('Failed');

-- Insert into payment_methods
INSERT INTO `payment_methods` (`method_name`) VALUES ('Credit Card');
INSERT INTO `payment_methods` (`method_name`) VALUES ('Debit Card');
INSERT INTO `payment_methods` (`method_name`) VALUES ('Paypal');
INSERT INTO `payment_methods` (`method_name`) VALUES ('Bank Transfer');
INSERT INTO `payment_methods` (`method_name`) VALUES ('Cash');

-- Insert into rooms_type
INSERT INTO `rooms_type` (`state`) VALUES ('Single');
INSERT INTO `rooms_type` (`state`) VALUES ('Double');
INSERT INTO `rooms_type` (`state`) VALUES ('Triple');
INSERT INTO `rooms_type` (`state`) VALUES ('Quad');
INSERT INTO `rooms_type` (`state`) VALUES ('Queen');

-- Insert into rooms_state
INSERT INTO `rooms_state` (`state`) VALUES ('Available');
INSERT INTO `rooms_state` (`state`) VALUES ('Occupied');
INSERT INTO `rooms_state` (`state`) VALUES ('Maintenance');
INSERT INTO `rooms_state` (`state`) VALUES ('Cleaning');
INSERT INTO `rooms_state` (`state`) VALUES ('Reserved');

-- Insert into reservations_state
INSERT INTO `reservations_state` (`state`) VALUES ('Booked');
INSERT INTO `reservations_state` (`state`) VALUES ('Cancelled');
INSERT INTO `reservations_state` (`state`) VALUES ('No-show');
INSERT INTO `reservations_state` (`state`) VALUES ('Checked-in');
INSERT INTO `reservations_state` (`state`) VALUES ('Checked-out');

-- Insert into users
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('admin', 1, 'Admin User', 'admin@example.com', 'password1');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'John Doe', 'john.doe@example.com', 'password2');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Jane Smith', 'jane.smith@example.com', 'password3');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Robert Johnson', 'robert.johnson@example.com', 'password4');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Maria Garcia', 'maria.garcia@example.com', 'password5');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('admin', 1, 'Super User', 'super.user@example.com', 'password6');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'James Brown', 'james.brown@example.com', 'password7');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Emily Davis', 'emily.davis@example.com', 'password8');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Jessica Miller', 'jessica.miller@example.com', 'password9');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Michael Wilson', 'michael.wilson@example.com', 'password10');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Sarah Moore', 'sarah.moore@example.com', 'password11');

-- Insert into rooms
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (1, 1, 'Room 101', 'Single room with park view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (2, 1, 'Room 102', 'Double room with sea view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (3, 1, 'Room 201', 'Triple room with city view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (4, 1, 'Room 202', 'Quad room with garden view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (5, 1, 'Room 301', 'Queen room with mountain view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (1, 1, 'Room 302', 'Single room with park view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (2, 1, 'Room 401', 'Double room with city view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (3, 1, 'Room 402', 'Triple room with garden view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (4, 1, 'Room 501', 'Quad room with sea view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (5, 1, 'Room 502', 'Queen room with city view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (1, 1, 'Room 601', 'Single room with mountain view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (2, 1, 'Room 602', 'Double room with park view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (3, 1, 'Room 701', 'Triple room with sea view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (4, 1, 'Room 702', 'Quad room with city view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (5, 1, 'Room 801', 'Queen room with garden view');
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`) VALUES (1, 1, 'Room 802', 'Single room with sea view');





