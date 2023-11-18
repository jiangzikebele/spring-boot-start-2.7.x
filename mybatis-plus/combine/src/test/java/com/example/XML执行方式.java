package com.example;

import com.example.bean.entity.AccountInfo;
import com.example.mapper.AccountInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class XML执行方式 {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    /**
     * 动态条件查询
     */
    @Test
    public void test01(){
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUsername("ee");
//        accountInfo.setActive(false);
//        accountInfo.setRegistrationDate(LocalDateTime.of(2023,9,23,12,3));
        accountInfo.setGender(AccountInfo.Gender.Other);
        List<AccountInfo> accountInfos = accountInfoMapper.queryAll(accountInfo);
        for (AccountInfo info : accountInfos) {
            System.out.println(info);
        }
    }

    /**
     * 动态新增数据
     */
    @Test
    public void test02(){
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setActive(false);
        accountInfo.setUsername("admin");
        accountInfo.setPassword("admin");
        int save = accountInfoMapper.save(accountInfo);
        System.out.printf("执行成功条数：%d",save);
    }


    /**
     * 动态条件删除
     */
    @Test
    public void test03(){
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUsername("ee");
        int remove = accountInfoMapper.remove(accountInfo);
        System.out.printf("执行成功条数：%d",remove);
    }

    /**
     * 动态更新
     */
    @Test
    public void test04(){
        AccountInfo entity = new AccountInfo();
        entity.setUsername("lianggangsheng");

        AccountInfo query = new AccountInfo();
        query.setId(16031L);

        int update = accountInfoMapper.edit(entity,query);
        System.out.printf("执行成功条数：%d",update);
    }
}
