package com.example.bean.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AccountInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLogin;
    private boolean active;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    // 枚举类型表示性别
    public enum Gender {
        Male, Female, Other
    }

    // 以下是构造函数、getter 和 setter 方法，以及其他可能需要的方法

    public AccountInfo() {
        // 默认构造函数
    }

    public AccountInfo(String username, String password, String fullName, Gender gender, LocalDate dateOfBirth,
                       String email, String phoneNumber, String address, boolean active) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.active = active;
    }

    // 其他 getter 和 setter 方法...
}
