/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 23/03/13
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */

function validation() {
    var registerForm = $('#registerForm');

    //user jQuery validation to validate the user input
    $.validator.addMethod("isUniqueUsername", function () {
        var isSuccess = false;
        $.ajax({
            type: "GET",
            url: "/isUsernameUnique",
            async: false,
            data: {username: $('input.username').val()},
            success: function (data, data1, data2) {
                isSuccess = Boolean(data);
            }
        });
        return isSuccess;
    }, "username not available");

    registerForm.validate({
        onkeyup: false,
        rules: {
            username: {
                required: true,
                isUniqueUsername: true
            },
            password: "required",
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            username: {
                required: "Please specify your unit name"
            },
            email: {
                required: "We need your email address to contact you",
                email: "Your email address must be in the format of name@domain.com"
            }
        }
    });

}

function signupHandler() {
    //handle the signup floating panel
    $("#signupButton").click(function (event) {
        var spanel = $('#signupPanel');
        if (spanel.css('display') == 'none') {
            spanel.css('display', 'inline');
        } else {
            spanel.css('display', 'none');
        }
    });

    $('#closelink').click(function (event) {
        var spanel = $('#signupPanel');
        spanel.css('display', 'none');
    });

}

$(document).ready(function () {
    validation();
    signupHandler();
});