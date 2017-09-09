package com.tudou.gen.server.modelvalid;

import com.tudou.gen.dao.model.GenTable;
import com.tudou.gen.dao.model.GenTableColumn;

import java.util.List;

public class GenTableAddValid {


	private GenTable genTable;

	private List<GenTableColumn> list;


	public GenTable getGenTable() {
		return genTable;
	}

	public void setGenTable(GenTable genTable) {
		this.genTable = genTable;
	}

	public List<GenTableColumn> getList() {
		return list;
	}

	public void setList(List<GenTableColumn> list) {
		this.list = list;
	}
}
