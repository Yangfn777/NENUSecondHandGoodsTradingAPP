package com.join.GoodsTradingProgram.controller.goods;

import com.join.GoodsTradingProgram.entity.goods.Goods;
import com.join.GoodsTradingProgram.service.goodsService.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 16:26 2020/5/16
 */
@Controller
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/addGoods")
    public int addGoods(Goods goods)throws Exception{
        return goodsService.addGoods(goods);
    }

    @ResponseBody
    @RequestMapping("/deleteGoods")
    public int deleteGoods(int id)throws Exception{
        return goodsService.deleteGoods(id);
    }

}
