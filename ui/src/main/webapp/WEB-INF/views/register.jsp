<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="resources/css/templatemo_style.css" rel="stylesheet" type="text/css">	
<title>register</title>
</head>
<body class="templatemo-bg-gray">
	<h1>用户注册</h1>
	<div class="container center-block templatemo-form-list-container templatemo-container">
		<div class="col-md-12">	
			<form action="user/register" method="post">
				<table class="table table-striped table-hover">
				  <tbody align="center">
					<tr>
					  <td>账号：<input type="text" name="account" /></td>
					</tr>
					<tr>
					  <td>密码：<input type="password" name="password"/></td>
					</tr>
					<tr>
					<tr>
					  <td>昵称：<input type="text" name="name" /></td>
					</tr>
					<tr>
					  <td>性别：<input type="text" name="sex" /></td>
					</tr>
					<tr>
					  <td>电话：<input type="text" name="tel" /></td>
					</tr>
					<tr>
					  <td>
						  <div class="col-md-12">
							<input type="submit" value="确认注册" class="btn btn-warning">
						  </div>
					  </td>
					</tr>
				  </tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>