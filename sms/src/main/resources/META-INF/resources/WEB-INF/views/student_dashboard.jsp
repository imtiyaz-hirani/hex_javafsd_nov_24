<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <html>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<body >
	       <div class="container-fluid" style="margin: 0%; padding: 0px;">
	           <div class="row">
	               <div class="col-lg-12">
					<%@ include file="navbar.jsp" %>	
	               </div>
	           </div>
	           <div class="row">
	               <div class="col-sm-2">sidebar goes here...</div>
	               <div class="col-md-10  mt-4">
	                   <div class="row mb-4 ">
	                       <div class="col-sm-4">
	                           <div class="card" >
	                               <div class="card-body">
	                                 <h5 class="card-title">Card title</h5>
	                                 <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
	                                 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	                                 <a href="#" class="card-link">Card link</a>
	                                 <a href="#" class="card-link">Another link</a>
	                               </div>
	                             </div>
	                       </div>
	                       <div class="col-sm-4">
	                           <div class="card" >
	                               <div class="card-body">
	                                 <h5 class="card-title">Card title</h5>
	                                 <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
	                                 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	                                 <a href="#" class="card-link">Card link</a>
	                                 <a href="#" class="card-link">Another link</a>
	                               </div>
	                             </div>
	                       </div>
	                       <div class="col-sm-4">
	                           <div class="card" >
	                               <div class="card-body">
	                                 <h5 class="card-title">Card title</h5>
	                                 <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
	                                 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	                                 <a href="#" class="card-link">Card link</a>
	                                 <a href="#" class="card-link">Another link</a>
	                               </div>
	                             </div>
	                       </div>
	                   </div>
	                    
	                   <div class="row">
	                       <div class="col-sm-4">
	                           <div class="form-floating mb-3">
	                               <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
	                               <label for="floatingInput">Email address</label>
	                             </div>
	                             <div class="form-floating">
	                               <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
	                               <label for="floatingPassword">Password</label>
	                             </div>
	                       </div>
	                       <div class="col-sm-8">
	                           <table class="table">
	                               <thead>
	                                 <tr>
	                                   <th scope="col">#</th>
	                                   <th scope="col">First</th>
	                                   <th scope="col">Last</th>
	                                   <th scope="col">Handle</th>
	                                 </tr>
	                               </thead>
	                               <tbody>
	                                 <tr>
	                                   <th scope="row">1</th>
	                                   <td>Mark</td>
	                                   <td>Otto</td>
	                                   <td>@mdo</td>
	                                 </tr>
	                                 <tr>
	                                   <th scope="row">2</th>
	                                   <td>Jacob</td>
	                                   <td>Thornton</td>
	                                   <td>@fat</td>
	                                 </tr>
	                                 <tr>
	                                   <th scope="row">3</th>
	                                   <td colspan="2">Larry the Bird</td>
	                                   <td>@twitter</td>
	                                 </tr>
	                               </tbody>
	                             </table>
	                       </div>
	                   </div>
	               </div>
	           </div>
	       </div>
	   </body>
</html>	