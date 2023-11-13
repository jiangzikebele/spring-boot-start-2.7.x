package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bean.entity.AccountInfo;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountInfoMapper extends BaseMapper<AccountInfo>, MPJBaseMapper<AccountInfo>{
}
