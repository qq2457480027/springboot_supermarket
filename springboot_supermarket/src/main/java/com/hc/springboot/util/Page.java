package com.hc.springboot.util;

import java.util.List;
import java.util.Map;

public class Page {
	//总页数
	private Integer totalPageCount = 1;
	//每页显示数据条数
	private Integer pageSize = 0;
	//总记录数
	private Integer totalCount = 0;
	
	//当前页码
	private Integer currentPageNo = 1;
	
	/**
	 * 模糊查询的参数对象
	 */
	private Object param;
	
	/**
	 * 查询的Map参数值
	 */
	private Map<String, Object> paramMap;
	
	//每页显示的对象集合数据
	private List list;
	
	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize>0) {
			this.pageSize = pageSize;
		}
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		if(totalCount>0) {
			this.totalCount = totalCount;
		}
		/**
		 * 计算总页数
		 */
		totalPageCount=this.totalCount%pageSize==0?(this.totalCount/pageSize):(this.totalCount/pageSize+1);
	}

	public Integer getCurrentPageNo() {
		if(currentPageNo<1) {
			currentPageNo = 1;
		}else if(currentPageNo>this.getTotalPageCount() && this.getTotalPageCount()!=0) {
			currentPageNo = this.getTotalPageCount();
		}
		return currentPageNo;
	}

	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
}
