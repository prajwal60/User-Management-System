<%-- 
    Document   : homepage
    Created on : Apr 28, 2020, 3:36:52 PM
    Author     : Prajwal Ghimire
--%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Forgot Password</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">     
            <div class="col-lg-6 d-none d-lg-block ">
                
                <div class="p-5 text-center">
                <div class="text-center">
                    <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-2">Enter New Password</h1>
                    
                    <form method="POST" action="Examp" class="user">
                    
                                      <div class="form-group">
                        <input type="password" class="form-control form-control-user fa fa-eye" name="newPassword" id="exampleInputEmail"  placeholder="Enter New Password..."><span class="btn-show-pass">
							
						</span>
                    </div> 
                                       <div class="form-group">
                        <input type="password" class="form-control form-control-user fa fa-eye" name="confirmPassword" id="exampleInputEmail"  placeholder="Enter confirm Password..." >
                        <span class="btn-show-pass">
                           
						</span>
                    </div>  
                           <input type="submit" name="forgetPassword"  class="btn btn-primary btn-user btn-block" value="Reset Password"/>
                           <span class="focus-input100"></span>
                    </form>
                    </div>
                   </div>
                </div>
              </div>
               </div>
            </div>
                    
          </div>
                    
        </div>
              
      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>


</body>

</html>

