package com.example.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import sun.nio.cs.UTF_32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：Puyb
 * @date ：Created in 2022/8/10 15:56
 * @description：
 */
public class Test {
    public static void main(String[] args) {

//        List<String> ins = new ArrayList<String>(Arrays.asList(codes));
//        final String string = JSON.toJSONString(ins);
//        System.out.println(string);
//        List<String> object = JSON.parseObject(string,List.class);
//        String[] strings = new String[object.size()];
//        final Object[] objects = object.toArray(strings);
//
//        List<List<String>> te = new ArrayList<>();
//        te.add(object);
//
//        te.add(new ArrayList<>(object));
//        final String tess = JSON.toJSONString(te);
//        List<List<String>> lists = JSON.parseObject(tess, new TypeReference<List<List<String>>>() {
//        });
//        System.out.println(tess);

//        final boolean matches = "digital".matches("ital.*");
//        System.out.println(matches);
//        System.out.println("digital".matches(".*dig.*"));
//        boolean f1 = false;
//        boolean f2 = false;
//        System.out.println(f1&f2);
        String[] codes = {"A","B","C"};
        String[] codes2 = {"A","B","F"};
        List<String> strings = new ArrayList<>(Arrays.asList(codes));
        List<String> strings2 = new ArrayList<>(Arrays.asList(codes2));
        final boolean b = strings.addAll(strings2);
        System.out.println(strings.toString());
        final boolean b1 = strings.removeAll(strings2);
        System.out.println(strings.toString());
    }
}
