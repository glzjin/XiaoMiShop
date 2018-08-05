<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include flush="true" page="../includes/reg/header.jsp" />

<div class="layout">
  <div class="n-frame device-frame reg_frame" id="main_container">
    <div class="external_logo_area"><a class="milogo" href="javascript:void(0)"></a></div>
    <div class="title-item t_c">
      <h4 class="title_big30">注册小米帐号</h4>          
    </div>  
  <div>
  <div class="regbox" id="div-main">
    <p>${Msg}</p>
    <p>三秒后跳转到首页！</p>
    <script>
    	window.setTimeout(function(){location.href="/"}, 3000);
    </script>
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