package com.offcn.mapper;

import com.offcn.pojo.ItemRanks;
import com.offcn.pojo.ItemRanksExample;
import com.offcn.pojo.ItemRanksKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemRanksMapper {
    int countByExample(ItemRanksExample example);

    int deleteByExample(ItemRanksExample example);

    int deleteByPrimaryKey(ItemRanksKey key);

    int insert(ItemRanks record);

    int insertSelective(ItemRanks record);

    List<ItemRanks> selectByExampleWithBLOBs(ItemRanksExample example);

    List<ItemRanks> selectByExample(ItemRanksExample example);

    ItemRanks selectByPrimaryKey(ItemRanksKey key);

    int updateByExampleSelective(@Param("record") ItemRanks record, @Param("example") ItemRanksExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemRanks record, @Param("example") ItemRanksExample example);

    int updateByExample(@Param("record") ItemRanks record, @Param("example") ItemRanksExample example);

    int updateByPrimaryKeySelective(ItemRanks record);

    int updateByPrimaryKeyWithBLOBs(ItemRanks record);

    int updateByPrimaryKey(ItemRanks record);
}