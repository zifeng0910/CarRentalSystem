package com.yjq.programmer.controller;

import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.dto.RoleDTO;
import com.yjq.programmer.service.IRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-10 20:52
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    /**
     * 分页获取角色数据
     * @param pageDTO
     * @return
     */
    @PostMapping("/list")
    public ResponseDTO<PageDTO<RoleDTO>> getRoleList(@RequestBody PageDTO<RoleDTO> pageDTO){
        return roleService.getRoleList(pageDTO);
    }

    /**
     * 保存角色信息
     * @param roleDTO
     * @return
     */
    @PostMapping("/save")
    public ResponseDTO<Boolean> saveRole(@RequestBody RoleDTO roleDTO){
        return roleService.saveRole(roleDTO);
    }

    /**
     * 删除角色信息
     * @param roleDTO
     * @return
     */
    @PostMapping("/delete")
    public ResponseDTO<Boolean> deleteRole(@RequestBody RoleDTO roleDTO){
        return roleService.deleteRole(roleDTO);
    }
}
