package com.up.libraryBookingSystem;

import com.up.libraryBookingSystem.ENUMS.GENRES;
import com.up.libraryBookingSystem.pojo.Authors;
import com.up.libraryBookingSystem.pojo.Books;
import com.up.libraryBookingSystem.pojo.Users;
import com.up.libraryBookingSystem.service.AuthorService;
import com.up.libraryBookingSystem.service.BookService;
import com.up.libraryBookingSystem.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LibraryController {

    private UserService userService;
    private AuthorService authorService;
    private BookService bookService;

    public LibraryController(UserService userService, AuthorService authorService, BookService bookService) {
        this.userService = userService;
        this.authorService = authorService;
        this.bookService = bookService;
    }
//    public LibraryController(UserService userService) {
//        this.userService = userService;
//    }
//
//    public LibraryController(AuthorService authorService) {
//        this.authorService = authorService;
//    }
//
//    public LibraryController(BookService bookService) {
//        this.bookService = bookService;
//    }

    //Users
    @GetMapping(path = "users")
    public List<Users> getUsers() {
        return userService.displayUsers();
    }

    @GetMapping(path = "users/{id}")
    public Users getUserById(@PathVariable("id") Integer userId) {
        return userService.selectUserById(userId);
    }

    @PostMapping(path = "users")
    public void addUser(@RequestBody Users user) {
        userService.addUser(user);
    }

    @DeleteMapping(path = "users/{id}")
    public void deleteUserById(@PathVariable("id") Integer userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "users/{id}")
    public void updateUser(@PathVariable("id") Integer userId, @RequestBody Users updatedUser) {
        userService.updateUser(userId, updatedUser);
    }

    //---------------------------- Books -------------------------------------

    // GET BOOKS BY GENRE OR ALL
    @GetMapping(path = "books")
    public List<Books> getBooks(@RequestParam (required = false, value = "genre") GENRES genre) {
        if (genre != null) {
            return bookService.displayBooksByGenre(genre);
        }
        return bookService.displayBooks();
    }

    @GetMapping(path = "available-books")
    public List<Books> getAvailableBooks() {
        return bookService.displayBooks()
                .stream()
                .filter(books -> books.isLoaned() == false)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "unavailable-books")
    public List<Books> getUnavailableBooks() {
        return bookService.displayBooks()
                .stream()
                .filter(books -> books.isLoaned() == true)
                .collect(Collectors.toList());
    }

    // GET BOOK BY ID
    @GetMapping(path = "books/{id}")
    public Books getBookById(@PathVariable("id") Integer bookId) {
        return bookService.selectBookById(bookId);
    }

    @RequestMapping(value= "books/title/{bookTitle}", method = RequestMethod.GET) //localhost:8080/bookTitle/?bookTitle=Emma
    public Books getBookByTitle(@PathVariable(value = "bookTitle") String bookTitle) {
        return bookService.selectBookByTitle(bookTitle);
    }

//    @RequestMapping(value= "/bookGenre", method = RequestMethod.GET) //localhost:8080/?bookTitle=Emma
//    public List<Books> getBooksByGenre(@RequestParam(value = "bookGenre")GENRES genre) {
//        return bookService.displayBooksByGenre(genre);
//    }
    //use localhost:8080/books/?isManager=true in postman
    @PostMapping(path = "books", params = "isManager")
    public void addBook(@RequestBody Books book, @RequestParam boolean isManager) {
        if(isManager){
        bookService.addBook(book);}
        else { throw new IllegalStateException("Access denied.");}
    }

    //------- RETURN BY BOOK ID --------
    @RequestMapping(value= "/assign/{bookId}", method = RequestMethod.PUT)
    public void returnBookById(@PathVariable("bookId") Integer bookId) {
        bookService.returnBookById(bookId);
    }

    @DeleteMapping(path = "books/{id}")
    public void deleteBookById(@PathVariable("id") Integer bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping(path = "books/{id}")
    public void updateBook(@PathVariable("id") Integer bookId, @RequestBody Books updatedBook) {
        bookService.updateBook(bookId, updatedBook);
    }

    @RequestMapping(value= "/assign/{bookId}/user/{userId}", method = RequestMethod.PUT)
   // @PutMapping(path = "books/id}")
    public void assignUserToBook(@PathVariable(value ="bookId") Integer bookID,
                                 @PathVariable(value ="userId") Integer userID){
        bookService.assignUserToBook(bookID, userID);
    }

    //Authors
    @GetMapping(path = "authors")
    public List<Authors> getAuthors() {
        return authorService.displayAuthors();
    }

    @GetMapping(path = "authors/{id}") //localhost:8080/authors/3
 //   @RequestMapping(value = "/{authorID}", method = RequestMethod.GET)
    public Authors getAuthorById(@PathVariable (value= "id") Integer authorId) {
        return authorService.selectAuthorById(authorId);
    }

   //@GetMapping(params = "author/{name}")
    @RequestMapping(value= "/authorName", method = RequestMethod.GET) //localhost:8080/authorName/?authorName=Brandon Sanderson
    public Authors getAuthorByName(@RequestParam(value = "authorName") String authorName) {
        return authorService.selectAuthorByName(authorName);
    }

    @PostMapping(path = "authors")
    public void addAuthor(@RequestBody Authors author) {
        authorService.addAuthor(author);
    }

    @DeleteMapping(path = "authors/{id}")
    public void deleteAuthorById(@PathVariable("id") Integer authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping(path = "authors/{id}")
    public void updateAuthor(@PathVariable("id") Integer authorId, @RequestBody Authors updatedAuthor) {
        authorService.updateAuthor(authorId, updatedAuthor);
    }
}

