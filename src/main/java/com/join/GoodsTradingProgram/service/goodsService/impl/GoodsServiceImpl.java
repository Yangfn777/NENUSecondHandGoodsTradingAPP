package com.join.GoodsTradingProgram.service.goodsService.impl;

import com.join.GoodsTradingProgram.entity.feelBack.FeelBack;
import com.join.GoodsTradingProgram.entity.goods.Goods;
import com.join.GoodsTradingProgram.entity.img.Img;
import com.join.GoodsTradingProgram.entity.msg.Msg;
import com.join.GoodsTradingProgram.mapper.feelBackMapper.FeelBackMapper;
import com.join.GoodsTradingProgram.mapper.goodsMapper.GoodsMapper;
import com.join.GoodsTradingProgram.mapper.imgMapper.ImgMapper;
import com.join.GoodsTradingProgram.mapper.msgMapper.MsgMapper;
import com.join.GoodsTradingProgram.service.goodsService.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 16:18 2020/5/16
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    FeelBackMapper feelBackMapper;

    @Autowired
    MsgMapper msgMapper;

    @Autowired
    ImgMapper imgMapper;

    public int deleteGoods(int id)throws Exception{
        List<Img> imgs=imgMapper.listImg(id);
        for(Img img:imgs){
            File file=new File(img.getPath());
            file.delete();
            imgMapper.deleteImg(img.getId());
        }
        return goodsMapper.deleteGoods(id);
    }

    public int addGoods(Goods goods)throws Exception{
        return goodsMapper.addGoods(goods);
    }
    public List<Goods> listGoods(int id)throws Exception{
        return goodsMapper.listGoods(id);
    }
    public List<Goods> list()throws Exception{
        return goodsMapper.list();
    }
    public int updateGoods(Goods goods)throws Exception{
        return goodsMapper.updateGoods(goods);
    }
    public List<Goods> queryType(String type)throws Exception{
        return goodsMapper.queryType(type);
    }
    public List<Goods> queryDes(String des)throws Exception{
        return goodsMapper.queryDes(des);
    }
    public Goods queryId(int id)throws Exception{
        return goodsMapper.queryId(id);
    }

    public int addView(Goods goods)throws Exception{
        goods.setView(goods.getView()+1);
        return goodsMapper.addView(goods);
    }
    public int addImg(Img img)throws Exception{
        return imgMapper.addImg(img);
    }
    public int deleteImg(int id)throws Exception{
        return imgMapper.deleteImg(id);
    }
    public List<Img> listImg(int gid)throws Exception{
        return imgMapper.listImg(gid);
    }

    public int deleteFeelBack(int id)throws Exception{
        return feelBackMapper.deleteFeelBack(id);
    }
    public int addFeelBack(FeelBack feelBack)throws Exception{
        return feelBackMapper.addFeelBack(feelBack);
    }
    public List<FeelBack> litsFeelBack()throws Exception{
        return feelBackMapper.listAll();
    }
    public List<FeelBack> litsFeelBackId(int id)throws Exception{
        return feelBackMapper.queryId(id);
    }
    public int updateFeelBack(FeelBack feelBack)throws Exception{
        return feelBackMapper.updateFeelBack(feelBack);
    }
    public int deleteMsg(int id)throws Exception{
        return msgMapper.deleteMsg(id);
    }
    public int addMsg(Msg feelBack)throws Exception{
        return msgMapper.addMsg(feelBack);
    }
    public List<Msg> litsMsg()throws Exception{
        return msgMapper.listAll();
    }
    public List<Msg> litsMsgId(int id)throws Exception{
        return msgMapper.queryId(id);}

}
