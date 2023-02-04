package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;

public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void eatMeatTest() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensTestWithInt() {
        assertEquals(10, feline.getKittens(10));
    }

}