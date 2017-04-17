package com.framework.persistence.mapper;

import java.util.Set;

import com.framework.persistence.po.SysResource;
/** 
 * 类名: SysResource
 * 创建日期: 
 * 功能描述: 
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

	Set<String> getResByUserId(Integer userId);

}