package com.up.libraryBookingSystem.service;

import com.up.libraryBookingSystem.ENUMS.Nationality;
import com.up.libraryBookingSystem.dao.AuthorsDao;
import com.up.libraryBookingSystem.pojo.Authors;
import org.checkerframework.common.reflection.qual.NewInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;

class AuthorServiceTest {

    @Mock
    private AuthorsDao authorsDao;
    private AuthorService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authorsDao = Mockito.mock(AuthorsDao.class);
        underTest = new AuthorService(authorsDao);
    }

    @Test
    void canAddAuthorIfAuthorDoesNotExist() {
        //Given
        Authors author = new Authors(1, "Alex", Nationality.ENGLISH, null);
//
//        doNothing().when(authorsDao).addAuthors(author);
//        underTest.addAuthor(author);
        Mockito.when(authorsDao.addAuthors(eq(author))).thenReturn(1);
//
        Mockito.when(authorsDao.displayAuthors()).thenReturn(List.of(new Authors(1, "Alex", Nationality.ENGLISH, null)));
        //When

        //then
//        assertThat(expectAlex).isEqualTo(author);
        assertThatThrownBy(() -> {
            underTest.addAuthor(author);
            ArgumentCaptor<Authors> authorsArgumentCaptor = ArgumentCaptor.forClass(Authors.class);
            Mockito.verify(authorsDao).addAuthors(authorsArgumentCaptor.capture());
            Authors expectAlex = authorsArgumentCaptor.getValue();

        }).isInstanceOf(IllegalStateException.class).hasMessage("Author already exists");
        Mockito.verify(authorsDao, Mockito.never()).addAuthors(author);
    }
}