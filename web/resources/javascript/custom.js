$( '.date' ).datepicker({
    dateFormat: 'yy-mm-dd'
});

function checkSubmit(e) {
    if(e && e.keyCode == 13) {
        document.forms[0].submit();
    }
}