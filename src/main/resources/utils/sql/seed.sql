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

-- Insert into users (admin is the password)
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('admin', 1, 'Admin User', 'admin@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'John Doe', 'john.doe@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Jane Smith', 'jane.smith@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Robert Johnson', 'robert.johnson@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Maria Garcia', 'maria.garcia@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('admin', 1, 'Super User', 'super.user@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'James Brown', 'james.brown@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Emily Davis', 'emily.davis@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Jessica Miller', 'jessica.miller@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Michael Wilson', 'michael.wilson@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');
INSERT INTO `users` (`user_type`, `user_state_id`, `name`, `email`, `password`) VALUES ('customer', 1, 'Sarah Moore', 'sarah.moore@example.com', '$2a$10$vQZyKo0NbHunzwiStvPfx.KCy6apDBkZBiOoWmgcE6AnlaDdaUD2S');

-- Insert into rooms
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (1, 1, 'Room 101', 'Single room with park view', 80.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (2, 1, 'Room 102', 'Double room with sea view', 120.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (3, 1, 'Room 201', 'Triple room with city view', 150.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (4, 1, 'Room 202', 'Quad room with garden view', 200.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (5, 1, 'Room 301', 'Queen room with mountain view', 250.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (1, 1, 'Room 302', 'Single room with park view', 80.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (2, 1, 'Room 401', 'Double room with city view', 120.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (3, 1, 'Room 402', 'Triple room with garden view', 150.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (4, 1, 'Room 501', 'Quad room with sea view', 200.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (5, 1, 'Room 502', 'Queen room with city view', 250.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (1, 1, 'Room 601', 'Single room with mountain view', 80.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (2, 1, 'Room 602', 'Double room with park view', 120.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (3, 1, 'Room 701', 'Triple room with sea view', 150.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (4, 1, 'Room 702', 'Quad room with city view', 200.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (5, 1, 'Room 801', 'Queen room with garden view', 250.00);
INSERT INTO `rooms` (`type_room_id`, `state_room_id`, `name`, `description`, `cost`) VALUES (1, 1, 'Room 802', 'Single room with sea view', 80.00);


-- Insert into reservations 

-- Insert into Sales 