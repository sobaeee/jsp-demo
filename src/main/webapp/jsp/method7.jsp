<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!


private static int remainder(int i, int j) {
	return i % j;
	
}

private static double divide(int i, int j) {
	return i / j;
	
	
}

private static int multiply(int i, int j) {
	return i * j;
	
}

private static int add(int i, int j) {
	return i + j;

}
private static int minus(int i, int j) {
	return i - j;

}

%>
<%
int i = 4;
int j = 2;
int res = 0;
double res2 =0;
res = add(i,j);
out.println(i + " + " + j + " = " + res);
add(i, j);// 더하기
System.out.println(i + " - " + j + " = " + res);
minus(i, j);// 빼기
System.out.println(i + " * " + j + " = " + res);
multiply(i, j);// 곱하기
out.println(i + " / " + j + " = " + res2);
divide(i, j);// 나누기
out.println(i + " % " + j + " = " + res);
remainder(i, j);// 나머지
%>

</body>
</html>