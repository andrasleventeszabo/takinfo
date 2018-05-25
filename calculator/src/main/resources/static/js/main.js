$(document).ready(function () {

    $("#search-form").submit(function (event) {

        event.preventDefault();

        ajax_submit();

    });

});

function ajax_submit() {


    var latitude = $("#latitude").val();
    var longitude = $("#longitude").val();
    var squeremeter = $("#squeremeter").val();

    $("#btn-search").prop("disabled", true);
    var search = {'latitude': latitude, 'longitude': longitude, 'square': squeremeter};
console.log(search);
    $.ajax({
        method: "POST",
        contentType: "application/json",
        url: "/api/calculation/new",
        data: search,
        dataType: 'json',
        success: function (data) {
            console.log(data)
            var json = "<h4>Az ingtlan ára</h4><pre>"
                +"</pre>";
            $('#price').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Error</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
}