<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<%

	
	String url = "jdbc:ucanaccess://D:/書籍管理.mdb";

	String usr = "";

	String pw = "";

	Connection cn = DriverManager.getConnection(url,usr,pw);

	request.setCharacterEncoding("UTF-8");

	String name    =request.getParameter("name");
	String order = request.getParameter("order");

	name = "%" + name +"%";

	String query = "select * from 分類別 where 書籍名 Like ? " ;
	if(order != null){
		if(order.equals("JAVA")){
			query += "AND 分類 = 'Java'";
		}
		else if(order.equals("AWS")){
			query += "AND 分類 = 'AWS'";
		}
		else if(order.equals("TOEIC")){
			query += "AND 分類 = 'TOEIC'";
		}
		else if(order.equals("KIHON")){
			query += "AND 分類 = '基本情報'";
		}
	}


	PreparedStatement prest = cn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	prest.setString(1,name);

	ResultSet rs =prest.executeQuery();


%>

<html>
	<head>
		<title>書籍名検索</title>
	</head>
		<body bgcolor=#ffffff>
			<font size="4">
				<h2>書籍名検索結果</h2>
				<hr>
				<p>
					<%
						while(rs.next()){
						out.println("<table border=\"1\">");
						out.print("<tr>");
						out.print("<td width=\"1000\" height=\"290\">");
						out.println("<p>IBSNコード:" +rs.getString("ISBNコード")+ "<br></p>");
						out.print("<p>書　籍　名　:"+rs.getString("書籍名")+"<br></p>");
						out.println("<p>著　者　名　:" +rs.getString("著者名")+"<br></p>");
						out.println("<p>出版社名　:" +rs.getString("出版社名")+"<br></p>");
						out.println("<p>発　行　日　:" +rs.getString("出版日")+"<br></p>");
						out.println("<p>価　　　格　:" +rs.getInt("価格")+"円<br></p>");
						out.println("<p>在　庫　数　:" +rs.getString("在庫")+"冊<br></p>");
						out.print("</td>");
						out.print("<td><img src="+"../image/"+rs.getString("写真")
							+" width=\"200\" height=\"290\"></td>");
						out.print("</tr>");
						out.print("<hr>");
						out.println("<table border=\"1\">");
						}
						rs.close();
						prest.close();
						cn.close();


					%>
					<a href="http://ictpc05/goods/jsp/HTML/Smpjsp100.html">もどゆ</a>
				</p>
				</hr>
			</font>
	</body>
</html>
