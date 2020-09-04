package com.join.GoodsTradingProgram.service.commentService.impl;

import com.join.GoodsTradingProgram.entity.comment.Comment;
import com.join.GoodsTradingProgram.mapper.commentMapper.CommentMapper;
import com.join.GoodsTradingProgram.service.commentService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;


import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 19:35 2020/5/26
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> listComment() throws Exception{
        List<Comment> list = commentMapper.listComment();
        return list;
    }

    @Override
    public boolean addComment(Comment comment) throws Exception{
        comment.setTimes(new Date());
        boolean a = commentMapper.addComment(comment);
        return a;
    }

    @Override
    public boolean delComment(int id)throws Exception{
        boolean a = commentMapper.delComment(id);
        return a;
    }

    @Override
    public boolean updateContent(Comment comment)throws Exception{
        boolean a = commentMapper.updateContent(comment);
        return a;
    }

    @Override
    public List<Comment> buyerSelect(int buyerId,int goodsId)throws Exception{
        List<Comment> list = commentMapper.buyerSelect(buyerId,goodsId);
        return list;
    }

    @Override
    public List<Comment> sellerSelect(int sellerId,int goodsId)throws Exception{
        List<Comment> list = commentMapper.sellerSelect(sellerId,goodsId);
        return list;
    }
}
