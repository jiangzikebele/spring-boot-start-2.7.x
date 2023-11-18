package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bean.entity.AccountInfo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountInfoMapper extends BaseMapper<AccountInfo>{

    List<AccountInfo> queryAll(AccountInfo accountInfo);

    int save(AccountInfo accountInfo);

    int remove(AccountInfo accountInfo);

    int edit(@Param("entity") AccountInfo entity, @Param("query") AccountInfo query);
}
