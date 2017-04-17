package com.framework.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.framework.common.LogFactory;
import com.framework.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * <p>
 * action基类
 * </p>
 * 作者 lianzhifei 日期 2016 2016年9月20日
 */
public abstract class BaseAction {

	protected int start; // 起始页
	protected int iDisplayLength = 5; // 每页显示的条数
	protected int recordsTotal; // 总记录数
	protected int recordsFiltered; //
	protected int recordsDisplay; //
	protected HttpServletRequest request;
	protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
	protected HttpServletResponse response;
	protected HttpSession session;
	public static final boolean FAIL = false;
	public static final boolean SUCCESS = true;

	/**
	 * 关闭窗口并且刷新页面
	 */
	protected static final String RESULT_TYPE_CLOSE_BOX_SELFPAGE = "close_box_selfpage";

	/**
	 * 关闭窗口并且执行函数
	 */
	protected static final String RESULT_TYPE_CLOSE_BOX_FUNCTION = "close_box_function";

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	/**
	 * 获取请求上下文路径
	 * @return
	 */
	public String getContext() {
		return request.getContextPath();
	}

	/**
	 * 将数据信息写到客户端
	 * 
	 * @param resStr
	 */
	protected void writerToClient(String respData) {
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(respData);
			writer.flush();
		} catch (IOException e) {
			LogFactory.getInstance().getSysInfoLogger().error("系统错误：" + e.getMessage());
		}
	}

	protected void writerToClient(List<?> data, int length, int recordsDisplay, int recordsFiltered, int recordsTotal,
			int start) {
		Map<String, Object> respData = new HashMap<String, Object>();
		respData.put("data", data);
		respData.put("length", length);
		respData.put("recordsDisplay", recordsDisplay);
		respData.put("recordsFiltered", recordsFiltered);
		respData.put("recordsTotal", recordsTotal);
		respData.put("start", start);
		Gson g = new GsonBuilder().serializeNulls().create();
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(g.toJson(respData));
			writer.flush();
		} catch (IOException e) {
			LogFactory.getInstance().getSysInfoLogger().error("系统错误：" + e.getMessage());
		}
	}

	protected Map<String, Object> convertToMap(List<?> data, int length, int recordsDisplay, int recordsFiltered,
			int recordsTotal, int start) {
		Map<String, Object> respData = new HashMap<String, Object>();
		respData.put("data", data);
		respData.put("length", length);
		respData.put("recordsDisplay", recordsDisplay);
		respData.put("recordsFiltered", recordsFiltered);
		respData.put("recordsTotal", recordsTotal);
		respData.put("start", start);
		return respData;
	}

	/**
	 * 组合列表的属性排序方式
	 * 
	 * @return
	 */
	protected void groupSortMap(Map<String, Object> map) {
		String sortCol = request.getParameter("iSortCol_0");// 点击排序列的数组序号
		String sSortDir_0 = request.getParameter("sSortDir_0"); // 点击拍序列的排序方式desc
																// asc
		String mDataProp_ = request.getParameter("mDataProp_" + sortCol); // 获取拍序列的属性
		map.put("prop", StringUtil.humpToLine(mDataProp_));
		map.put("sort", sSortDir_0);
		map.put("startPage", getStart());
		map.put("pageSize", getIDisplayLength());
	}

	/**
	 * 描述: 设置下行成功JSON <br>
	 *
	 * @param response
	 *            - HttpServletResponse
	 * @param data
	 *            - 数据，可为空
	 * @param msg
	 *            - 描述
	 * @param resultType
	 *            - 返回操作类型
	 */
	protected void setJsonSuccess(HttpServletResponse response, Object data, String msg, String resultType) {
		setJson(response, data, SUCCESS, 0, msg, resultType);
	}

	/**
	 * 描述: 设置下行失败JSON <br>
	 *
	 * @param response
	 *            - HttpServletResponse
	 * @param data
	 *            - 数据，可为空
	 * @param code
	 *            - 信息代码
	 * @param msg
	 *            - 描述
	 * @param resultType
	 *            - 返回操作类型
	 */
	protected void setJsonFail(HttpServletResponse response, Object data, int code, String msg, String resultType) {
		setJson(response, data, FAIL, code, msg, resultType);
	}

	/**
	 * 描述: 设置下行JSON <br>
	 *
	 * @param data
	 *            - 数据，可为空
	 * @param success
	 *            - 成功还是失败
	 * @param code
	 *            - 信息代码
	 * @param msg
	 *            - 描述
	 * @param resultType
	 *            - 返回操作类型
	 */
	protected void setJson(HttpServletResponse response, Object data, boolean success, int code, String msg,
			String resultType) {
		response.setCharacterEncoding("UTF-8");
		try {
			Map<String, Object> respData = new HashMap<String, Object>();
			if (data != null) {
				respData.put("data", data);
			}
			respData.put("success", success);
			respData.put("msg", msg);
			respData.put("code", code);
			respData.put("resultType", resultType);
			Gson g = new GsonBuilder().serializeNulls().create();

			response.getWriter().write(g.toJson(respData));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 描述: 设置下行JSON <br>
	 *
	 * @param data
	 *            - 数据，可为空
	 * @param success
	 *            - 成功还是失败
	 * @param code
	 *            - 信息代码
	 * @param msg
	 *            - 描述
	 */
	protected void setJson(HttpServletResponse response, Object data, boolean success, int code, String msg) {
		response.setCharacterEncoding("UTF-8");
		try {
			Map<String, Object> respData = new HashMap<String, Object>();
			if (data != null) {
				respData.put("data", data);
			}
			respData.put("success", success);
			respData.put("msg", msg);
			respData.put("code", code);
			Gson g = new GsonBuilder().serializeNulls().create();
			response.getWriter().write(g.toJson(respData));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 描述: 设置下行成功JSON <br>
	 *
	 * @param response
	 *            - HttpServletResponse
	 * @param data
	 *            - 数据，可为空
	 * @param msg
	 *            - 描述
	 */
	protected void setJsonSuccess(HttpServletResponse response, Object data, String msg) {
		setJson(response, data, SUCCESS, 0, msg);
	}

	/**
	 * 描述: 设置下行失败JSON <br>
	 *
	 * @param response
	 *            - HttpServletResponse
	 * @param data
	 *            - 数据，可为空
	 * @param code
	 *            - 信息代码
	 * @param msg
	 *            - 描述
	 */
	protected void setJsonFail(HttpServletResponse response, Object data, int code, String msg) {
		setJson(response, data, FAIL, code, msg);
	}

	public int getStart() {
		String iDisplayStart = request.getParameter("iDisplayStart");

		if (StringUtils.isBlank(iDisplayStart)) {
			return start;
		} else {
			return Integer.valueOf(iDisplayStart);
		}
	}

	public int getIDisplayLength() {
		String length = request.getParameter("iDisplayLength");
		if (StringUtils.isBlank(length)) {
			return iDisplayLength;
		} else {
			return Integer.valueOf(length);
		}
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getRecordsDisplay() {
		return recordsDisplay;
	}

	public void setRecordsDisplay(int recordsDisplay) {
		this.recordsDisplay = recordsDisplay;
	}

}
