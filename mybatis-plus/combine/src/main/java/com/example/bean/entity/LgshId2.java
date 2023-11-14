package com.example.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "lgsh_id2")
public class LgshId2 {

    //填充式uuid
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String name;

    public LgshId2() {
    }

    public LgshId2(String name) {
        this.name = name;
    }
}
