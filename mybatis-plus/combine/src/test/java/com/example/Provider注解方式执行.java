package com.example;

import com.example.bean.entity.AccountInfo;
import com.example.mapper.AccountInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class Provider注解方式执行 {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    /**
     * 动态条件查询
     */
    @Test
    public void test01(){
        AccountInfo accountInfo = new AccountInfo();
//        accountInfo.setId(10324L);
        accountInfo.setUsername("as");
        List<AccountInfo> accountInfos = accountInfoMapper.queryAll2(accountInfo);
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
        int save = accountInfoMapper.save2(accountInfo);
        System.out.printf("执行成功条数：%d",save);
    }


    /**
     * 动态条件删除
     */
    @Test
    public void test03(){
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUsername("ac");
        int remove = accountInfoMapper.remove2(accountInfo);
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
