package edu.unc.comp210.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeImplTest {

    @Test
    void testEquals() {
        Node<Integer> one = new NodeImpl<>(1);
        Node<Integer> two = new NodeImpl<>(2);
        Node<Integer> other = one;
        assertEquals(one,other);
        assertSame(one,other);
        assertNotSame(one,two);


    }
}