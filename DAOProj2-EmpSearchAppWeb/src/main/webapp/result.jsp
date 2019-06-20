
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:choose>
  <c:when test="${!empty empList}">
     <table  border="1">
      <tr><th>Empno</th><th>EmpName</th><th>JOB</th><th>SAL</th></tr>
     <c:forEach var="m" items="${empList}">
        <tr>
         <td>${m.EMPNO}</td>
         <td>${m.ENAME}</td>
         <td>${m.JOB}</td>
         <td>${m.SAL}</td>
        </tr>
     </c:forEach>
     </table>
  </c:when>
  <c:otherwise>
    <h1> Records  not found</h1>
  </c:otherwise>
</c:choose>

<a href="search.html">home</a>



