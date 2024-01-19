INSERT INTO dbo.city (created_at, name, state, status) VALUES
(GETDATE(), 'Nueva York', 'NY', 'Activo'),
(GETDATE(), 'Los Ángeles', 'CA', 'Activo'),
(GETDATE(), 'Chicago', 'IL', 'Activo'),
(GETDATE(), 'Houston', 'TX', 'Activo'),
(GETDATE(), 'Phoenix', 'AZ', 'Activo'),
(GETDATE(), 'Filadelfia', 'PA', 'Activo'),
(GETDATE(), 'San Antonio', 'TX', 'Activo'),
(GETDATE(), 'San Diego', 'CA', 'Activo'),
(GETDATE(), 'Dallas', 'TX', 'Activo'),
(GETDATE(), 'San José', 'CA', 'Activo');


INSERT INTO dbo.sex (created_at, name, state, status) VALUES
(GETDATE(), 'Masculino', 'Activo', 'Confirmado'),
(GETDATE(), 'Femenino', 'Activo', 'Confirmado');

INSERT INTO dbo.book (isbn, author, created_at, name, price, status, image, amount) VALUES
('978-0439708180', 'J.K. Rowling', GETDATE(), 'Harry Potter and the Sorcerer''s Stone', 24.99, 'Available', 'http://photo.com', 15),
('978-0439064873', 'J.K. Rowling', GETDATE(), 'Harry Potter and the Chamber of Secrets', 24.99, 'Available', 'http://photo.com', 12),
('978-0439136365', 'J.K. Rowling', GETDATE(), 'Harry Potter and the Prisoner of Azkaban', 24.99, 'Available', 'http://photo.com', 10),
('978-0439139595', 'J.K. Rowling', GETDATE(), 'Harry Potter and the Goblet of Fire', 24.99, 'Unavailable', 'http://photo.com', 0),
('978-0439358071', 'J.K. Rowling', GETDATE(), 'Harry Potter and the Order of the Phoenix', 24.99, 'Available', 'http://photo.com', 5),
('978-0439785969', 'J.K. Rowling', GETDATE(), 'Harry Potter and the Half-Blood Prince', 24.99, 'Available', 'http://photo.com', 7),
('978-0545139700', 'J.K. Rowling', GETDATE(), 'Harry Potter and the Deathly Hallows', 24.99, 'Available', 'http://photo.com', 4),
('978-0743273565', 'F. Scott Fitzgerald', GETDATE(), 'The Great Gatsby', 10.99, 'Available', 'http://photo.com', 10),
('978-0451524935', 'George Orwell', GETDATE(), '1984', 9.99, 'Available', 'http://photo.com', 20),
('978-0679783268', 'Jane Austen', GETDATE(), 'Pride and Prejudice', 12.99, 'Available', 'http://photo.com', 14),
('978-1593083246', 'Mary Shelley', GETDATE(), 'Frankenstein', 7.99, 'Available', 'http://photo.com', 8),
('978-0141439600', 'Charlotte Brontë', GETDATE(), 'Jane Eyre', 8.99, 'Available', 'http://photo.com', 10),
('978-0486284736', 'Mark Twain', GETDATE(), 'Adventures of Huckleberry Finn', 5.99, 'Available', 'http://photo.com', 6),
('978-0140449266', 'Homer', GETDATE(), 'The Odyssey', 13.99, 'Available', 'http://photo.com', 7),
('978-0140449198', 'Homer', GETDATE(), 'The Iliad', 13.99, 'Available', 'http://photo.com', 5),
('978-0486292564', 'Oscar Wilde', GETDATE(), 'The Picture of Dorian Gray', 4.99, 'Available', 'http://photo.com', 12),
('978-0486406510', 'Joseph Conrad', GETDATE(), 'Heart of Darkness', 5.99, 'Available', 'http://photo.com', 9),
('978-0316769488', 'J.D. Salinger', GETDATE(), 'The Catcher in the Rye', 8.99, 'Available', 'http://photo.com', 7),
('978-0679732242', 'Toni Morrison', GETDATE(), 'Beloved', 9.99, 'Available', 'http://photo.com', 6),
('978-0345391803', 'Douglas Adams', GETDATE(), 'The Hitchhiker''s Guide to the Galaxy', 7.99, 'Available', 'http://photo.com', 11);


-- ALTER TABLE dbo.book
-- DROP COLUMN ammount;

INSERT INTO dbo.profession (created_at, name_profession, state, status) VALUES
(GETDATE(), 'Software Engineer', 'Employed', 'Verified'),
(GETDATE(), 'Data Analyst', 'Self-Employed', 'Verified'),
(GETDATE(), 'Graphic Designer', 'Employed', 'Pending'),
(GETDATE(), 'Doctor', 'Contractor', 'Verified'),
(GETDATE(), 'Lawyer', 'Part-Time', 'Pending');

INSERT INTO users_state (state) VALUES
('Active'),
('Inactive'),
('Suspended'),
('Pending Verification');

INSERT INTO dbo.users (name, email, password, age, sex_id, profession_id, city_id, created_at, user_state_id) VALUES
('John Doe', 'johndoe@example.com', 'password123', 30, 1, 1, 1, GETDATE(), 1),
('Jane Smith', 'janesmith@example.com', 'password123', 28, 2, 2, 2, GETDATE(), 1),
('Emily Johnson', 'emilyjohnson@example.com', 'password123', 35, 2, 3, 3, GETDATE(), 1),
('Michael Brown', 'michaelbrown@example.com', 'password123', 40, 1, 4, 4, GETDATE(), 1),
('Jessica Williams', 'jessicawilliams@example.com', 'password123', 25, 2, 2, 5, GETDATE(), 1),
('David Miller', 'davidmiller@example.com', 'password123', 32, 1, 1, 6, GETDATE(), 1),
('Sarah Wilson', 'sarahwilson@example.com', 'password123', 22, 2, 5, 7, GETDATE(), 1),
('James Taylor', 'jamestaylor@example.com', 'password123', 27, 1, 3, 8, GETDATE(), 1),
('Laura Moore', 'lauramoore@example.com', 'password123', 29, 2, 4, 9, GETDATE(), 1),
('Robert Anderson', 'robertanderson@example.com', 'password123', 38, 1, 2, 10, GETDATE(), 1);

INSERT INTO dbo.card_membership (user_id, balance, created_at) VALUES
(1, 100.00, GETDATE()),
(2, 150.00, GETDATE()),
(3, 120.00, GETDATE()),
(4, 80.00, GETDATE()),
(5, 200.00, GETDATE()),
(6, 110.00, GETDATE()),
(7, 130.00, GETDATE()),
(8, 145.00, GETDATE()),
(9, 90.00, GETDATE()),
(10, 175.00, GETDATE());




