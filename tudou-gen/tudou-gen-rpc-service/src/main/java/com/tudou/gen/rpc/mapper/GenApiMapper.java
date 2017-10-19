package com.tudou.gen.rpc.mapper;

import com.tudou.gen.dao.model.GenTableColumn;
import com.tudou.gen.dao.model.TableList;

import java.util.List;
import java.util.Map;

public interface GenApiMapper {

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

	/**
	 * 获取数据表字段
	 * @param map
	 * @return
	 */
	List<GenTableColumn> findTableColumnListByTables(Map<String,Object> map);


	/**
	 * 获取数据表主键
	 * @param tableList
	 * @return
	 */
	List<String> findTablePK(TableList tableList);

}
