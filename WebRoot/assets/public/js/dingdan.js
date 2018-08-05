$(".smbox").not(".lastbox").on("click",function () {
    $(this).addClass("on");
    $(this).siblings().removeClass("on");
    $(this).find("span").css("display","block");
    $(this).siblings().find("span").css("display","none");
});

$(".title_box").click(function () {
    $(this).addClass("on1");
    $(this).siblings().removeClass("on1")
});

$(".yhquan").children("i").focus().click(function (e) {
    $(this).parent().next("div").css("display","block");
    e.stopPropagation();//阻止冒泡事件
    /*e.target 事件源*/
});

$("body").click(function () {
    // console.log($("body").not(".yhquan i"))
    $(this).find(".yhqnr").css("display","none");
    // e.stopPropagation();
    // alert(1)
});

$(".yhqnr").click(function (e) {
    e.stopPropagation();
});
$(".yhqnr").find("li").click(function (e) {
    $(this).css("color","#ff6700");
    $(this).siblings().css("color","#757575");
    if(this.className==="left secli"){
        $(this).parent("ul").siblings(".lidiv1").css("display","none");
        $(this).parent("ul").siblings(".lidiv2").css("display","block");
    }
    if(this.className==="left firli"){
        $(this).parent("ul").siblings(".lidiv2").css("display","none");
        $(this).parent("ul").siblings(".lidiv1").css("display","block");
    }
});

$(".inbox input:text").eq(0).focus(function () {
    $(this).prev("div").css({"display":"none"});
    $(this).siblings(".zuoshang").css({"display":"block"});
    $(this).css("border","2px solid #ff6700");
}).blur(function () {
    $(this).prev("div").css("display","block");
    $(this).siblings(".zuoshang").css({"display":"none"});
    $(this).css("border","1px solid #E0E0E0");
});
$(".buyong").click(function () {
    $(this).parents(".yhqnr").css("display","none");
    console.log($(this).parents(".yhqnr"));
});



