$(document).ready(function() {
    console.log("ready");
    $("#ch-cardexp input").keypress(function(e) {
        var v = $(this).val();
        if(v.length == 2) {
            e.preventDefault();
        }
    });
    $('input[name="ch-cardno"]').keypress(function(e) {
        var v = $(this).val();
        if(v.length == 16) {
            e.preventDefault();
        }
    });
    $('input[name="ch-pin"]').keypress(function(e) {
        var v = $(this).val();
        if(v.length == 6) {
            e.preventDefault();
        }
    });
});