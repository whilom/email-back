package com.example.emailback.pojo;

import java.io.File;
import java.util.Properties;

public class Email {
    // 发送邮件的服务器的IP和端口
    private String mailServerHost;
    private String mailServerPort;
    private static boolean isSSL;
    // 邮件发送者的地址
    private String fromAddress;
    // 邮件接收者的地址
    private String toAddress;
    // 登陆邮件发送服务器的用户名和密码
    private String userName;
    private String password;
    // 是否需要身份验证
    private static boolean validate = false;
    // 邮件主题
    private String subject;
    // 邮件的文本内容
    private String content;

    static{
        isSSL = false;
        validate = true;
    }

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties(){
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        p.put("mail.stmp.timeout", "5000");
        return p;
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

    public boolean isValidate() {
        return validate;
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

    public String getToAddress() {
        return toAddress;
    }
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String textContent) {
        this.content = textContent;
    }

    public static boolean getIsSSL() {
        return isSSL;
    }
    public static void setIsSSL(boolean isSSL) {
        Email.isSSL = isSSL;
    }
}
