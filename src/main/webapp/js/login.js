
function login()
{
    var user = $('#username').val();
    var pass = $('#password').val();

    var details = {'emailId':user,'password':pass};
    details = JSON.stringify(details);
    console.log('Information : '+details);
    $.ajax({
        type : 'POST',
        url : cabaseurl+'/login',
        contentType:"application/json; charset=utf-8",
        data : details,
        success : function(response)
        {
            
            if(response.emailId == user)
            {
                sessionStorage.setItem('userdetails',JSON.stringify(response));                              
                window.location.replace(cabaseurl+'/index.jsp');
            }
            else
            {
                $('#errmsg').show();
            }
            $.session.set("userdetail",response);
            
        },
        error : function()
        {
            $('#errmsg').show();
            alert('Error. . .');
        }
    })
}





