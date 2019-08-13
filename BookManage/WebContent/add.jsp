<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

$(function(){
	
	$("#form").submit(function(){
		
		var bName=$("#bName").val();
		var bAuthor=$("#bAuthor").val();
		var bTime=$("#bTime").val();
		var bType=$("#book").val();
		var reg=/^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
		if(bName==""){
			alert("图书名称和作者不能为空");
			return false;
		}
		if(bAuthor==""){
			alert("图书名称和作者不能为空");
			return false;
		}
		if(!bTime.match(reg)){
			alert("日期格式不正确");
			return false;
		}
		if(bType==0){
			alert("请选择图书分类");
			return false;
		}
		
		return true;
		
	});
	
	
});
</script>
</head>
<body>
	<form action="addServlet" id="form">
	
		<table border="0">
			<tr>
				<td colspan="2" align="center">新增图书信息</td>
			</tr>
			<tr>
				<td>图书名称：</td>
				<td><input type="text" name="bName" id="bName"/></td>
			</tr>
			<tr>
				<td>图书作者：</td>
				<td><input type="text" name="bAuthor" id="bAuthor" /></td>
			</tr>
			<tr>
				<td>购买日期：</td>
				<td><input type="text" name="bTime" id="bTime"/>yyyy-MM-dd</td>
			</tr>
			<tr>
				<td>图书类别：</td>
				<td>
					<select id="book" name="bType">
						<option value="0">选择所属分类</option>
						<option value="1">计算机/软件</option>
						<option value="2">小说/文摘</option>
						<option value="3">杂项</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="增加图书" /></td>
			</tr>
		</table>
	</form>
</body>
</html>