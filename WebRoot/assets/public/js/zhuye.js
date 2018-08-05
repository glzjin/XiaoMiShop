
var t1 =setInterval(gun,2000);
var num = 0;
function gun() {
    //alert(1)
    num++;
    if(num>=$(".right1 li").length){
        num=0;
    }else if(num<0){
        num=$(".right1 li").length;
    }
    $(".right1 li").eq(num).css("z-index",2).animate({"opacity":1}).siblings().css({"z-index":1,"opacity":0});
    $(".dian span").eq(num).addClass("change").siblings().removeClass("change");
}
    $(".right1").mouseover(function () {
        clearInterval(t1);
    }).mouseout(function () {
        t1 =setInterval(gun,2000);
    });
    $(".right1 .zuo").click(function () {
        num-=2;//向前移动一个,但是经过num++,num会不发生改变 所以需要-2
        gun();
    });
    $(".right1 .you").click(function () {
        gun();
    });
    $(".dian span").click(function () {
       var index = $(this).index();
        num = index-1;
        gun();
    });


$(".gundong ul").eq(0).css("left", "0");

var t2=setInterval(move,2000);
var flag=true;
var n1=0;//下一个
var n2=0;//当前
function move(e) {
    e=e?e:"left";
    n1++; //1
    n2=n1-1; //0
    if(n1 >= $(".gundong ul").length){
        n1=0;
    }
    if(e=="left"){
        $(".gundong ul").eq(n2).css("left","0");
        $(".gundong ul").eq(n1).css("left","1225px");

        $(".gundong ul").eq(n2).stop().animate({"left":"-1225px"});
        $(".gundong ul").eq(n1).stop().animate({"left":"0"});
    }else{
        $(".gundong ul").eq(n2).stop().css("left","0");
        $(".gundong ul").eq(n1).stop().css("left","-1225px");

        $(".gundong ul").eq(n2).stop().animate({"left":"1225px"});
        $(".gundong ul").eq(n1).stop().animate({"left":"0"});
    }
}
$(".l-1").click(function(){
    clearInterval(t2);
    move("left");
    flag=false;
});
$(".r-1").click(function(){
    clearInterval(t2);
    move("right");
    flag=false;
});
setInterval(function(){
    if(!flag){
        t=setInterval(move,2000);
        flag=true;
    }

},5000);


