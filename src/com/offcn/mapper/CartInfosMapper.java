package com.offcn.mapper;

import com.offcn.pojo.CartInfos;
import com.offcn.pojo.CartInfosExample;
import com.offcn.pojo.CartInfosKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartInfosMapper {
    int countByExample(CartInfosExample example);

    int deleteByExample(CartInfosExample example);

    int deleteByPrimaryKey(CartInfosKey key);

    int insert(CartInfos record);

    int insertSelective(CartInfos record);

    List<CartInfos> selectByExample(CartInfosExample example);

    CartInfos selectByPrimaryKey(CartInfosKey key);

    int updateByExampleSelective(@Param("record") CartInfos record, @Param("example") CartInfosExample example);

    int updateByExample(@Param("record") CartInfos record, @Param("example") CartInfosExample example);

    int updateByPrimaryKeySelective(CartInfos record);

    int updateByPrimaryKey(CartInfos record);
}