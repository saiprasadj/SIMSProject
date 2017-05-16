<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>
	FROM ACCOUNT MASTER

	<div class="container-fluid">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-sm-6">
					<div class="card">
						<div class="card-header">
							<strong>Credit Card</strong> <small>Form</small>
						</div>
						<div class="card-block">
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="name">Name</label> <input type="text"
											class="form-control" id="name" placeholder="Enter your name">
									</div>
								</div>
							</div>
							<!--/row-->
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group">
										<label for="ccnumber">Credit Card Number</label> <input
											type="text" class="form-control" id="ccnumber"
											placeholder="0000 0000 0000 0000">
									</div>
								</div>
							</div>
							<!--/row-->
							<div class="row">
								<div class="form-group col-sm-4">
									<label for="ccmonth">Month</label> <select class="form-control"
										id="ccmonth">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
										<option>9</option>
										<option>10</option>
										<option>11</option>
										<option>12</option>
									</select>
								</div>
								<div class="form-group col-sm-4">
									<label for="ccyear">Year</label> <select class="form-control"
										id="ccyear">
										<option>2014</option>
										<option>2015</option>
										<option>2016</option>
										<option>2017</option>
										<option>2018</option>
										<option>2019</option>
										<option>2020</option>
										<option>2021</option>
										<option>2022</option>
										<option>2023</option>
										<option>2024</option>
										<option>2025</option>
									</select>
								</div>
								<div class="col-sm-4">
									<div class="form-group">
										<label for="cvv">CVV/CVC</label> <input type="text"
											class="form-control" id="cvv" placeholder="123">
									</div>
								</div>
							</div>
							<!--/row-->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<a href="account/showaccountmaster" id="accountmaster">Account
		Master</a>
	<a href="department/showdepartmentmaster" id="departmentmaster">Department
		Master</a>
</body>
</html>