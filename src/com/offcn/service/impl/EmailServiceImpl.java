package com.offcn.service.impl;

import java.util.Date;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.offcn.pojo.Users;
import com.offcn.service.EmailService;
import com.offcn.service.UsersService;
import com.offcn.util.ConfigUtil;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
    private MimeMessage mimeMessage;
	
	@Autowired
	private UsersService usersService;
    
	@Async
	public void sendVerifyEmail(Users user) {
		//没发送的再发送
		if(user.getIsEmailAuth() == UsersService.USER_AUTH_STATUS_UNAUTH) {
			try {
				//读配置文件
				ConfigUtil mailConfig = new ConfigUtil("mail");
				
	            MimeMessageHelper mailMessage = new MimeMessageHelper(
	                    this.mimeMessage, true, "UTF-8");
	            mailMessage.setFrom(mailConfig.getConfig("sender"));// 设置邮件消息的发送者

	            mailMessage.setSubject("小米商城 - 验证邮件");// 设置邮件消息的主题
	            mailMessage.setSentDate(new Date());// 设置邮件消息发送的时间
	            
	            long unixTime = System.currentTimeMillis() / 1000L;
	            mailMessage.setText("请点击以下链接来完成您的验证，三小时内有效：<a href=\"" + mailConfig.getConfig("access_host") + 
	            					"/user/reg/verify?email=" + user.getEmail() + "&t=" + unixTime + "&token=" + this.usersService.getUserVerifyToken(user.getEmail(), unixTime) + "\">" + mailConfig.getConfig("access_host") + 
	            					"/user/reg/verify?email=" + user.getEmail() + "&t=" + unixTime + "&token=" + this.usersService.getUserVerifyToken(user.getEmail(), unixTime) + "</a>", true); // 设置邮件正文，true表示以html的格式发送
	            
	            mailMessage.setTo(user.getEmail());//设置收件人
	            
                this.mailSender.send(this.mimeMessage);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	}
}
