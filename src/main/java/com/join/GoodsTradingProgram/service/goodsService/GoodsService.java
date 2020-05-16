package com.join.GoodsTradingProgram.service.goodsService;

import com.join.GoodsTradingProgram.entity.goods.Goods;
import org.springframework.stereotype.Service;


/**
 * @Author: Yangfn
 * @Description:
 * @Date: 16:17 2020/5/16
 */

public interface GoodsService {
    public int deleteGoods(int id)throws Exception;

    public int addGoods(Goods goods)throws Exception;
}
