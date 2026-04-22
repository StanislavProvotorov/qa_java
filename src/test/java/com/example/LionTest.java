package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    Lion lion;

    @Mock
    Feline mockFeline;

    @Test
    public void testGetKittens() throws Exception{
        int expected = 1;
        lion = new Lion(mockFeline,"Самец");
        Mockito.when(mockFeline.getKittens()).thenReturn(1);

        int actual = lion.getKittens();

        assertEquals("Не верное кол-во котят",expected,actual);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        lion = new Lion(mockFeline,"Самец");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expected);

        List<String> actual = lion.getFood();

        assertEquals("Не правильное питание",expected,actual);
    }

    @Test
    public void testExceptionLionConstructor() throws Exception{
        String expected = "Используйте допустимые значения пола животного - самец или самка";

        try {
            lion = new Lion(mockFeline,"Неизвестно");
        } catch (Exception e) {
            String actual = e.getMessage();

            assertEquals(expected,actual);
        }
    }
}
