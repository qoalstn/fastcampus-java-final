<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<strong>고객 등록 화면</strong>
    <form action="${pageContext.request.contextPath}/regist" method="post">
		<label for="no">고객번호 : ${no}<input type="text" id="no" name="no"></label>
		<label for="name">고객이름 : <input type="text" id="name" name="name"></label>
		<label for="phone">전화번호 : <input type="text" id="phone" name="phone"></label>
		<label for="email">이메일 : <input type="text" id="email" name="email"></label>
		<label for="grade">고객등급(P,G,S) : <input type="text" id="grade" name="grade"></label>
 		<button type="submit">등록</button>
 		<button>취소</button>
    </form>


</body>
</html>