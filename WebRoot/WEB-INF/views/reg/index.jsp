<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include flush="true" page="../includes/reg/header.jsp" />

<div class="layout">
  <div class="n-frame device-frame reg_frame" id="main_container">
    <div class="external_logo_area"><a class="milogo" href="/"></a></div>
    <div class="title-item t_c">
      <h4 class="title_big30">注册小米帐号</h4>          
    </div>  
  <div>
  <div class="regbox" id="div-main">
    <div class="phone_step1">
      <h4 class="tit_normal">
       用户名
      </h4>
      <div class="listwrap_inside_panel c_b">
        <div class="inputbg">
          <label class="labelbox" for="">
            <input name="text" placeholder="请输入用户名" type="text" id="text-username" maxlength="32">
          </label>
        </div>
        <div class="err_tip" id="div-username-msg">
          <div class="dis_box"><em class="icon_error"></em><span></span><div id="msg-username"></div></div>
        </div>
      </div>
      
      <h4 class="tit_normal">
        邮箱
      </h4>
      <div class="listwrap_inside_panel c_b">
        <div class="inputbg">
          <label class="labelbox" for="">
            <input name="email" placeholder="请输入邮箱" type="email" id="text-email" maxlength="32">
          </label>
        </div>
        <div class="err_tip" id="div-email-msg">
          <div class="dis_box"><em class="icon_error"></em><span></span><div id="msg-email"></div></div>
        </div>
      </div>
      
      <h4 class="tit_normal">
        密码
      </h4>
      <div class="listwrap_inside_panel c_b">
        <div class="inputbg">
          <label class="labelbox" for="">
            <input name="password" placeholder="请输入密码" type="password" id="text-password" maxlength="32">
          </label>
        </div>
        <div class="err_tip" id="div-password-msg">
          <div class="dis_box"><em class="icon_error"></em><span></span><div id="msg-password"></div></div>
        </div>
      </div>
      
      <div class="err_tip send-left-times">
      </div>
      <div class="err_tip err_invalid error-invalid">
        <div class="dis_box"><em class="icon_error"></em><span></span></div>
      </div>
      <div class="fixed_bot mar_phone_dis1">
        <input class="btn332 btn_reg_1 submit-step" data-to="phone-step2" value="立即注册" type="submit" id="btn-reg">
        <img style="display:none;" src="/assets/reg/tick.png">
      </div>
    </div>
  </div>
  <div class="privacy_box">
    <div class="msg">
      <label class="n_checked now select-privacy">
        <i class="icon_select"></i>注册帐号即表示您同意并愿意遵守小米 <a href="http://www.miui.com/res/doc/eula/cn.html" class="inspect_link agreement_link" title="用户协议" target="_blank">用户协议</a>和<a href="http://www.miui.com/res/doc/privacy/cn.html" class="inspect_link privacy_link" title=" 隐私政策 " target="_blank"> 隐私政策 </a>
      </label>
    </div>
  </div>
</div></div>
</div>

<jsp:include flush="true" page="../includes/reg/footer.jsp" />

<script type="text/javascript">
	$(function() {
		email_can_be_reg = true;
		password_can_be_reg = true;
		username_can_be_reg = true;
		
		//监控文本框输入结束
		$("#text-email").change(function(){
			var regExp = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/; 
			if(!regExp.test($("#text-email").val())){ 
				$("#msg-email").html("请输入正确的邮箱地址！");
    			$("#div-email-msg").show();
    			email_can_be_reg = false;
                return; 
            } 
			$.ajax({
	            type: "post",
	            url: "/user/email/ajax/check",
	            async: false, 
	            data: JSON.stringify({                  
	                "email": $("#text-email").val()
	            }),
	            contentType: "application/json; charset=utf-8",
	            dataType: "json",
	            success: function(data) {
	                if(data.result == 1) {
	                	$("#msg-email").html("该邮箱地址已被注册！");
	        			$("#div-email-msg").show();
	        			email_can_be_reg = false;
	                } else {
	                	$("#div-email-msg").hide();
	                	email_can_be_reg = true;
	                }
	            } 
	        });

		});
		
		$("#text-password").change(function(){
			var password = $("#text-password").val();
			if(password.length < 6) {
				$("#msg-password").html("密码长度需要大于六位！");
    			$("#div-password-msg").show();
    			password_can_be_reg = false;
    			return;
			}
			
			$("#div-password-msg").hide();
			password_can_be_reg = true;	
		});
		
		$("#text-username").change(function(){
			var username = $("#text-username").val();
			if(username.length < 1) {
				$("#msg-username").html("大侠，不留个名吗！");
    			$("#div-username-msg").show();
    			username_can_be_reg = false;
    			return;
			}
			
			$("#div-username-msg").hide();
			username_can_be_reg = true;	
		});
		
		$("#btn-reg").click(function(){
			if(!email_can_be_reg || $("#text-email").val() == "") {
				$("#msg-email").html("您的邮箱地址似乎有些问题，请检查！");
    			$("#div-email-msg").show();
    			return;
			}
			
			$("#div-email-msg").hide();
			
			if(!password_can_be_reg || $("#text-password").val() == "") {
				$("#msg-password").html("您的密码似乎有些问题，请检查！");
    			$("#div-password-msg").show();
    			return;
			}
			
			$("#div-password-msg").hide();
			
			if(!username_can_be_reg || $("#text-username").val() == "") {
				$("#msg-username").html("您的用户名似乎有些问题，请检查！");
    			$("#div-username-msg").show();
    			return;
			}
			
			$("#div-username-msg").hide();
			
			$.ajax({
	            type: "post",
	            url: "/user/reg/ajax",
	            async: false, 
	            data: JSON.stringify({                  
	                "email": $("#text-email").val(),
	                "password": $("#text-password").val(),
	                "username": $("#text-username").val()
	            }),
	            contentType: "application/json; charset=utf-8",
	            dataType: "json",
	            success: function(data) {
	                if(data.result == 1) {
	                	email = $("#text-email").val();
	                	
	                	$.ajax({
	        	            type: "post",
	        	            url: "/user/email/ajax/send",
	        	            async: false, 
	        	            data: JSON.stringify({                  
	        	                "email": email
	        	            }),
	        	            contentType: "application/json; charset=utf-8",
	        	            dataType: "json",
	        	            success: function(data) {
	        	            } 
	        	        });
	                	
	                	$("#div-main").html('<p>注册成功，到您的邮箱激活账号吧！</p> \
	                			<p>三秒后跳转到首页！</p>');
	                	window.setTimeout(function(){location.href="/"}, 3000);
	                } else {
	                	$("#div-main").html('<p>注册失败！</p> \
	                			<p>三秒后跳转到首页！</p>');
	                	window.setTimeout(function(){location.href="/"}, 3000);
	                }
	            } 
	        });
		});
	});
</script>