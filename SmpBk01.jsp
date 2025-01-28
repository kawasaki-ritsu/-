<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<%
	request.setCharacterEncoding("UTF-8");

	String isbn =request.getParameter("code");
	
	String url = "jdbc:ucanaccess://D:/書籍管理.mdb";

	String usr = "";

	String pw = "";

	Connection cn = DriverManager.getConnection(url,usr,pw);

	Statement st = cn.createStatement();

	String query = "select * from 出版社名 where ISBNコード= "+ isbn +";";

	ResultSet rs = st.executeQuery(query);


%>

<html>
	<head>
		<title>ISBNコード検索</title>
	</head>
		<body bgcolor=#ffffff>
			<font size="4">
				<h2>IBSNコード検索結果</h2>
				<hr>
					<%
						if(rs.next()){
						out.println("<p>IBSNコード:" +isbn+ "<br></p>");
						out.println("<table border=\"1\">");
						out.print("<tr>");
						out.print("<td width=\"1000\" height=\"290\">");
						out.print("<p>書　籍　名　:" +rs.getString("書籍名")+"<br></p>");
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
						}else{
							out.println();
						}
						rs.close();
						st.close();
						cn.close();



					%>
					<marquee scrollamount="50" behavior="alternate"><a href="http://ictpc05/goods/jsp/HTML/Smpjsp100.html">もどる～～～</a></marquee>
			</font>
	</body>
</html>
