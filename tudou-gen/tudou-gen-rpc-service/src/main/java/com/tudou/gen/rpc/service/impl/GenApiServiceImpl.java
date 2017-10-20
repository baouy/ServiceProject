package com.tudou.gen.rpc.service.impl;

import com.tudou.gen.dao.model.GenTableColumn;
import com.tudou.gen.dao.model.TableList;
import com.tudou.gen.rpc.api.GenApiService;
import com.tudou.gen.rpc.mapper.GenApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GenApiServiceImpl implements GenApiService{

	private static Logger _log = LoggerFactory.getLogger(GenApiServiceImpl.class);

	@Autowired
	GenApiMapper genApiMapper;

	@Override
	public List<TableList> findTableList(TableList tableList) {
		return genApiMapper.findTableList(tableList);
	}



	@Override
	public List<GenTableColumn> findTableColumnList(TableList tableList) {
		return genApiMapper.findTableColumnList(tableList);
	}

	@Override
	public List<GenTableColumn> findTableColumnListByTables(String tableNames) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("tableNames",tableNames.split(","));
		return genApiMapper.findTableColumnListByTables(map);
	}


	@Override
	public List<String> findTablePK(TableList tableList) {
		return genApiMapper.findTablePK(tableList);
	}
}
