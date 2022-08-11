package com.yjq.programmer.service;

import com.yjq.programmer.dto.AuthorityDTO;
import com.yjq.programmer.dto.ResponseDTO;

import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-12 9:43
 */
public interface IAuthorityService {

    // 根据角色获取权限数据
    ResponseDTO<List<AuthorityDTO>> getAuthorityList(AuthorityDTO authorityDTO);

    // 保存角色权限信息
    ResponseDTO<Boolean> saveAuthority(AuthorityDTO authorityDTO);

}
