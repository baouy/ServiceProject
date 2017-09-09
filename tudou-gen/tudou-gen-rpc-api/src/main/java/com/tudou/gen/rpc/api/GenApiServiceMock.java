package com.tudou.gen.rpc.api;

import com.tudou.gen.dao.model.GenTableColumn;
import com.tudou.gen.dao.model.TableList;

import java.util.List;

public class GenApiServiceMock implements GenApiService{


	@Override
	public List<TableList> findTableList(TableList tableList) {
		return null;
	}

	@Override
	public List<GenTableColumn> findTableColumnList(TableList tableList) {
		return null;
	}

	@Override
	public List<String> findTablePK(TableList tableList) {
		return null;
	}
}
