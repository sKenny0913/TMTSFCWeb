$(document).ready(function () {
    $("#idTable").hide();
    $("#btnClear").click(function () {
        clearValue();
    });
    $("#btnSearch").click(function () {
        //        $("#idTable").hide();
        var url = serverAddress + "DynamicSelect_Part";
        var strPartNo = $(this).closest("form").find("input[name='PartNo']").val();
        var strCapacity = $(this).closest("form").find("input[name='Capacity']").val();
        var strYear = $(this).closest("form").find("input[name='Year']").val();
        var urlFinal = url + '?PartNo=' + strPartNo + '&Capacity=' + strCapacity + '&Year=' + strYear;
        document.getElementById('idResult').innerHTML = "Loading...";
        $("#idSpinner").show();
        $("#idLoader").show();
        w3.getHttpObject(urlFinal, getSelectResult);
    });
    $("#btnUpdate").click(function () {
        var strPartNo = $(this).closest("form").find("input[name='PartNo']").val();
        document.getElementById('idUpdateConfirm').innerHTML = "Are you sure to update SID: " + strPartNo + " ?";
        $("#idDivUpdateConfirm").show();
        $("#btnUpdateYes").click(function () {
            $("#idDivUpdateConfirm").hide();
            if ($('#idForm').valid()) {
                var url = serverAddress + "DynamicUpdate_Part";
                //        var url = "http://localhost:8085/TMTSFCWeb/Update_AOI";
                var strPartNo = $('#idForm').find("input[name='PartNo']").val();
                var strCapacity = $('#idForm').find("input[name='Capacity']").val();
                var strYear = $('#idForm').find("input[name='Year']").val();
                var userid = $.cookie('userid');
                //        console.log(strCommandType);
                //            console.log(checkingTextHasValue());
                var urlFinal = url + '?PartNo=' + strPartNo + '&Capacity=' + strCapacity + '&Year=' + strYear;
                console.log(urlFinal);
                document.getElementById('idResult').innerHTML = "Loading...";
                $("#idSpinner").show();
                $("#idLoader").show();
                w3.getHttpObject(urlFinal, getResult);
                setTimeout(function () {
                    pageRefresh();
                    clearValue();
                }, 1500);
            }
        })
    });
    $('#idForm').keypress(function (e) {
        if (e.which == 13) {
            alert("Please click button.");
        }
    });
});
$(document).on('click', '.w3-medium', function () {
    var strPartNo = $(this).find("td:eq(0)").text().trim();
    var strCapacity = $(this).find("td:eq(1)").text().trim();
    var strYear = $(this).find("td:eq(2)").text().trim();
    $("input[name='PartNo']").val(strPartNo);
    $("input[name='Capacity']").val(strCapacity);
    $("input[name='Year']").val(strYear);
    //    console.log(url);
    //    w3.getHttpObject(url, displayRDetail);
});

function getResult(result) {
    //    console.log(result);
    //    console.log(result.isSuccess);
    if (result.isSuccess == true) {
        $("#idSpinner").hide();
        document.getElementById('idResult').innerHTML = "completed.";
        $('#idLoader').delay(1500).fadeOut('fast')
    }
    else if (result.isSuccess == false) {
        $("#idSpinner").hide();
        document.getElementById('idResult').innerHTML = "failed, please check.";
        $('#idLoader').delay(1500).fadeOut('fast')
    }
}

function getSelectResult(dataArray) {
    //    console.log(dataArray);
    //    console.log(result.isSuccess);
    if (dataArray != null) {
        if (dataArray.stations.length > 0) {
            $("#idSpinner").hide();
            document.getElementById('idResult').innerHTML = "select completed.";
            $('#idLoader').delay(1500).fadeOut('fast')
            w3.displayObject("idStations2", dataArray);
            $("#idTable").show();
        }
        else {
            $("#idSpinner").hide();
            document.getElementById('idResult').innerHTML = "no data, please check.";
            $('#idLoader').delay(1500).fadeOut('fast')
            $("#idTable").hide();
        }
    }
    else {
        $("#idSpinner").hide();
        document.getElementById('idResult').innerHTML = "select failed, please check.";
        $('#idLoader').delay(1500).fadeOut('fast')
        $("#idTable").hide();
    }
}

function pageRefresh() {
    $("#idTable").hide();
    var url = serverAddress + "DynamicSelect_Part";
    var urlFinal = url;
    //        console.log(url);
    document.getElementById('idResult').innerHTML = "Loading...";
    $("#idSpinner").show();
    $("#idLoader").show();
    w3.getHttpObject(urlFinal, function (dataArray) {
        //        console.log(dataArray);
        //    console.log(result.isSuccess);
        if (dataArray != null) {
            if (dataArray.stations.length > 0) {
                $("#idSpinner").hide();
                $('#idLoader').hide()
                w3.displayObject("idStations2", dataArray);
                $("#idTable").show();
            }
            else {
                $("#idSpinner").hide();
                document.getElementById('idResult').innerHTML = "no data, please check.";
                $('#idLoader').delay(1500).fadeOut('fast')
                $("#idTable").hide();
            }
        }
        else {
            $("#idSpinner").hide();
            document.getElementById('idResult').innerHTML = "pageRefresh failed, please check.";
            $('#idLoader').delay(1500).fadeOut('fast')
            $("#idTable").hide();
        }
    });
}

function clearValue() {
    $("input:text").val("");
    $("select").val("");
}