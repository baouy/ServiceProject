package com.tudou.gen.server.util;

import com.tudou.common.util.StringUtil;
import com.tudou.common.util.VelocityUtil;
import com.tudou.gen.dao.model.GenScheme;
import com.tudou.gen.dao.model.GenTable;
import com.tudou.gen.dao.model.GenTableColumn;
import org.apache.commons.lang.ObjectUtils;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.tudou.common.util.StringUtil.*;

public class GeneratourUtil {

	private static final String project = "ServiceProject";
	//单表
	private static final String CURD = "curd";
	//一对多
	private static final String CURD_MANY = "curd_many";
	//数据层
	private static final String DAO = "dao";
	//前端
	private static final String HTML = "html";
	//列表竖
	private static final String TREETABLE = "treeTable";
	//左右竖
	private static final String TREETABLEANDLIST = "treeTableAndList";

	public static void ChooseVM(GenScheme genScheme, List<GenTableColumn> columns,GenTable genTable) {
		switch (genScheme.getCategory()){
			case CURD:
				CURD(genScheme,columns,genTable);
				break;
			case CURD_MANY:

				break;
			case DAO:

				break;
			case HTML:

				break;
			case TREETABLE:

				break;
			case TREETABLEANDLIST:

				break;
		}
	}

	private static void CURD(GenScheme genScheme,List<GenTableColumn> columns,GenTable genTable){
		List<Map<String, Object>> tables = new ArrayList<>();
		Map<String, Object> table = new HashMap<>();
		table.put("table_name", genTable.getName());
		table.put("model_name", lineToHump(ObjectUtils.toString(genTable.getName())));
		tables.add(table);
		generator_template(genScheme,columns,tables);
	}

