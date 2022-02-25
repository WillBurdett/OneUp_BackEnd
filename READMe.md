ReadMe

We are the 1-UP Team, a team consisting of BNTA Cohort 4 members: Connie, Michelle, Wendy, and Zhengyang.

One liner:
1-Upping your reading experience with a book borrowing system made-better.

Contributors:
@​​zhengyangqiu
@MichelleRafols
@WendyDiane
@conniebernardin


Introduction

This collaborative project consists of a Library Booking System using java17 as our main language, PostgreSQL to create and store our database, SQL for our queries, SpringBoot to connect the server to the database, and Postman for our API testing.





The team started by creating a flowchart as a visual representation of how the user interacts with the backend of the application. The first method created was to enable new users to create a user profile and for current users/managers to login to the system. Then the users can search up, loan books and/or use another service. The library system also enables the manager, and only the manager to access and update the books in our database. 



The team also created an entity relationship diagram that shows the relationship among the tables in our Postgres database, which includes books, authors and users. Each table is linked through a many to one relationship using a foreign key. This displays how to set up the databases for efficient communication and relations. 

Plain Old Java Objects (POJOS):

List of the basic java objects and the properties they contain

POJO
Type
Input Structure
User
UserId int
Username String
Name String
isManager Boolean
Password String
{
"username": "Bob",
"name": "Robert Smith",
"password": "password12",
"manager": false
}
Author
AuthorId int
Name String
Nationality ENUM
Image String (hyperlink)
{
"name": "Leo Tolstoy",
"nationality":       "RUSSIAN",
"image": "https://www.history.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTU3ODc4Njg0ODUyOTU0NDQx/fb-tolstoy-2.jpg"
}
Book
BookId int
Genre ENUM
AuthorId int
UserId int
Loaned Boolean
Isbn Int
{
"title": "War and Peace",
"genre": "FANTASY",
"authorId": 2,
"userId": 3,
"loaned": false,
"isbn": 2222

}


HTTP Requests

Users


HTTP request
Type
Function
localhost:8080/users
GET
Display a list of all the users in the database
localhost:8080/users/{id}
GET
Display a specific user by id
localhost:8080/users
POST
Add a user to the database
​​localhost:8080/users/{id}
DELETE
Identify a specific user by id and delete them from the database
localhost:8080/users/{id}
PUT
Identify a specific user from the database by id and update their details 

Authors


HTTP Request
Type
Function
localhost:8080/authors
GET
Display all authors in the database
localhost:8080/authors/{id}
GET
Identify a specific author by id and display all information about them stored in the database
localhost:8080/authors/
?authorName = {authorName}
PUT
Identify a specific author by name and display all information about them stored in the database
localhost:8080/authors
POST
Add author to the database
localhost:8080/authors/{id}
PUT
Identify a specific author by id and update their details
localhost:8080/authors/{id}
DELETE
Identify author by id and delete them from the database



Books


HTTP Request
Type
Function
localhost:8080/books/ ?isManager=true


POST
Add book to the database
localhost:8080/books/{id}


DELETE
Identify a book by id and remove it from the database
localhost:8080/books/{id}
PUT
Identify a book and update its details within the database
localhost:8080/assign/{bookId}/user/{userId}
PUT
Assign a userId primary key in the user table to the userId foreign key of a specific book
Changes isLoaned boolean to true
localhost:8080/books
GET
Displays a list of all books in the database
localhost:8080/books/{id}
GET
Identifies a book by id and displays its details
localhost:8080/books/
?bookTitle={bookTitle}
GET
Identifies  book by its title and displays its details

Minimum Viable Product (MVP)
Must-haves:
Helper Mode
Service logic
Integration of an API (Controller), to send HTTP requests to progress library system between Postgres
Integration with database containing the books,users and authors (DAO interface with database implementation)
SQL file, with instructions to set up database and tables in the postico.
Competitive Mode
Allow user to create User,books and authors POJOs
Create a user, book, author in database
Allow user to  get, input,delete and update the information of books, authors
Allow users to create account and set password for them
Allow user to assign book to user

Potential Extensions to MVP
Nice-to-haves (if time):
Leaderboard
Authentication
Stretch objective:
Test Edge Cases

Acknowledgements
A huge thanks to the BNTA team, and especially to our trainers, Colin, Nelson, and Iain!



How to: Set up your PostgreSQL database

Make sure to have installed Java and PostgreSQL
Clone our library database repo by copying this text to the terminal:
git clone git@github.com:zhengyangqiu/BookingSystem.git
Now you can open the repository in your Java IDE (in our case, we used IntelliJ)
Open PostgreSQL and create a new PostgreSQL database called library system by copying the following command into the SQL Query section:
CREATE DATABASE librarysytem;
Once again in PostgreSQL, create your tables for authors, users and books by copying the following code:

CREATE TABLE authors (
author_id SERIAL PRIMARY KEY,
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


Now, you can populate your tables with authors, users and books of your choice. Let’s help you get started on this by copying the following code:

INSERT INTO authors (name, nationality) VALUES ('Jane Austen', 'English');

INSERT INTO books (title, genre, author_id, loaned, ISBN) VALUES ('Emma', 'Classic', 1, FALSE, 1234);
INSERT INTO books (title, genre, author_id, loaned, ISBN) VALUES ('Pride and Prejudice', 'Classic', 1, FALSE, 12345);

INSERT INTO users (name, username, isManager, password) VALUES ('Yang', 'Yang', TRUE, 'password');
INSERT INTO users (name, username, isManager, password) VALUES ('Wendy', 'WendyDiane', FALSE, 'password');
INSERT INTO users (name, username, isManager, password) VALUES ('Michelle', 'Michelle', FALSE, 'password');
INSERT INTO users (name, username, isManager, password) VALUES ('Connie', 'ConnieB', FALSE, 'password');

Note: you can also find the SQL queries in steps 5 & 6 in our libraryDataBase.sql file on our IntelliJ repo. You can accordingly follow the DROP TABLE queries in the file if in any case you need to delete your database. Otherwise, you can ignore them.

8. And done! Your database is now ready to use.





