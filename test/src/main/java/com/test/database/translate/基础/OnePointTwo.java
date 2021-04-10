package com.test.database.translate.基础;

import com.test.database.translate.std.StdDraw;
import com.test.database.translate.std.StdOut;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class OnePointTwo {
    public static void main(String[] args) {
        printString();
        printStringTwo();
        System.out.println(checkCircleRotation("SACTGACG", "TGACGAC"));
        System.out.println(myStery("abcsds"));
        MyCounter count = new MyCounter("count");
        // 1.2.9
        int rank = BinarySearch.rank(new int[]{2, 2, 1, 2, 1, 4, 2, 12, 3, 4, 65, 24}, 3, count);
        System.out.println(count.tally());
    }

    // 1.2.4
    public static void printString() {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1);
        System.out.println(string2);
    }

    // 1.2.5
    public static void printStringTwo() {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        System.out.println(s);
    }

    // 1.2.6
    public static boolean checkCircleRotation(String s1, String s2) {
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            s1 = s1.substring(1, s1.length()) + s1.substring(0, 1);
            if (s1.equals(s2)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    // 1.2.7
    public static String myStery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return myStery(b) + myStery(a);
    }


}

class BinarySearch {
    public static int rank(int[] arr, int value, MyCounter counter) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > value) {
                counter.increment();
                right = mid - 1;
            } else if (arr[mid] < value) {
                counter.increment();
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int rank2(int[] arr, int value) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                int count = 0;
                while (mid >= 0) {
                    count++;
                    mid--;
                }
                return count;
            }
        }
        return -1;
    }

    public static int randTwo(int[] arr, int left, int right, int value) {
        if (left > right) {
            System.out.println("- " + value);
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            System.out.println("+ " + value);
            return mid;
        } else if (arr[mid] < value) {
            return randTwo(arr, mid + 1, right, value);
        } else {
            return randTwo(arr, left, mid - 1, value);
        }
    }
}

class MyCounter {
    private final String name;
    private int count;

    public MyCounter(String id) {
        this.name = id;
    }

    public void increment() {
        this.count++;
    }

    public int tally() {
        return this.count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}


// 1.2.10
class VisualCounter {
    private int count;//计数器
    private int operater;//一共操作了多少次
    private int max;//计数器最大绝对值
    private int n;//操作的最大次数

    public VisualCounter(int N, int Max) {
        this.n = N;
        this.max = Math.abs(Max);
        StdDraw.setXscale(0, N + 1);//给StdDraw类设置参数x,y的范围
        StdDraw.setYscale(0, Max * 2);//
        StdDraw.setPenRadius(0.05);//设置笔的半径
    }

    public void increment() {
        operater++;//操作次数+1
        count++;//计数器加一
        StdDraw.point(operater, count);//画出以操作数和计数器为参数的圆
        if (operater > n || Math.abs(count) > max) {
            throw new RuntimeException();
        }
    }

    public void decliine() {
        operater++;//操作数+1
        count--;//计数器减一
        StdDraw.point(operater, count);//画出一个点
        if (operater > n || Math.abs(count) > max)
            throw new RuntimeException();
    }

    public int tally() {
        return count;//返回计数器的值
    }

    public String toString() {
        return "操作了" + operater + "次" + "此时的count为" + count + "次";
    }

    public static void main(String[] args) {
        int n = 5;
        int max = 3;

        VisualCounter visualcount = new VisualCounter(n, max);
        visualcount.increment();
        visualcount.increment();
        visualcount.increment();
        visualcount.decliine();
        visualcount.decliine();
        StdOut.println(visualcount);
    }
}

// 1.2.11
class SmartDate {
    private final int month;
    private final int day;
    private final int year;

    SmartDate(int month, int day, int year) {
        int maxDay;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else {
            maxDay = 31;
        }
        if (month % 2 == 0 && day > 30) throw new IllegalArgumentException("day is error.");
        //非润年的2月，日只能是1至28的数
        if (year % 400 != 0 && (!(year % 4 == 0 && year % 100 != 0)) && month == 2 && day > 28)
            throw new IllegalArgumentException("day is error.");
        //润年的2月，日只能是1至29的数
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month == 2 && day > 29)
            throw new IllegalArgumentException("day is error.");
        if (year < 1000 || year > 2500) {
            throw new RuntimeException("年份不合法");
        }
        if (month < 1 || month > 12) {
            throw new RuntimeException("月份不合法");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }


    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return month() +
                "/" + day() +
                "/" + year();
    }

    // 1.2.12
    public String dayOfWeek() {
        String[] arr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        // 如果想设置为某个日期，可以一次设置年月日时分秒，由于月份下标从0开始赋值月份要-1
        // cal.set(year, month, date, hourOfDay, minute, second);
        cal.set(year, month, day);
        return arr[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate(2, 28, 2021);
        String s = smartDate.dayOfWeek();
        System.out.println(s);
    }
}