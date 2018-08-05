<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的购物车-小米商城</title>
    <link rel="stylesheet" href="/assets/public/css/index4.css">
</head>
<body>
    <!--标题块-->
    <div class="head">
        <div class="mid clear">
            <div class="image">
                <a href="/"><img src="/assets/public/images/milogo.jpg" alt=""></a>
            </div>
            <div class="l">
                <h2>我的订单</h2>
                <jsp:include flush="true" page="../includes/user/bar.jsp"/>
            </div>
        </div>
    </div>
    <hr class="org">
    <!--选择块-->
    <div class="back">
    	<table id="table-order-list" class="list-head clear" style="text-align: center;">
    		<tr style="border-bottom:1px solid #E0E0E0">
    			<td>订单号</td>
    			<td>商品内容</td>
    			<td>小计</td>
    			<td>时间</td>
    			<td>送货信息</td>
    			<td>状态</td>
    		</tr>
    	</table>
    	<!--  
        <div class="list-head clear">
            <div class="check"><i class="sele sele1">√</i>全选</div>
            <div class="left b1">&nbsp;</div>
            <div class="left b2">商品名称</div>
            <div class="left b3">单价</div>
            <div class="left b4">数量</div>
            <div class="left b5">小计</div>
            <div class="left b6">操作</div>
        </div>
        <div class="itembg" id="div-item-list">
            
        </div>-->
       
        
        
        <!--十小块-->

    </div>
    
    <jsp:include flush="true" page="../includes/user/footer.jsp"/>
    
    <script>
    
    	function getDateTime(timeStamp) {
    		var date = new Date(timeStamp);
			Y = date.getFullYear() + '-';
			M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
			D = date.getDate() < 10 ? '0' + date.getDate() + ' ':  date.getDate() + ' ';
			h = date.getHours() + ':';
			m = date.getMinutes() + ':';
			s = date.getSeconds(); 
			return Y+M+D+h+m+s;
    	}
    	function item_model(order, items) {
    		var str = '';
    		str += '<tr id="table-row-' + order.i + '" style="border-bottom:1px solid #E0E0E0"> \
    		<td>' + order.id + '</td> \
    		<td class="name">';
    		
    		for(var item_index in items) {
    			var item = items[item_index];
    			str += '<p><a href="/item/detail?item_id=' + item.id + '">' + item.itemName + '</a> X ' + item.itemAmount + ' (' + item.itemPrice + ' X ' + item.itemAmount + ')元</p>';
    		}
    		
    		status = '';
    		
    		switch(order.status) {
    			case 0:
    				status = '未付款';
    				break;
   				case 1:
   					status = '已付款，等待发货';
   					break;
  				default:
  					status = '未知状态';
    		}
    		
    		str += '</td> \
    		<td>' + order.price + '元</td> \
    		<td>' + getDateTime(order.datetime) + '</td>\
    		<td>' + order.userRealName + '<br>' + order.userPhone + '<br>'+ order.userAddress + '</td> \
    		<td>' + status + '</td> \
    		</tr> \
    		';
    		
    		$('#table-order-list  > tbody').after(str);
    	}
    	
    	$(function() {
			 $.ajax({
		            type: "post",
		            url: "/user/order/ajax/list",
		            async: false, 
		            data: JSON.stringify({
		            }),
		            contentType: "application/json; charset=utf-8",
		            dataType: "json",
		            success: function(data) {
		            	for(var order_index in data.data) {
		            		var order = data.data[order_index];
		            		$.ajax({
					            type: "post",
					            url: "/user/order/ajax/item",
					            async: false, 
					            data: JSON.stringify({
					            	"order_id": order.id
					            }),
					            contentType: "application/json; charset=utf-8",
					            dataType: "json",
					            success: function(data) {
					            	var item_list = [];
					            	for(var order_item_index in data.data) {
					            		var order_item = data.data[order_item_index];
					            		$.ajax({
								            type: "post",
								            url: "/item/ajax/detail",
								            async: false, 
								            data: JSON.stringify({
								            	"item_id": order_item.itemId
								            }),
								            contentType: "application/json; charset=utf-8",
								            dataType: "json",
								            success: function(data) {
								            	data.itemAmount = order_item.itemAmount;
								            	data.itemPrice = order_item.itemCurrentPrice;
								           		item_list.push(data);
								            } 
					        			});
					            	}
					            	
					            	item_model(order, item_list);
					            } 
					        });	
		            	}
		            } 
		        });	
		       
    	});
    </script>
    