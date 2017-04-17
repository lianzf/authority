package com.framework.service;

import com.framework.persistence.po.SysUser;
/** 
 * 类名: SysUserService
 * 创建日期: 
 * 功能描述: 
 */
public interface SysUserService extends CommonService<SysUser> {

	SysUser findUserByUserName(String username);

}