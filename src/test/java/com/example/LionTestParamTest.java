package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParamTest {
    private final String sex;
    private final boolean expected;
    Lion lion;

    Feline felineMock = Mockito.mock(Feline.class);

    public LionTestParamTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getTest() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        lion = new Lion(felineMock, sex);

        boolean actual = lion.doesHaveMane();

        assertEquals("Не верно определена грива", expected, actual);
    }
}
