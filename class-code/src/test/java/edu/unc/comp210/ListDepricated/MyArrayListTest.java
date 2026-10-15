package edu.unc.comp210.ListDepricated;

public class MyArrayListTest extends MyListTest{
    @Override
    protected MyList<String> createList() {
        return new MyArrayList<>();
    }
}
