

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
request.setCharacterEncoding("UTF-8");
String name = (String) request.getParameter("name");
String example = (String) request.getParameter("example");

out.println(example);

String result = "未実施";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題4</title>
<style>
body {
border: solid 2px #000080;
padding: 5px;
}

.result {
background: #fffacd;
display: inline-block;
margin: 5px;
padding: 10px;
}
</style>
</head>
<body>

<h1>Java応用 - 演習問題4</h1>

<h2>ゲームアプリ実行ページ</h2>

<div class="result">
    <h3>アプリの実行結果</h3>
    <c:if test="${not empty name}">
        <p>${info}</p>
    </c:if>

</div>

<form action=StartAppServlet method="post">
    <label>ユーザ名：</label> <input type="text" name="name"> <br>
    アプリ: <input type="radio" name="example" value="トランプ" checked>トランプ
    <input type="radio" name="example" value="ダーツ">ダーツ <input
        type="radio" name="example" value="時計">時計 <input type="radio"
        name="example" value="その他">その他 <br>

    <button type="submit">実行</button>
</form>
</body>
</html>