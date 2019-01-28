$(document).ready(function () {
    $("#idTable").hide();
    getStations();
    $("#btnClear").click(function () {
        clearValue();
    });
    $("#btnSearch").click(function () {
        //        $("#idTable").hide();
        var url = serverAddress + "Report_05";
        var sOuterId = $(this).closest("form").find("input[name='OuterId']").val();
        var sInnerId = $(this).closest("form").find("input[name='InnerId']").val();
        var sInnerSeq = $(this).closest("form").find("input[name='InnerSeq']").val();
        var urlFinal = url + '?OuterId=' + sOuterId + '&InnerId=' + sInnerId + '&InnerSeq=' + sInnerSeq ;
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
    var sOuterId = $(this).find("td:eq(0)").text().trim();
    var sInnerId = $(this).find("td:eq(1)").text().trim();
    var sInnerSeq = $(this).find("td:eq(2)").text().trim();
    $("input[name='OuterId']").val(sOuterId);
    $("input[name='InnerId']").val(sInnerId);
    $("input[name='InnerSeq']").val(sInnerSeq);
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