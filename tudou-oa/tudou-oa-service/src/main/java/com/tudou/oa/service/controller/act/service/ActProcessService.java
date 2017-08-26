package com.tudou.oa.service.controller.act.service;


import com.tudou.oa.service.modelvalid.ProcessRunValid;
import com.tudou.oa.service.modelvalid.ProcessValid;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 流程定义相关Controller
 */
public interface ActProcessService {

	/**
	 * 流程定义列表
	 */
	public List<ProcessValid> processList(ProcessValid processValid, int pc, int ps);


	/**
	 * 流程定义列表
	 */
	public List<ProcessRunValid> runningList(ProcessRunValid processRunValid, int pc, int ps) ;

	/**
	 * 读取资源，通过部署ID
	 * @param procDefId  流程定义ID
	 * @param proInsId 流程实例ID
	 * @param resType 资源类型(xml|image)
	 */
	public InputStream resourceRead(String procDefId, String proInsId, String resType) throws Exception;

	/**
	 * 部署流程 - 保存
	 * @param file
	 * @return
	 */
	public int deploy(String category, MultipartFile file);

	/**
	 * 设置流程分类
	 */
	public void updateCategory(String procDefId, String category);

	/**
	 * 挂起、激活流程实例
	 */
	public String updateState(String state, String procDefId);

	/**
	 * 将部署的流程转换为模型
	 * @param procDefId
	 */
	public org.activiti.engine.repository.Model convertToModel(String procDefId) throws UnsupportedEncodingException, XMLStreamException;

	/**
	 * 导出图片文件到硬盘
	 */
	public List<String> exportDiagrams(String exportDir) throws IOException;

	/**
	 * 删除部署的流程，级联删除流程实例
	 * @param deploymentId 流程部署ID
	 */
	public void deleteDeployment(String deploymentId);
	/**
	 * 删除部署的流程实例
	 * @param procInsId 流程实例ID
	 * @param deleteReason 删除原因，可为空
	 */
	public void deleteProcIns(String procInsId, String deleteReason);

}
