package com.chang.utils;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class sendEmailUtil {
    private final String  sendEmail ;  //邮箱出口
    private final String pwd ;        //授权码

    public sendEmailUtil() {

        //Properties properties = new Properties();
        //try {
        //    properties.load(new FileInputStream("./config/email.properties"));
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //sendEmail = properties.getProperty("sendEmail");
        //pwd = properties.getProperty("pwd");
        sendEmail = "2148753336@qq.com";
        pwd = "ogvvdidndreudjic";
    }


    /**
     * @param receiveEmail	收件箱
     * @param name	称呼
     * @param emailMsg 消息
     * @return boolean
     */
    public boolean sendHtmlMail(String receiveEmail,String name,String emailMsg)  {
        try {
            JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
            //邮箱的主机  如果是qq邮箱就是smtp.qq.com
            senderImpl.setHost("smtp.qq.com");
            //编码集
            senderImpl.setDefaultEncoding("utf-8");

            //建立邮件消息，我们需要发送的是html格式邮件
            MimeMessage mimeMessage = senderImpl.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

            //设置收件人，寄件人
            messageHelper.setTo(receiveEmail);//收件人
            messageHelper.setFrom("2148753336@qq.com");//发件人
            messageHelper.setSubject("登录");//设置邮件的主题

            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

            //设置邮件的正文
            messageHelper.setText(emailMsg, true);

            //发件箱的名称
            senderImpl.setUsername(sendEmail);
            //发件箱的密码  状态码
            senderImpl.setPassword(pwd);

            Properties prop = new Properties();
            prop.put("mail.smtp.auth", "true");//让服务器去认证用户名和密码
            prop.put("mail.smtp.timeout", "2500");//连接超时时间
            senderImpl.setJavaMailProperties(prop);
            senderImpl.send(mimeMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
