package com.offcn.mapper;

import com.offcn.pojo.OrderItems;
import com.offcn.pojo.OrderItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemsMapper {
    int countByExample(OrderItemsExample example);

    int deleteByExample(OrderItemsExample example);

    int insert(OrderItems record);

    int insertSelective(OrderItems record);

    List<OrderItems> selectByExample(OrderItemsExample example);

    int updateByExampleSelective(@Param("record") OrderItems record, @Param("example") OrderItemsExample example);

    int updateByExample(@Param("record") OrderItems record, @Param("example") OrderItemsExample example);
}