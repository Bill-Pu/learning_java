package com.example.security;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：Puyb
 * @date ：Created in 2022/8/31 16:51
 * @description：
 */

public class FastJsonTest {
    @Test
    public void test(){
//        JSON.toJSON()
//        JSON.parseObject()
        List<String> stringList1 = Lists.newArrayList("AAA", "2AA2", "33");
        stringList1.stream().peek(String::toLowerCase).collect(Collectors.toList());
        List<String> collect = stringList1.stream().peek(String::toLowerCase).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
        List<String> collect1 = collect.stream().map(String::toLowerCase).collect(Collectors.toList());

        List<String> stringList2 = Lists.newArrayList("11", "22", "33");

        //支持自定义返回值，将字符串转换为数字
        List<Integer> mapResultList = stringList2.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        System.out.println(mapResultList);

        //可以看到返回值还是List<String>
        List<String> peekResultList = stringList2.stream().peek(s -> Integer.valueOf(s)).collect(Collectors.toList());
        System.out.println(peekResultList);
        Object o = JSON.toJSON(stringList1);
        System.out.println("------------");
        System.out.println(String.valueOf(o));
        List<String> strings = JSON.parseArray(o.toString(), String.class);
        System.out.println(strings);

    }
}
