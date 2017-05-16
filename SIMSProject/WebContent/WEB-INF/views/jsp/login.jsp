<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en"><head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="CoreUI Bootstrap 4 Admin Template">
        <meta name="author" content="Lukasz Holeczek">
        <meta name="keyword" content="CoreUI Bootstrap 4 Admin Template">
        <!-- <link rel="shortcut icon" href="assets/ico/favicon.png"> -->
        <title>CoreUI Bootstrap 4 Admin Template</title>
        <!-- Icons -->
        <link href="resources/css/font-awesome.min.css" rel="stylesheet">
        <link href="resources/css/simple-line-icons.css" rel="stylesheet">
        <!-- Main styles for this application -->
        <link href="resources/css/style.css" rel="stylesheet">
    </head>
    <body class="">
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-x-auto pull-xs-none vamiddle" style="margin-top: 154.5px;">
                    <div class="card-group ">
                        <div class="card p-a-2">
                            <div class="card-block">
                                <h1>Login</h1>
                                <p class="text-muted">Sign In to your account</p>
                                <div class="input-group m-b-1">
                                    <span class="input-group-addon"><i class="icon-user"></i></span>
                                    <input type="text" class="form-control" placeholder="Username">
                                </div>
                                <div class="input-group m-b-2">
                                    <span class="input-group-addon"><i class="icon-lock"></i></span>
                                    <input type="password" class="form-control" placeholder="Password">
                                </div>
                                <div class="row">
                                    <div class="col-xs-6">
                                        <button type="button" class="btn btn-primary p-x-2">Login</button>
                                    </div>
                                    <div class="col-xs-6 text-xs-right">
                                        <button type="button" class="btn btn-link p-x-0">Forgot password?</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card card-inverse card-primary p-y-3" style="width:44%">
                            <div class="card-block text-xs-center">
                                <div>
                                    <h2>Sign up</h2>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                    <button type="button" class="btn btn-primary active m-t-1">Register Now!</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap and necessary plugins -->
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/tether.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script>
        function verticalAlignMiddle()
        {
            var bodyHeight = $(window).height();
            var formHeight = $('.vamiddle').height();
            var marginTop = (bodyHeight / 2) - (formHeight / 2);
            if (marginTop > 0)
            {
                $('.vamiddle').css('margin-top', marginTop);
            }
        }
        $(document).ready(function()
        {
            verticalAlignMiddle();
        });
        $(window).bind('resize', verticalAlignMiddle);
        </script>
    
</body></html>