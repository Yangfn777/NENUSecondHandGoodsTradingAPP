package com.join.GoodsTradingProgram.mapper.msgMapper;

import com.join.GoodsTradingProgram.entity.feelBack.FeelBack;
import com.join.GoodsTradingProgram.entity.msg.Msg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:49 2020/8/9
 */
@Mapper
@Repository
public interface MsgMapper {
    public int addMsg(@Param("feelback")Msg feelback)throws Exception;
    public int deleteMsg(int id)throws Exception;
    public List<Msg> listAll()throws Exception;
    public List<Msg> queryId(int id)throws Exception;

}
