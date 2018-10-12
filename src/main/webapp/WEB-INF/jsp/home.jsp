<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Student Web Application</title>
</head>
<body>
    <h1 align="center">Student Application Spring Boot</h1>

    <center>
        <font color="red">${errorMessage}</font>

        <h3> <a href="/ui/student/addstudent">Add Student</a> </h3>
    </center>

    <table align="center" border=1>
        <tr>
            <td>StudentId</td>
            <td>Name</td>
            <td>Course</td>
            <td></td>
            <td></td>
        </tr>

        <c:forEach var="student" items="${studentList}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.course}</td>
                <td> <a href="/ui/student/edit/${student.id}">Edit</a> </td>
                <td> <a href="/ui/student/delete/${student.id}">Delete</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>