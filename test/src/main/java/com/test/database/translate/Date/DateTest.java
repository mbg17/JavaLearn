package com.test.database.translate.Date;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateTest {
    public static void main(String[] args) {
        // 获取执行前时间
        Instant now = Instant.now();
        // 获取执行后时间
        runAlgorithm();
        Instant end = Instant.now();
        // 获取相差时间
        Duration between = Duration.between(now, end);
        long l = between.toMillis();
        // 输出相差的时间长度
        System.out.printf("%d milliseconds\n", l);

        Instant now1 = Instant.now();
        runAlgorithm2();
        Instant end2 = Instant.now();
        Duration between2 = Duration.between(now, end);
        long l2 = between.toMillis();
        System.out.printf("%d milliseconds\n", l2);
        // 比较是否快10倍
        boolean negative = between.multipliedBy(10).minus(between2).isNegative();
        System.out.printf("The first algorithm is %smore than ten times faster", negative ? " " : "not");
    }

    public static void runAlgorithm() {
        int size = 10;
        // 随机数获取前十个用list集合收集
        List<Integer> collect = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
        Collections.sort(collect);
        System.out.println(collect);
    }

    public static void runAlgorithm2() {
        int size = 10;
        /**
         * new Random().ints()返回的是IntStream，里面的元素是int 类型 无法用List集合收集，需要转换
         * IntStream是存的是int类型的stream,而Steam是一个存了Integer的stream。boxed的作用就是将int类型的stream转成了Integer类型的Stream。
         * IntStream range(int startInclusive，int endExclusive)以1为增量步长从startInclusive(包括)到endExclusive(不包括)返回顺序的有序IntStream
         */
        List<Integer> collect = new Random().ints().map(i -> i % 100).limit(size).boxed().collect(Collectors.toList());
        while (!IntStream.range(1, collect.size()).allMatch(i -> collect.get(i - 1).compareTo(collect.get(i)) <= 0)) {
            Collections.shuffle(collect);
        }
        System.out.println(collect);
    }
}
