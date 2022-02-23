package com.up.libraryBookingSystem.service;

import com.up.libraryBookingSystem.ENUMS.GENRES;
import com.up.libraryBookingSystem.dao.BooksDao;
import com.up.libraryBookingSystem.pojo.Authors;
import com.up.libraryBookingSystem.pojo.Books;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.awt.print.Book;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookServiceTest {
    @Mock
    private BooksDao booksDao;
    private BookService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        booksDao = Mockito.mock(BooksDao.class);
        underTest = new BookService(booksDao);

    }

    @Test
    void itCanDeleteBookIfItExists() {
        //Given
        Books book = new Books(2, "Sara", GENRES.CLASSIC, 2, true, 123);
        Mockito.when(booksDao.displayBooks()).thenReturn(List.of(
                new Books(2, "Sara", GENRES.CLASSIC, 2, true, 123)
        ));
        Mockito.when(booksDao.deleteBook(book.getBookId()))
                .thenReturn(1);
        // When
        underTest.deleteBook(book.getBookId());

        Mockito.verify(booksDao).deleteBook(2);
//        Mockito.verify(personDAO).deletePerson(person.getId());
        //THEN
    }
//    void itCanSavePerson() {
    //Given
//        Person person = new Person(1, "Sara", 25);
//
//        Mockito.when(personDAO.insertPerson(eq(person)))
//                .thenReturn(1);
//
//        Mockito.when(personDAO.selectAllPeople()).thenReturn(List.of(
//                new Person(2, "Lizzie", 25)
//        ));
//        // When
//        int result = underTest.savePerson(person);
//        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
//
//        Mockito.verify(personDAO).insertPerson(personArgumentCaptor.capture());
//
//        Person expectedSarah = personArgumentCaptor.getValue();
//        //THEN
//        assertThat(expectedSarah).isEqualTo(person);
//        assertThat(result).isEqualTo(1);
}