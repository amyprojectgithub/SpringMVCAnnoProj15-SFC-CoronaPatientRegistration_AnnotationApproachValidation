<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
span {
	color: red;
}
</style>
<noscript>
<p style="text-align: center;color: red"><b><i>Enable JavaScript on your browser!!!!!</i>></b></p>
</noscript>
<script type="text/javascript" src="js/validation.js"/>
</script>
<h2 style="color: green; text-align: center">:::::::Corona Patient Registration Form:::::::</h2>
<form:form modelAttribute="patCmd" onsubmit="return validate(this)">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Patient Name</td>
			<td><form:input path="patName"/><form:errors path="patName"/><span id="patNameErr"></span></td>
		</tr>
		<tr>
			<td>Patient Age</td>
			<td><form:input path="age"/><form:errors path="age"/><span id="ageErr"></span></td>
		</tr>
		<tr>
			<td>Patient Location</td>
			<td><form:input path="location"/><form:errors path="location"/><span id="locationErr"></span></td>
		</tr>
		<tr>
			<td>Hospital</td>
			<td><form:input path="hospital"/><form:errors path="hospital"/><span id="hospitalErr"></span></td>
		</tr>
		<tr>
			<td><input type="submit" value="register"></td>
			<td><input type="reset" value="clear"></td>
		</tr>
	</table>
	<form:hidden path="vflag"/>
</form:form>
