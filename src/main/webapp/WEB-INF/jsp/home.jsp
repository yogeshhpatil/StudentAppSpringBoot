<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Sample Application using Spring Boot</title>
</head>

<body>
    <div class="container">

        <center>
            <h1>Student Application</h1>
            <hr>
            <div class="alert alert-danger" role="alert"> ${errorMessage} </div>
            <hr>
            <a class="btn btn-outline-success" href="/ui/students/addstudent" role="button">Add Student</a>
            <hr>
        </center>

        <table class="table">

            <thead class="thead-dark">
                <tr>
                    <th scope="col">StudentId</th>
                    <th scope="col">Name</th>
                    <th scope="col">Course</th>
                    <th scope="col">Operation</th>
                    <th scope="col">Operation</th>
                </tr>
            </thead>

            <tbody>

                <c:forEach var="student" items="${studentList}">
                    <tr>
                        <th scope="row">${student.id}</th>
                        <td>${student.name}</td>
                        <td>${student.course}</td>
                        <td>
                            <a class="btn btn-outline-success" href="/ui/students/edit/${student.id}" role="button">Update</a>
                        </td>
                        <td>
                            <a class="btn btn-outline-danger" href="/ui/students/delete/${student.id}" role="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <!-- Optional JavaScript -->

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </div>
</body>

</html>