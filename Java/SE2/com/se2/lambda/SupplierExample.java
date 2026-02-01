package com.se2.lambda;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    Supplier<ArrayList<Integer>> getNewArrayList = () -> new ArrayList<Integer>();

    Supplier<LocalTime> getTime = () -> LocalTime.now();

    List<Integer> list1 = getNewArrayList.get();
    List<Integer> list2 = getNewArrayList.get();

    LocalTime time = getTime.get();
}
