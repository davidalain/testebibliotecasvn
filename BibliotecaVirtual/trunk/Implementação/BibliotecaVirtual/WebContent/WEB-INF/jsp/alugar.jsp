<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca Virtual - Alugar Livro</title>
</head>
<body>
<form action="Alugar.do" method="post">

<table>
	<tr>
		<td>C�digo do Aluno:</td> 
		<td><input type="text" name="idAluno"></td>
	</tr>
	<tr>
		<td>C�digo do Exemplar:</td> 
		<td><input type="text" name="idExemplar" ></td>
	</tr>
	<tr>
		<td><input type="submit" value="Alugar"></td>
	</tr>
</table>

</form>
</body>
</html>