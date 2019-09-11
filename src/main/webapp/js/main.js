
var cabaseurl = 'http://localhost:8080';
var pageurl = '';

function pageredirect(url)
{
    $('#contentPage').attr('src',url);
}

function sendMail(sub, to, msg){
	mailRequest = {}
	mailRequest["subject"] = sub;
	mailRequest["recipients"] = to;
	mailRequest["message"] = msg;    

	mailRequest = JSON.stringify(mailRequest);  
	jQuery.ajax({
		type : 'POST',
        url : cabaseurl+'/sendMail',
	    contentType:"application/json; charset=utf-8",
        data : mailRequest,	        
        success : function(response)
        {	        	
        	alert("Successfully sent.");        	
		},
        error : function(e)
        {	     
        	console.log(e);
            alert('Error. . .');
        }
    });
}

