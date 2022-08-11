package com.yjq.programmer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.programmer.bean.CodeMsg;
import com.yjq.programmer.dao.CarMapper;
import com.yjq.programmer.dao.CommentMapper;
import com.yjq.programmer.dao.UserMapper;
import com.yjq.programmer.domain.*;
import com.yjq.programmer.dto.*;
import com.yjq.programmer.service.ICommentService;
import com.yjq.programmer.util.CommonUtil;
import com.yjq.programmer.util.CopyUtil;
import com.yjq.programmer.util.UuidUtil;
import com.yjq.programmer.util.ValidateEntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-18 14:17
 */
@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CarMapper carMapper;

    @Resource
    private UserMapper userMapper;


    /**
     * 评价租赁体验
     * @param commentDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> addComment(CommentDTO commentDTO) {
        if(CommonUtil.isEmpty(commentDTO.getCarId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        // 判断汽车是否存在
        Car car = carMapper.selectByPrimaryKey(commentDTO.getCarId());
        if(car == null) {
            return ResponseDTO.errorByMsg(CodeMsg.CAR_NOT_EXIST);
        }
        // 判断是否已经评价过
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andUserIdEqualTo(commentDTO.getUserId()).andCarIdEqualTo(car.getId());
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        if(commentList != null && commentList.size() > 0) {
            return ResponseDTO.errorByMsg(CodeMsg.COMMENT_ALREADY_EXIST);
        }
        // 进行统一表单验证
        CodeMsg validate = ValidateEntityUtil.validate(commentDTO);
        if (!validate.getCode().equals(CodeMsg.SUCCESS.getCode())) {
            return ResponseDTO.errorByMsg(validate);
        }
        Comment comment = CopyUtil.copy(commentDTO, Comment.class);
        comment.setId(UuidUtil.getShortUuid());
        comment.setCreateTime(new Date());
        if(commentMapper.insertSelective(comment) == 0) {
            return ResponseDTO.errorByMsg(CodeMsg.COMMENT_ADD_ERROR);
        }
        return ResponseDTO.successByMsg(true, "评价成功！");
    }

    /**
     * 删除评价信息
     * @param commentDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> deleteComment(CommentDTO commentDTO) {
        if(CommonUtil.isEmpty(commentDTO.getId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        String[] ids = commentDTO.getId().split(",");
        for(String id : ids) {
            Comment comment = commentMapper.selectByPrimaryKey(id);
            // 删除评价信息
            if(commentMapper.deleteByPrimaryKey(id) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.COMMENT_DELETE_ERROR);
            }
        }
        return ResponseDTO.successByMsg(true, "删除评价信息成功！");
    }

    /**
     * 分页获取评价信息
     * @param pageDTO
     * @return
     */
    @Override
    public ResponseDTO<PageDTO<CommentDTO>> getCommentList(PageDTO<CommentDTO> pageDTO) {
        CommentExample commentExample = new CommentExample();
        // 不知道当前页多少，默认为第一页
        if(pageDTO.getPage() == null){
            pageDTO.setPage(1);
        }
        // 不知道每页多少条记录，默认为每页5条记录
        if(pageDTO.getSize() == null){
            pageDTO.setSize(5);
        }
        if(pageDTO.getParam() != null) {
            CommentDTO commentDTO = pageDTO.getParam();
            commentExample.createCriteria().andContentLike("%" + commentDTO.getContent() + "%");
        }
        commentExample.setOrderByClause("create_time desc");
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
        // 分页查出评价数据
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        // 获取数据的总数
        pageDTO.setTotal(pageInfo.getTotal());
        // 讲domain类型数据  转成 DTO类型数据
        List<CommentDTO> commentDTOList = CopyUtil.copyList(commentList, CommentDTO.class);
        for(CommentDTO commentDTO : commentDTOList) {
            User user = userMapper.selectByPrimaryKey(commentDTO.getUserId());
            commentDTO.setUserDTO(CopyUtil.copy(user, UserDTO.class));
            Car car = carMapper.selectByPrimaryKey(commentDTO.getCarId());
            commentDTO.setCarDTO(CopyUtil.copy(car, CarDTO.class));
        }
        pageDTO.setList(commentDTOList);
        return ResponseDTO.success(pageDTO);
    }

    /**
     * 根据汽车查看评价信息
     * @param commentDTO
     * @return
     */
    @Override
    public ResponseDTO<List<CommentDTO>> viewCommentListByCarId(CommentDTO commentDTO) {
        if(CommonUtil.isEmpty(commentDTO.getCarId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andCarIdEqualTo(commentDTO.getCarId());
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        List<CommentDTO> commentDTOList = CopyUtil.copyList(commentList, CommentDTO.class);
        for(CommentDTO e : commentDTOList) {
            User user = userMapper.selectByPrimaryKey(e.getUserId());
            e.setUserDTO(CopyUtil.copy(user, UserDTO.class));
            Car car = carMapper.selectByPrimaryKey(e.getCarId());
            e.setCarDTO(CopyUtil.copy(car, CarDTO.class));
        }
        return ResponseDTO.success(commentDTOList);
    }

    /**
     * 统计评价总数
     * @return
     */
    @Override
    public ResponseDTO<Integer> totalComment() {
        return ResponseDTO.success(commentMapper.countByExample(new CommentExample()));
    }
}
