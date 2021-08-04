$(document).ready(function() {
    $.ajax({
        type: "POST",
        url: 'getData',
        data: {type: 'places'},
        success: function(data) {
            var f = $("#from"),
                t = $("#to");

            f.html('');
            t.html('');
            data = JSON.parse(data);
            $.each(data.from, (i, af) => {
                f.append(`<option value="${af}">${af}</option>`);
            });
            $.each(data.to, (i, at) => {
                t.append(`<option value="${at}">${at}</option>`);
            });
        }
      });
});