package com.example.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "lgsh_id1")
public class LgshId1 {

    //自增id
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    public LgshId1() {
    }

    public LgshId1(String name) {
        this.name = name;
    }
}
