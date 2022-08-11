package com.yjq.programmer.service;

import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.dto.RoleDTO;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-10 20:51
 */
public interface IRoleService {

    // 分页获取角色数据
    ResponseDTO<PageDTO<RoleDTO>> getRoleList(PageDTO<RoleDTO> pageDTO);

    // 保存角色信息
    ResponseDTO<Boolean> saveRole(RoleDTO roleDTO);

    // 删除角色信息
    ResponseDTO<Boolean> deleteRole(RoleDTO roleDTO);
}
