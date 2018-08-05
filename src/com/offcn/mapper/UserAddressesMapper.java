package com.offcn.mapper;

import com.offcn.pojo.UserAddresses;
import com.offcn.pojo.UserAddressesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddressesMapper {
    int countByExample(UserAddressesExample example);

    int deleteByExample(UserAddressesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAddresses record);

    int insertSelective(UserAddresses record);

    List<UserAddresses> selectByExample(UserAddressesExample example);

    UserAddresses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAddresses record, @Param("example") UserAddressesExample example);

    int updateByExample(@Param("record") UserAddresses record, @Param("example") UserAddressesExample example);

    int updateByPrimaryKeySelective(UserAddresses record);

    int updateByPrimaryKey(UserAddresses record);
}