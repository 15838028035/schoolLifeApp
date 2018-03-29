// JavaScript Document
$(function(){
$('.forder li a').click(function(){	
	$(this).addClass('acver').parents('li').siblings().find('a').removeClass('acver')	
})
$('.app_Guest li').click(function(){
	$(this).addClass('avcet').siblings().removeClass('avcet')	
})
/*常见问题*/
$('.problem').click(function(){
	if($(this).hasClass('ancwer')){	
		$(this).removeClass('ancwer')
	}else{		
		$(this).addClass('ancwer').siblings().removeClass('ancwer')
	}	
})
/*收藏*/
$('body').on('click','.like',function(){
	if($(this).hasClass('j')){
		$(this).attr('src','img/xi02@2xx.png')
	    $(this).removeClass('j')
	}else{
		$(this).attr('src','img/xi01@2xx.png')
	    $(this).addClass('j')
	}		
})
$('.khlst').click(function(){
	layer.open({
    title: false
    ,className:'aopn'
    ,content:$('#jinof').html()
 });
})
$('body').on('click','.nodet',function(){
	
	layer.closeAll()
})
/*搜索遮罩层*/

var bodyheight= $(window).height()

var bodywidth= $(window).width()

$('.Mask').width(bodywidth)

$('.Mask').height(bodyheight-90+'px')

$('.Mask1').width(bodywidth)

$('.Mask1').height(bodyheight)

$('.web_sku').height(bodyheight)

/*搜索选项卡*/

$('.web_soso_tite li').click(function(){
	$(this).addClass('liacor').siblings().removeClass('liacor')	
})

/*搜索价格星级*/
$('.Mask').click(function(){
	$('.Mask').hide()
	$('.web_Price').hide()
	$('.web_Star').hide()
})
$('.mindor_4').click(function(){
	$('.Mask').hide()
	$('.web_Price').hide()
	$('.web_Star').hide()
	$('.mindor_3').css('background-image','url(img/sx@2x.png)')
})
$('.mindor_1').click(function(){
	$('.Mask').show()
	$('.web_Price').show()
	$('.web_Star').hide()
	$('.mindor_3').css('background-image','url(img/sx@2x.png)')
})
$('.mindor_2').click(function(){
	$('.Mask').show()
	$('.web_Star').show()
	$('.web_Price').hide()
	$('.mindor_3').css('background-image','url(img/sx@2x.png)')
})
$('.dont').click(function(){
	$('.Mask').hide()
	$('.web_Price').hide()
	$('.web_Star').hide()	
})
/*搜索条件筛选*/
$('.screen_right1 li').click(function(){
	if($(this).hasClass('navert')){
		$(this).removeClass('navert')
	}else{
		$(this).addClass('navert')
	}
	
})
$('.mindor_3').click(function(){
	$(this).css('background-image','url(img/sx_xz.png)')
	$('.Mask1').show()
	$('.web_sku').css('right','0')
	$('.Mask').hide()
	$('.web_Price').hide()
	$('.web_Star').hide()
})
$('.aist').click(function(){
	$('.Mask1').hide()
	$('.web_sku').css('right','-100%')
	
})


/*客房详情选项卡*/

$('.attribute li').click(function(){
	$(this).addClass('acvter').siblings().removeClass('acvter')	
	$('.attr_cont>.cenoct:eq(' + $(this).index() + ')').show().siblings().hide();
})

$('.hist').click(function(){
	layer.open({
    content: '领取成功'
    ,skin: 'msg'
    ,time: 2 //2秒后自动关闭
 });
})



$('.Coupon').click(function(){
 layer.open({
    type: 1
    ,className: 'amst'
    ,content: $('#oimyt').html()
    ,anim: 'up'
    ,style: 'position:fixed; bottom:0; left:0; width: 100%; height: 100%; padding:10px; border:none; box-sizing: border-box; overflow: auto;'
  });
})

$('body').on('click','.onctor_a',function(){
	
	layer.closeAll()
})

/*填写订单*/
$('.asint').click(function(){
      var exct = $('#exct').html()
      var j = $(exct).clone();
	  $('.Occupant_zont').append(j);	 
})
$('body').on('click','.remsint',function(){
	$(this).parents('.Occupant').remove()
})

//填写订单,房屋加减

$('.appjia').click(function() {
	var pp = $('.appcont');
	var getNum = parseInt(pp.html());
	if(getNum < 1000000) {
		pp.html(getNum + 1)
	} else {
		layer.open({		
		  className:'sese',			
          content: '不能大于99'		  
          ,skin: 'msg'		  
         ,time: 2 //2秒后自动关闭		 
      });
	}
})
$('.appjian').click(function() {
	var pp = $('.appcont');
	var getNum = parseInt(pp.html());
	if(getNum > 1) {
		pp.html(getNum - 1)
	} else {
		layer.open({		
		  className:'sese',		
          content: '不能小于1'	  
          ,skin: 'msg'	  
         ,time: 2 //2秒后自动关闭	 
      });
	}
})	

/*优惠券选择*/

$('.inyent_left_inp').click(function(){
	if($(this).hasClass('jop')){
		$(this).removeClass('jop')
	    $(this).find('input').prop('checked',false)
	    $(this).css('background-image','url(img/xie@2x_32.png)')
	}else{
	$(this).addClass('jop').siblings().removeClass('jop')
	$(this).find('input').prop('checked',true)
	$(this).css('background-image','url(img/pj@2x_50.png)').siblings().css('background-image','url(img/xie@2x_32.png)')
	}
	
})

/*提交订单*/
$('.forder_dist').click(function(){
	
	layer.open({		
		  className:'sese',		
          content: '提交成功'	  
          ,skin: 'msg'	  
         ,time: 2 //2秒后自动关闭	 
      });
	
})

/*优惠劵*/

$('.Coupon_lin_tite li').click(function(){
	$(this).addClass('acvio').siblings().removeClass('acvio')	
	/*$('.attr_cont>.cenoct:eq(' + $(this).index() + ')').show().siblings().hide();*/
})

$('.biem_cont').click(function(){
	$(this).addClass('biatacve').siblings().removeClass('biatacve')
	
})

     
	 










//通用提示框
$(".spoert").click(function(){
	var msg = $(this).attr("msg-tite")
	layer.open({	
	className:'smtn',
    content: msg
    ,btn: ['确认', '取消']
    ,skin: 'footer'
    ,yes: function(index){	
     layer.open({
    content: '提交成功'
    ,skin: 'msg'
    ,time: 2 //2秒后自动关闭
  });
    }
  });		
})	




})



	
















