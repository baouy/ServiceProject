package com.tudou.upms.server.controller.act.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tudou.upms.server.modelvalid.ProcessRunValid;
import com.tudou.upms.server.modelvalid.ProcessValid;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * 流程定义相关Controller
 */
@Service
@Transactional(readOnly = true)
public class ActProcessService {

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	/**
	 * 流程定义列表
	 */
	public List<ProcessValid> processList(ProcessValid processValid, int pc, int ps) {

		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery().latestVersion().orderByProcessDefinitionKey().asc();

		if (StringUtils.isNotEmpty(processValid.getCategory())) {
			processDefinitionQuery.processDefinitionCategory(processValid.getCategory());
		}

		if (StringUtils.isNotEmpty(processValid.getKey())) {
			processDefinitionQuery.processDefinitionKeyLike(processValid.getKey());
		}

		if (StringUtils.isNotEmpty(processValid.getName())) {
			processDefinitionQuery.processDefinitionNameLike(processValid.getName());
		}

		if (processValid.getVersion() != null) {
			processDefinitionQuery.processDefinitionVersion(processValid.getVersion());
		}

		long maxnum = processDefinitionQuery.count();
		processValid.setMaxunum(maxnum);
		List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(pc, ps);
		List<ProcessValid> list = new ArrayList<ProcessValid>();
		for (ProcessDefinition processDefinition : processDefinitionList) {
			ProcessValid processValid1 = new ProcessValid();
			processValid1.setId(processDefinition.getId());
			processValid1.setKey(processDefinition.getKey());
			processValid1.setName(processDefinition.getName());
			processValid1.setVersion(processDefinition.getVersion());
			processValid1.setCategory(processDefinition.getCategory());
			processValid1.setResourceName(processDefinition.getResourceName());
			processValid1.setDiagramResourceName(processDefinition.getDiagramResourceName());
			processValid1.setSuspended(!processDefinition.isSuspended());
			processValid1.setDeploymentId(processDefinition.getDeploymentId());
			String deploymentId = processDefinition.getDeploymentId();
			Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
			processValid1.setDeploymentTime(deployment.getDeploymentTime());
			list.add(processValid1);
		}

		return list;
	}


	/**
	 * 流程定义列表
	 */
	public List<ProcessRunValid> runningList(ProcessRunValid processRunValid,int pc,int ps) {

	    ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();

	    if (StringUtils.isNotBlank(processRunValid.getProcessInstanceId())){
		    processInstanceQuery.processInstanceId(processRunValid.getProcessInstanceId());
	    }

	    if (StringUtils.isNotBlank(processRunValid.getProcDefKey())){
		    processInstanceQuery.processDefinitionKey(processRunValid.getProcDefKey());
	    }

		if (StringUtils.isNotBlank(processRunValid.getProcDefKey())){
			processInstanceQuery.processDefinitionKey(processRunValid.getProcDefKey());
		}

		processRunValid.setMaxnum(processInstanceQuery.count());

		List<ProcessRunValid> list = new ArrayList<ProcessRunValid>();
	    for (ProcessInstance processInstance : processInstanceQuery.listPage(pc,ps)){
			ProcessRunValid processRunValid1 = new ProcessRunValid();

			processRunValid1.setId(processInstance.getId());
			processRunValid1.setProcessInstanceId(processInstance.getProcessInstanceId());
			processRunValid1.setProcessDefinitionId(processInstance.getProcessDefinitionId());
			processRunValid1.setActivityId(processInstance.getActivityId());
			processRunValid1.setSuspended(!processInstance.isSuspended());
			processRunValid1.setVersion(processInstance.getProcessDefinitionVersion());
			processRunValid1.setProcDefKey(processInstance.getProcessDefinitionKey());

			list.add(processRunValid1);

		}

		return list;
	}

	/**
	 * 读取资源，通过部署ID
	 * @param procDefId  流程定义ID
	 * @param proInsId 流程实例ID
	 * @param resType 资源类型(xml|image)
	 */
	public InputStream resourceRead(String procDefId, String proInsId, String resType) throws Exception {

		if (StringUtils.isBlank(procDefId)){
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(proInsId).singleResult();
			procDefId = processInstance.getProcessDefinitionId();
		}
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(procDefId).singleResult();

		String resourceName = "";
		if (resType.equals("image")) {
			resourceName = processDefinition.getDiagramResourceName();
		} else if (resType.equals("xml")) {
			resourceName = processDefinition.getResourceName();
		}

		InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
		return resourceAsStream;
	}

