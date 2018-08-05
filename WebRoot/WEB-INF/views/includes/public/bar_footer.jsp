<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
	$(function() {
		$.ajax({
    	            type: "post",
    	            url: "/user/login/ajax/is_login",
    	            async: true, 
    	            data: JSON.stringify({
    	            }),
    	            contentType: "application/json; charset=utf-8",
    	            dataType: "json",
    	            success: function(data) {
    	            	if(data.result == 1) {
    	            		setInterval(function(){refresh_cart();},1000);
    	            		$(".righta").css("width", "362px");
    	            	}
    	            } 
    	        });
	});
	
	function refresh_cart() {
			//定时刷新
           	
			$.ajax({
    	            type: "post",
    	            url: "/user/cart/ajax/list",
    	            async: true, 
    	            data: JSON.stringify({
    	            }),
    	            contentType: "application/json; charset=utf-8",
    	            dataType: "json",
    	            success: function(data) {
    	            	
    	            	$('#div-cart-count').html('<span id="div-cart-count">购物车(' + data.length + ')</span>');
    	            	
    	            } 
    	        });
    	       
		}
</script>