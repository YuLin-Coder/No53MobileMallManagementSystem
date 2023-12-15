package com.java.model;

public class Admin {
    private Integer id;

    private String login;

    private String pwd;
    private int author;
    private String authorText;
    public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getAuthorText() {
		return author==1?"管理员":"普通管理员";
	}

	public void setAuthorText(String authorText) {
		this.authorText = authorText;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login == null ? null : login.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}