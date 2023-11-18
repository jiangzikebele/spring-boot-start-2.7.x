package com.example.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "authors")
public class Author {
    @TableId(value = "author_id",type = IdType.AUTO)
    private int authorId;
    private String name;
    private Date birthDate;
    private String nationality;

    // 构造函数
    public Author(String name, Date birthDate, String nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }

    public Author() {
    }
}
