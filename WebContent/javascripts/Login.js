//var serverAddress = 'http://localhost:8085/TMTSFCWeb/';
var serverAddress = 'http://tmtsfc.techmanth.com:8080/TMTSFCWeb/';
//var serverAddress = 'http://tmtsfcdev.techmanth.com:8080/TMTSFCWeb/';
var userid;
var password;
$(document).ready(function () {
    $("#nav-placeholder").load("nav", function () {
        $(".Report").hide();
        $(".Dev").hide();
        $(".IT").hide();
        if ($.cookie('userid') && $.cookie('password') == null) {
            $('#idPuserName').innerHTML = "Login";
            $("#idALogin").innerHTML = "Login";
        }
    });
    $("#login-placeholder").load("Login", function () {
        initialize();
        $("#idBtnLogin").click(function () {
            userid = $('#userid').val();
            password = $('#pwd').val();
            doLogin();
        });
        $("#idBtnLogout").click(function () {
            doLogout();
            initialize();
            setTimeout(location.reload.bind(location), 1000);
        });
        if ($.cookie('userid') && $.cookie('password') != null) {
            userid = $.cookie('userid');
            password = $.cookie('password');
            doLogin();
        }
    });
    $("#report-placeholder").load("Report");
});

function initialize() {
    $("#idBtnLogin").show();
    $("#idBtnLogout").hide();
    $("input[name='button']").hide();
}

function doLogin() {
    var blnUserExist = false;
    $.getJSON("json/user.json", function (data) {
        $.each(data, function (i) {
            if (userid == data[i].userid) {
                if (password == data[i].password) {
                    blnUserExist = true;
                    $.cookie('userid', data[i].userid);
                    $.cookie('password', data[i].password);
                    document.getElementById('idSpanLoginResult').innerHTML = "welcome " + userid;
                    document.getElementById('idPuserName').innerHTML = userid;
                    document.getElementById('idALogin').innerHTML = userid;
                    $('#idDivLogin').delay(1000).fadeOut('fast')
                    if (data[i].privilege == 'administrator') {
                        $("input[name='button']").show();
                        $(".Dev").show();
                        $(".IT").show();
                        $(".Report").show();
                    }
                    else if (data[i].privilege == 'AUTO') {
                        $(".AOI").show();
                        $(".Part").show();
                    }
                    else if (data[i].privilege == 'IT') {
                        $("input[name='button']").show();
                        $(".IT").show();
                        $(".Report").show();
                    }
                    else if (data[i].privilege == 'REPORT') {
                        $(".Report").show();
                    }
                    $("#idBtnLogin").hide();
                    $("#idBtnLogout").show();
                }
            }
            if (blnUserExist == false) {
                document.getElementById('idSpanLoginResult').innerHTML = "incorrect username or password";
            }
        });
    });
}

function doLogout() {
    document.getElementById('idSpanLoginResult').innerHTML = "Bye " + userid
    $('#idDivLogin').delay(1000).fadeOut('fast')
    $.cookie("userid", null);
    $.cookie("password", null);
}

function sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("idStations2");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
            else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount++;
        }
        else {
            /* If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again. */
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}