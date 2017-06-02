package com.tudou.common.util;

import java.io.*;

/**
 * Created by DavidWang on 2017/5/31.
 */
public class CpUtil {

	/**
	 * 复制一个目录及其子目录、文件到另外一个目录
	 * @param dest
	 * @throws IOException
	 */

	public static void copy(String dest,String name,String path,String outputPath){
		File dir = new File(outputPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		try {
			String src = getSubpath(name,dest);
			copyFolder(new File(src+path),new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void copyFolder(File src, File dest) throws IOException {
		if (src.isDirectory()) {
			if (!dest.exists()) {
				dest.mkdir();
			}
			String files[] = src.list();
			for (String file : files) {
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// 递归复制
				copyFolder(srcFile, destFile);
			}
		} else {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;

			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		}
	}

	public static String getSubpath(String pathName,String fileName) {
		int index = fileName.indexOf(pathName);
		if (index != -1) {
			return fileName.substring(0,index + pathName.length());
		}
		else {
			return fileName;
		}
	}
}
