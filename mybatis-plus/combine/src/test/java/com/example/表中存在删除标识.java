package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.bean.entity.AccountInfo;
import com.example.mapper.AccountInfoMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class 表中存在删除标识 {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Test
    public void test01(){
        LambdaQueryWrapper<AccountInfo> query = new LambdaQueryWrapper<>();
        Integer integer = accountInfoMapper.selectCount(query);
        System.out.println(integer);

    }

}
