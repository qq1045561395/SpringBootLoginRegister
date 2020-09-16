package com.soft.wesker.dao;

public class TUser {
    private Integer id;
    private String userName;
    private String passWord;
    private String problem;
    private String problemText;

    public Integer getId() {
        return id;
    }

    public TUser setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public TUser setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public String getProblem() {
        return problem;
    }

    public TUser setProblem(String problem) {
        this.problem = problem;
        return this;
    }

    public String getProblemText() {
        return problemText;
    }

    public TUser setProblemText(String problemText) {
        this.problemText = problemText;
        return this;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", problem='" + problem + '\'' +
                ", problemText='" + problemText + '\'' +
                '}';
    }
}
