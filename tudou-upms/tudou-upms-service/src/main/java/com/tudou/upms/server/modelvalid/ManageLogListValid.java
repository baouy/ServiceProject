package com.tudou.upms.server.modelvalid;

import com.tudou.common.base.BaseModelValid;
import io.swagger.annotations.ApiParam;

/**
 * Created by DavidWang on 2017/6/6.
 */
public class ManageLogListValid extends BaseModelValid{

	/**
	 * 编号
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "编号",required = false)
	private Integer logId;

	/**
	 * 操作描述
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "操作描述",required = false)
	private String description;

	/**
	 * 操作用户
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "操作用户",required = false)
	private String username;

	/**
	 * 操作时间
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "操作时间",required = false)
	private Long startTime;

	/**
	 * 消耗时间
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "消耗时间",required = false)
	private Integer spendTime;

	/**
	 * 根路径
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "根路径",required = false)
	private String basePath;

	/**
	 * URI
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "URI",required = false)
	private String uri;

	/**
	 * URL
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "URL",required = false)
	private String url;

	/**
	 * 请求类型
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "请求类型",required = false)
	private String method;

	/**
	 * 用户标识
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "用户标识",required = false)
	private String userAgent;

	/**
	 * IP地址
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "IP地址",required = false)
	private String ip;

	/**
	 * 权限值
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "权限值",required = false)
	private String permissions;

	private String parameter;

	private String result;

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Integer getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
