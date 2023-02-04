package com.example;

import static  org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final Boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSex(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    private Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeTest() throws Exception {
//        try {
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
//        } catch (Exception exception) {
//            Lion lion = new Lion(sex, feline);
//            assertEquals("Используйте допустимые значения пола животного - самец или самка", lion.doesHaveMane());
//        }
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}