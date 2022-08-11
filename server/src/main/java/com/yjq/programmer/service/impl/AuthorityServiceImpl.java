package com.yjq.programmer.service.impl;

import com.yjq.programmer.bean.CodeMsg;
import com.yjq.programmer.dao.AuthorityMapper;
import com.yjq.programmer.domain.Authority;
import com.yjq.programmer.domain.AuthorityExample;
import com.yjq.programmer.dto.AuthorityDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.service.IAuthorityService;
import com.yjq.programmer.util.CommonUtil;
import com.yjq.programmer.util.CopyUtil;
import com.yjq.programmer.util.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-12 9:44
 */
@Service
@Transactional
public class AuthorityServiceImpl implements IAuthorityService {

    @Resource
    private AuthorityMapper authorityMapper;


    /**
     * 根据角色获取权限数据
     * @param authorityDTO
     * @return
     */
    @Override
    public ResponseDTO<List<AuthorityDTO>> getAuthorityList(AuthorityDTO authorityDTO) {
        if(CommonUtil.isEmpty(authorityDTO.getRoleId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        AuthorityExample authorityExample = new AuthorityExample();
        authorityExample.createCriteria().andRoleIdEqualTo(authorityDTO.getRoleId());
        List<Authority> authorityList = authorityMapper.selectByExample(authorityExample);
        List<AuthorityDTO> authorityDTOList = CopyUtil.copyList(authorityList, AuthorityDTO.class);
        return ResponseDTO.success(authorityDTOList);
    }

    /**
     * 保存角色权限信息
     * @param authorityDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> saveAuthority(AuthorityDTO authorityDTO) {
        if(CommonUtil.isEmpty(authorityDTO.getRoleId()) || authorityDTO.getSelectedKeys() == null) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        // 先删除该角色的所有权限
        AuthorityExample authorityExample = new AuthorityExample();
        authorityExample.createCriteria().andRoleIdEqualTo(authorityDTO.getRoleId());
        authorityMapper.deleteByExample(authorityExample);
        // 更新最新权限数据到数据库中
        for(String key : authorityDTO.getSelectedKeys()) {
            Authority authority = new Authority();
            authority.setId(UuidUtil.getShortUuid());
            authority.setKey(key);
            authority.setRoleId(authorityDTO.getRoleId());
            if(authorityMapper.insertSelective(authority) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.AUTHORITY_SAVE_ERROR);
            }
        }
        return ResponseDTO.successByMsg(true, "保存权限信息成功！");
    }
}
