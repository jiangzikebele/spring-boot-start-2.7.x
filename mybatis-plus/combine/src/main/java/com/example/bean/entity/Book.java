package com.example.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "books")
public class Book {
    @TableId(value = "book_id",type = IdType.AUTO)
    private int bookId;
    private String title;
    private int authorId;
    private Date publicationDate;
    private String isbn;
    private double price;
    private String category;

    // 构造函数
    public Book(String title, int authorId, Date publicationDate, String isbn, double price, String category) {
        this.title = title;
        this.authorId = authorId;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public Book() {
    }

}
