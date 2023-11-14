package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.bean.entity.AccountInfo;
import com.example.bean.entity.LgshId1;
import com.example.bean.entity.LgshId2;
import com.example.bean.entity.LgshId3;
import com.example.mapper.AccountInfoMapper;
import com.example.mapper.LgshId1Mapper;
import com.example.mapper.LgshId2Mapper;
import com.example.mapper.LgshId3Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class 三种id填充方式 {

    @Autowired
    private LgshId1Mapper lgshId1Mapper;

    @Autowired
    private LgshId2Mapper lgshId2Mapper;

    @Autowired
    private LgshId3Mapper lgshId3Mapper;

    /**
     * id自增
     */
    @Test
    public void test01(){
        LgshId1 lgshId1 = new LgshId1("admin");
        int insert = lgshId1Mapper.insert(lgshId1);
        System.out.printf("执行成功条数：%d",insert);
    }

    /**
     * 自动生成uuid,32位uuid
     */
    @Test
    public void test02(){
        LgshId2 lgshId2 = new LgshId2("admin");
        int insert = lgshId2Mapper.insert(lgshId2);
        System.out.printf("执行成功条数：%d",insert);
    }

    /**
     * 自动生成雪花id，19位
     */
    @Test
    public void test03(){
        LgshId3 lgshId3 = new LgshId3("admin");
        int insert = lgshId3Mapper.insert(lgshId3);
        System.out.printf("执行成功条数：%d",insert);
    }


}