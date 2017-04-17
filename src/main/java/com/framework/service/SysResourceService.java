package com.framework.service;

import java.util.Set;

import com.framework.persistence.po.SysResource;
/** 
 * 类名: SysResourceService
 * 创建日期: 
 * 功能描述: 
 */
public interface SysResourceService extends CommonService<SysResource> {

	Set<String> getResByUserId(Integer userId);

}