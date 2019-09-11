/**
 * 
 */

var validateEmail = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
var saveEnbl = true;

$('.mndry').on({
    blur : function(){
        if($(this).attr('validate') == 'email'){
            if(validateEmail.test($(this).val())){
                $(this).siblings().css({'display':'none'});
                $(this).removeClass('border-danger');
                saveEnbl = true;
            }else{
                $(this).siblings().css({'display':'block'});
                $(this).addClass('border-danger');
                saveEnbl = false;
            }
        }
        if($(this).val() == '' )
        {
            // $('#val-email-error').css({'display':'none'});
            $(this).addClass('border-danger');
            $(this).siblings().children().css({'display':'block'});
        }
        else
        {
            // $('#val-email-error').css({'display':'none'});
            $(this).removeClass('border-danger');
            $(this).siblings().children().css({'display':'none'});
        }
        saveButtonEnable();
    }
});

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
}