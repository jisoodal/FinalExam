<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>자격증 시험장 안내</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">   
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sool.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sool.js"></script>

  </head>
 <style>
 	.cover{
 		color:black;
 	}
 </style>
  <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true&key=AIzaSyC6hcU8i93zfGdbgepwGhjsagJ31HTaYIk"></script>

<!-- Code -->
<script type="text/javascript">
    /** Google Map 객체. **/
    GoogleMap = {
        /* 초기화. */
        initialize : function() {
            this.input = document.getElementById("GoogleMap_input");
            this.address = document.getElementById("GoogleMap_addr");
            this.geocoder = new google.maps.Geocoder();
            this.infowindow = new google.maps.InfoWindow();
               
            //지도 생성.(기본 위치 서울.)
            var latlng = new google.maps.LatLng(37.56641923090,126.9778741551);
            var myOptions = {
                zoom: 8,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            this.map = new google.maps.Map(
                    document.getElementById("GoogleMap_map"),myOptions);
                
            //마커 생성.
            this.marker = new google.maps.Marker({
                map : this.map,
                animation: google.maps.Animation.DROP
            });
        },
        /* 주소 검색.(지오코딩) */
        codeAddress : function() {
            var address = this.input.value;
            //콜백 함수 호출.
            this.geocoder.geocode( { 'address': address}, 
                           function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    //검색 된 주소 목록.
                    GoogleMap.address.innerHTML = "";
                    var ul = document.createElement('ul');
                    for(var i=0; i<results.length; i++){
                        var li = document.createElement('li');
                        var a = document.createElement('a');
                         
                        a.href = "#";
                        a.innerHTML = results[i].formatted_address;
                        GoogleMap.clickAddress(a, results[i].geometry.location,
                                results[i].formatted_address);
                        
                        li.appendChild(a);
                        ul.appendChild(li);
                    }
                    GoogleMap.address.appendChild(ul);
                }
            });
        },
        //주소 클릭 이벤트.
        clickAddress : function(a, addr,content){
            a.onmousedown = function(){
                //지도와 마커이동.
                GoogleMap.map.setCenter(addr);
                GoogleMap.marker.setPosition(addr);
                GoogleMap.marker.setAnimation(google.maps.Animation.DROP);
                GoogleMap.infowindow.setContent(content);
                GoogleMap.infowindow.open(GoogleMap.map,GoogleMap.marker);
            }
        }
    }
    window.onload = function(){
        GoogleMap.initialize();
    }
</script>

<body>
<jsp:include page="../main/module/mainTest.jsp"/>
	<div class="cover">
		<div class="cover-image"
			style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
		<div class="container" id="content">
		        <div>
				    <div id="GoogleMap_map" style="width:500px; height:500px; float:left;">
				    </div>
				    <div style="height:500px; padding-left: 10px;">
				        <div><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				            <input id="GoogleMap_input" type="textbox" value="" onkeydown="javascript:if(event.keyCode == 13) GoogleMap.codeAddress();" >
				            <input type="button" value="Enter" onclick="javascript:GoogleMap.codeAddress()">
				        </div>
				        <div id="GoogleMap_addr"></div>
				    </div>
			</div>
		</div>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp"/>