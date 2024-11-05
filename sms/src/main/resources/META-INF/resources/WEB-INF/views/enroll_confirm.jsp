<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*" %>	
<html>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<body background="grey">
	<div class="container">
        <div class="row">
            <div class="col-lg-12">
                <%@ include file="navbar.jsp" %>	
            </div>

        </div>
        <div class="row mt-4">
            <div class="col.lg-12">
                <div class="p-5 mb-4 bg-light rounded-3">
                    <div class="container-fluid py-5">
                      <h1 class="display-5 fw-bold">Course Enrollment Confirmation</h1>
                      <p class="col-md-8 fs-4">
                        Dear <%=session.getAttribute("username") %>, <br>
                        Thank you for enrolling in course: <%=request.getAttribute("cname") %>
                        <br>
                        Your enrollment will be active for next 1 year till <%=LocalDate.now().plusYears(1) %>
                      </p>
                      <a href="<%=request.getContextPath() %>/student-dashboard"> <button class="btn btn-primary btn-lg"   type="button">Go to Dashboard</button></a>
                    </div>
                  </div>
            </div>
        </div>
    </div>
</body>
</html>