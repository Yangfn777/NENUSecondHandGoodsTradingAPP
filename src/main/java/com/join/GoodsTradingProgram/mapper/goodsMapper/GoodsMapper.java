package com.join.GoodsTradingProgram.mapper.goodsMapper;

import com.join.GoodsTradingProgram.entity.goods.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 15:13 2020/5/16
 */
@Repository
@Mapper
public interface GoodsMapper {
    /**
     * 增加商品
     * @param
     * @return
     * @throws Exception
     */
    public int addGoods(@Param("goods")Goods goods)throws Exception;

    /**
     * 删除商品
     * @param
     * @return
     * @throws Exception
     */
    public int deleteGoods(@Param("id")int id)throws Exception;

    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<Goods> list()throws Exception;
    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<Goods> listGoods(@Param("id")int id)throws Exception;
    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public int updateGoods(@Param("goods")Goods goods)throws Exception;

    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public int addView(@Param("goods")Goods goods)throws Exception;

    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<Goods> queryType(@Param("type")String type)throws Exception;
    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<Goods> queryDes(@Param("des")String des)throws Exception;
    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public Goods queryId(@Param("id")int id)throws Exception;
}
