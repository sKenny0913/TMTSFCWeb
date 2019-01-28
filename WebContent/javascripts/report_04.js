$(document).ready(function () {
    $("#idTable").hide();
    $("#btnClear").click(function () {
        clearValue();
    });
    $("#btnSearch").click(function () {
        var url = serverAddress + "Report_04";
        var sWO = $(this).closest("form").find("input[name='WO']").val();
        var sHDD_ID = $(this).closest("form").find("input[name='HDD_ID']").val();
        var sHDD_PN = $(this).closest("form").find("input[name='HDD_PN']").val();
        var urlFinal = url + '?WO=' + sWO + '&HDD_ID=' + sHDD_ID + '&HDD_PN=' + sHDD_PN;
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
    var sHDD_ID = $(this).find("td:eq(1)").text().trim();
    var sHDD_PN = $(this).find("td:eq(2)").text().trim();
    $("input[name='WO']").val(sWO);
    $("input[name='HDD_ID']").val(sHDD_ID);
    $("input[name='HDD_PN']").val(sHDD_PN);
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

function clearValue() {
    $("input:text").val("");
    $("select").val("");
}