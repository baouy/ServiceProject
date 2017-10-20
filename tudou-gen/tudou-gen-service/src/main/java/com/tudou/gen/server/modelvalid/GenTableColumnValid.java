package com.tudou.gen.server.modelvalid;

import com.tudou.gen.dao.model.GenTableColumn;

import java.util.List;

public class GenTableColumnValid{

	private List<GenTableColumn> genTableColumns;

	private List<String> pkList;

	private String className;

	public List<GenTableColumn> getGenTableColumns() {
		return genTableColumns;
	}

	public void setGenTableColumns(List<GenTableColumn> genTableColumns) {
		this.genTableColumns = genTableColumns;
	}

	public List<String> getPkList() {
		return pkList;
	}

	public void setPkList(List<String> pkList) {
		this.pkList = pkList;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
