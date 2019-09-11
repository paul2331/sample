<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Chennai Audit</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <!-- Pignose Calender -->
    <link href="./plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <!-- Chartist -->
    <link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
    <link rel="stylesheet" href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
    <!-- Custom Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
<script>
function ajaxFunction(url,id){	
	document.getElementById('contentPage').src = url;    
    document.getElementById('homeLi').style ="";
    document.getElementById('clientsLi').style ="";
    document.getElementById('addNewLi').style ="";
    document.getElementById('emailLi').style ="";
    document.getElementById('staffsLi').style ="";
    document.getElementById('servicesLi').style ="";
    document.getElementById('ecsLi').style="";
    document.getElementById('stickyLi').style="";
    document.getElementById('reportsLi').style="";
    document.getElementById('contactUsLi').style="";
    /*document.getElementById(id).style ="background: #ddfdff;";*/
    document.getElementById(id).style ="background: aqua;";
}
</script>
</head>
    
<style>
    body {
        height: 450px;
    }
</style>

<body>

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

    
    <!--**********************************
        Main wrapper start
    ***********************************-->
    <div id="main-wrapper">

        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <div class="brand-logo">
                <a href="index.html">
                    <b class="logo-abbr">
                    <i class="   "><font style="font-family: 'Courier New', Courier, monospace" color="white">CA</font></i>    
                    </b>
                    <span class="logo-compact"><img src="./images/logo-compact.png" alt=""></span>
                    <span class="brand-title">
                        <img src="images/logo-text.png" alt="">
                    </span>
                </a>
            </div>
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->
        <div class="header">    
            <div class="header-content clearfix">
                
                <div class="nav-control">
                    <div class="hamburger">
                        <span class="toggle-icon"><i class="icon-menu"></i></span>
                    </div>
                </div>
                <div class="header-left">
                        <img src="./images/logo.jpg" width="90px" height="60px" /> 
                </div>
                <div class="header-right">
                    <ul class="clearfix">
                            <li id="welcomeUser" class="icons dropdown" style="padding-top: 5px;"></li>
                        <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                <i class="mdi mdi-email-outline"></i>
                                <span class="badge badge-pill gradient-1">3</span>
                            </a>
                            <div class="drop-down animated fadeIn dropdown-menu">
                                <div class="dropdown-content-heading d-flex justify-content-between">
                                    <span class="">3 New Messages</span>  
                                    <a href="javascript:void()" class="d-inline-block">
                                        <span class="badge badge-pill gradient-1">3</span>
                                    </a>
                                </div>
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li class="notification-unread">
                                            <a href="javascript:void()">
                                                <img class="float-left mr-3 avatar-img" src="images/avatar/1.jpg" alt="">
                                                <div class="notification-content">
                                                    <div class="notification-heading">Saiful Islam</div>
                                                    <div class="notification-timestamp">08 Hours ago</div>
                                                    <div class="notification-text">Hi Teddy, Just wanted to let you ...</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="notification-unread">
                                            <a href="javascript:void()">
                                                <img class="float-left mr-3 avatar-img" src="images/avatar/2.jpg" alt="">
                                                <div class="notification-content">
                                                    <div class="notification-heading">Adam Smith</div>
                                                    <div class="notification-timestamp">08 Hours ago</div>
                                                    <div class="notification-text">Can you do me a favour?</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <img class="float-left mr-3 avatar-img" src="images/avatar/3.jpg" alt="">
                                                <div class="notification-content">
                                                    <div class="notification-heading">Barak Obama</div>
                                                    <div class="notification-timestamp">08 Hours ago</div>
                                                    <div class="notification-text">Hi Teddy, Just wanted to let you ...</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <img class="float-left mr-3 avatar-img" src="images/avatar/4.jpg" alt="">
                                                <div class="notification-content">
                                                    <div class="notification-heading">Hilari Clinton</div>
                                                    <div class="notification-timestamp">08 Hours ago</div>
                                                    <div class="notification-text">Hello</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    
                                </div>
                            </div>
                        </li>
                        <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                <i class="mdi mdi-bell-outline"></i>
                                <span class="badge badge-pill gradient-2">3</span>
                            </a>
                            <div class="drop-down animated fadeIn dropdown-menu dropdown-notfication">
                                <div class="dropdown-content-heading d-flex justify-content-between">
                                    <span class="">2 New Notifications</span>  
                                    <a href="javascript:void()" class="d-inline-block">
                                        <span class="badge badge-pill gradient-2">5</span>
                                    </a>
                                </div>
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li>
                                            <a href="javascript:void()">
                                                <span class="mr-3 avatar-icon bg-success-lighten-2"><i class="icon-present"></i></span>
                                                <div class="notification-content">
                                                    <h6 class="notification-heading">Events near you</h6>
                                                    <span class="notification-text">Within next 5 days</span> 
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <span class="mr-3 avatar-icon bg-danger-lighten-2"><i class="icon-present"></i></span>
                                                <div class="notification-content">
                                                    <h6 class="notification-heading">Event Started</h6>
                                                    <span class="notification-text">One hour ago</span> 
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <span class="mr-3 avatar-icon bg-success-lighten-2"><i class="icon-present"></i></span>
                                                <div class="notification-content">
                                                    <h6 class="notification-heading">Event Ended Successfully</h6>
                                                    <span class="notification-text">One hour ago</span>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <span class="mr-3 avatar-icon bg-danger-lighten-2"><i class="icon-present"></i></span>
                                                <div class="notification-content">
                                                    <h6 class="notification-heading">Events to Join</h6>
                                                    <span class="notification-text">After two days</span> 
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    
                                </div>
                            </div>
                        </li>
                        <li class="icons dropdown d-none d-md-flex">
                            <a href="javascript:void(0)" class="log-user"  data-toggle="dropdown">
                                <span>English</span>  <i class="fa fa-angle-down f-s-14" aria-hidden="true"></i>
                            </a>
                            <div class="drop-down dropdown-language animated fadeIn  dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li><a href="javascript:void()">English</a></li>
                                        <li><a href="javascript:void()">Dutch</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li class="icons dropdown">
                            <div class="user-img c-pointer position-relative"   data-toggle="dropdown">
                                <span class="activity active"></span>
                                <img src="images/user/11.jpg" height="40" width="40" alt="">
                            </div>
                            <div class="drop-down dropdown-profile animated fadeIn dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li>
                                            <a href="app-profile.html"><i class="icon-user"></i> <span>Profile</span></a>
                                        </li>
                                       
                                        
                                        <hr class="my-2">
                                        <li>
                                            <a href="page-lock.html"><i class="icon-lock"></i> <span>Change Password</span></a>
                                        </li>
                                        <li><a href="#" onclick="logout()"><i class="icon-key"></i> <span>LogOut</span></a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        <div class="nk-sidebar">           
            <div class="nk-nav-scroll">`
                <ul class="metismenu" id="menu">
                    <li class="nav-label"  >Home</li>
                        <li id="homeLi" style ="background: aqua;" >
                                <a class="has-arrow" onclick="ajaxFunction('./table-datatable.html','homeLi')" href="#" aria-expanded="false">
                                    <i class="fa fa-home fa-6x" aria-hidden="true"></i><span class="nav-text" style="color:red">Home</span>
                                </a>
                        </li>
                    
                    <li >
                        <a id="clientsLi" class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="fa fa-users" aria-hidden="true"></i><span class="nav-text" style="color:red">Clients</span>
                        </a>
                        <ul aria-expanded="false" class="colorparentsidemenu">                            
                            <li><a onclick="ajaxFunction('./views/listcustomer.html','clientsLi')" href="#">Customers</a></li>
                            <li><a onclick="ajaxFunction('./views/listconsultant.html','clientsLi')" href="#">Consultants</a></li>
                        </ul>
                    </li>
                    <li >
                            <a id="addNewLi" class="has-arrow" href="javascript:void()" aria-expanded="false">
                                <i class="fa fa-plus-square" aria-hidden="true"></i><span class="nav-text" style="color:red">Add New</span>
                            </a>
                            <ul aria-expanded="false" class="colorparentsidemenu">
                                <li><a onclick="ajaxFunction('./views/new-customer.html','addNewLi')" href="#">Customer</a></li>
                                <li><a onclick="ajaxFunction('./views/new-consultant.html','addNewLi')" href="#">Consultant</a></li>
                                <li><a onclick="ajaxFunction('./views/new-staff.html','addNewLi')" href="#">Staff</a></li>
                                <li><a onclick="ajaxFunction('./views/new-service.html','addNewLi')" href="#">Service</a></li>
                                <li><a onclick="ajaxFunction('./views/new-timesheet.html','addNewLi')" href="#">Timesheet</a></li>
                            </ul>
                        </li>
                    <li class="nav-label">Email</li>
                    <li >
                        <a id="emailLi" class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="fa fa-envelope" aria-hidden="true"></i><span class="nav-text" style="color:red">Email</span>
                        </a>
                        <ul aria-expanded="false" class="colorparentsidemenu">
                            <li><a onclick="ajaxFunction('./table-datatable.html','emailLi')" href="#">Inbox</a></li>
                            <li><a href="./email-read.html">Read</a></li>
                            <li><a href="./email-compose.html">Compose</a></li>
                        </ul>
                    </li>                    
                    <li >
                        <a id="staffsLi" class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="fa fa-address-card" aria-hidden="true"></i> <span class="nav-text" style="color:red">Staffs</span>
                        </a>
                        <ul aria-expanded="false" class="colorparentsidemenu">
                            <li><a onclick="ajaxFunction('./views/staff.html','staffsLi')" href="#" >Staff List</a></li>
                            <li><a onclick="ajaxFunction('./views/listconsultant.html','staffsLi')" href="#" >Timesheet</a></li>                            
                        </ul>
                    </li>
                    <!-- <li class="nav-label">UI Components</li> -->
                    <li id = "servicesLi" >
                        <a class="has-arrow" onclick="ajaxFunction('./table-datatable.html','servicesLi')" href="#" aria-expanded="false">
                            <i class="fa fa-suitcase" aria-hidden="true"></i><span class="nav-text" style="color:red">Services</span>
                        </a>
                    </li>
                    <li id="ecsLi" >
                        <a class="has-arrow" onclick="ajaxFunction('./table-datatable.html','ecsLi')" href="#" aria-expanded="false">
                            <i class="fa fa-inr" aria-hidden="true"></i><span class="nav-text" style="color:red">ECS</span>
                        </a>
                    </li>
                    <li class="nav-label">Forms</li>
                    <li >
                        <a id="stickyLi" class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="fa fa-sticky-note" aria-hidden="true"></i><span class="nav-text" style="color:red">Sticky Note</span>
                        </a>
                        <ul aria-expanded="false" class="colorparentsidemenu">
                            <li><a onclick="ajaxFunction('./table-datatable.html','stickyLi')" href="#">Follow Up Note</a></li>
                            <li><a href="./form-basic.html">Visitors Note</a></li>                            
                        </ul>
                    </li>
                    <!-- <li class="nav-label">Table</li> -->
                    <li id="reportsLi" >
                        <a onclick="ajaxFunction('./table-datatable.html','reportsLi')" href="#" aria-expanded="false">
                            <i class="fa fa-bar-chart" aria-hidden="true"></i><span class="nav-text" style="color:red">Reports</span>
                        </a>
                    </li>
                    <!-- <li class="nav-label">Pages</li> -->
                    <li id="contactUsLi" >
                        <a onclick="ajaxFunction('./table-datatable.html','contactUsLi')" href="#" aria-expanded="false">
                            <i class="fa fa-phone-square"></i><span class="nav-text" style="color:red">Contact Us</span>
                        </a>
                        
                    </li>
                </ul>
            </div>
        </div>
        <!--**********************************
            Sidebar end
        ***********************************-->
		
		<!--**********************************
            Content body start
        ***********************************-->
		<div class="">
			<iframe id="contentPage"  background="red" frameborder="0" width="95%" height="580px;"
	        style=" margin-top: 62px; margin-left: 60px" src="dashboard.html" ></iframe>
		</div>
		<!--**********************************
            Content body end
        ***********************************-->
        
        
        <!--**********************************
            Footer start
        ***********************************-->
       <!--  <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018</p>
            </div>
        </div> -->
        <!--**********************************
            Footer end
        ***********************************-->
    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>
    <script src="js/main.js"></script>

    <!-- Chartjs -->
    <script src="./plugins/chart.js/Chart.bundle.min.js"></script>
    <!-- Circle progress -->
    <script src="./plugins/circle-progress/circle-progress.min.js"></script>
    <!-- Datamap -->
    <script src="./plugins/d3v3/index.js"></script>
    <script src="./plugins/topojson/topojson.min.js"></script>
    <script src="./plugins/datamaps/datamaps.world.min.js"></script>
    <!-- Morrisjs -->
    <script src="./plugins/raphael/raphael.min.js"></script>
    <script src="./plugins/morris/morris.min.js"></script>
    <!-- Pignose Calender -->
    <script src="./plugins/moment/moment.min.js"></script>
    <script src="./plugins/pg-calendar/js/pignose.calendar.min.js"></script>
    <!-- ChartistJS -->
    <script src="./plugins/chartist/js/chartist.min.js"></script>
    <script src="./plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>



    <script src="./js/dashboard/dashboard-1.js"></script>

    <script>
    function logout(){
    	sessionStorage.setItem('userdetails',null);
    	window.location.replace(cabaseurl+'/login.jsp');
    }
        $(document).ready(function(){            
            // var name = $session.get("userDetails").name;
            var name = sessionStorage.getItem('userdetails');
            name = JSON.parse(name);            
            $("#welcomeUser").text('Welcome '+name.name);
        });

        function colorparentsidemenu()
        {
            this.child.hover(function(){
                this.css('background-color:bg-info');
            });
        }

    </script>

</body>

</html>