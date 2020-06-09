package com.join.GoodsTradingProgram.service.goodsService;

import com.join.GoodsTradingProgram.entity.goods.Goods;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: Yangfn
 * @Description:
 * @Date: 16:17 2020/5/16
 */

public interface GoodsService {
    public int deleteGoods(int id)throws Exception;
    public List<Goods> listGoods(int id)throws Exception;
    public List<Goods> list()throws Exception;
    public List<Goods> queryType(String type)throws Exception;
    public List<Goods> queryDes(String des)throws Exception;
    public Goods queryId(int id)throws Exception;
    public int addGoods(Goods goods)throws Exception;
    public int updateGoods(Goods goods)throws Exception;
    public int addView(Goods goods)throws Exception;
}
