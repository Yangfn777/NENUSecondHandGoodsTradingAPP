package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.controller.goods.GoodsController;
import com.join.GoodsTradingProgram.entity.goods.Goods;
import com.join.GoodsTradingProgram.mapper.goodsMapper.GoodsMapper;
import com.join.GoodsTradingProgram.service.goodsService.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 16:14 2020/5/16
 */
@SpringBootTest
public class GoodsTest {
    @Autowired
    GoodsController goodsController;

    @Test
    public void addGoodsTest()throws Exception {
        Goods goods=new Goods();
        goods.setUserId(1);
        goods.setDegree(7);
        goods.setType("衣架");
        System.out.println(goodsController.addGoods(goods));
    }
    @Test
    public void deleteGoods()throws Exception{
        int id=4;
        System.out.println(goodsController.deleteGoods(id));
    }
}
