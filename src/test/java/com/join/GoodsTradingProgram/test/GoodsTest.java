package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.controller.goods.GoodsController;
import com.join.GoodsTradingProgram.entity.feelBack.FeelBack;
import com.join.GoodsTradingProgram.entity.goods.Goods;
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
        goods.setView(7);
        goods.setType("衣架");
//        System.out.println(goodsController.addGoods(goods));
    }

    @Test
    public void addFTest()throws Exception {
        FeelBack feelBack=new FeelBack();
        feelBack.setGid(2);
        feelBack.setStr("sdaad");
        feelBack.setUid(1);
        System.out.println(goodsController.addFeelBack(feelBack));
    }
    @Test
    public void deleteGoods()throws Exception{
        int id=4;
        System.out.println(goodsController.deleteGoods(id));
    }

    @Test
    public void queryType()throws Exception{
        System.out.println(goodsController.queryType("书"));
    }

    @Test
    public void queryId()throws Exception{
        System.out.println(goodsController.queryId(1));
    }

    @Test
    public void queryDes()throws Exception{
        System.out.println(goodsController.queryDes("论"));
    }

    @Test
    public void list()throws Exception{
        System.out.println(goodsController.list());
    }
    @Test
    public void listGoods()throws Exception{
        int id=1;
        System.out.println(goodsController.listGoods(id));
    }
}
