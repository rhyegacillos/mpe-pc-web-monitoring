$( '.date' ).datepicker({
    dateFormat: 'yy-mm-dd'
});

function checkSubmit(e) {
    if(e && e.keyCode == 13) {
        document.forms[0].submit();
    }
}

// $(document).ready(function() {
//     $('.table-search').DataTable( {
//         "paging":   false,
//         "ordering": false,
//         "info":     false
//     } );
// } );