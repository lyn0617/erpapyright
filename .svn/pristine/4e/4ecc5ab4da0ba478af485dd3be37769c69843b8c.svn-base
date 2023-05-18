<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>부서관리</title>
<!-- sweet alert import -->
<script src='${CTX_PATH}/js/sweetalert/sweetalert.min.js'></script>
<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<!-- sweet swal import -->

<script type="text/javascript">
	
	// 페이징 설정
	var pageSize = 10;
	var pageBlockSize = 5;
	
	/** OnLoad event */ 
	$(function() {
	
		fRegisterButtonClickEvent(); //버튼이벤트
	
		searchdept();
		
	});
	
	/** 버튼 이벤트 등록 */
	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');
			
			switch (btnId) {
			    case 'btnSave' :
				fn_save();
				break;
			    case 'btnDelete' :
			    	$("#action").val("D");
					fn_countindept();
					break;
				case 'btnClose' :
					gfCloseModal();
					break;
			}
		});
	}
	
	/* 부서 정보 검색 */
	function searchdept(cpage) {
		
		cpage = cpage || 1;
		
		// 파라메터,  callback
		var param = {
				srcdept : $("#srcdept").val(),
				pageSize : pageSize,
				cpage : cpage,
		}
		console.log(param);
		
		var listcallback = function(returndata) {
						
			console.log(returndata);
			
			$("#listDept").empty().append(returndata);
			
			var countdeptlist = $("#countdeptlist").val();
			
			var paginationHtml = getPaginationHtml(cpage, countdeptlist, pageSize, pageBlockSize, 'searchdept');
			
			$("#deptPagination").empty().append(paginationHtml);
			
			$("#currentpage").val(cpage);
			
		}
		
		callAjax("/system/deptlist.do", "post", "text", "false", param, listcallback) ;
	}
	
    // 부서 등록 팝업	
	function fn_openpopup() {
		
		initpopup();
		
		gfModalPop("#deptreg");
		
	}
    
    // 부서정보 저장
	function fn_save(data) {
		
		if(!fValidate()) {
			return;
		}
		
		if(!data == 0){ //data는 존재인원이 넘어옴
			console.log("들어왔다")
			alert("해당 부서에 인원이 존재합니다.")
			return;
		}
		
		var param = {
				detail_name  : $("#detail_name").val(),  
				detail_code : $("#detail_code").val(),
				action : $("#action").val(),
		}
		console.log(param);
		var savecallback = function(returndata) {
						
			console.log(  JSON.stringify(returndata) );
			
			if(returndata.result == "SUCCESS") {
				alert("저장 되었습니다.");
				gfCloseModal();
				
				if($("#action").val() == "U") {
					searchdept($("#currentpage").val());
				} else {
					searchdept();
				}
				
			}
		}
		
		callAjax("/system/deptsave.do", "post", "json", "false", param, savecallback) ;
		
	}
    
    function fValidate() {
    	
		var chk = checkNotEmpty(
				[
						[ "detail_name", "부서명을 입력해 주세요." ]
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
    
	function initpopup(object) {	
		
		if( object == "" || object == null || object == undefined) {
			
			$("#detail_name").val("");
			$("#detail_code").val("");
			
			$("#btnDelete").hide();
			
			$("#action").val("I");
		} else {			
			
			$("#detail_name").val(object.detail_name);
			$("#detail_code").val(object.detail_code);
			
			$("#btnDelete").show();
			
			$("#action").val("U");
		}
		
	}
	
	
	// 부서 상세정보 조회
    function fn_detaildept(detail_code,popuptype) {
    	
		$("#countindept").val(detail_code);
		
    	var param = {
    			detail_code : detail_code
    	}
    	
    	var detaildeptcallback = function(returndata) {
    		console.log(  JSON.stringify(returndata)  );
    		
    		console.log( returndata.detaildept.detail_code);
    		
    		
    		initpopup(returndata.detaildept);
        		
        	gfModalPop("#deptreg");
    		
    		
    	}
    	
    	callAjax("/system/detaildept.do", "post", "json", "false", param, detaildeptcallback) ;
    } 
	
	function fn_countindept(){
		
		var param = {
				dept_cd : $("#countindept").val()
		}
		
		var callback = function(data){
			console.log(data);
			fn_save(data.countindept);
		}
		callAjax("/system/countindept.do", "post", "json", false, param, callback);
	}

</script>

</head>
<body>

<form id="myForm" action=""  method="">
	<input type="hidden" name="action" id="action" value="">
	<input type="hidden" name="loginId" id="loginId" value="${loginId}">
	<input type="hidden" name="userNm" id="userNm" value="${userNm}">
	<input type="hidden" name="currentpage" id="currentpage" value="">
	<input type="hidden" name="countindept" id="countindept" value="">
	
	<!-- 모달 배경 -->
	<div id="mask"></div>

	<div id="wrap_area">

		<h2 class="hidden">header 영역</h2>
		<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

		<h2 class="hidden">컨텐츠 영역</h2>
		<div id="container">
			<ul>
				<li class="lnb">
					<!-- lnb 영역 --> <jsp:include
						page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
				</li>
				<li class="contents">
					<!-- contents -->
					<h3 class="hidden">contents 영역</h3> <!-- content -->
					<div class="content">

						<p class="Location">
							<a href="../dashboard/dashboard.do" class="btn_set home">메인으로</a> <span
								class="btn_nav bold">시스템</span> <span class="btn_nav bold">부서관리
								</span> <a href="../system/comnCodMgr.do" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>부서관리</span> 
						</p>
						
						
						<span>	
						부서명
						
						<input type="text" id="srcdept" name="srcdept" style="width: 150px; height: 25px;"/>
								
						<a	class="btnType blue" href="javascript:searchdept();" name="modal" ><span>검색</span></a>
							<c:if test ="${sessionScope.userType eq 'A'}">
								<a	class="btnType blue" href="javascript:fn_openpopup();" name="modal"><span>등록</span></a>
							</c:if>	
						<!-- userType이 관리자 일때만 등록 버튼이 뜸 -->
						</span>										
							
						
						
						<div class="divComGrpCodList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="50%">
									<col width="50%">
								</colgroup>
								<thead>
									<tr>
										<th scope="col">부서명</th>
										<th scope="col">부서코드</th>
									</tr>
								</thead>
								<tbody id="listDept"></tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="deptPagination"> </div>
						
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>
	
		<div id="deptreg" class="layerPop layerType2" style="width: 600px;">
	     <dl>
			<dt>
			
				<c:choose>
			
			         <c:when test = "${sessionScope.userType eq 'A'}">
			         	<strong>부서 등록/수정</strong>   
			         </c:when>
					 		
			         <c:otherwise>
			         	<strong>부서 조회</strong>   
			         </c:otherwise>
			    </c:choose>
			    

			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="120px">
						<col width="*">
						<col width="120px">
						<col width="*">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">부서명 <span class="font_red">*</span></th>
							  <c:choose>
						      	 <c:when test = "${sessionScope.userType eq 'A'}">
						            <td><input type="text" class="inputTxt p100" name="detail_name" id="detail_name" /></td>
						         </c:when>			
						         <c:otherwise>
						            <td><input type="text" class="inputTxt p100" name="detail_name" id="detail_name" readonly /></td>
						         </c:otherwise>
						      </c:choose>
							
							<th scope="row">부서코드 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="detail_code" id="detail_code" readonly /></td>
						</tr>	
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
			      <c:choose>
			
			         <c:when test = "${sessionScope.userType eq 'A'}">
						<a href="" class="btnType blue" id="btnSave" name="btn"><span>저장</span></a> 
						<a href="" class="btnType blue" id="btnDelete" name="btn"><span>삭제</span></a>
						<a href=""	class="btnType gray"  id="btnClose" name="btn"><span>취소</span></a> 			            
			         </c:when>
			
			         <c:otherwise>
			         	<a href=""	class="btnType gray"  id="btnClose" name="btn"><span>확인</span></a>   
			         </c:otherwise>
			      </c:choose>
				
					
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	
	
	</div>
	

	
	

</form>

</body>
</html>