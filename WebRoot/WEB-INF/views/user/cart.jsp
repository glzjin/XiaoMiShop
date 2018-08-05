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
                <h2>我的购物车</h2>
                <p>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</p>
                <jsp:include flush="true" page="../includes/user/bar.jsp"/>
            </div>
        </div>
    </div>
    <hr class="org">
    <!--选择块-->
    <div class="back">
    	<table id="table-item-list" class="list-head clear" style="text-align: center;  ">
    		<tr style="border-bottom:1px solid #E0E0E0">
    			<td><input type="checkbox" id="checkbox-select-all" onclick="selectAll(this.checked)"/>全选</td>
    			<td>商品名称</td>
    			<td>单价</td>
    			<td>数量</td>
    			<td>小计</td>
    			<td>操作</td>
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
       
        <!--结算块-->
        <div class="jiesuan">
            <div class="left jixu">
                <a href="/">继续购物</a>
                <span class="shu">|</span>
                <span>
                    共<i id="text-total-item-count"> 1 </i>件商品,已选择<i id="text-selected-item-count"> 0 </i>件
                </span>
            </div>
            <div class="right rjiesuan" id="btn-checkout">
                去结算
            </div>
            <span class="right heji">
                合计:<strong id="text-total-price">0</strong>元
            </span>
        </div>
        <!--分割块-->
        
        <!--十小块-->

    </div>
    
    <jsp:include flush="true" page="../includes/user/footer.jsp"/>
    
    
    <script src="/assets/public/js/gouwuche.js"></script>
    
    <script>
    	function selectAll(selectStatus){//传入参数（全选框的选中状态）
	        //根据name属性获取到单选框的input，使用each方法循环设置所有单选框的选中状态
	        $("input[name='check']").each(function(i,n){
	        	if(n.checked && !selectStatus) {
					var item_id = parseInt(n.getAttribute('data-item-id'));
					var item_total_price = getItemTotalPrice(item_id);
					total_price -= item_total_price;
	    			selected_item_count -= 1;
	        	}
	        	
	        	if(!n.checked && selectStatus) {
					var item_id = parseInt(n.getAttribute('data-item-id'));
					var item_total_price = getItemTotalPrice(item_id);
					total_price += item_total_price;
	    			selected_item_count += 1;
	        	}
	        	
	            n.checked = selectStatus;
	        });
	        
	        syncData();
	    }
	    
	    total_item_count = 0;
	    selected_item_count = 0;
	    total_price = 0;
	    function checkboxChecked(item_id, checked) {	    	
	    	if(checked) {
	    		total_price += getItemTotalPrice(item_id);
	    		selected_item_count += 1;
	    	} else {
	    		total_price -= getItemTotalPrice(item_id);
	    		selected_item_count -= 1;
	    	}
	    	
	    	syncData();
	    } 
	    
	    function getItemChecked(item_id) {
	    	return document.getElementById("checkbox-" + item_id).checked;
	    }
	    
	    function modifyItem(item_id, is_add) {
	    	if(getItemAmount(item_id) - 1 == 0 && !is_add) {
	    		deleteItem(item_id);
	    		return;
	    	}
	    	
	    	$.ajax({
	            type: "post",
	            url: "/user/cart/ajax/item/modify",
	            async: false, 
	            data: JSON.stringify({
	            	"item_id": item_id,
	            	"is_add": is_add
	            }),
	            contentType: "application/json; charset=utf-8",
	            dataType: "json",
	            success: function(data) {
	            	if(data.result == 1) {
	            		//操作成功之后就要变动界面
	            		if(is_add) {
	            			//添加
	            			setItemAmount(item_id, getItemAmount(item_id) + 1);
	            			
	            			setItemTotalPrice(item_id);
	            			
	            			if(getItemChecked(item_id)) {
	            				total_price += getItemPrice(item_id);
	            			}
	            			
	            			syncData();
	            			
	            		} else {
	            			//添加
	            			setItemAmount(item_id, getItemAmount(item_id) - 1);
	            			
	            			setItemTotalPrice(item_id);
	            			
	            			if(getItemChecked(item_id)) {
	            				total_price -= getItemPrice(item_id);
	            			}
	            			
	            			syncData();
	            		}
	            	}
	            } 
	        });
	    }
	    
	    function deleteItem(item_id) {
	    	
	    	$.ajax({
	            type: "post",
	            url: "/user/cart/ajax/item/delete",
	            async: false, 
	            data: JSON.stringify({
	            	"item_id": item_id
	            }),
	            contentType: "application/json; charset=utf-8",
	            dataType: "json",
	            success: function(data) {
	            	if(data.result == 1) {
	            		//操作成功之后就要变动界面
	            		total_price -= getItemTotalPrice(item_id);
	    				selected_item_count -= 1;
	    				
	    				syncData();
	    				
	    				$('#table-row-' + item_id).remove(); 
	            	}
	            } 
	        });
	    }
	    
	    //防止浮点数陷阱
	    function strip(num, precision = 12) {
	  		return parseFloat(num.toPrecision(precision));
		}
	    
	    function syncData() {
	    	$('#text-selected-item-count').html(" " + selected_item_count + " ");
	    	$('#text-total-price').html(strip(total_price));
	    	$('#text-total-item-count').html(" " + total_item_count + " ");
	    	
	    	if(selected_item_count <= 0) {
	    		//灰按钮
	    		$('#btn-checkout').css({"background": "#e0e0e0", "color": "#B0B0B0"});
	    		$('#btn-checkout').attr("disabled", "disabled");
	    	} else {
	    		//橙按钮
	    		$('#btn-checkout').css({"background": "#ff6700", "color": "#ffffff"});
	    		$('#btn-checkout').removeAttr("disabled");
	    	}
	    }
	    
	    function getItemPrice(item_id) {
	    	return parseFloat($('#text-' + item_id + '-price').text());
	    }
	    
	    function setItemPrice(item_id, price) {
	    	$('#text-' + item_id + '-price').text(strip(price));
	    }
	    
	    function getItemAmount(item_id) {
	    	return parseInt($('#text-' + item_id + '-amount').text());
	    }
	    
	    function setItemAmount(item_id, amount) {
	    	$('#text-' + item_id + '-amount').text(strip(amount));
	    }
	    
	    function getItemTotalPrice(item_id) {
	    	return parseFloat($('#text-' + item_id + '-total-price').text());
	    }
	    
	    function setItemTotalPrice(item_id) {
	    	$('#text-' + item_id + '-total-price').text(strip(getItemAmount(item_id) * getItemPrice(item_id)));
	    }
    	
    	function item_model(cart_info, item) {
    		total_item_count += 1;
    		$('#table-item-list  > tbody').after('<tr style="border-bottom:1px solid #E0E0E0" id="table-row-' + cart_info.itemId + '"><td><input type="checkbox"  id="checkbox-' + cart_info.itemId + '" name="check" id="tect-item-checkbox" data-item-id="' + cart_info.itemId + '" onclick="checkboxChecked(' + cart_info.itemId + ', this.checked)"/></td> \
    		<td class="name imga"><a href="/item/detail?item_id=' + cart_info.itemId + '"><img src="' + item.itemImgUri + '" alt="">' + item.itemName + '</a></td> \
    		<td id="text-' + cart_info.itemId + '-price">' + strip(item.itemPrice) + '</td> \
    		<td><button onclick="modifyItem(' + cart_info.itemId + ', true)">+</button><div id="text-' + cart_info.itemId + '-amount">' + cart_info.itemAmount + '</div><button onclick="modifyItem(' + cart_info.itemId + ', false)">-</button></td> \
    		<td id="text-' + cart_info.itemId + '-total-price">' + strip(item.itemPrice * cart_info.itemAmount) + '</td> \
    		<td><button onclick="deleteItem(' + cart_info.itemId + ', ' + item.itemPrice +');">X</button></td> \
    		<tr> \
    		');
    		/*var table = $('#table-item-list');
    		var row = table.insertRow(0);
    		row.insertCell(1).innerHTML = '<a href="/item/detail?id=' + cart_info.itemId + '"><img src="' + item.itemImgUri + '" alt=""></a>';
    		return '<div class="item"> \
                <div class="left check"> \
                    <i class="sele sele2">√</i> \
                </div> \
                <div class="left imag"> \
                    <a href="/item/detail?id=' + cart_info.itemId + '"><img src="' + item.itemImgUri + '" alt=""></a> \
                </div> \
                <div class="left name"> \
                    <a href=""> ' + item.itemName + ' </a> \
                </div> \
                <div class="left price"> ' + item.itemPrice + ' </div> \
                <div class="left num"> \
                    <form action="" class="for"> \
                        <input type="button" value="-" class="button1"> \
                        <input type="text"  class="text" value="1"> \
                        <input type="button" value="+" class="button2"> \
                    </form> \
                </div> \
                <div class="left total"> <span>999</span>元 </div> \
                <div class="left bigx"><div class="x">x</div></div> \
            </div> \
            ';*/
    	}
    	$(function() {
			 $.ajax({
		            type: "post",
		            url: "/user/cart/ajax/list",
		            async: false, 
		            data: JSON.stringify({
		            }),
		            contentType: "application/json; charset=utf-8",
		            dataType: "json",
		            success: function(data) {
		            	for(var cart_index in data) {
		            		var cart_info = data[cart_index];
		            		$.ajax({
					            type: "post",
					            url: "/item/ajax/detail",
					            async: false, 
					            data: JSON.stringify({
					            	"item_id": cart_info.itemId
					            }),
					            contentType: "application/json; charset=utf-8",
					            dataType: "json",
					            success: function(data) {
					           		//$('#div-item-list').append(item_model(cart_info, data));
					           		item_model(cart_info, data);
					            } 
					        });
		            	}
		            	
		            	syncData();
		            } 
		        });	
		        
		        //自动勾选所有
		        document.getElementById("checkbox-select-all").checked = true;
		        selectAll(true);
		        
		        $('#btn-checkout').click(function() {
		        		var checkout_list = [];
		        		$("input[name='check']").each(function(i,n){
		        			if(n.checked) {
								var item_id = parseInt(n.getAttribute('data-item-id'));
								checkout_list.push(item_id);
							}
		        		});
		        		
			        	$.ajax({
				            type: "post",
				            url: "/user/cart/ajax/checkout",
				            async: false, 
				            data: JSON.stringify(checkout_list),
				            contentType: "application/json; charset=utf-8",
				            dataType: "json",
				            success: function(data) {
				            	if(data.result == 1) {
				            		window.setTimeout(function(){location.href="/user/order/checkout"}, 1);
				            	}
				            } 
				        });	
		        });
    	});
    </script>
    