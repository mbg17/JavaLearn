package com.test.database.translate;

import lombok.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamToHashMap {
    public static void main(String[] args) {
        // 生成数据
        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(new Person(1, "haha"));
        peoples.add(new Person(2, "xixi"));
        peoples.add(new Person(3, "huhu"));
        peoples.add(new Person(3, "hehe"));
        peoples.add(new Person(5, "asd"));
        // 生成流对象
        Stream<Person> stream = peoples.stream();
        // 通过流对象转换成hashmap
        Map<Integer, String> collect = stream.collect(Collectors.toMap(Person::getId, Person::getName,
                (existValue, newValue) -> {
                    // 存在相同的值抛出异常
//                    throw new IllegalArgumentException();
                    // 存在相同的值合并
                    return existValue;
                },
                TreeMap::new));
        Set<Map.Entry<Integer, String>> entries = collect.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        // Function.identity() 直接返回对象本身
//        Map<Person, String> collect1 = stream.collect(Collectors.toMap(Function.identity(), Person::getName,(existValue,newValue)->{
//            throw new IllegalArgumentException();
//        }));
        // 将每个国家下的语言转成Set集合
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
//        Map<String, Set<String>> countryLanguages = availableLocales.collect(Collectors.toMap(Locale::getDisplayCountry,
//                // 将国家下的语言转成Set集合
//                l -> Set.of(l.getDisplayLanguage()),
//                (a, b) -> {
////                    System.out.println(a+":"+b);
//                    HashSet<String> strings = new HashSet<>(a);
//                    // 合并所有结果
//                    strings.addAll(b);
//                    return strings;
//                }));
//        // 输出国家语言
//        System.out.println(countryLanguages);
        // 直接分组 通过城市名
        Map<String, List<String>> collect1 = availableLocales.collect(Collectors.groupingBy(Locale::getCountry, mapping(Locale::getDisplayLanguage, toList())));
        System.out.println(collect1);
        // 获取使用英文和其他类型的地区列表
//        Map<Boolean, Set<Locale>> en = availableLocales.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en"),
//                /* 转换器，转换成你需要的数据类型*/
//                toSet()));
//        System.out.println(en);
//        Set<Locale> locales = en.get(true);
        Stream<String> stream1 = List.of("1111", "234234", "54545", "5555").stream();
        IntStream intStream = stream1.mapToInt(String::length);
//        OptionalInt max = in ax.getAsInt());
        int[] ints = intStream.toArray();
        System.out.println(Arrays.toString(ints));
    }

    @Data
    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    public static class Person {
        private Integer id;
        private String name;
    }
}
