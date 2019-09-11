
<!DOCTYPE html>
<html class="h-100" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Chennai Audit</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../../assets/images/favicon.png">
    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous"> -->
    <link href="css/style.css" rel="stylesheet">

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>
    
     <%-- chennaiaudit designn start --%>
        <script src="js/main.js"></script>
        <script src="js/login.js"></script>
     <%-- chennaiaudit design end --%>

</head>

<body class="h-100">
    
    <!--*******************
        Preloader start
    ********************-->
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->

    



    <div class="login-form-bg h-100">
        <div class="container h-100">
            <div class="row justify-content-center h-100">
                <div class="col-xl-6">
                    <div class="form-input-content">
                        <div class="card login-form mb-0">
                            <div class="card-body pt-5">
                                <div style="border-bottom:1px solid #8898aa;padding-bottom:5px;float:left;width:100%">
								<a class="" href="#"> <h4>Chennai Audit Login Page</h4></a> 
								</div>       
                                <div class="mt-5 mb-5 login-input">
                                <%-- <form class="mt-5 mb-5 login-input"> --%>
                                    <div class="form-group">
                                        <input type="email" id="username" class="form-control" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" id="password" class="form-control" placeholder="Password">
                                    </div>									
                                    <button class="btn login-form__btn submit w-100" id='signin' onclick='login()'>Sign In</button>
                                </div>
                                <%-- </form> --%>
								<h5 class="mt-4" style="color:red" id='errmsg' ><i class="fa fa-thumbs-down text-danger"></i> Invalid username/password</h5>
                                <p class="mt-5 login-form__footer"> <a href="index.html" style="float:right" class="text-primary">Forget Password</a> </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

    <script>
        $(document).ready(function() {
            $('#errmsg').hide();
        })

        // $('#signin').click(function()
        // {
        //     var user = $('#username').val();
        //     var pass = $('#password').val();
        //     alert("Hi");
        //     var details = {'emailId':user,'password':pass};
        //     details = JSON.stringify(details);
        //     console.log('Information : '+details);
        //     $.ajax({
        //         type : 'POST',
        //         url : cabaseurl+'/login',
        //         contentType:"application/json; charset=utf-8",
        //         data : details,
        //         success : function(response)
        //         {
        //             alert(response+"--********8"+response.status+"--"+user+"=="+response.emailId);
        //             if(response.emailId == user)
        //             {
        //                 $.session.set("userDetails",response);
        //                 alert("Success----------"+cabaseurl+'/index.jsp');
        //                 window.location.href=cabaseurl+'/index.jsp';
        //             }
        //             else
        //             {
        //                 $('#errmsg').show();
        //             }
        //             $.session.set("userdetail",response);
                    
        //         },
        //         error : function()
        //         {
        //              $('#errmsg').show();
        //             alert('Error. . .');
        //         }
        //     })
        // });

    </script>

    
    
</body>
</html>





