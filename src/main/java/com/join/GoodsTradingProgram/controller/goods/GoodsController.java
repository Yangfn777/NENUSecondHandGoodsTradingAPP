package com.join.GoodsTradingProgram.controller.goods;

import com.join.GoodsTradingProgram.entity.feelBack.FeelBack;
import com.join.GoodsTradingProgram.entity.goods.Goods;
import com.join.GoodsTradingProgram.entity.img.Img;
import com.join.GoodsTradingProgram.entity.msg.Msg;
import com.join.GoodsTradingProgram.service.goodsService.GoodsService;
import com.join.GoodsTradingProgram.utils.img.ImgUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
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
    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    public int addGoods(@RequestParam(value = "file") MultipartFile files[], Goods goods)throws Exception{
        ImgUploadUtil imgUploadUtil=new ImgUploadUtil();
        Date date=new Date();
        goods.setDate(date);
        goods.setView(0);
        if(goodsService.addGoods(goods)==0){
            return 0;
        }
        int id=goods.getId();
        System.out.println(goods);
        for(MultipartFile file:files){
            if (file.isEmpty()) {
                System.out.println("文件为空");
                break;
            }
            String filename=null;
            String path="/yfn/good/"+id+"_";
            String picUrl="/img/good/"+id+"_";
//            String path="e:/yfn/good/"+id+"_";
//            String picUrl="/img/good/"+id+"_";
            filename=imgUploadUtil.imgUpload(file,path);
            Img img=new Img(id,picUrl+filename,path+filename);
            goodsService.addImg(img);
        }
        return id;
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


    @ResponseBody
    @RequestMapping("/deleteImg")
    public int deleteImg(int id)throws Exception{
        return goodsService.deleteImg(id);
    }

    @ResponseBody
    @RequestMapping("/addImg")
    public int addImg(int id,MultipartFile file)throws Exception{
        ImgUploadUtil imgUploadUtil=new ImgUploadUtil();
        if(file==null){
            return 0;
        }
        String filename=null;
            String path="/yfn/good/"+id+"_";
            String picUrl="/img/good/"+id+"_";
//        String path="e:/yfn/good/"+id+"_";
//        String picUrl="/img/good/"+id+"_";
        filename=imgUploadUtil.imgUpload(file,path);
        Img img=new Img(id,picUrl+filename,path+filename);
        return goodsService.addImg(img);
    }

    @ResponseBody
    @RequestMapping("/listImg")
    public List<Img> listImg(int id)throws Exception{
        return goodsService.listImg(id);
    }

    @ResponseBody
    @RequestMapping("/listFeelBack")
    public List<FeelBack> listFeelBack()throws Exception{
        return goodsService.litsFeelBack();
    }

    @ResponseBody
    @RequestMapping("/listMyFeelBack")
    public List<FeelBack> listMyFeelBack(int id)throws Exception{
        return goodsService.litsFeelBackId(id);
    }
    @ResponseBody
    @RequestMapping("/addFeelBack")
    public int addFeelBack(FeelBack feelBack)throws Exception{
        Date date=new Date();
        feelBack.setDate(date);
        return goodsService.addFeelBack(feelBack);
    }
    @ResponseBody
    @RequestMapping("/updateFeelBack")
    public int updateFeelBack(FeelBack feelBack)throws Exception{
        return goodsService.updateFeelBack(feelBack);
    }
    @ResponseBody
    @RequestMapping("/deleteFeelBack")
    public int deleteFeelBack(int id)throws Exception{
        return goodsService.deleteFeelBack(id);
    }

    @ResponseBody
    @RequestMapping("/listMsg")
    public List<Msg> listMsg()throws Exception{
        return goodsService.litsMsg();
    }

    @ResponseBody
    @RequestMapping("/listMyMsg")
    public List<Msg> listMyMsg(int id)throws Exception{
        return goodsService.litsMsgId(id);
    }
    @ResponseBody
    @RequestMapping("/addMsg")
    public int addMsg(Msg feelBack)throws Exception{
        Date date=new Date();
        feelBack.setDate(date);
        return goodsService.addMsg(feelBack);
    }

    @ResponseBody
    @RequestMapping("/deleteMsg")
    public int deleteMsg(int id)throws Exception{
        return goodsService.deleteMsg(id);
    }

}
