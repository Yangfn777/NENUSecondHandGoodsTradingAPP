package com.join.GoodsTradingProgram.mapper.commentMapper;

import com.join.GoodsTradingProgram.entity.comment.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 19:30 2020/5/26
 */
@Mapper
@Repository
public interface CommentMapper {
    public List<Comment> listComment() throws Exception;
    public boolean addComment(@Param("comment")Comment comment)throws Exception;
    public boolean delComment(@Param("id")int id)throws Exception;
    public boolean updateContent(@Param("comment")Comment comment)throws Exception;
    public List<Comment> buyerSelect(@Param("buyerId")int buyerId,@Param("goodsId")int goodsId)throws Exception;
    public List<Comment> sellerSelect(@Param("sellerId")int sellerId,@Param("goodsId")int goodsId)throws Exception;
}
