DROP TABLE books;
DROP TABLE users;
DROP TABLE authors;

CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(255),
    image TEXT
);

//filler the books for authors

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    author_id INT REFERENCES authors(author_id),
    user_id INT REFERENCES users(user_id),
    loaned BOOLEAN NOT NULL,
    ISBN INT NOT NULL
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR (255) NOT NULL,
    isManager BOOLEAN NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO authors (name, nationality) VALUES ('Jane Austen', 'English');

INSERT INTO books (title, genre, author_id, loaned, ISBN) VALUES ('Emma', 'Classic', 1, FALSE, 1234);
INSERT INTO books (title, genre, author_id, loaned, ISBN) VALUES ('Pride and Prejudice', 'Classic', 1, FALSE, 12345);

INSERT INTO users (name, username, isManager, password) VALUES ('Yang', 'Yang', TRUE, 'password');
INSERT INTO users (name, username, isManager, password) VALUES ('Wendy', 'WendyDiane', FALSE, 'password');
INSERT INTO users (name, username, isManager, password) VALUES ('Michelle', 'Michelle', FALSE, 'password');
INSERT INTO users (name, username, isManager, password) VALUES ('Connie', 'ConnieB', FALSE, 'password');

