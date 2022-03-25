DROP TABLE IF EXISTS authors CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS books CASCADE;

CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(255),
    image TEXT
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR (255) NOT NULL,
    isManager BOOLEAN NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE books (
    bookid SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    author_id INT REFERENCES authors(author_id),
    user_id INT REFERENCES users(user_id),
    loaned BOOLEAN NOT NULL,
    ISBN INT NOT NULL
);
INSERT INTO authors (name, nationality) VALUES
    ('Jane Austen', 'English'),
    ('J.R.R Tolkien', 'English'),
    ('Terry Pratchett', 'English'),
    ('Douglas R. Hofstadter', 'American');

INSERT INTO books (title, genre, author_id, loaned, ISBN) VALUES
    ('Emma', 'CLASSIC', 1, FALSE, 11132),
    ('Pride and Prejudice', 'CLASSIC', 1, FALSE, 11345),
    ('The Lord of the Rings', 'FANTASY', 2, FALSE, 12353),
    ('The Silmarillion', 'FANTASY', 2, FALSE, 12683),
    ('The Hobbit', 'FANTASY', 2, FALSE, 12799),
    ('The Colour of Magic', 'FANTASY', 3, FALSE, 12954),
    ('The Light Fantastic', 'FANTASY', 3, FALSE, 13233),
    ('Godel, Escher, Bach', 'NON_FICTION', 4, FALSE, 13600),
    ('I am a Strange Loop', 'NON_FICTION', 4, FALSE, 13602);

INSERT INTO users (name, username, isManager, password) VALUES
    ('Yang', 'Yang', TRUE, 'password'),
    ('Wendy', 'WendyDiane', FALSE, 'password'),
    ('Michelle', 'Michelle', FALSE, 'password'),
    ('Connie', 'ConnieB', FALSE, 'password');