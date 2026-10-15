package edu.unc.comp210.ListDepricated;

public class MyLinkedListTest extends MyListTest {
    @Override
    protected MyList<String> createList() {
        return new MyLinkedList<>();
    }
}
