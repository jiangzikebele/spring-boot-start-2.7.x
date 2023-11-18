package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.entity.Author;
import com.example.bean.entity.Book;
import com.example.mapper.AuthorMapper;
import com.example.mapper.BookMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.PanelUI;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class 继承mpjbasemapper查询方式 {

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private BookMapper bookMapper;


    /**
     * 条数查询
     */
    @Test
    public void test01(){
        MPJLambdaWrapper<Author> query = new MPJLambdaWrapper<>();
        //关联查询
        query.leftJoin(Book.class,Book::getAuthorId,Author::getAuthorId);
        query.eq(Book::getAuthorId,2);

        //条数查询
        Long aLong = authorMapper.selectJoinCount(query);
        System.out.printf("总条数：%d",aLong);
    }

    /**
     * 单挑数据查询
     */
    @Test
    public void test02(){
        MPJLambdaWrapper<Author> query = new MPJLambdaWrapper<>();
        //关联查询
        query.leftJoin(Book.class,Book::getAuthorId,Author::getAuthorId);
        query.eq(Author::getAuthorId,2);
        query.eq(Book::getIsbn,"9791796695631");

        //返回对象
        Author author = authorMapper.selectJoinOne(Author.class, query);
        System.out.println(author);

        //返回map
        Map<String, Object> stringObjectMap = authorMapper.selectJoinMap(query);
        System.out.println(stringObjectMap);

    }

    /**
     * 多条数据查询
     */
    @Test
    public void test03(){
        MPJLambdaWrapper<Author> query = new MPJLambdaWrapper<>();
        //关联查询
        query.leftJoin(Book.class,Book::getAuthorId,Author::getAuthorId);
        query.eq(Author::getAuthorId,2);

        // 返回list-对象
        List<Author> authors = authorMapper.selectJoinList(Author.class, query);
        System.out.println(authors);

        // 返回list-map
        List<Map<String, Object>> maps = authorMapper.selectJoinMaps(query);
        System.out.println(maps);

    }

    /**
     * 分页数据查询
     */
    @Test
    public void test04(){
        MPJLambdaWrapper<Author> query = new MPJLambdaWrapper<>();
        //关联查询
        query.leftJoin(Book.class,Book::getAuthorId,Author::getAuthorId);
        query.eq(Author::getAuthorId,2);


        //返回条数，list-对象
        Page<Author> page = new Page(1,10);
        Page<Author> authorPage = authorMapper.selectJoinPage(page, Author.class, query);

        long total = authorPage.getTotal();
        List<Author> records = authorPage.getRecords();
        System.out.printf("条件查询总条数：%d",total);
        System.out.println(records);


        //返回条数，list-map
        IPage<Map<String,Object>> objectIPage = new Page<Map<String,Object>>(1,10);
        IPage<Map<String, Object>> mapIPage = authorMapper.selectJoinMapsPage(objectIPage, query);

        long total1 = mapIPage.getTotal();
        List<Map<String, Object>> records1 = mapIPage.getRecords();
        System.out.printf("条件查询总条数：%d",total1);
        System.out.println(records1);

    }

}
