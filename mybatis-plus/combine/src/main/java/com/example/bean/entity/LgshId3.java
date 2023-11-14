package com.example.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "lgsh_id3")
public class LgshId3 {

    //雪花id
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;

    private String name;

    public LgshId3() {
    }

    public LgshId3(String name) {
        this.name = name;
    }
}
