package com.join.GoodsTradingProgram.service.goodsService;

import com.join.GoodsTradingProgram.entity.feelBack.FeelBack;
import com.join.GoodsTradingProgram.entity.goods.Goods;
import com.join.GoodsTradingProgram.entity.img.Img;
import com.join.GoodsTradingProgram.entity.msg.Msg;
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
    public int addImg(Img img)throws Exception;
    public int deleteImg(int id)throws Exception;
    public int deleteFeelBack(int id)throws Exception;
    public int addFeelBack(FeelBack feelBack)throws Exception;
    public List<FeelBack> litsFeelBack()throws Exception;
    public List<FeelBack> litsFeelBackId(int id)throws Exception;
    public int updateFeelBack(FeelBack feelBack)throws Exception;
    public List<Img> listImg(int id)throws Exception;
    public int deleteMsg(int id)throws Exception;
    public int addMsg(Msg feelBack)throws Exception;
    public List<Msg> litsMsg()throws Exception;
    public List<Msg> litsMsgId(int id)throws Exception;
}
