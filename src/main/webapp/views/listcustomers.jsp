<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title>Chennai Audit</title>

<!-- Custom Stylesheet -->
    <link href="/plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/loading.css" rel="stylesheet"> 

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="/plugins/common/common.min.js"></script>
    <script src="/js/custom.min.js"></script>
    <script src="/js/settings.js"></script>
    <script src="/js/gleek.js"></script>
    <script src="/js/styleSwitcher.js"></script>

    
    <script src="/plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
    <!-- <script src="/plugins/tables/js/datatable-init/datatable-basic.min.js"></script> -->
    
    <script src="/js/main.js"></script>
  
<script type="text/javascript" language="javascript" src="/js/customer/jquery.js"></script>
<script type="text/javascript" language="javascript" src="/js/customer/jquery.dataTables.js"></script>
<script src="/js/customer/pagination.js"></script>
<script src="/js/customer/common.js"></script>
<script src="/js/customer/listcustomers.js"></script>
 <script src="/js/main.js"></script>
<script type="text/javascript">	
		$(document).ready(function() {
				var oTable = $('#example').dataTable( {
					"aaSorting": [],
					"bPaginate": false,
					"bFilter": false,
					"sScrollX": "100%",
			        "sScrollXInner": "100%"				
				} );		
		} );		
</script>
<style type="">
input[type=submit],
a.submit{
	background:#ddd;
	background:-moz-linear-gradient(90deg, #0459b7, #08adff); /* Firefox */
	background:-webkit-gradient(linear, left top, left bottom, from(#08adff), to(#0459b7)); /* Webkit */
	border:1px solid #093c75;
	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	-moz-box-shadow:0 1px 0 #fff;
	-webkit-box-shadow:0 1px 0 #fff;
	color:#fff;
	cursor:pointer;
	font-family:Arial,sans-serif;
	font-size:12px;
	font-weight:bold;
	margin-left:120px;
	padding:1px 10px;
	text-decoration:none;
	text-shadow:0 1px 1px #333;
	text-transform:uppercase;
}
input[type=submit]:hover,
a.submit:hover{
	background:#eee;
	background:-moz-linear-gradient(90deg, #067cd3, #0bcdff);
	background:-webkit-gradient(linear, left top, left bottom, from(#0bcdff), to(#067cd3));
	border-color:#093c75;
	text-decoration:none;
}
input[type=submit]:active,
input[type=submit]:focus,
a.submit:active,
a.submit:focus{
	background:#ccc;
	background:-moz-linear-gradient(90deg, #0bcdff, #067cd3);
	background:-webkit-gradient(linear, left top, left bottom, from(#067cd3), to(#0bcdff));
	border-color:#093c75;
	outline:none;
}

</style>
</head>			
<body id="dt_example" onload="getRecords('-1',10)">
<input type="hidden" id="userType" value="<%=(String)session.getAttribute("userType") %>">
<input type="hidden" id="role" value="<%=(String)session.getAttribute("role") %>">
<input type="hidden" id="consultantId" value="<%=(String)session.getAttribute("staffId") %>">
<center>
<div style="padding-top: 25px;">
<div style="width: 96%;padding-bottom: 10px;">
	<span style="color: #1F3D71;float: left; font: 16px Arial,Helvetica,sans-serif; font-weight:bold;height: 0px; height: 0; padding: 0 5px;">Clients List
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<select id="currentstatus" onchange="getRecords('-1',10)">	
		<option value="1" selected="selected">Active Clients Only</option>
		<option value="2" >DeActivated Clients Only</option>
	</select>&nbsp;&nbsp;
	<select id="logedInClientId" onchange="getRecords('-1',10)">
	</select>&nbsp;&nbsp;</span><span style="float: right;">
	<input type="text" id="allSearch" placeholder="Search in all columns..." size="25" onkeyup="submitSearch(event)"/>
	</span>
	<div align="right" style="width: 55%;"><a class="submit" href="../../jsp/customer/createcustomer.jsp" id="add" >Add New</a></div>
</div>		



<div id="container1">

<div id="demo1">

<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
	<thead>
		<tr>
			<th width="15%" align="left">Client Name</th>
			<th width="17%" align="left">Company Name</th>
			<th width="40%" align="left">Address</th>
			<th width="10%" align="left">Mobile No1</th>
			<th width="10%" align="left">Mobile No2</th>
			<th width="8%" align="right">Action</th>
		</tr>
	</thead>
	<tbody id="scores">
	</tbody>
</table>
</div><input type="hidden" id="total" value="16"/>
</div>
</div>
<div class="navBar" id="pg" >
</div>
</div>
</center>
<script type="text/javascript">
listAllClientsNames();
</script>
</body>
</html>
