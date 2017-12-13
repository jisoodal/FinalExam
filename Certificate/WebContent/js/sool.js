!function($,n,e){
   var o=$();
   
   $.fn.dropdownHover=function(e){
      return"ontouchstart"in document?this:(o=o.add(this.parent()),
            this.each(function(){
               function t(e){
                  o.find(":focus").blur(),
                  h.instantlyCloseOthers===!0&&o.removeClass("open"),
                  n.clearTimeout(c),
                  i.addClass("open"),
                  r.trigger(a)}var r=$(this),
                  i=r.parent(),
                  d={delay:5,instantlyCloseOthers:!0},
                  s={delay:$(this).data("delay"),
                     instantlyCloseOthers:$(this).data("close-others")},
                     a="show.bs.dropdown",
                     u="hide.bs.dropdown",
                     h=$.extend(!0,{},d,e,s),
                     c;
                  
 i.hover(function(n){
   return i.hasClass("open")||r.is(n.target)?void t(n):!0},
   function(){c=n.setTimeout(function(){
   i.removeClass("open"),r.trigger(u)},h.delay)}),
   r.hover(function(n){
   return i.hasClass("open")||i.is(n.target)?void t(n):!0}),i.find(".dropdown-submenu").each(function(){
   var e=$(this),o;e.hover(function(){
   n.clearTimeout(o),
   e.children(".dropdown-menu").show(),
   e.siblings().children(".dropdown-menu").hide()},function(){
   var t=e.children(".dropdown-menu");o=n.setTimeout(function(){
   t.hide()},h.delay)})})}))},$(document).ready(function(){
   $('[data-hover="dropdown"]').dropdownHover()})}(jQuery,this);
   
   /*$(document).ready(function(){
         $(window).scroll(function(){
            if($(document).scrollTop()>50){
               $(".navbar-fixed-top").css("background-color","#f2f5f7");
            }else{
               $(".navbar-fixed-top").css("background-color","transparent");
            }
         });
      });
         */   
   
   $(document).ready(function(){
	   $(window).resize(function (){
		   var width=window.outerWidth;
		   if (width > 600) {
			   $(window).scroll(function(){
			          if($(document).scrollTop()>50){
			             $("#mainnav").css("background-color","#f2f5f7");
			          }else{
			             $("#mainnav").css("background-color","transparent");
			          }
			       });
				   } else if (width <=600){
					   $("#mainnav").css("background-color","#f2f5f7");
		
		  		   }
		   });
	 
   });