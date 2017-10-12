package com.tudou.common.util;

import com.tudou.common.FileEnum;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Properties;

/**
 * Velocity工具类
 */
public class VelocityUtil {

	/**
	 * 根据模板生成文件
	 * @param inputVmFilePath 模板路径
	 * @param outputFilePath 输出文件路径
	 * @param context
	 * @throws Exception
	 */
	public static void generate(String inputVmFilePath, String outputFilePath, VelocityContext context) throws Exception {
		try {
			Properties properties = new Properties();
			properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, getPath(inputVmFilePath));
			Velocity.init(properties);
			//VelocityEngine engine = new VelocityEngine();
			Template template = Velocity.getTemplate(getFile(inputVmFilePath), "utf-8");
			File outputFile = new File(outputFilePath);
			FileWriterWithEncoding writer = new FileWriterWithEncoding(outputFile, "utf-8");
			template.merge(context, writer);
			writer.close();
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * 导出文档
	 * @param context
	 * @param resp
	 * @throws Exception
	 */
	public static void exportFile(VelocityContext context,HttpServletResponse resp,FileEnum fileEnum) throws Exception {
		String templatePath = VelocityUtil.class.getResource("/").getPath()+"/ftl/"+fileEnum.getTemplate();
		try {
			Properties properties = new Properties();
			properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, getPath(templatePath));
			Velocity.init(properties);
			Template template = Velocity.getTemplate(getFile(templatePath), "utf-8");
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("application/msword");
			resp.addHeader("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(context.get("filename").toString(),"UTF-8")+fileEnum.getSubfix());
			template.merge(context, resp.getWriter());
			resp.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	/**
	 * 根据文件绝对路径获取目录
	 * @param filePath
	 * @return
	 */
	public static String getPath(String filePath) {
		String path = "";
		if (StringUtils.isNotBlank(filePath)) {
			path = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		}
		return path;
	}

	/**
	 * 根据文件绝对路径获取文件
	 * @param filePath
	 * @return
	 */
	public static String getFile(String filePath) {
		String file = "";
		if (StringUtils.isNotBlank(filePath)) {
			file = filePath.substring(filePath.lastIndexOf("/") + 1);
		}
		return file;
	}

}
