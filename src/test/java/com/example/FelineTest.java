package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();

        assertEquals("Не правильное питание",expected, actual);
    }

    @Test
    public void testGetFamily() {
       String expected = "Кошачьи";
       String actual = feline.getFamily();

       assertEquals("Не правильное семейство",expected,actual);
    }

    @Test
    public void testGetKittensNotArgumrnt() {
        int expected = 1;
        int actual = feline.getKittens();

        assertEquals("Не верное кол-во котят",expected,actual);
    }

    @Test
    public void testGetKittens() {
        int expected = 3;
        int actual = feline.getKittens(3);

        assertEquals("Не верное кол-во котят",expected,actual);
    }
}