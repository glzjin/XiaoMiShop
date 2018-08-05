<%@ page import="com.offcn.util.SessionUtil" %>
<%@ page import="com.offcn.pojo.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 顶部条 -->
	<div class="box">
		<div class="cen clear">
			<div class="lefta">
				<a href="/">小米商城</a>
			</div>
			<% 	Users user = new SessionUtil(session).getUserFromSession();
				if(user == null) {%>
				<div class="righta">
					<a href="/user/login">登录</a>
					<span class="shu">|</span>
					<a href="/user/reg">注册</a>
					<div class="gwc">
						<a href="/user/cart" ><span>购物车(0)</span></a>
						<div class="gwcxiala"><b class="claspan">您还未登录，请登陆后再查看。</b></div>
					</div>
				</div>
				<% } else {%>
				<div class="righta">
					<a href="#">欢迎您，<%=user.getUsername() %></a> <span class="shu"> | </span><a href="/user/order">我的订单</a><span> | </span><a href="/user/login/logout">登出</a>
					<div class="gwc">
						<a href="/user/cart" ><span id="div-cart-count">购物车(0)</span></a>
						<div class="gwcxiala"><b class="claspan">查看购物车</b></div>
					</div>
				</div>
				<%} %>
		</div>
	</div>
	
	<!-- 文字条 -->
	<div class="box1 clear">
		<div class="mi">
			<a href="/"><img src="/assets/public/images/zhuye/mi.jpg" alt=""></a>
		</div>
		<div class="wenzi" id="div-category-link">
		</div>

	</div>
	