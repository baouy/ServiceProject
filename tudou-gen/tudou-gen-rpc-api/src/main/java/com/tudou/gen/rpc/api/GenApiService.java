package com.tudou.gen.rpc.api;

import com.tudou.gen.dao.model.GenTableColumn;
import com.tudou.gen.dao.model.TableList;

import java.util.List;

public interface GenApiService {


	/**
	 * 查询表列表
	 * @param tableList
	 * @return
	 */
	List<TableList> findTableList(TableList tableList);

    /**
	 * 获取数据表字段
	 * @param tableList
	 * @return
	 */
	List<GenTableColumn> findTableColumnList(TableList tableList);

    List<GenTableColumn> findTableColumnListByTables(String tableNames);

    /**
	 * 获取数据表主键
	 * @param tableList
	 * @return
	 */
	List<String> findTablePK(TableList tableList);

}
