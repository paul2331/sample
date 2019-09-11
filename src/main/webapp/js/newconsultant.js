
var validateEmail = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
var saveEnbl = true;

function savedata(){

    var r = '';
    var arr = [];
    r = {}
    r["id"] = $('#id').val();
    r["name"] = $('#consultantname').val();
    r["companyname"] = $('#companyname').val();
    r["emailId"] = $('#email').val();
    r["password"] = $('#password').val();
    r["phoneNo"] = $('#phone1').val();
    r["phoneNo1"] = $('#phone2').val();
    r["address"] = $('#address').val();

    console.log("JSON Value : "+r);
    arr.push(r);
    console.log('Array forming : '+arr);

    r = JSON.stringify(r);  
    arr = JSON.stringify(arr);
    console.log('After stringify r : '+r);
    console.log('After stringify Arr : '+arr);


    $.ajax({
        type : 'POST',
        url : cabaseurl+'/saveConsultant',
	    contentType:"application/json; charset=utf-8",
        data : r,
        success : function(){
            alert('Succesfully data has been saved. . .');
            window.location.href = 'listconsultant.html';
        },
        error : function()
        {
            alert("Data hasn't Save please try again. . .");
        }

    })
}

$('#consultantname').on({
    blur : function(){
        var consultant = $(this).val();
        var company = $('#companyname').val();
        var mobi1 = $('#phone1').val();
        var mobi2 = $('#phone2').val();

            if(consultant == '')
            {
                $(this).addClass('border-danger');
                $('#namemsg').css({'display':'block'});
            }
            else
            {
                $('#namemsg').css({'display':'none'});
                $('#consultantname').removeClass('border-danger'); 
            }
            saveButtonEnable();

            if(consultant != '' && company != '' && mobi1 != '' || mobi2 != '' ){
                dataExistDB();
            }
    }
});

$(document).on('blur','#companyname',function(){
    if($(this).val() == '')
    {
        $(this).addClass('border-danger');
        $('#companymsg').css({'display':'block'});
    }
    else
    {
        $('#companymsg').css({'display':'none'});
        $('#companyname').removeClass('border-danger'); 
    }
    saveButtonEnable();
});

$(document).on('blur','#email',function(){
    if(!$(this).val() == '' && validateEmail.test($(this).val())){
        $('#emailmsg').css({'display':'none'});
        $('#email').removeClass('border-danger');
        saveEnbl = false; 
    }
    else
    {
        $(this).addClass('border-danger');
        $('#emailmsg').css({'display':'block'});
        $('#emailmsg').text('Invalid E-mail . . .');
        saveEnbl = true;
    }
    saveButtonEnable();
});

$(document).on('blur','#password',function(){
    if($(this).val() == '')
    {
        $(this).addClass('border-danger');
        $('#passmsg').css({'display':'block'});
    }
    else
    {
        $('#passmsg').css({'display':'none'});
        $('#password').removeClass('border-danger'); 
    }
    saveButtonEnable();
});

$(document).on('blur','#phone1',function(){
    if($(this).val() == '')
    {
        $(this).addClass('border-danger');
        $('#phonemsg').css({'display':'block'});
    }
    else
    {
        $('#phonemsg').css({'display':'none'});
        $('#phone1').removeClass('border-danger'); 
    }
   
    saveButtonEnable();
});

function dataExistDB(consultant,company,mobi1,mobi2){
    var datacheck = {'consultant':consultant,'company':company,'mobi1':mobi1,'mobi2':mobi2};
}

// End On Blur Validation of Mandatory Field


function saveButtonEnable(){
    var flag = true;
    $('.mndry').each(function(){
        if($(this).val() == '')
        {
            flag = false;
        }
    });
    if(flag){
        $('#save').removeAttr('disabled');
    }
    else
    {
        $('#save').attr('disabled','disabled');
    }
    if(saveEnbl)
    {
        $('#save').attr('disabled','disabled');
    }
    checkSimilarConsultant();
}
function checkSimilarConsultant(){    		
	var namemsg = $('#namemsg').val();
	var companymsg = $('#companymsg').val();
	var email = $('#email').val();
	var phone1 = $('#phone1').val();
	var phone2 = $('#phone2').val();
	
	$.ajax({
        type : 'GET',
        url : cabaseurl+'/listSimilarConsultant?name='+namemsg+'&companyname='+companymsg+'&email='+email+'&phoneNo='+phone1+'&phoneNo1='+phone2,
        contentType:"application/json; charset=utf-8",	        
        success : function(response)
        {
        	$("#tbodyid").empty();	
        	$.each(response, function(i,dish){ 
		    	   var markup = "<tr><td>"+dish.name+"</td><td>" + dish.companyname 
		    	   +"</td><td>" + dish.phoneNo + "</td><td>" + dish.phoneNo1+"</td></tr>";
		            $("table tbody").append(markup);   			       		 			             
		        });
        	if(response.length>0){
        		$("#modalLabel").show();
        	}else{
        		$("#modalLabel").hide();
        	}
		},
        error : function()
        {	     
            // $('#').fadeOut();      
            alert('Error. . .');
        }
    });
}
// function nameExist(data)
// {
    // alert(data.value);
    // if(data.value == '')
    // {
    //     $('#consultantname').addlass('border-danger');
    //     $('#namemsg').css({'display':'block'});
    //     $('#namemsg').text('Consultant Name Required...').addClass('text-danger');
    // }
    // else
    // {
    //     $('#namemsg').css({'display':'none'});
    //     $('#consultantname').removeClass('border-danger');
    // }
//     var data = cabaseurl+'/isNewConsultant?name='+data.value;
//     console.log('URL : '+data);
//     $.ajax({
//         type : 'GET',
//         url : data,
//         success : function(result)
//         {
//             // alert('I am success');
//             console.log("Name : "+result);
//         },
//         error : function()
//         {
//             $('#namemsg').css({'display':'block'});
//             $('#namemsg').text('Consultant Name hase to be Exist...').addClass('text-danger');
//             alert('I am Error');
//         }
//     })
// }