function appendListItem(subject, content, date, weather) {
    //establish the structure of a list item, and add a class name for css purpose
    var element = document.createElement('li');
    $('<p/>').attr('class','subject').appendTo(element).text(subject);
    $('<p/>').attr('class','weather').appendTo(element).text('Weather: ' + weather);
    $('<p/>').attr('class','content').appendTo(element).text(content);
    $('<p/>').attr('class','date').appendTo(element).html('<span>' + date + '</span>');

    //append the list element to the list
    $("#posts").append(element);
}

function weatherHandler(data) {
    var condition = data.query.results.channel.item.condition.text
    $("#weather").html(condition);
    $('#weather_input').val(condition);
}

function getWetherCondition() {
    //get the json wether data from Yahoo weather (only for Sydney at the moment)
    var weatherURL = "http://query.yahooapis.com/v1/public/yql?q=select%20item%20from%20weather.forecast%20where%20location%3D%22ASXX0112%22&format=json";
    $.getJSON(weatherURL,
        function (data) {
            weatherHandler(data);
        });
}

$(document).ready(function () {
    //get the user name in the url in order to load the user feeds
    var owner = window.location.pathname.split('/').pop();
    $.getJSON(context+"/users/" + owner + "/loadUserFeeds", function (data) {
        $.each(data, function (key, val) {
            appendListItem(val.subject, val.content, new Date(val.created), val.weather);
        });
    });
    $('select#order-by').change(function(){
        var order = $(this).val();
        $("ul").empty();
        $.getJSON(context+"/users/" + owner + "/loadUserFeeds",{order:order}, function (data) {
            $("#posts").empty();
            $.each(data, function (key, val) {
                appendListItem(val.subject, val.content, new Date(val.created), val.weather);
            });
        });

    });
    //put the weather condition on when user want to post a new post
    getWetherCondition();
});