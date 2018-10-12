
<html>
  <head>
    <title>Edit Student </title>
  </head>
  <body>
      <center>
        <h1>Edit Student</h1>

        <form action="/ui/student/${student.id}" method="post">
            <table>
            <tr>
                <td>Enter id:</td>
                <td><input type="text" name="id" value="${student.id}" readonly/></td>
            </tr>
            <tr>
                <td>Enter name:</td>
                <td><input type="text" name="name" value="${student.name}" /></td>
            </tr>
            <tr>
                <td>Enter course:</td >
                <td><input type="text" name="course" value="${student.course}"/></td>
            </tr>
            </table>

            <input type="submit" value="Update Student" />
      </form>

      </center>
  </body>
</html>