package com.example;

import com.example.bean.entity.Author;
import com.example.bean.entity.Book;
import com.example.mapper.AuthorMapper;
import com.example.mapper.BookMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class 生成作者表数据 {

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test01(){
        Faker faker = new Faker(new Locale("en-US"));

        // 生成10个作者
        for (int i = 0; i < 10000; i++) {
            String name = faker.book().author();
            Date birthDate = faker.date().birthday();
            String nationality = faker.nation().nationality();

            Author author = new Author(name, birthDate, nationality);
            // 在这里可以将作者数据存储到数据库或做其他处理
            int insert = authorMapper.insert(author);
            System.out.printf("执行成功条数：%d",insert);
        }
    }

    @Test
    public void test02(){
        Faker faker = new Faker(new Locale("en-US"));
        // 生成20本书
        for (int i = 0; i < 20000; i++) {
            String title = faker.book().title();
            int authorID = faker.number().numberBetween(1, 9999); // 11是作者的数量
            Date publicationDate = faker.date().past(365 * 10, TimeUnit.DAYS); // 在过去10年内出版的日期
            String ISBN = faker.code().isbn13();
            double price = faker.number().randomDouble(2, 10, 100); // 价格在10到100之间的随机数
            String category = faker.book().genre();

            Book book = new Book(title, authorID, publicationDate, ISBN, price, category);
            // 在这里可以将书籍数据存储到数据库或做其他处理
            int insert = bookMapper.insert(book);
            System.out.printf("执行成功条数：%d",insert);
        }
    }

}
