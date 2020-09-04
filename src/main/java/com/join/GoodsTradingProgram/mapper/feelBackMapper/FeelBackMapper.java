package com.join.GoodsTradingProgram.mapper.feelBackMapper;

import com.join.GoodsTradingProgram.entity.feelBack.FeelBack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 21:24 2020/8/9
 */
@Mapper
@Repository
public interface FeelBackMapper {
    public int addFeelBack(FeelBack feelback)throws Exception;
    public int deleteFeelBack(int id)throws Exception;
    public List<FeelBack> listAll()throws Exception;
    public List<FeelBack> queryId(int id)throws Exception;
    public int updateFeelBack(@Param("feelback")FeelBack feelback)throws Exception;
}
