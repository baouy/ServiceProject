package com.tudou.common.util;

/**
 * Created by DavidWang on 2017/6/1.
 */
public class FileUtil {

	public static String getSubpath(String pathName,String fileName) {
		int index = fileName.indexOf(pathName);
		if (index != -1) {
			return fileName.substring(index + pathName.length() + 1);
		}
		else {
			return fileName;
		}
	}

}
