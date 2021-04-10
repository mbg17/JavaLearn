package com.springboot.demo.lianxi;

import java.util.*;

public class Solutation {
    public static String reorganizeString(String S) {
        char[] chars = S.toCharArray();
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            characterIntegerHashMap.put(chars[i],characterIntegerHashMap.getOrDefault(chars[i],0)+1);
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(characterIntegerHashMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        System.out.println(Arrays.toString(entries.toArray()));
        if(entries.get(0).getValue()>(chars.length+1)/2){
            return "--";
        }
        
        return "";
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaab"));
    }
}
