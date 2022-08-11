package com.yjq.programmer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.programmer.bean.CodeMsg;
import com.yjq.programmer.dao.AuthorityMapper;
import com.yjq.programmer.dao.RoleMapper;
import com.yjq.programmer.domain.AuthorityExample;
import com.yjq.programmer.domain.Role;
import com.yjq.programmer.domain.RoleExample;
import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.dto.RoleDTO;
import com.yjq.programmer.enums.RoleEnum;
import com.yjq.programmer.service.IRoleService;
import com.yjq.programmer.util.CommonUtil;
import com.yjq.programmer.util.CopyUtil;
import com.yjq.programmer.util.UuidUtil;
import com.yjq.programmer.util.ValidateEntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-10 20:51
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private AuthorityMapper authorityMapper;

    /**
     * 分页获取角色数据
     * @param pageDTO
     * @return
     */
    @Override
    public ResponseDTO<PageDTO<RoleDTO>> getRoleList(PageDTO<RoleDTO> pageDTO) {
        RoleExample roleExample = new RoleExample();
        // 不知道当前页多少，默认为第一页
        if(pageDTO.getPage() == null){
            pageDTO.setPage(1);
        }
        // 不知道每页多少条记录，默认为每页5条记录
        if(pageDTO.getSize() == null){
            pageDTO.setSize(5);
        }
        if(pageDTO.getParam() != null) {
            RoleDTO roleDTO = pageDTO.getParam();
            roleExample.createCriteria().andNameLike("%" + roleDTO.getName() + "%");
        }
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
        // 分页查出角色数据
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        // 获取数据的总数
        pageDTO.setTotal(pageInfo.getTotal());
        // 讲domain类型数据  转成 DTO类型数据
        List<RoleDTO> roleDTOList = CopyUtil.copyList(roleList, RoleDTO.class);
        pageDTO.setList(roleDTOList);
        return ResponseDTO.success(pageDTO);
    }

    /**
     * 保存角色信息
     * @param roleDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> saveRole(RoleDTO roleDTO) {
        // 进行统一表单验证
        CodeMsg validate = ValidateEntityUtil.validate(roleDTO);
        if (!validate.getCode().equals(CodeMsg.SUCCESS.getCode())) {
            return ResponseDTO.errorByMsg(validate);
        }
        Role role = CopyUtil.copy(roleDTO, Role.class);
        if(CommonUtil.isEmpty(role.getId())) {
            // 添加操作
            // 判断角色名称是否存在
            if(isNameExist(role, "")){
                return ResponseDTO.errorByMsg(CodeMsg.ROLE_NAME_EXIST);
            }
            role.setId(UuidUtil.getShortUuid());
            if(roleMapper.insertSelective(role) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.ROLE_ADD_ERROR);
            }
        } else {
            // 修改操作
            if(RoleEnum.ADMIN.getCode().equals(role.getId()) || RoleEnum.CUSTOMER.getCode().equals(role.getId()) || RoleEnum.SELLER.getCode().equals(role.getId())) {
                return ResponseDTO.errorByMsg(CodeMsg.BASE_ROLE_CHANGE);
            }
            // 判断角色名称是否存在
            if(isNameExist(role, role.getId())){
                return ResponseDTO.errorByMsg(CodeMsg.ROLE_NAME_EXIST);
            }
            if(roleMapper.updateByPrimaryKeySelective(role) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.ROLE_EDIT_ERROR);
            }
        }

        return ResponseDTO.successByMsg(true, "保存角色信息成功！");
    }

    /**
     * 删除角色信息
     * @param roleDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> deleteRole(RoleDTO roleDTO) {
        if(CommonUtil.isEmpty(roleDTO.getId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        String[] ids = roleDTO.getId().split(",");
        boolean flag = false; // 是否删除了基本角色
        for(String id : ids) {
            if(RoleEnum.ADMIN.getCode().equals(id) || RoleEnum.CUSTOMER.getCode().equals(id) || RoleEnum.SELLER.getCode().equals(id)) {
                flag = true;
                continue;
            }
            // 删除该角色对应的权限信息
            AuthorityExample authorityExample = new AuthorityExample();
            authorityExample.createCriteria().andRoleIdEqualTo(id);
            authorityMapper.deleteByExample(authorityExample);
            // 删除角色信息
            if(roleMapper.deleteByPrimaryKey(id) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.ROLE_DELETE_ERROR);
            }
        }
        if(flag) {
            return ResponseDTO.errorByMsg(CodeMsg.BASE_ROLE_CHANGE);
        } else {
            return ResponseDTO.successByMsg(true, "删除角色信息成功！");
        }
    }

    /**
     * 判断角色名称是否重复
     * @param role
     * @param id
     * @return
     */
    public Boolean isNameExist(Role role, String id) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andNameEqualTo(role.getName());
        List<Role> selectedRoleList = roleMapper.selectByExample(roleExample);
        if(selectedRoleList != null && selectedRoleList.size() > 0) {
            if(selectedRoleList.size() > 1){
                return true; //出现重名
            }
            if(!selectedRoleList.get(0).getId().equals(id)) {
                return true; //出现重名
            }
        }
        return false;//没有重名
    }
}
