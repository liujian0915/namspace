<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/book.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

$(function(){
	
	$("tr:odd").css("background-color","#9AEEE1");
	$("tr:eq(1)").css("background-color","#7DB4F8");
	
	
	
	var flag="${param.flag}";
	if(flag!=null && flag!="" && undefined!=flag){
		if(flag=="success"){
			alert("会议室预定成功");
		}else{
			alert("会议室预定失败");
		}
	}
});


function deleteBook(bId,obj) {
	
	var falg=confirm('确认删除这本书吗？');
	if(falg==true){
		//删除成功
		//ajax删除
		$.ajax({
			url:"deleteServlet",
			type:"get",
			data:{"id":bId},
			dataType:"json",
			success:function(data){
				alert(data);
				if(true==data){
					$(obj).parent().parent().remove();
				}
			},
			error:function(data){
				
			}
			
		});
	}
}
</script>
</head>
<body>
	<table border="1" width="500px">
	
		<tr>
			<td colspan="5" class="td" align="center">图书信息</td>
		</tr>
		<tr class="aa">
			<td >图书名称</td>
			<td>图书作者</td>
			<td>购买时间</td>
			<td>图书分类</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="u">
		<tr>
			<td>${u.bName }</td>
			<td>${u.bAuthor }</td>
			<td>${u.bTime }</td>
			<td>
				<c:if test="${u.bType==0 }">选择所属分类</c:if>
				<c:if test="${u.bType==1 }">计算机/软件</c:if>
				<c:if test="${u.bType==2 }">小说/文摘</c:if>
				<c:if test="${u.bType==3 }">杂项</c:if>
						
			</td>
			<td> 
		<%-- 	<a href="javascript:if(confirm('确认删除这本书吗？')) location='<%=request.getContextPath() %>/deleteServlet?id=${u.bId }'" style="color:blue">删除</a> --%>
			<a href="javascript:void(0);" style="color:blue" onclick="deleteBook('${u.bId}',this)">删除</a>
			</td>
		</tr>
			
		</c:forEach>
	</table>
	<a href="add.jsp" class="add">新增图书信息</a>
</body>
</html>