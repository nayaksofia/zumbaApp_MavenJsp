<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Add Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>User Login</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header text-center">
						<h3>User Login</h3>
					</div>
					<div class="card-body">


						<form action="userLoginController.jsp" method="post">
							<div class="form-group">
								<label for="txtEmail"><b>Enter Your Email:</b></label> <input
									type="text" class="form-control" name="txtEmail" id="txtEmail"
									placeholder="e.g. john@example.com" required>
							</div>
							<div class="form-group">
								<label for="txtPassword"><b>Enter Your Password:</b></label> <input
									type="password" class="form-control" name="txtPassword"
									id="txtPassword" placeholder=""  required>
							</div>
							<input type="hidden" value="login" name="txtType">
							<button type="submit" class="btn btn-primary btn-block">LOGIN</button>
						</form>

					</div>

					<div class="card-footer text-center">
						<a href="index.html" class="text-primary">Admin ? Login Here.</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>