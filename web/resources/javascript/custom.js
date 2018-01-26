$( '.date' ).datepicker({
    dateFormat: 'yy-mm-dd'
});

function checkSubmit(e) {
    if(e && e.keyCode == 13) {
        document.forms[0].submit();
    }
}


$(".main-table tr").each(function () {
    var ngOccurrence = $(this).find("#ngOccurence").html();
    if (ngOccurrence == "2") {
        $(this).css("backgroundColor", "rgba(234, 60, 60, 0.4)");
        $(this).hover(function () {
            $(this).css("backgroundColor", "rgba(234, 60, 60, 0.7)");
        }, function () {
            $(this).css("backgroundColor", "rgba(234, 60, 60, 0.4)");
        })
    }
})


function alertNgOccurence() {
    if($("#ng-occurrence" ).val() == "2") {
        $(".alert-ng-occurrence").css({
            "backgroundColor": "rgba(234, 60, 60, 0.4)",
            "borderColor" : "rgba(234, 60, 60, 1)",
            "color" : "#771f1f"
        });
        $(".wrench").css("backgroundColor","rgba(234, 60, 60, 1)");
        // $(".pc-repair-form").css({
        //     "backgroundColor": "rgba(234, 60, 60, 0.2)",
        //     "borderColor" : "rgba(234, 60, 60, 0.8)",
        // })
        //
        // $(".main-title").css({
        //     "backgroundColor" : "rgba(234, 60, 60, 0.8)",
        //     "borderBottom" : "rgba(234, 60, 60, 0.8)"
        // })
    }
}

alertNgOccurence();

