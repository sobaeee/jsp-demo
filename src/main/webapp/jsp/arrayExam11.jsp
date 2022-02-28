<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println(Integer.MAX_VALUE);
out.println(Integer.MIN_VALUE);
int max = -99999999;//Integer.MIN
int [] arr = {-1, 5, 3, 8, 2};

for (int i = 0; i < arr.length; i++) {
	if (arr[i] > max) {
		max = arr[i];
	}
	
}
out.println(max);
%>

</body>
</html>