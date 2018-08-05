package com.offcn.mapper;

import com.offcn.pojo.Items;
import com.offcn.pojo.ItemsExample;
import com.offcn.pojo.ItemsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapper {
    int countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemsWithBLOBs record);

    int insertSelective(ItemsWithBLOBs record);

    List<ItemsWithBLOBs> selectByExampleWithBLOBs(ItemsExample example);

    List<Items> selectByExample(ItemsExample example);

    ItemsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemsWithBLOBs record, @Param("example") ItemsExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemsWithBLOBs record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByPrimaryKeySelective(ItemsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ItemsWithBLOBs record);

    int updateByPrimaryKey(Items record);
}