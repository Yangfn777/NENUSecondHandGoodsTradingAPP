package com.join.GoodsTradingProgram.service.commentService;

import com.join.GoodsTradingProgram.entity.comment.Comment;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 19:35 2020/5/26
 */
public interface CommentService {
    public List<Comment> listComment() throws Exception;
    public boolean addComment(Comment comment)throws Exception;
    public boolean delComment(int id) throws Exception;
    public boolean updateContent(Comment comment)throws Exception;
    public List<Comment> buyerSelect(int buyerId,int goodsId)throws Exception;
    public List<Comment> sellerSelect(int sellerId,int goodsId)throws Exception;
}
