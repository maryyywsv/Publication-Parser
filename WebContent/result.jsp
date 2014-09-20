<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Publication Finder</title>
</head>
<body>
<div class="col-sm-offset-2 col-sm-8">
		<br/>
<table class="table table-hover">
			
		    
			<tr>
				<td class="warning">Author</td>
				<td><%=request.getAttribute("author")%></td>
			</tr>
			<tr>
				<td class="warning">Title</td>
				<td><%=request.getAttribute("title")%></td>
			</tr>
			<tr>
				<td class="warning">Pages</td>
				<td><%=request.getAttribute("pages")%></td>
			</tr>
			<tr>
				<td class="warning">year</td>
				<td><%=request.getAttribute("year")%></td>
			</tr>
			</table>
			<p>Publication Finder WebApp is developed by Yuwei Yang.</p>
			</div>
</body>
</html>