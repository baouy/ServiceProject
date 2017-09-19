package com.tudou.oss.common.constant;

import com.tudou.common.util.PropertiesFileUtil;

/**
 * Created by DavidWang on 2017/6/15.
 */
public class OssConstant {

	// endpoint
	public static final String ALIYUN_OSS_ENDPOINT = PropertiesFileUtil.getInstance("config").get("aliyun.oss.endpoint");

	// bucketName
	public static final String ALIYUN_OSS_BUCKET_NAME = PropertiesFileUtil.getInstance("config").get("aliyun.oss.bucketName");

	// 文件大小
	public static final int ALIYUN_OSS_MAX_SIZE = PropertiesFileUtil.getInstance("config").getInt("aliyun.oss.maxSize");

	// 签名有效期(单位:分钟)
	public static final int ALIYUN_OSS_EXPIRE = PropertiesFileUtil.getInstance("config").getInt("aliyun.oss.policy.expire");

}
