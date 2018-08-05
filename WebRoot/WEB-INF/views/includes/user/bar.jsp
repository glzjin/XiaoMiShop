<%@ page import="com.offcn.util.SessionUtil" %>
<%@ page import="com.offcn.pojo.Users" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="r">
    <div class="rl clear">
        <a href=""><span>${user.username}</span></a>
        <ul>
            <li class="li"><b><a href="/user/login/logout">退出登录</a></b></li>
        </ul>
    </div>
    <div class="rr">
        <a href="/user/order" class="dingd">我的订单</a>
    </div>
</div>