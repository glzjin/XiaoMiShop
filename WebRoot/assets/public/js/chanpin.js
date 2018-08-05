$(".ul1").find("li").click(function () {
    $(this).css("border","1px solid #ff6700");
    $(this).siblings().css("border","1px solid #E0E0E0")
});
$(".ul1").find("li").eq(0).click(function () {
    $(".total li").eq(0).find("i").html("红米5 Plus  3GB+32GB");
    $(".total li").eq(0).find("span").html("999元");
    $(".totalpri").html("总计 ：999元");
})
$(".ul1").find("li").eq(1).click(function () {
    $(".total li").eq(0).find("i").html("红米5 Plus 4GB+64GB");
    $(".total li").eq(0).find("span").html("1299元");
    $(".totalpri").html("总计 ：1299元");
})
$(".ul2").find("li").click(function () {
    $(this).css("border","1px solid #ff6700");
    $(this).siblings().css("border","1px solid #E0E0E0");
    if($(this).find("b").html()=="金色"){
        $(this).eq(0).parents(".midbg").find(".img").attr("src","images/jshm.jpg");
    }if($(this).find("b").html()=="黑色"){
        $(this).eq(0).parents(".midbg").find(".img").attr("src","images/hshm.jpg");
    }if($(this).find("b").html()=="玫瑰金"){
        $(this).eq(0).parents(".midbg").find(".img").attr("src","images/mgjhm.jpg");
    }if($(this).find("b").html()=="浅蓝色"){
        $(this).eq(0).parents(".midbg").find(".img").attr("src","images/qlshm.jpg");
    }
    $(".ul2").find("li").eq(0).click(function () {
        $(".total li").eq(0).find("em").html("金色");
    });
    $(".ul2").find("li").eq(1).click(function () {
        $(".total li").eq(0).find("em").html("黑色");
    });
    $(".ul2").find("li").eq(2).click(function () {
        $(".total li").eq(0).find("em").html("玫瑰金");
    });
    $(".ul2").find("li").eq(3).click(function () {
        $(".total li").eq(0).find("em").html("浅蓝色");
    });
    //console.log(this);
    //console.log($("li:contains(黑色)").get(0));
    /*this==$("li:contains(金色).get(0)"*/
    //$("li:contains(浅蓝色)").eq(0).parents(".midbg").find(".img").attr("src","images/qlshm.jpg");
});




/*if(this==$("li:contains(黑色)").get(0)){
    $("li:contains(黑色)").eq(0).parents(".midbg").find(".img").attr("src","images/hshm.jpg");
}
if(this==$("li:contains(玫瑰金)").get(0)){
    $("li:contains(玫瑰金)").eq(0).parents(".midbg").find(".img").attr("src","images/mgjhm.jpg");
}
if(this==$("li:contains(浅蓝色)").get(0)){
    $("li:contains(浅蓝色)").eq(0).parents(".midbg").find(".img").attr("src","images/qlshm.jpg");
}
//console.log(this);
//console.log($("li:contains(黑色)").get(0));
/!*this==$("li:contains(金色).get(0)"*!/
//$("li:contains(浅蓝色)").eq(0).parents(".midbg").find(".img").attr("src","images/qlshm.jpg");*/

