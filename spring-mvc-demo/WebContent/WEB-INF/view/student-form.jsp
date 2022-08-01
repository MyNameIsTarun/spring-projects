<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<title>Student Registration form</title>
</head>

	<body>
	
		<form:form action="processForm" modelAttribute="student">
		
			First name: <form:input path="firstName" />
		
			<br><br>
		
			Last name: <form:input path="lastName" />
		
			<br><br>
			
			Country: 
			<form:select path="country">
				<form:options items="${student.countryOptions}" />
			</form:select>
			
			<br><br>
			
			Favorite Programming Language: <br>
			Java: <form:radiobutton path="favoriteLanguage" value="Java"/>
			Python: <form:radiobutton path="favoriteLanguage" value="Python"/>
			Javascript: <form:radiobutton path="favoriteLanguage" value="Javascript"/>
			C++: <form:radiobutton path="favoriteLanguage" value="C++"/>
			
			<br><br>
			
			Operating Systems: <br>
			<form:checkboxes items="${student.operatingSystems}" path="os"/>
			
			<br><br>
			
			<input type="submit" value="Submit">
		
		</form:form>
	
	</body>
	
</html>