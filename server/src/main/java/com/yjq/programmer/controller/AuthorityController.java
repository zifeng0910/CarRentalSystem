package com.yjq.programmer.controller;

import com.yjq.programmer.dto.AuthorityDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.service.IAuthorityService;
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
 * @create 2022-06-12 9:43
 */
@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Resource
    private IAuthorityService authorityService;

    /**
     * 根据角色获取权限数据
     * @param authorityDTO
     * @return
     */
    @PostMapping("/list")
    public ResponseDTO<List<AuthorityDTO>> getAuthorityList(@RequestBody AuthorityDTO authorityDTO){
        return authorityService.getAuthorityList(authorityDTO);
    }

    /**
     * 保存角色权限信息
     * @param authorityDTO
     * @return
     */
    @PostMapping("/save")
    public ResponseDTO<Boolean> saveAuthority(@RequestBody AuthorityDTO authorityDTO){
        return authorityService.saveAuthority(authorityDTO);
    }
}
