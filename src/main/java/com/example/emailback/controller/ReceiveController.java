package com.example.emailback.controller;

import com.example.emailback.pojo.Receive;
import com.example.emailback.util.Result;
import com.example.emailback.util.StatusCode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/receive")
@CrossOrigin
public class ReceiveController {
    @RequestMapping(method = RequestMethod.POST)
    public Result receive(@RequestBody Map<String, String> map) {
        try {
            Receive receiveInfo = new Receive();
            receiveInfo.setPop3Server(map.get("pop3Server")); // POP3服务器
            receiveInfo.setProtocol(map.get("protocol")); // 协议
            receiveInfo.setUsername(map.get("username")); // 登陆邮件接收服务器的用户名
            receiveInfo.setPassword(map.get("password")); // 登陆邮件接收服务器的授权码

            Properties pro2 = receiveInfo.getProperties();
            Session mailSession = Session.getInstance(pro2, null);
            mailSession.setDebug(false);
            try {
                Store store = mailSession.getStore(receiveInfo.getProtocol());
                //登陆验证
                store.connect(receiveInfo.getPop3Server(), receiveInfo.getUsername(), receiveInfo.getPassword());
                //获取邮箱帐户
                Folder folder = store.getFolder("inbox");
                //设置访问权限
                folder.open(Folder.READ_WRITE);
                //获取全部邮件
                Message[] messages = folder.getMessages();

                for (int i = messages.length - 1; i < messages.length; i++) {
                    //主题
                    String subject = messages[i].getSubject();
                    //时间
                    Date sendDate = messages[i].getSentDate();
                    //发件人
                    String from = messages[i].getFrom()[0].toString();
                    //内容
                    MimeMultipart part = (MimeMultipart) messages[i].getContent();
                    BodyPart body = part.getBodyPart(0);
                    String content = body.getContent().toString();

                    String data = "<p>" + "主题：" + subject
                            + "<br/><br/>" + "发件人：" + from
                            + "<br/><br/>" + "时间：" + sendDate
                            + "<br/><br/><br/>" + "正文："
                            + "<br/><br/>" + content
                            + "</p>";

                    return new Result(true, StatusCode.OK, "接收成功！", data);
                }
                folder.close(false);
                store.close();

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } catch (Exception e){
            return new Result(false,StatusCode.ERROR,"接收失败！");
        }
        return new Result(false,StatusCode.ERROR,"接收失败！");
    }
}
