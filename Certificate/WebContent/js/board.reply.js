$(document).ready(function(){
	var currentPage;
	var count;
	var rowCount;
	//댓글 목록
	function selectData(pageNum,num){//게시글 number
		currentPage=pageNum;
		
		if(pageNum==1){
			//처음 호출시에는 해당 id의 div의 내부 내용물을 제거(기타 페이지는 기존 데이터 뒤에 누적시킬겁니다.)
			$('#output').empty();
		}
		//로딩 이미지 노출(빙글빙글 이미지)
		$('#loading').show();
		
		$.ajax({
			type:'post',
			data:{pageNum:pageNum,num:num},//from function selectData(pageNum,num)
			url:'listReplyAjax.do',//server program에 data를 넘김
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				//로딩 이미지 감추기
				$('#loading').hide();
				//단일데이터는 그냥 빼고
				count=data.count;
				rowCount=data.rowCount;
				//아니니깐 반복문
				var list=data.list;
				
				if(count<0 || list==null){
					alert('목록 호출 오류 발생');
				}else{
					$(list).each(function(index,item){
						var output="";
						output+='<div class="item" id="i'+item.re_num+'">';
						output+='<h4>'+item.id+'</h4>';
						output+='<div class="sub-item">';
						output+='<p>'+item.re_content+'</p>';
						output+='<div>'+item.re_date;
						if($('#user_id').val() && $('#user_id').val()==item.id){
							output += ' <input type="button" data-num="'+item.re_num+'" data-id="'+item.id+'" value="수정" class="modify_button">';
							
							output += ' <input type="button" data-num="'+item.re_num+'" data-id="'+item.id+'" value="삭제" class="delete_button">';
							
						}else{
							output += ' <input type="button" value="수정" disabled="disabled">';
							output += ' <input type="button" value="삭제" disabled="disabled">';
						}
						output+='<hr size="1" noshade>';//수평선
						output+='</div>';
						output+='</div>';
						output+='</div>';
						
						//위에서 얻은 데이터를 순서대로 문서 객체에 추가
						$('#output').append(output);
					});
					//paging button처리
					if(currentPage>=Math.ceil(count/rowCount)){
						//다음페이지가 없으면 
						$('.paging_button').hide();
					}else{
						//다음페이지 존재
						$('.paging_button').show();
					}
				}
			},
		error:function(){
			//로딩 이미지 감추기
			$('#loading').hide();
			alert('목록 호출시 네트워크 오류!');
		}
		});
	}
	//다음 댓글 보기 버튼 클릭시 데이터 추가
	$('.paging_button input').click(function(){
		var pageNum = currentPage +1;
		selectData(pageNum,$('#num').val());
	});
	//댓글 등록
	$('#re_form').submit(function(event){
		if($('#re_content').val()==''){
			alert('내용을 입력하세요');
			$('#re_content').focus();
			return false;
		}
		var data=$(this).serialize();//parameter에 데이터를 쌍으로 읽어옴
		
		//등록
		$.ajax({
			type:'post',
			data:data,
			url:'writeReplyAjax.do',
			dataType:'json',//T를 소문자로 쓰면 나중에 JSON으로 인식을 못함
			cache:false,
			timeout:30000,
			success:function(data){//정상적으로 Data를 전송 받았으나 기타 오류 발생시 alert함
				if(data.result=="logout"){
					alert("로그인해야 작성할 수 있습니다.");
				}else if(data.result=='success'){
					//기존에 폼에 입력한 데이터 초기화
					initForm();
					//수정폼 초기화
					initModifyForm();
					/*
					 * 댓글 작성이 성공하면 새로 삽입한 글을 포함해서 첫번째 페이지의 게시글을 다시 호출함
					 */
					selectData(1,$('#num').val());//부모글번호
				}else{
					alert('등록시 오류 발생');
				}
			},
			error:function(){
				alert('댓글 작성 오류!');
			}
		});
		//기본 이벤트 제거
		event.preventDefault();
	});
	//댓글 작성 폼 초기화
	function initForm(){
		$('textarea').val('');
		$('#re_first.letter-count').html('300/300');
	}
	//textarea에 내용 입력시 글자수 체크
	$('#re_content,#mre_content').keyup(function(){
		//남은 글자수를 구함
		var inputLength = $(this).val().length;
		
		if(inputLength>300){//300을 넘어서면 잘르는 것
			//300자가 넘어서면 더이상 입력을 하지 못하게 처리
			$(this).val($(this).val().substring(0,300));
			if($(this).attr('id')=='re_content'){
				//등록폼 글자수
				$('#re_first .letter-count').html('0/300');
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').html('0/300');
			}
		}else{
			var remain = 300- inputLength;
			remain += '/300';
			//문서객체에 반영
			if($(this).attr('id')=='re_content'){
				//등록 폼 글자수
				$('#re_first .letter-count').html(remain);
			}else{
				//수정폼 글자수
				$('#mre_first .letter-count').html(remain);
			}
		}
	});
	
	//댓글 수정 버튼 클릭시 수정폼 노출
	$(document).on('click','.modify_button',function(){
		//댓글 글번호
		var num = $(this).attr('data-num');
		//작성자 아이디
		var id = $(this).attr('data-id');
		
		//이전에 이미 수정하는 댓글이 있을경우 수정버튼을
		//클릭하면 숨김 sub-item를 환원시키기위함
		$('.sub-item').show();
		//지금 클릭해서 수정하고자 한느 데이터는 감춤
		$('#i'+num+'.sub-item').hide();
		
		//수정폼에 데이터 셋팅
		$('#mre_num').val(num);
		$('#muser_id').val(id);
		$('#mre_content').val($('#i'+num+' p').first().text());
		
		//입력한 글자수 셋팅
		var inputLength = $('#mre_content').val().length;
		var remain = 300 - inputLength;
		remain += '/300';
		  
		//문서객체에 반영
		$('#mre_first .letter-count').html(remain);
		
		//수정폼을 수정하고자하는 데이터가 있는 div에 노출
		$('#i'+num).append($('#mre_form'));
		
	});
	
	//수정폼에서 취소 버튼 클릭시 수정폼 초기화
	$('.re-reset').click(function(){
		initModifyForm();
	});
	//댓글 수정폼 초기화
	function initModifyForm(){
		$('.sub-item').show();
		$('#modify_div').append($('#mre_form'));
		$('#mre_num').val('');
		$('#muser_id').val('');
		$('#mre_content').val('');
		$('#mre_first .letter-count').html('300/300');
	}
	//댓글수정
	$('#mre_form').submit(function(event){
		if($('#mre_content').val()==''){
			alert('내용을 입력하세요');
			$('#mre_content').focus();
			return false;
		}
		
		//폼에 입력한 데이터 반환
		var data = $(this).serialize();
		
		//수정
		$.ajax({
			type:'post',
			data:data,
			url:'updateReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=='logout'){
					alert('로그인해야 수정할수있습니다');
				}else if(data.result=='wrongAccess'){
					alert('타인의 글은 수정할수 없습니다');
				}else if(data.result=='success'){
					$('#i'+$('#mre_num').val() + ' p').html($('#mre_content').val());
					//수정폼 초기화
					initModifyForm();
				}else{
					alert('수정오류발생');
				}
			},
			error:function(){
				alert('댓글 수정시 네트워크 오류');
			}
		});
		//기본이벤트 제거
		event.preventDefault();
	});
	//댓글삭제
	$(document).on('click','.delete_button',function(){
		//댓글번호
		var data_num = $(this).attr('data-num');
		//작성자아이디
		var id =$(this).attr('data-id');
		
		$.ajax({
			type:'post',
			data:{re_num:data_num,id:id},
			url:'deleteReplyAjax.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result == 'logout'){
					alert('로그인해야 삭제할수 있습니다!');
				}else if(data.result == 'wrongAccess'){
					alert('타인의 글을 삭제할수 없습니다');
				}else if(data.result == 'success'){
					alert('삭제완료!');
					//수정폼초기화
					initModifyForm();
					selectData(1,$('#num').val());
				}
			},
			error:function(){
				alert('댓글삭제시 네트워트 오류');
			}
		});
		
	});
	
	//초기 데이터(목록)호출
	selectData(1,$('#num').val());//구동이 안되면 캐시 제거가 안되서 그런겁니다.
});