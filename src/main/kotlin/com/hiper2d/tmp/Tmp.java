package com.hiper2d.tmp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tmp {
    public static void main(String[] args) {
        List<Integer> someList = Arrays.asList(1, 2, 3, 4, 5);
        Map<Num, List<Integer>> grouped = someList.stream().collect(Collectors.groupingBy(Num::getNum));
    }
}

enum Num {
    ODD,
    EVEN;

    public static Num getNum(Integer num) {
        return (num % 2 == 0) ? EVEN : ODD;
    }
}
