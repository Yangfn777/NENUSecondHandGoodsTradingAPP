package com.join.GoodsTradingProgram.service.goodsService.impl;

import com.join.GoodsTradingProgram.entity.goods.Goods;
import com.join.GoodsTradingProgram.mapper.goodsMapper.GoodsMapper;
import com.join.GoodsTradingProgram.service.goodsService.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 16:18 2020/5/16
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    public int deleteGoods(int id)throws Exception{
        return goodsMapper.deleteGoods(id);
    }

    public int addGoods(Goods goods)throws Exception{
        return goodsMapper.addGoods(goods);
    }
}
