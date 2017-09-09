package com.tudou.gen.dao.model;

import java.io.Serializable;

public class TableList implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String comments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
