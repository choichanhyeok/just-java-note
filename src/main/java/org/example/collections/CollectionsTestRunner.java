package org.example.collections;

import org.example.collections.collection.list.ListTest;
import org.example.collections.collection.list.VectorTest;
import org.example.collections.collection.set.SetTest;

import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsTestRunner {
    public CollectionsTestRunner(){
        new ListTest();
        new VectorTest();
        new ListTest();
        new SetTest();

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    }

}
