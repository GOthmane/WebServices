<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conversion</title>
</head>
<body>
	<form method="post" action="ConversionED">
		<fieldset>
			<legend>Conversion d'euros en dollars</legend>
			<label for="mtEuros">Saisir le montant en euros :</label> <input
				type="text" name="mtEuros" id="mtEuros" /><br />
		</fieldset>
		<input type="submit" value="valider" /><br />
	</form>
	<p>${mtDollars} dollars</p>
</body>
</html>