
<html>
  <head>
    <title>Add Student </title>
  </head>
  <body>
      <center>
        <h1>Add Student</h1>

        <font color="red">${errorMessage}</font>

        <form action="/ui/student" method="post">
            <table>
            <tr>
                <td>Enter id:</td>
                <td><input type="text" name="id" value="${student.id}"/></td>
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

            <input type="submit" value="Add Student" />
      </form>

      </center>
  </body>
</html>