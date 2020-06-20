///
//
//  IMPLEMENTATION OF REST API 
//
///
$(document).ready(function () {

    //DISPLAY LIST OF COURTS IN HOMEPAGE
    $.ajax({
        type: "get",
        url: "api/courts",
        dataType: "json",
        success: function (data) {

            $.each(data, function (index, item) {

                $("#contents").append("<div class='col-lg-3 col-md-6 mb-4'>" +
                    "<div class='card h-100'>" +
                    "<img id='image' class='card-img-top' src='img/" + item.image + "' alt='" + item.courtName + "'>" +
                    "<div class='card-body'>" +
                    "<h4 class='card-title' id='courtname'>" + item.courtName + "</h4>" +
                    "<p class='card-text' id='details'>Type : " + item.courtType + "</p>" +
                    "<p class='card-text' id='details'>Price : RM " + item.price + "</p>" +
                    "</div>" +
                    "<div class='card-footer'>" +
                    "<a href='#' class='btn btn-primary'>Find Out More!</a>" +
                    "</div>" +
                    "</div>" +
                    "</div>");
            });

        }
    });


    // DO THE UPDATE STATUS OF THE COURT
    $("#listcourts").on("click", "span", function () {
        var parentTR = $(this).parent().parent();

        var id = parentTR.find('#id').html();
        $.ajax({
            type: "PUT", //not restful => php not recognize put
            contentType: "application/json",
            url: 'api/updatecourtstatus/' + id,
            dataType: 'json',
            success: function (data) {
                if (data.courtStat == "Inactive") {
                    parentTR.find("#status").html("<span class='btn btn-danger'>InActive</span>");
                }
                if (data.courtStat == "Active") {
                    parentTR.find('#status').html("<span class='btn btn-success'>Active</span>");
                }
                alert("Court status update successful");

            },

            error: function () {
                alert("Court status update failed - please try again: ");


            },

        });
    });
});