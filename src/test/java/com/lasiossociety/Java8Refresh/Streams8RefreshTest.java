package com.lasiossociety.Java8Refresh;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Some unit testing for Java8-Streams
 */
@SpringBootTest
public class Streams8RefreshTest {

    @Test
    public void shouldReturnUpperCaseElements() {

        List<String> lowerCaseElements = Arrays.asList("here", "are", "some", "words");

        List<String> upperCaseElements = lowerCaseElements.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertTrue(!upperCaseElements.isEmpty());
        assertEquals("Element was not uppercase!", "HERE",
                upperCaseElements.stream().findFirst().get());
    }

    @Test
    public void shouldReturnAffordableItems() {

        List<Inventory> inventory = Arrays.asList(
                new Inventory("potion", 10),
                new Inventory("ether", 30),
                new Inventory("antidote", 5));

        Integer currentFunds = 20;

        List<Inventory> affordable = inventory.stream()
                .filter(afford -> afford.getCost() <= currentFunds)
                .collect(Collectors.toList());

        Optional<Inventory> reduced = affordable.stream()
                .reduce((x1, x2) -> new Inventory(x1.getName() + "-" + x2.getName(), x1.getCost() + x2.getCost()));

        assertTrue(!affordable.isEmpty());
        assertEquals(2, affordable.size());
        assertEquals("potion", affordable.get(0).getName());
        assertEquals("potion-antidote", reduced.get().getName());
        assertEquals("15", reduced.get().getCost().toString() );

    }
}