	/**
	 * 部署流程 - 保存
	 * @param file
	 * @return
	 */
	@Transactional(readOnly = false)
	public int deploy(String category, MultipartFile file) {

		int status = 1;
		String fileName = file.getOriginalFilename();

		try {
			InputStream fileInputStream = file.getInputStream();
			Deployment deployment;
			String extension = FilenameUtils.getExtension(fileName);
			if (extension.equals("zip") || extension.equals("bar")) {
				ZipInputStream zip = new ZipInputStream(fileInputStream);
				deployment = repositoryService.createDeployment().addZipInputStream(zip).deploy();
			} else if (extension.equals("png")) {
				deployment = repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
			} else if (fileName.indexOf("bpmn20.xml") != -1) {
				deployment = repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
			} else if (extension.equals("bpmn")) { // bpmn扩展名特殊处理，转换为bpmn20.xml
				String baseName = FilenameUtils.getBaseName(fileName);
				deployment = repositoryService.createDeployment().addInputStream(baseName + ".bpmn20.xml", fileInputStream).deploy();
			} else {
				return 2;
			}

			List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).list();

			// 设置流程分类
			for (ProcessDefinition processDefinition : list) {
				repositoryService.setProcessDefinitionCategory(processDefinition.getId(), category);
			}

			if (list.size() == 0){
				status = 0;
			}

		} catch (Exception e) {
			throw new ActivitiException("部署失败！", e);
		}
		return status;
	}

	/**
	 * 设置流程分类
	 */
	@Transactional(readOnly = false)
	public void updateCategory(String procDefId, String category) {
		repositoryService.setProcessDefinitionCategory(procDefId, category);
	}
//
	/**
	 * 挂起、激活流程实例
	 */
	@Transactional(readOnly = false)
	public String updateState(String state, String procDefId) {
		if (state.equals("active")) {
			repositoryService.activateProcessDefinitionById(procDefId, true, null);
			return "已激活ID为[" + procDefId + "]的流程定义。";
		} else if (state.equals("suspend")) {
			repositoryService.suspendProcessDefinitionById(procDefId, true, null);
			return "已挂起ID为[" + procDefId + "]的流程定义。";
		}
		return "无操作";
	}

	/**
	 * 将部署的流程转换为模型
	 * @param procDefId
	 * @throws UnsupportedEncodingException
	 * @throws XMLStreamException
	 */
	@Transactional(readOnly = false)
	public org.activiti.engine.repository.Model convertToModel(String procDefId) throws UnsupportedEncodingException, XMLStreamException {

		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(procDefId).singleResult();
		InputStream bpmnStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
		processDefinition.getResourceName());
		XMLInputFactory xif = XMLInputFactory.newInstance();
		InputStreamReader in = new InputStreamReader(bpmnStream, "UTF-8");
		XMLStreamReader xtr = xif.createXMLStreamReader(in);
		BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);

		BpmnJsonConverter converter = new BpmnJsonConverter();
		ObjectNode modelNode = converter.convertToJson(bpmnModel);
		org.activiti.engine.repository.Model modelData = repositoryService.newModel();
		modelData.setKey(processDefinition.getKey());
		modelData.setName(processDefinition.getResourceName());
		modelData.setCategory(processDefinition.getCategory());//.getDeploymentId());
		modelData.setDeploymentId(processDefinition.getDeploymentId());
		modelData.setVersion(Integer.parseInt(String.valueOf(repositoryService.createModelQuery().modelKey(modelData.getKey()).count()+1)));

		ObjectNode modelObjectNode = new ObjectMapper().createObjectNode();
		modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, processDefinition.getName());
		modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, modelData.getVersion());
		modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, processDefinition.getDescription());
		modelData.setMetaInfo(modelObjectNode.toString());

		repositoryService.saveModel(modelData);

		repositoryService.addModelEditorSource(modelData.getId(), modelNode.toString().getBytes("utf-8"));

		return modelData;
	}

	/**
	 * 导出图片文件到硬盘
	 */
	public List<String> exportDiagrams(String exportDir) throws IOException {
		List<String> files = new ArrayList<String>();
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();

		for (ProcessDefinition processDefinition : list) {
			String diagramResourceName = processDefinition.getDiagramResourceName();
			String key = processDefinition.getKey();
			int version = processDefinition.getVersion();
			String diagramPath = "";

			InputStream resourceAsStream = repositoryService.getResourceAsStream(
					processDefinition.getDeploymentId(), diagramResourceName);
			byte[] b = new byte[resourceAsStream.available()];

			@SuppressWarnings("unused")
			int len = -1;
			resourceAsStream.read(b, 0, b.length);

			// create file if not exist
			String diagramDir = exportDir + "/" + key + "/" + version;
			File diagramDirFile = new File(diagramDir);
			if (!diagramDirFile.exists()) {
				diagramDirFile.mkdirs();
			}
			diagramPath = diagramDir + "/" + diagramResourceName;
			File file = new File(diagramPath);

			// 文件存在退出
			if (file.exists()) {
				// 文件大小相同时直接返回否则重新创建文件(可能损坏)
//				logger.debug("diagram exist, ignore... : {}", diagramPath);

				files.add(diagramPath);
			} else {
				file.createNewFile();
//				logger.debug("export diagram to : {}", diagramPath);

				// wirte bytes to file
				FileUtils.writeByteArrayToFile(file, b, true);

				files.add(diagramPath);
			}

		}

		return files;
	}

	/**
	 * 删除部署的流程，级联删除流程实例
	 * @param deploymentId 流程部署ID
	 */
	@Transactional(readOnly = false)
	public void deleteDeployment(String deploymentId) {
		repositoryService.deleteDeployment(deploymentId, true);
	}

	/**
	 * 删除部署的流程实例
	 * @param procInsId 流程实例ID
	 * @param deleteReason 删除原因，可为空
	 */
	@Transactional(readOnly = false)
	public void deleteProcIns(String procInsId, String deleteReason) {
		runtimeService.deleteProcessInstance(procInsId, deleteReason);
	}

}
