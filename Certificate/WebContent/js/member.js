$(document).ready(function(){
	//id 중복체크 여부
	var checkIdDuplicated=0;//체크 안한것, 1이면 한것
	
	$('#mb_pw').click(function(){
		if($('#mb_pw').val()==''){
			alert('패스워드를 입력하세요!');
		}
	});
	
	
	$('#id_check').click(function(){
	      if($('#mem_id').val()==''){
	         alert('아이디를 입력하세요!');
	         $('#mem_id').focus();
	         return;
	      }
	
		$('#message_id').html('');//메시지 초기화
		$('#loading').show();//로딩이미지 노출
		 $.ajax({
	         url:'checkDuplicatedId.do',
	         type:'post',
	         data:{mem_id:$('#mem_id').val()},
	         dataType:'json',
	         cache:false,
	         timeout:30000,
	         success:function(data){
	            $('#loading').hide();//로딩 이미지 감추기
	            
	            if(data.result=='idNotFound'){
	               $('#message_id').css('color','#fafd98').text('등록 가능 ID');
	               checkIdDuplicated=1;//등록가능할 경우 1로 해서 사용가능하도록
	            }else if(data.result=='idDuplicated'){//아이디 중복
	               $('#message_id').css('color','#f9d9d9').text('중복된 ID');
	               $('#mem_id').val('').focus();
	               checkIdDuplicated=0;
	            }else{
	               alert('ID 중복 체크 오류 발생!');
	            }
	         },
	         error:function(){
	            $('#loading').hide();//로딩 이미지 감추기
	            alert('네트워크 오류 발생');
	         }
	      });
	   });
	   
	   
	
	//ID 중복안내 메시지 초기화 및 아이디 중복값 초기화 작업
	$('#register_form #mem_id').keyup(function(){
		checkIdDuplicated=0;
		$('#message_id').text('');
	});
	
	//회원 정보 등록 유효성 체크
	   $('#register_form').submit(function(){
	      if($('#mem_id').val()==''){
	         alert('아이디를 입력하세요.');
	         $('#mem_id').focus();
	         return false;
	      }
	      if(checkIdDuplicated==0){
	         alert('아이디 중복 체크 필수');
	         $('#id_check').focus();
	         return false;
	      }
	      if($('#mem_pw').val()==''){
	            alert('비밀번호를 입력하세요!');
	            $('#mem_pw').focus();
	            return false;
	      }
	      if($('#check_pw').val()==''){
	            alert('비밀번호 확인을 입력하세요!');
	            $('#check_pw').focus();
	            return false;
	         }
	         if($('#mem_pw').val()!=$('#check_pw').val()){
	            alert('비밀번호와 비밀번호 확인이 불일치합니다!');
	            $('#check_pw').val('').focus();
	            return false;
	         } 
	         if($('#mem_name').val()==''){
	            alert('이름을 입력하세요.');
	            $('#mem_name').focus();
	            return false;
	         }
	         if($('#mem_email').val()==''){
	            alert('이메일을 입력하세요.');
	            $('#mem_email').focus();
	            return false;
	         }
	      if($('#mem_cell').val()==''){
	         alert('전화번호를 입력하세요.');
	         $('#mem_cell').focus();
	         return false;
	      }
	   
	   });
	
	//로그인 유효성 체크
	$('#login_form').submit(function(){
		if($('#mem_id').val()==''){
			alert('아이디를 입력하세요');
			$('#mem_id').focus();
			return false;
		}
		if($('#mem_pw').val()==''){
			alert('비밀번호를 입력하세요');
			$('#mem_pw').focus();
			return false;
		}
		
	});
	//회원탈퇴 유효성 체크
	$('#delete_form').submit(function(){
		if($('#mem_pw').val()==''){
			alert('비밀번호를 입력하세요');
			$('#mem_pw').focus();
			return false;
		}
		if($('#check_pw').val()==''){
			alert('비밀번호 확인을 입력하세요');
			$('#check_pw').focus();
			return false;
		}
		if($('#mem_pw').val()!=$('#check_pw').val()){
			alert('비밀번호와 비밀번호 확인이 불일치합니다!');
			//value값을 초기화 시키고 포커스 주기
			$('#check_pw').val('').focus();
			return false;
		}
	});	
});