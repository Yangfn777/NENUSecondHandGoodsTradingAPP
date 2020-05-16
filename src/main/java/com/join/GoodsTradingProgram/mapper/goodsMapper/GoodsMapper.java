package com.join.GoodsTradingProgram.mapper.goodsMapper;

import com.join.GoodsTradingProgram.entity.goods.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 15:13 2020/5/16
 */
@Repository
@Mapper
public interface GoodsMapper {
    /**
     * 增加商品
     * @param
     * @return
     * @throws Exception
     */
    public int addGoods(@Param("goods")Goods goods)throws Exception;

    /**
     * 删除商品
     * @param
     * @return
     * @throws Exception
     */
    public int deleteGoods(@Param("id")int id)throws Exception;
}
