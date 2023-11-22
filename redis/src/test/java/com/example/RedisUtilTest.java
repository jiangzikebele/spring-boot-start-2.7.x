package com.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.bean.Demo;
import com.example.util.RedisUtil;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = RedisApplication.class)
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test01() {
        //字符串
        String key1 = "test01";
        String v1 = "字符串";
        redisUtil.setValue(key1, v1);
        String value = (String) redisUtil.getValue(key1);
        System.out.printf("%s：%s", key1, value);

        //整数
        String key2 = "test02";
        int v2 = 2;
        redisUtil.setValue(key2, v2);
        int value2 = (int) redisUtil.getValue(key2);
        System.out.printf("\n%s：%d", key2, value2);

        //单精度
        String key3 = "test03";
        float v3 = 3L;
        redisUtil.setValue(key3, v3);
        double value3 = (double) redisUtil.getValue(key3);
        System.out.printf("\n%s：%f", key3, value3);

        //布尔值
        String key4 = "test04";
        boolean v4 = true;
        redisUtil.setValue(key4, v4);
        boolean value4 = (boolean) redisUtil.getValue(key4);
        System.out.printf("\n%s：%b", key4, value4);

        //字符
        String key5 = "test05";
        char v5 = 'f';
        redisUtil.setValue(key5, v5);
        String value5 = (String) redisUtil.getValue(key5);
        System.out.printf("\n%s：%s", key5, value5);

        //map
        String key6 = "test06";
        Map<String, Object> v6 = new HashMap<>();
        v6.put("1", 1);
        v6.put("2", "2");
        v6.put("3", "3");
        redisUtil.setValue(key6, v6);
        Map<String, Object> value6 = (Map<String, Object>) redisUtil.getValue(key6);
        System.out.println("\n"+key6 + "：" + value6);
//        int v101 = (int) value6.get("1");
//        String v102 = (String) value6.get("2");
//        System.out.println(v101);
//        System.out.println(v102);

        //list
        String key7 = "test07";
        List<Integer> v7 = new ArrayList<>();
        v7.add(1);
        v7.add(2);
        v7.add(3);
        redisUtil.setValue(key7, v7);
        List<Integer> value7 = (List<Integer>) redisUtil.getValue(key7);
        System.out.println("\n"+key7 + "：" + value7);

        //list
        String key8 = "test08";
        List<String> v8 = new ArrayList<>();
        v8.add("1");
        v8.add("2");
        v8.add("3");
        redisUtil.setValue(key8, v8);
        List<String> value8 = (List<String>) redisUtil.getValue(key8);
        System.out.println("\n"+key8 + "：" + value8);

        //list
        String key9 = "test09";
        List<Object> v9 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> tem = new HashMap<>();
            tem.put("1", 1);
            tem.put("2", "2");
            tem.put("3", '3');
            v9.add(tem);
        }
        redisUtil.setValue(key9, v9);
        List<Object> value9 = (List<Object>) redisUtil.getValue(key9);
        System.out.println("\n"+key9 + "：" + value9);

        //class
        String key10 = "test10";
        Demo demo = new Demo();
        demo.setFlag(true);
        demo.setName("admin");

        redisUtil.setStringValue(key10,demo);
        Demo demo1 = redisUtil.getClassValue(key10, Demo.class);

        System.out.println("\n"+key10 + "：" + demo1);

        //list-class
        String key11 = "test11";

        List<Demo> demos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Demo demo2 = new Demo();
            demo2.setFlag(true);
            demo2.setName("admin");
            demos.add(demo2);
        }
        redisUtil.setStringValue(key11,demos);
        List<Demo> demos1 = redisUtil.getListValue(key11, Demo.class);
        System.out.println("\n"+key11 + "：" + demos1);

    }

}
