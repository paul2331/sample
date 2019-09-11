		function getRecords(page,itemsPerPage){
			/*var firstTime = false;
			if(page<1){
				firstTime = true;
				page=1;
			}
			//var noodrecords = 5;
			
			var noodrecords = itemsPerPage;
			var index = (page-1)*noodrecords;
			logedInClientId = document.getElementById("logedInClientId").value;
			if(logedInClientId==null||logedInClientId==""||logedInClientId=="null"){
				logedInClientId = "0";
			}
			currentstatus = document.getElementById("currentstatus").value;
			if(currentstatus==null||currentstatus==""||currentstatus=="null"){
				logedInClientId = "1";
			}
			if(document.getElementById("userType").value=='2'){				
				document.getElementById("logedInClientId").value = document.getElementById("consultantId").value;
				document.getElementById("logedInClientId").disabled=true;
				logedInClientId = document.getElementById("consultantId").value;
			}
			urlx = "/chennaiaudit/rest/addressbookservice/listMatchedAddresses/"+index+"/"+noodrecords+"/"+currentstatus+"/"+logedInClientId+"?";
			urlx+="allColumnSearch="+document.getElementById("allSearch").value;*/
			document.getElementById("total").value = "42";
			$.ajax({
			        type : 'GET',
			        url : cabaseurl+'/listCustomers?iDisplayStart=0&iDisplayLength=10&iSortCol_0=0&sSortDir_0=asc&sSearch=&sEcho=1&sColumns=1',
			        contentType:"application/json; charset=utf-8",	        
			        success : function(response)
			        {	        	
			        	navicate(-1,"",10,10);          
						removeAll();
				       $.each(response.data, function(i,dish){ 
				    	   var clientname = '<a href="../../jsp/work/listworks.jsp?customerId='+dish.sino+'&customerName='+dish.name+'&companyName='+dish.companyname+'" alt="Edit">'+dish.name+'</a>';
				       		
				       		$('#example').dataTable().fnAddData( [
																clientname+"",
																dish.companyname+"",
																dish.address+"",
																dish.phno+"",
																dish.phno2+"",
																"" ] );       			             
				        });
			        },
			        error : function()
			        {	     
		                // $('#').fadeOut();      
			            alert('Error. . .');
			        }
			    });

			
		}
		function listAllClientsNames(){
			jQuery.ajax({
				    cache: false,
				    url:  cabaseurl+'/listAllConsultants',
				    type: "GET",
				    success: function(json) {
				    	var e = document.getElementById('logedInClientId');
				    	e.options[0] = new Option('All Consultant', '0');
				    	var d = 1; 		        			  					  				
				    	$.each(json, function(i,dish){
				    		e.options[d] = new Option(dish.name, dish.id);
				    		d++;				    					    		
				    	});
				    	/*if(document.getElementById("userType").value=='2'){
							document.getElementById("logedInClientId").value = document.getElementById("consultantId").value;
							document.getElementById("logedInClientId").disabled=true;
						}*/
				     } ,
				    error: function(e){
				    }
				});	
		}
		function submitSearch(event){
			//if( event.keyCode == 13 ){
				getRecords('-1',10)
			//}
		}
		function deleteRecord(id,indx) {
			// get field to be validated
			Demo.prompt("/chennaiaudit/rest/addressbookservice/updateByIdAndStatus/",id,indx);
		}