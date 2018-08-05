package com.offcn.mapper;

import com.offcn.pojo.ItemCategories;
import com.offcn.pojo.ItemCategoriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemCategoriesMapper {
    int countByExample(ItemCategoriesExample example);

    int deleteByExample(ItemCategoriesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemCategories record);

    int insertSelective(ItemCategories record);

    List<ItemCategories> selectByExample(ItemCategoriesExample example);

    ItemCategories selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemCategories record, @Param("example") ItemCategoriesExample example);

    int updateByExample(@Param("record") ItemCategories record, @Param("example") ItemCategoriesExample example);

    int updateByPrimaryKeySelective(ItemCategories record);

    int updateByPrimaryKey(ItemCategories record);
}