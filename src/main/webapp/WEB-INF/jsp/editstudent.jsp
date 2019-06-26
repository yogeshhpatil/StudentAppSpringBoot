
<html>

<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Sample Application using Spring Boot</title>
</head>

<body>
    <hr>

    <center>
        <div class="alert alert-danger" role="alert"> ${errorMessage} </div>
    </center>

    <hr>

    <div class="container">
        <form action="/ui/students/${student.id}" method="POST">
            <div class="form-group">
                <label for="lblId">Enter Id</label>
                <input type="text" class="form-control" id="id" name="id" placeholder="Id" value="${student.id}">
            </div>
            <div class="form-group">
                <label for="lblName">Enter Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${student.name}">
            </div>
            <div class="form-group">
                <label for="lblCourse">Enter Course</label>
                <input type="text" class="form-control" id="course" name="course" placeholder="Course" value="${student.course}">
            </div>

            <button type="submit" class="btn btn-primary">Update Student</button>
            <a class="btn btn-outline-success" href="/ui/students" role="button">Home</a>

        </form>
    </div>

    <!-- Optional JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>

</html>