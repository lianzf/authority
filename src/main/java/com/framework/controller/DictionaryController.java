package com.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <p>
 * 数据字典模块
 * </p>
 * 作者 lianzhifei 日期 2016 2016年9月20日
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController extends BaseAction {

	@RequestMapping("dictionary")
	public String getPage() throws Exception {
		request.setAttribute("menu", "dictionary");
		return "dictionary/dictionary";
	}

}