	public static void generator_template(GenScheme genScheme,List<GenTableColumn> columns,List<Map<String, Object>> tables){

		String module = genScheme.getModuleName()+"-"+genScheme.getSubModuleName();
		String package_name = genScheme.getPackageName()+"."+genScheme.getSubModuleName();
		String dir[]  =  System.getProperty("user.dir").split(project);
		String path = dir[0] + project + "/";

		//GeneratorConfig模板路径
		String generatorConfig_vm = "/template/generatorConfig.vm";
		// Service模板路径
		String service_vm = "/template/Service.vm";
		// ServiceMock模板路径
		String serviceMock_vm = "/template/ServiceMock.vm";
		// ServiceImpl模板路径
		String serviceImpl_vm = "/template/ServiceImpl.vm";
		// Controller 模板路径
		String controller_vm = "/template/Controller.vm";
		// index 模板路径
		String index_vm = "/template/index.vm";
		// save 模板路径
		String save_vm = "/template/save.vm";

		Map<String, String> last_insert_id_tables = new HashMap<>();
		generatorConfig_vm = "/"+GeneratourUtil.class.getResource(generatorConfig_vm).getPath().replaceFirst("/", "");

		service_vm = GeneratourUtil.class.getResource(service_vm).getPath().replaceFirst("/", "");
		serviceMock_vm = GeneratourUtil.class.getResource(serviceMock_vm).getPath().replaceFirst("/", "");
		serviceImpl_vm = GeneratourUtil.class.getResource(serviceImpl_vm).getPath().replaceFirst("/", "");
		controller_vm = "/"+GeneratourUtil.class.getResource(controller_vm).getPath().replaceFirst("/", "");
		index_vm = "/"+GeneratourUtil.class.getResource(index_vm).getPath().replaceFirst("/", "");
		save_vm = "/"+GeneratourUtil.class.getResource(save_vm).getPath().replaceFirst("/", "");

		String targetProject = path+module + "/" + module + "-dao";
		String module_path = path+module + "/" + module + "-dao/src/main/resources/generatorConfig.xml";

		try {
//			VelocityContext context = new VelocityContext();
//			String targetProject_sqlMap = path+module + "/" + module + "-rpc-service";
//			context.put("tables", tables);
//			context.put("generator_javaModelGenerator_targetPackage", package_name + ".dao.model");
//			context.put("generator_sqlMapGenerator_targetPackage", package_name + ".dao.mapper");
//			context.put("generator_javaClientGenerator_targetPackage", package_name + ".dao.mapper");
//			context.put("targetProject", targetProject);
//			context.put("targetProject_sqlMap", targetProject_sqlMap);
//			context.put("generator_jdbc_password", AESUtil.AESDecode("TvMXT+TLFod0JxEmceskAA=="));
//			context.put("last_insert_id_tables", last_insert_id_tables);
//			VelocityUtil.generate(generatorConfig_vm, module_path, context);

			System.out.println("========== 开始删除生成文件 ==========");
			String ctime = new SimpleDateFormat("yyyy/M/d").format(new Date());
			for (int i = 0; i < tables.size(); i++){
				String name = tables.get(i).get("model_name").toString();
//				new File(targetProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao/model/"+name+".java").delete();
//				new File(targetProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao/model/"+name+"Example.java").delete();
//				new File(targetProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao/mapper/"+name+"Mapper.java").delete();
//				new File(targetProject_sqlMap + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao/mapper/"+name+"Mapper.xml").delete();

				String table_name = ObjectUtils.toString(tables.get(i).get("table_name"));
				String model = lineToHump(table_name);
				String nmodule = lineToLower(table_name);
				String smodule = allToLower(table_name);

//				String servicePath = path + module + "/" + module + "-rpc-api" + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/rpc/api";
//				File servicePathfile = new File(servicePath);
//				if (!servicePathfile.exists()){
//					servicePathfile.mkdirs();
//				}
//				String serviceImplPath = path + module + "/" + module + "-rpc-service" + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/rpc/service/impl";
//				File serviceImplPathfile = new File(servicePath);
//				if (!serviceImplPathfile.exists()){
//					serviceImplPathfile.mkdirs();
//				}
//
//				String service = servicePath + "/" + model + "Service.java";
//				String serviceMock = servicePath + "/" + model + "ServiceMock.java";
//				String serviceImpl = serviceImplPath + "/" + model + "ServiceImpl.java";
//
//				System.out.println("========== 开始生成Service ==========");
//				// 生成service
//				VM_Generate(package_name,model,ctime,service_vm,service);
//
//				// 生成serviceMock
//				VM_Generate(package_name,model,ctime,serviceMock_vm,serviceMock);
//
//				// 生成serviceImpl
//				VM_Generate(package_name,model,ctime,serviceImpl_vm,serviceImpl);
//
//				System.out.println("========== 结束生成Service ==========");
//
//				System.out.println("========== 开始生成Controller ==========");
//				String controllerPath = path + module + "/" + module + "-service" + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/service/controller/manage/";
//
//				String controller = controllerPath + model + "Controller.java";
//				VelocityContext context2 = new VelocityContext();
//				context2.put("package_name", package_name);
//				context2.put("module",nmodule);
//				context2.put("smodule",smodule);
//				//module tudou-oa
//				context2.put("vmmodel", model);
//				context2.put("smodel", lineToHump(genScheme.getSubModuleName()));
//				context2.put("permissions",stringListtoString(table_name,"_"));
//				context2.put("modelname",genScheme.getFunctionName());
//				context2.put("ctime", ctime);
//				context2.put("columns",columns);
//				VelocityUtil.generate(controller_vm, controller, context2);
//
//				System.out.println("========== 结束生成Controller ==========");

				System.out.println("========== 开始生成Html ==========");
				String htmlPath = path + "tudou-upms/tudou-upms-service/src/main/webapp/resources/erp/manage/"+genScheme.getSubModuleName()+"/"+smodule ;
				File htmlfile = new File(htmlPath);
				if (!htmlfile.exists()){
					htmlfile.mkdirs();
				}

				String index = htmlPath + "/index.html";
				VelocityContext context1 = new VelocityContext();
				context1.put("module",nmodule);
				context1.put("smodule",smodule);
				context1.put("smodel", genScheme.getSubModuleName());
				context1.put("permissions",stringListtoString(table_name,"_"));
				context1.put("columns",columns);
				VelocityUtil.generate(index_vm, index, context1);

				System.out.println("========== 结束生成Html ==========");

				System.out.println("========== 开始生成SaveHtml ==========");
				String savePath = path + "tudou-upms/tudou-upms-service/src/main/webapp/resources/erp/manage/"+genScheme.getSubModuleName()+"/"+smodule ;
				File savefile = new File(savePath);
				if (!savefile.exists()){
					savefile.mkdirs();
				}

				String save = savePath + "/save.html";
				VelocityContext context3 = new VelocityContext();
				context3.put("smodule",smodule);
				context3.put("smodel", genScheme.getSubModuleName());
				context3.put("permissions",stringListtoString(table_name,"_"));
				context3.put("columns",columns);
				VelocityUtil.generate(save_vm, save, context3);

				System.out.println("========== 开始生成SaveHtml ==========");

			}

			System.out.println("========== 结束删除生成文件 ==========");

//			System.out.println("========== 开始运行MybatisGenerator ==========");
//			List<String> warnings = new ArrayList<>();
//			File configFile = new File(module_path);
//			ConfigurationParser cp = new ConfigurationParser(warnings);
//			Configuration config = cp.parseConfiguration(configFile);
//			DefaultShellCallback callback = new DefaultShellCallback(true);
//			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//			myBatisGenerator.generate(null);
//			for (String warning : warnings) {
//				System.out.println(warning);
//			}
//			System.out.println("========== 结束运行MybatisGenerator ==========");

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void  VM_Generate(String package_name,String model,String ctime,String inputVmFilePath, String outputFilePath) throws Exception{
		VelocityContext context = new VelocityContext();
		context.put("package_name", package_name);
		context.put("vmmodel", model);
		context.put("mapper", StringUtil.toLowerCaseFirstOne(model));
		context.put("ctime", ctime);
		VelocityUtil.generate(inputVmFilePath, outputFilePath, context);
	}


}
