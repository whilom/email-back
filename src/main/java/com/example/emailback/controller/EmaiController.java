package com.example.emailback.controller;

import com.example.emailback.pojo.Email;
import com.example.emailback.util.EmailUtil;
import com.example.emailback.util.Result;
import com.example.emailback.util.StatusCode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/email")
@CrossOrigin
public class EmaiController {

    @RequestMapping(method = RequestMethod.POST)
    public Result send(@RequestBody Map<String, String> map) {
        try{
            Email mailInfo = new Email();
            mailInfo.setMailServerHost(map.get("mailServerHost")); //发送邮件的服务器
            mailInfo.setMailServerPort(map.get("mailServerPort")); //发送邮件的服务器的端口
            mailInfo.setUserName(map.get("userName")); //登陆邮件发送服务器的用户名
            mailInfo.setPassword(map.get("password")); //登陆邮件发送服务器的授权码
            mailInfo.setFromAddress(map.get("fromAddress")); //邮件的发件地址
            mailInfo.setToAddress(map.get("email")); //邮件的收件地址
            mailInfo.setSubject(map.get("title")); //邮件的title
            mailInfo.setContent(map.get("content")); //邮件的内容

            //这个类主要来发送邮件
            EmailUtil.sendHtmlMail(mailInfo);
            return new Result(true, StatusCode.OK,"发送成功！");
        } catch (Exception e){
            return new Result(false,StatusCode.ERROR,"发送失败！");
        }
    }
}
