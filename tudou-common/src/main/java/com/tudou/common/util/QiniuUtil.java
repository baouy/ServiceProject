package com.tudou.common.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;

public class QiniuUtil {
	//设置好账号的ACCESS_KEY和SECRET_KEY
	static String ACCESS_KEY = "a4bPil1KcyfXI2gT0ExaSh91eEwYtmE9BtIjXJka";
	static String SECRET_KEY = "2awczuyKtGRdp5uRzCcmyeh2I-9BlVdgXRfmyHZS";
	//要上传的空间
	static String bucketname = "meiwo-image";
	//上传到七牛后保存的文件名
	static String key = "";
	//上传文件的路径
	static String FilePath = "";

	//密钥配置
	static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	//创建上传对象
	UploadManager uploadManager = new UploadManager();

	//简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public static String getUpToken(){
		return auth.uploadToken(bucketname);
	}


}
