package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            boolean result = true;

            for (String s : list) {
                if (s != null && !s.isEmpty()) {
                    char ch = s.charAt(0);
                    if (Character.isLetter(ch)) {
                        if (Character.isLowerCase(ch)) {
                            result = false;
                            break;
                        }
                    } else {
                        result = false;
                        break;
                    }
                } else {
                    result = false;
                    break;
                }
            }

            return result;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Integer e = list.get(i);
                if (e % 2 == 0) {
                    list.add(e);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> resultList = new ArrayList<>();
            for (String value : values) {
                if (value == null || value.isBlank()) {
                    continue;
                }

                String[] words = value.split(" ");

                char firstChar = value.charAt(0);
                char lastChar = value.charAt(value.length() - 1);
                if (!Character.isLetter(firstChar) || Character.isLowerCase(firstChar)
                        || lastChar != '.' || words.length < 4) {
                    continue;
                }

                resultList.add(value);
            }

            return resultList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : list) {
                map.put(s, s.length());
            }

            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return new ArrayList<>(list1);
        };
    }
}
