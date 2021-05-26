package com.example.emailback.entity;

public class Dept {
    private Integer id;
    private Integer userId;
    private String mailbox;
    private String mailServerHost;
    private String mailServerPort;
    private String pop3Server;
    private String protocol;
    private String userName;
    private String password;
    private String fromAddress;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", mailServerHost='" + mailServerHost + '\'' +
                ", mailServerPort='" + mailServerPort + '\'' +
                ", pop3Server='" + pop3Server + '\'' +
                ", protocol='" + protocol + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getPop3Server() {
        return pop3Server;
    }

    public void setPop3Server(String pop3Server) {
        this.pop3Server = pop3Server;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
}
