package com.yjq.programmer.controller;

import com.yjq.programmer.dto.CommentDTO;
import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.service.ICommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-18 14:16
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private ICommentService commentService;

    /**
     * 评价租赁体验
     * @param commentDTO
     * @return
     */
    @PostMapping("/add")
    public ResponseDTO<Boolean> addComment(@RequestBody CommentDTO commentDTO){
        return commentService.addComment(commentDTO);
    }

    /**
     * 分页获取评价数据
     * @param pageDTO
     * @return
     */
    @PostMapping("/list")
    public ResponseDTO<PageDTO<CommentDTO>> getCommentList(@RequestBody PageDTO<CommentDTO> pageDTO){
        return commentService.getCommentList(pageDTO);
    }

    /**
     * 根据汽车查看评价信息
     * @param commentDTO
     * @return
     */
    @PostMapping("/view")
    public ResponseDTO<List<CommentDTO>> viewCommentListByCarId(@RequestBody CommentDTO commentDTO){
        return commentService.viewCommentListByCarId(commentDTO);
    }

    /**
     * 删除评价信息
     * @param commentDTO
     * @return
     */
    @PostMapping("/delete")
    public ResponseDTO<Boolean> deleteComment(@RequestBody CommentDTO commentDTO){
        return commentService.deleteComment(commentDTO);
    }

    /**
     * 统计评价总数
     * @return
     */
    @PostMapping("/total")
    public ResponseDTO<Integer> totalComment(){
        return commentService.totalComment();
    }
}
