$(function () {
    var num=1;
    $(".button1").click(function () {
        num--;
        if(num<=0){
            num=0;
        }
            $("form :text").attr("value",num);
            $(".total").html(999*num);


    });
    $(".button2").click(function () {
        num++;
        $("form :text").attr("value",num);
        $(".total").html(999*num);
        console.log(num)
        console.log(999*num)
    });







})