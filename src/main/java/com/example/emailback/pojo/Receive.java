package com.example.emailback.pojo;

import java.util.Properties;

public class Receive {
    // POP3服务器
    private String pop3Server;
    // 协议
    private String protocol;
    // 登陆邮件接收服务器的用户名和密码
    private String username;
    private String password;

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties(){
        Properties p2 = new Properties();
        p2.put("mail.pop3.host", this.pop3Server);
        p2.put("mail.store.protocol", this.protocol);
        return p2;
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

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
