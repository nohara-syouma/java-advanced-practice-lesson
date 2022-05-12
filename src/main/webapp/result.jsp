<%@ page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%
    /*
    下記コメントを参考に、必要な処理を記述してください
    todoと書かれた部分を変更してください
    */

    // todo:入力値を取得
    request.setCharacterEncoding("UTF-8");
    String userId = request.getParameter("userId");
	String userName = request.getParameter("userName");	
	String age = request.getParameter("age");
	
	int ageint = 0;
    if (!age.isEmpty()) {
        ageint = Integer.parseInt(age);
    }
	
	

    // todo:userオブジェクト作成
    // 入力値を作成したオブジェクトのフィールドにセット
    User user = new User(userId,userName,ageint);

    // セッションから現在のユーザー情報を取得
    out.println(session.getAttribute("users"));
    
    
    // 現在は変数のみ定義。
    // todo:セッションから値を取得するように修正。
    User[] users = (User[]) session.getAttribute("users");

    // セッションに値が無ければ、配列を作成
    if (users == null) {
        users = new User[5]; //最大件数：5
    }

    // 実行結果用メッセージ
    String result = "これ以上ユーザーを登録できません"; // 最大件数時のメッセージ

    // ユーザーを登録
    for (int count = 0; count < users.length; count++) {
        if (users[count] == null) {
            // todo:ユーザーを登録していない添え字の所に
            // 入力したユーザーを登録する
            users[count] = user;


            // 登録できた際のメッセージ
            result = "ユーザーを登録しました";
            break;
        }
    }

    // todo:セッションに現在のユーザー情報を保存
    session.setAttribute("users", users);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題1(発展)</title>
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

a.button {
    background-color: #ddeeff;
    border: 1px solid #ccc;
    padding: 5px;
    cursor: pointer;
}
</style>
</head>
<body>

  <h1>Java応用 - 演習問題1(発展)</h1>

  <h2>登録結果</h2>

  <div class="result">
    <h3>実行結果</h3>
    <p><%=result%></p>
  </div>

  
  <p>

    <span>現在の登録ユーザー</span><br>

    <%
        // 現在のユーザー情報を表示
        for (User tempUser : users) {
            if (tempUser != null) {
                // ユーザー情報を取得
                // todo:
                // 現在は変数のみ定義している。
                // Userクラスの情報取得用メソッドを呼んだ値をセットするように修正。
                String msg = tempUser.returnUserInfo();

                // ユーザー情報表示
                out.println(msg);
                out.println("<br>");
            }
        }
    %>
  </p>

  <form action="input.jsp">
    <button type="submit" name="btn" value="back">戻る</button>
    <button type="submit" name="btn" value="reset">リセット</button>
  </form>
</body>
</html>