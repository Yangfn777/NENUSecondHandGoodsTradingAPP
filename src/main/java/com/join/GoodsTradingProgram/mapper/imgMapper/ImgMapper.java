package com.join.GoodsTradingProgram.mapper.imgMapper;

import com.join.GoodsTradingProgram.entity.img.Img;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 17:25 2020/6/9
 */
@Repository
@Mapper
public interface ImgMapper {
    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<Img> listImg(@Param("gid")int gid)throws Exception;
    /**
     * 删除
     * @param
     * @return
     * @throws Exception
     */
    public int deleteImg(@Param("id")int id)throws Exception;

    /**
     * 删除
     * @param
     * @return
     * @throws Exception
     */
    public int addImg(@Param("img")Img img)throws Exception;


}


