package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bean.entity.AccountInfo;
import com.example.util.StringUtil;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface AccountInfoMapper extends BaseMapper<AccountInfo> {

    List<AccountInfo> queryAll(AccountInfo accountInfo);

    int save(AccountInfo accountInfo);

    int remove(AccountInfo accountInfo);

    int edit(@Param("entity") AccountInfo entity, @Param("query") AccountInfo query);

    //---------

    @SelectProvider(type = AccountInfoProvider.class, method = "queryAll2")
    List<AccountInfo> queryAll2(AccountInfo accountInfo);

    @InsertProvider(type = AccountInfoProvider.class, method = "save2")
    int save2(AccountInfo accountInfo);

    @DeleteProvider(type = AccountInfoProvider.class, method = "remove2")
    int remove2(AccountInfo accountInfo);

    @UpdateProvider(type = AccountInfoProvider.class, method = "edit2")
    int edit2(@Param("entity") AccountInfo entity, @Param("query") AccountInfo query);



    public class AccountInfoProvider {
        //动态查询
        public String queryAll2(AccountInfo accountInfo) {
            return new SQL() {
                {
                    SELECT("*");
                    FROM("account_info");

                    if (accountInfo.getActive() != null) {
                        WHERE("active = #{active}");
                    }
                    if (accountInfo.getId() != null) {
                        WHERE("id = #{id}");
                    }
                    if (accountInfo.getGender() != null) {
                        WHERE("gender = #{gender}");
                    }
                    if (accountInfo.getDateOfBirth() != null) {
                        WHERE("dateOf_birth  #{dateOfBirth}");
                    }
                    if (accountInfo.getRegistrationDate() != null) {
                        WHERE("registration_date = #{registrationDate}");
                    }
                    if (accountInfo.getLastLogin() != null) {
                        WHERE("last_login = #{lastLogin}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getUsername())) {
                        WHERE("username like concat('%',#{username},'%')");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getFullName())) {
                        WHERE("full_name like concat('%',#{fullName},'%')");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getAddress())) {
                        WHERE("address = #{address}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getEmail())) {
                        WHERE("email = #{email}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getPhoneNumber())) {
                        WHERE("phone_number = #{phoneNumber}");
                    }

                }
            }.toString();
        }

        //动态新增
        public String save2(AccountInfo accountInfo) {
            return new SQL() {
                {
                    INSERT_INTO("account_info");
                    if (accountInfo.getActive() != null) {
                        VALUES("active","#{active}");
                    }
                    if (accountInfo.getId() != null) {
                        VALUES("id","#{id}");
                    }
                    if (accountInfo.getGender() != null) {
                        VALUES("gender","#{gender}");
                    }
                    if (accountInfo.getDateOfBirth() != null) {
                        VALUES("dateOf_birth","#{dateOfBirth}");
                    }
                    if (accountInfo.getRegistrationDate() != null) {
                        VALUES("registration_date","#{registrationDate}");
                    }
                    if (accountInfo.getLastLogin() != null) {
                        VALUES("last_login","#{lastLogin}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getUsername())) {
                        VALUES("username","#{username}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getPassword())) {
                        VALUES("password","#{password}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getFullName())) {
                        VALUES("full_name","#{fullName}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getAddress())) {
                        VALUES("address","#{address}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getEmail())) {
                        VALUES("email","#{email}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getPhoneNumber())) {
                        VALUES("phone_number","#{phoneNumber}");
                    }
                }
            }.toString();
        }

        //动态删除
        public String remove2(AccountInfo accountInfo) {
            return new SQL(){
                {
                    DELETE_FROM("account_info");
                    if (accountInfo.getActive() != null) {
                        WHERE("active = #{active}");
                    }
                    if (accountInfo.getId() != null) {
                        WHERE("id = #{id}");
                    }
                    if (accountInfo.getGender() != null) {
                        WHERE("gender = #{gender}");
                    }
                    if (accountInfo.getDateOfBirth() != null) {
                        WHERE("dateOf_birth  #{dateOfBirth}");
                    }
                    if (accountInfo.getRegistrationDate() != null) {
                        WHERE("registration_date = #{registrationDate}");
                    }
                    if (accountInfo.getLastLogin() != null) {
                        WHERE("last_login = #{lastLogin}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getUsername())) {
                        WHERE("username = #{username}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getFullName())) {
                        WHERE("full_name = #{fullName}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getAddress())) {
                        WHERE("address = #{address}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getEmail())) {
                        WHERE("email = #{email}");
                    }
                    if (StringUtil.isNotNullOrEmpty(accountInfo.getPhoneNumber())) {
                        WHERE("phone_number = #{phoneNumber}");
                    }
                }
            }.toString();
        }

        //动态删除
        public String edit2(@Param("entity") AccountInfo entity, @Param("query") AccountInfo query) {
            return new SQL(){
                {
                    UPDATE("account_info");

                    //-set
                    if (entity.getActive() != null) {
                        SET("active = #{active}");
                    }
                    if (entity.getId() != null) {
                        SET("id = #{id}");
                    }
                    if (entity.getGender() != null) {
                        SET("gender = #{gender}");
                    }
                    if (entity.getDateOfBirth() != null) {
                        SET("dateOf_birth  #{dateOfBirth}");
                    }
                    if (entity.getRegistrationDate() != null) {
                        SET("registration_date = #{registrationDate}");
                    }
                    if (entity.getLastLogin() != null) {
                        SET("last_login = #{lastLogin}");
                    }
                    if (StringUtil.isNotNullOrEmpty(entity.getUsername())) {
                        SET("username = #{username}");
                    }
                    if (StringUtil.isNotNullOrEmpty(entity.getFullName())) {
                        SET("full_name = #{fullName}");
                    }
                    if (StringUtil.isNotNullOrEmpty(entity.getAddress())) {
                        SET("address = #{address}");
                    }
                    if (StringUtil.isNotNullOrEmpty(entity.getEmail())) {
                        SET("email = #{email}");
                    }
                    if (StringUtil.isNotNullOrEmpty(entity.getPhoneNumber())) {
                        SET("phone_number = #{phoneNumber}");
                    }

                    //-where
                    if (query.getActive() != null) {
                        WHERE("active = #{active}");
                    }
                    if (query.getId() != null) {
                        WHERE("id = #{id}");
                    }
                    if (query.getGender() != null) {
                        WHERE("gender = #{gender}");
                    }
                    if (query.getDateOfBirth() != null) {
                        WHERE("dateOf_birth  #{dateOfBirth}");
                    }
                    if (query.getRegistrationDate() != null) {
                        WHERE("registration_date = #{registrationDate}");
                    }
                    if (query.getLastLogin() != null) {
                        WHERE("last_login = #{lastLogin}");
                    }
                    if (StringUtil.isNotNullOrEmpty(query.getUsername())) {
                        WHERE("username = #{username}");
                    }
                    if (StringUtil.isNotNullOrEmpty(query.getFullName())) {
                        WHERE("full_name = #{fullName}");
                    }
                    if (StringUtil.isNotNullOrEmpty(query.getAddress())) {
                        WHERE("address = #{address}");
                    }
                    if (StringUtil.isNotNullOrEmpty(query.getEmail())) {
                        WHERE("email = #{email}");
                    }
                    if (StringUtil.isNotNullOrEmpty(query.getPhoneNumber())) {
                        WHERE("phone_number = #{phoneNumber}");
                    }
                }
            }.toString();
        }


    }
}
