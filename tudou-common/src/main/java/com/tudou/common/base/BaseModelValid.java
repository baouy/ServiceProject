package com.tudou.common.base;

/**
 * Created by DavidWang on 2017/6/6.
 */
public class BaseModelValid {

	private int pageCurrent = 1;

	private int pageSize = 50;

	public int getPageCurrent() {
		pageCurrent = (pageCurrent - 1) * pageSize;
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
