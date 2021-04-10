package com.test.database.translate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationLearn {
    public static void main(String[] args) {
        List<String> words = List.of("aaaa", "bbbb", "cccc", "dddd", "eee");
        Optional<String> operation = words.stream().max(String::compareToIgnoreCase);
        //compareToIgnoreCase 比较字符串大小
        System.out.println("operation: " + operation);
        // 返回查到的第一个元素
        Optional<String> startWithD = words.stream().parallel().filter(s -> s.startsWith("eee")).findAny();
        System.out.println(startWithD);
        // 返回是否存在匹配
        boolean anyStartWithD = words.stream().parallel().anyMatch(s -> s.startsWith("f"));
        System.out.println(anyStartWithD);
        // 存在匹配的对象返回对象，不存在返回默认字符串
        String result = startWithD.orElse("---");
        System.out.println(result);
        String defaultS = startWithD.orElseGet(() -> "morenzhi");
        System.out.println(defaultS);
        String thowException = startWithD.orElseThrow(RuntimeException::new);
        System.out.println(thowException);
        List<Integer> integers = List.of(1, 2, 3, 46, 34, 7);
        integers = integers.stream().sorted().collect(Collectors.toList());
        integers.forEach(s -> System.out.println(s));
        Optional<Integer> integerFilter = integers.stream().parallel().filter(integer -> integer > 7).findAny();
        List<Integer> finalIntegers = new ArrayList<>();
        integerFilter.ifPresent(finalIntegers::add);
        System.out.println(finalIntegers);
//        创建Optional含值的对象
        Optional<Integer> integer = Optional.of(111);
//        获取Optional的值
        Integer integer1 = integer.get();
//        判断optional是否为空
        System.out.println(integer.isPresent());
        // 创建一个空的Optional对象
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());
        ArrayList<String> strings = new ArrayList<>();
        Integer i = null;
        empty.ifPresent(strings::add);
        System.out.println(strings);
        String[] strings1 = new String[]{"111", "22", "33", "44"};
        List<String> collect = Arrays.stream(strings1).collect(Collectors.toList());
        System.out.println(collect);
        Iterator<Integer> iterator = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        HashSet<Integer> integers1 = new HashSet<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        integers1.add(5);
        System.out.println(integers1.stream().limit(10).map(Objects::toString).collect(Collectors.joining(", ")));
        for (Integer integer2 : integers1) {
            System.out.println(integer2);
        }
        DoubleSummaryStatistics collect1 = collect.stream().collect(Collectors.summarizingDouble(Double::parseDouble));
        double average = collect1.getAverage();
        System.out.println(average);
    }
}
