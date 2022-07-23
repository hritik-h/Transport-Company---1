<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="model.User"%>
<%@ page import="service.UserService"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>
<body>
<%
	//UserBean user = new UserBean();
	UserService dao = new UserService();
	List<User> userList = dao.getAllRecords();
	//Iterator<UserBean> itr = userList.iterator();
	for(User user: userList){
	out.println();
	}
%>
<table class="table">
	<thead>
	<tr>
		<th scope="col">Id</th>
		<th scope="col">First Name</th>
		<th scope="col">Last Name</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<%
			/*while(itr.hasNext())
			 {
			 System.out.println(user.getId());*/
			for (User user : userList) {
		%>
		<td><%=user.getId()%></td>
		<td><%=user.getFirstName()%></td>
		<td><%=user.getLastName()%></td>

	</tr>
	</tbody>
	<%
		}
		//}
	%>
</table>
</body>
</html>