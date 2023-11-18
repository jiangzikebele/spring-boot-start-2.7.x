package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.entity.AccountInfo;
import com.example.mapper.AccountInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class 继承basemapper查询方式 {

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    //------单表查询

    /**
     * 多条数据查询
     */
    @Test
    public void test01(){
        LambdaQueryWrapper<AccountInfo> query = new LambdaQueryWrapper<>();
        query.eq(AccountInfo::getId,10000);

        //返回List-entity
        List<AccountInfo> objects1 = accountInfoMapper.selectList(query);
        System.out.println(objects1);

        //返回List-map
        List<Map<String, Object>> objects2 = accountInfoMapper.selectMaps(query);
        System.out.println(objects2);

        //返回List<第一个字段>
        List<Object> objects3 = accountInfoMapper.selectObjs(query);
        System.out.println(objects3);

        //返回List-entity，map条件查询
        Map<String, Object> query2 = new HashMap<>();
        query2.put("id",8090);
        List<AccountInfo> objects4 = accountInfoMapper.selectByMap(query2);
        System.out.println(objects4);

        //返回List-entity，批量id查询
        List<Integer> ids = new ArrayList<>();
        ids.add(8090);
        ids.add(9090);
        List<AccountInfo> accountInfos = accountInfoMapper.selectBatchIds(ids);
        System.out.println(accountInfos);
    }

    /**
     * 单条数据查询
     */
    @Test
    public void test02(){
        LambdaQueryWrapper<AccountInfo> query = new LambdaQueryWrapper<>();
        query.eq(AccountInfo::getId,8090);

        //返回entity，多条件查询
        AccountInfo object1 = accountInfoMapper.selectOne(query);
        System.out.println(object1);

        //返回entity，id条件查询
        AccountInfo object2 = accountInfoMapper.selectById(9001);
        System.out.println(object2);

        //返回int，条数查询
        Integer count = accountInfoMapper.selectCount(query);
        System.out.printf("总条数：%d",count);
    }

    /**
     * 分页数据查询
     */
    @Test
    public void test03(){

        LambdaQueryWrapper<AccountInfo> query = new LambdaQueryWrapper<>();
        query.eq(AccountInfo::getId,8090);

        //返回条数，list-对象
        Page<AccountInfo> page = new Page<>(1, 10);
        Page<AccountInfo> accountInfoPage = accountInfoMapper.selectPage(page, query);

        long total = accountInfoPage.getTotal();
        List<AccountInfo> records = accountInfoPage.getRecords();
        System.out.printf("总条数：%d",total);
        System.out.println(records);

        //返回条数，list-map
        Page<Map<String, Object>> mapPage = new Page<>();
        Page<Map<String, Object>> mapPage1 = accountInfoMapper.selectMapsPage(mapPage, query);
        long total1 = mapPage1.getTotal();
        List<Map<String, Object>> records1 = mapPage1.getRecords();
        System.out.printf("总条数：%d",total1);
        System.out.println(records1);

    }

    /**
     * 事务操作
     */
    @Test
    public void test04(){
        //新增操作
        AccountInfo accountInfo = new AccountInfo();
        int insert = accountInfoMapper.insert(accountInfo);
        System.out.printf("执行成功条数：%d",insert);

        //更新条件
        LambdaQueryWrapper<AccountInfo> queryWrapper = new LambdaQueryWrapper<>();
        //更新值
        AccountInfo entity = new AccountInfo();
        int update = accountInfoMapper.update(entity, queryWrapper);
        System.out.printf("执行成功条数：%d",update);

        //id更新
        AccountInfo accountInfo1 = new AccountInfo();
        int update1 = accountInfoMapper.updateById(accountInfo1);
        System.out.printf("执行成功条数：%d",update1);

        //id删除
        int delete = accountInfoMapper.deleteById(20);
        System.out.printf("执行成功条数：%d",delete);

        //条件删除
        LambdaQueryWrapper<AccountInfo> queryWrapper1 = new LambdaQueryWrapper<>();
        int delete1 = accountInfoMapper.delete(queryWrapper1);
        System.out.printf("执行成功条数：%d",delete1);

        //批量id删除
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(12);
        ids.add(13);
        int delete2 = accountInfoMapper.deleteBatchIds(ids);
        System.out.printf("执行成功条数：%d",delete2);

        //map条件删除
        Map<String, Object> stringObjectMap = new HashMap<>();
        int delete3 = accountInfoMapper.deleteByMap(stringObjectMap);
        System.out.printf("执行成功条数：%d",delete3);

    }

    /**
     *
     */
    @Test
    public void test10(){

    }

    /**
     *
     */
    @Test
    public void test11(){

    }

}
