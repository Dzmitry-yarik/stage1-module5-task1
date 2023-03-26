package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
              return x -> {
            boolean b;
            int a = 0;
            for (String s : x) {
                b = s.chars().filter(Character::isUpperCase).count() > 0;
                if (b){
                    a++;
                }
            }
            return a == x.size();
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
              return x -> {
            List<Integer> z = new ArrayList<>(x);
            for (Integer s : x) {
                if (s % 2 == 0){
                    z.add(s);
                }
            }
            System.out.println(x);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
            return () -> {
            for (int i = 0; i < values.size(); i++) {
                String s = values.get(i);
                System.out.println(s);
                int count = s.split(" ").length;
                String cha = s.substring(s.length() - 1);
                if (!(Character.isUpperCase(s.charAt(0)) && count > 3 && cha.equals("."))) {
                    values.remove(s);
                    i--;
                }
            }
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
              Map<String,Integer> res = new HashMap<>();
        return x -> {
            int con = 0;
            for (String nRes : x) {
                con = nRes.length();
                res.put(nRes, con);
            }
            return res;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
              return (list1, list2) -> {
            List<Integer> sum = new ArrayList<>(list1);
            sum.addAll(list2);
            return sum;
        };
    }
}
