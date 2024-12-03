CREATE TABLE Users (
    userId INT IDENTITY(1,1) PRIMARY KEY,
    Names NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL UNIQUE,
    Passwords NVARCHAR(255) NOT NULL
);

Drop Table Users;

INSERT INTO Users (Names, Email, Passwords)
VALUES 
    ('John Doe', 'johndoe@example.com', 'password123'),
    ('Jane Smith', 'janesmith@example.com', 'password456'),
    ('Mike Johnson', 'mikejohnson@example.com', 'password789'),
    ('Alice Brown', 'alicebrown@example.com', 'password101'),
    ('Tom Clark', 'tomclark@example.com', 'password202');
