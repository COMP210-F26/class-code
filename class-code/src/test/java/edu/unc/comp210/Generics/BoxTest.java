package edu.unc.comp210.Generics;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Box")
public class BoxTest {

    // ------------------------------------------------------------------
    @Nested
    @DisplayName("holds its invariant")
    class Invariant {

        @Test
        @DisplayName("a new box is empty")
        void newBoxIsEmpty() {
            assertTrue(new Box<String>().isEmpty());
        }

        @Test
        @DisplayName("a box with something in it is not empty")
        void filledBoxIsNotEmpty() {
            Box<String> box = new Box<>();
            box.put("Doobi");
            assertFalse(box.isEmpty());
        }

        @Test
        @DisplayName("taking the item empties the box again")
        void takeEmptiesTheBox() {
            Box<String> box = new Box<>();
            box.put("Doobi");
            box.take();
            assertTrue(box.isEmpty());
        }

        @Test
        @DisplayName("null is refused, because null is how the box spells empty")
        void putRejectsNull() {
            Box<String> box = new Box<>();
            assertThrows(IllegalArgumentException.class, () -> box.put(null));
            assertTrue(box.isEmpty(), "a refused put must leave the box untouched");
        }

        @Test
        @DisplayName("a full box refuses a second item")
        void putRejectsSecondItem() {
            Box<String> box = new Box<>();
            box.put("Doobi");
            assertThrows(IllegalStateException.class, () -> box.put("Kali"));
            assertEquals("Doobi", box.peek(), "the original item must survive the refused put");
        }
    }

    // ------------------------------------------------------------------
    @Nested
    @DisplayName("reading the item")
    class Reading {

        @Test
        @DisplayName("peek returns the item and leaves it in the box")
        void peekDoesNotRemove() {
            Box<String> box = new Box<>();
            box.put("Doobi");

            assertEquals("Doobi", box.peek());
            assertEquals("Doobi", box.peek());
            assertFalse(box.isEmpty());
        }

        @Test
        @DisplayName("take returns the same object that was put in")
        void takeReturnsTheSameObject() {
            String doobi = "Doobi";
            Box<String> box = new Box<>();
            box.put(doobi);

            assertSame(doobi, box.take());
        }

        @Test
        @DisplayName("peek and take on an empty box throw instead of returning null")
        void emptyBoxThrows() {
            Box<String> box = new Box<>();
            assertThrows(IllegalStateException.class, box::peek);
            assertThrows(IllegalStateException.class, box::take);
        }

        @Test
        @DisplayName("a box can be refilled after it is emptied")
        void refillAfterTake() {
            Box<String> box = new Box<>();
            box.put("Doobi");
            box.take();
            box.put("Kali");

            assertEquals("Kali", box.peek());
        }
    }

    // ------------------------------------------------------------------
    @Nested
    @DisplayName("the generic version needs no casts")
    class Generics {

        @Test
        @DisplayName("what comes out is already the right type")
        void noCastNeeded() {
            Box<String> box = new Box<>();
            box.put("Doobi");

            // No cast on this line. That is the whole difference from ObjectBox.
            String name = box.peek();
            assertEquals(5, name.length());
        }

        @Test
        @DisplayName("the same class works for a different type")
        void worksForAnyType() {
            Box<Integer> numbers = new Box<>();
            numbers.put(300);

            int teeth = numbers.take();
            assertEquals(300, teeth);
        }

    }
}
