package com.daryll.eightfeatures.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

public class Java8ForEachExample {

    public static void main(String[] args) {

        //  creating sample Collection
        List<Integer> myList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        //  traversing using Iterator
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::"+i);
        }

        //  traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("forEach anonymous class Value::"+t);
            }
        });

        //  traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);
    }

    /*
    Iterator Value::0
    Iterator Value::1
    Iterator Value::2
    Iterator Value::3
    Iterator Value::4
    Iterator Value::5
    Iterator Value::6
    Iterator Value::7
    Iterator Value::8
    Iterator Value::9
    forEach anonymous class Value::0
    forEach anonymous class Value::1
    forEach anonymous class Value::2
    forEach anonymous class Value::3
    forEach anonymous class Value::4
    forEach anonymous class Value::5
    forEach anonymous class Value::6
    forEach anonymous class Value::7
    forEach anonymous class Value::8
    forEach anonymous class Value::9
    Consumer impl Value::0
    Consumer impl Value::1
    Consumer impl Value::2
    Consumer impl Value::3
    Consumer impl Value::4
    Consumer impl Value::5
    Consumer impl Value::6
    Consumer impl Value::7
    Consumer impl Value::8
    Consumer impl Value::9
     */
}

class MyConsumer implements Consumer<Integer> {
    @Override
    public void accept(Integer t) {
        System.out.println("Consumer impl Value::"+t);
    }
}