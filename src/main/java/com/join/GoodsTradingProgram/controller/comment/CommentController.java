package com.join.GoodsTradingProgram.controller.comment;

import com.join.GoodsTradingProgram.entity.comment.Comment;
import com.join.GoodsTradingProgram.service.commentService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 19:37 2020/5/26
 */
@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "list")
    public List<Comment> listComment() throws Exception{
        List<Comment> list = commentService.listComment();
        return list;
    }

    @RequestMapping(value = "addComment")
    public int addComment(Comment comment) throws Exception{
        boolean a = commentService.addComment(comment);
        int b = 0;
        if(a==true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "delComment")
    public int delComment(int id) throws Exception{
        boolean a = commentService.delComment(id);
        int b=0;
        if(a==true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "updateContent")
    public int updateContent(Comment comment) throws Exception{
        boolean a = commentService.updateContent(comment);
        int b = 0;
        if(a==true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "buyerSelect")
    public List<Comment> buyerSelect(int buyerId,int goodsId)throws Exception{
        List<Comment> list = commentService.buyerSelect(buyerId,goodsId);
        return list;
    }

    @RequestMapping(value = "sellerSelect")
    public List<Comment> sellerSelect(int sellerId,int goodsId)throws Exception{
        List<Comment> list = commentService.sellerSelect(sellerId,goodsId);
        return list;
    }
}
