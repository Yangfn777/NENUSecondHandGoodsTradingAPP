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
    @RequestMapping("/updateGoods")
    public int updateGoods(Goods goods)throws Exception{
        return goodsService.updateGoods(goods);
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Goods> list()throws Exception{
        return goodsService.list();
    }

    @ResponseBody
    @RequestMapping("/queryDes")
    public List<Goods> queryDes(String des)throws Exception{
        return goodsService.queryDes(des);
    }

    @ResponseBody
    @RequestMapping("/queryId")
    public Goods queryId(int id)throws Exception{
        Goods goods=goodsService.queryId(id);
        goodsService.addView(goods);
        return goodsService.queryId(id);
    }

    @ResponseBody
    @RequestMapping("/queryType")
    public List<Goods> queryType(String type)throws Exception{
        return goodsService.queryType(type);
    }

    @ResponseBody
    @RequestMapping("/listGoods")
    public List<Goods> listGoods(int id)throws Exception{
        return goodsService.listGoods(id);
    }

    @ResponseBody
    @RequestMapping("/deleteGoods")
    public int deleteGoods(int id)throws Exception{
        return goodsService.deleteGoods(id);
    }


}
