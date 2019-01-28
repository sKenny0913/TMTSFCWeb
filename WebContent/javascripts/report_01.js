
$(document).ready(function () {
    $("#idTable").hide();
    getStations();
    $("#btnClear").click(function () {
        clearValue();
    });
    $("#btnSearch").click(function () {
        //        $("#idTable").hide();
        var url = serverAddress + "Report_01";
        var sWO = $(this).closest("form").find("input[name='WO']").val();
        var sStation = $(this).closest("form").find("select[id='idStationList']").val();
        var sSN_Type = $(this).closest("form").find("input[name='SN_Type']").val();
        var sSN = $(this).closest("form").find("input[name='SN']").val();
        var urlFinal = url + '?WO=' + sWO + '&Station=' + sStation + '&SN_Type=' + sSN_Type + '&SN=' + sSN;
        document.getElementById('idResult').innerHTML = "Loading...";
        $("#idSpinner").show();
        $("#idLoader").show();
        w3.getHttpObject(urlFinal, getSelectResult);
    });
    $('#idForm').keypress(function (e) {
        if (e.which == 13) {
            alert("Please click button.");
        }
    });
});
$(document).on('click', '.w3-medium', function () {
    var sWO = $(this).find("td:eq(0)").text().trim();
    var sStation = $(this).find("td:eq(1)").text().trim();
    var sSN_Type = $(this).find("td:eq(2)").text().trim();
    var sSN = $(this).find("td:eq(3)").text().trim();
    $("input[name='WO']").val(sWO);
    $("select[id='idStationList']").val(sStation);
    $("input[name='SN_Type']").val(sSN_Type);
    $("input[name='SN']").val(sSN);
    //    console.log(url);
    //    w3.getHttpObject(url, displayRDetail);
});

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

function getStations() {
    var url = serverAddress + "Select_Station";
    var urlFinal = url;
    w3.getHttpObject(urlFinal, function (dataArray) {
        //        console.log(dataArray);
        //        console.log(dataArray.stationList.length);
        if (dataArray != null) {
            if (dataArray.stationList.length > 0) {
                w3.displayObject("idStationList", dataArray);
            }
        }
    });
}

function clearValue() {
    $("input:text").val("");
    $("select").val("");
}