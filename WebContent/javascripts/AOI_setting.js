var strCcd_setting_sid;
$(document).ready(function () {
    $("#idTable").hide();
    $("#idBarcode").hide();
    getStations();
    $("#btnClear").click(function () {
        clearValue();
    });
    $("#btnAdd").click(function () {
        if ($('#idForm').valid()) {
            var url = serverAddress + "Insert_AOI";
            var strLine = $(this).closest("form").find("input[name='Line']").val();
            var strStation = $(this).closest("form").find("select[id='idStationList']").val();
            var strSku = $(this).closest("form").find("input[name='Sku']").val();
            var strCommandType = $(this).closest("form").find("select[id='idCommandType']").val();
            var strProjectCode = $(this).closest("form").find("input[name='ProjectCode']").val();
            var strJobCode = $(this).closest("form").find("input[name='JobCode']").val();
            var strN1 = $(this).closest("form").find("input[name='N1']").val();
            var strN2 = $(this).closest("form").find("input[name='N2']").val();
            var strN3 = $(this).closest("form").find("input[name='N3']").val();
            var strN4 = $(this).closest("form").find("input[name='N4']").val();
            var strN5 = $(this).closest("form").find("input[name='N5']").val();
            var strN6 = $(this).closest("form").find("input[name='N6']").val();
            var strN7 = $(this).closest("form").find("input[name='N7']").val();
            var strN8 = $(this).closest("form").find("input[name='N8']").val();
            var strN9 = $(this).closest("form").find("input[name='N9']").val();
            var strN10 = $(this).closest("form").find("input[name='N10']").val();
            var strN11 = $(this).closest("form").find("input[name='N11']").val();
            var strN12 = $(this).closest("form").find("input[name='N12']").val();
            var strN13 = $(this).closest("form").find("input[name='N13']").val();
            var strN14 = $(this).closest("form").find("input[name='N14']").val();
            var strN15 = $(this).closest("form").find("input[name='N15']").val();
            var strNodeKey = $(this).closest("form").find("input[name='NodeKey']").val();
            var userid = $.cookie('userid');
            //        console.log(strCommandType);
            //            console.log(checkingTextHasValue());
            var urlFinal = url + '?Line=' + strLine + '&Station=' + strStation + '&Sku=' + strSku + '&CommandType=' + strCommandType + '&ProjectCode=' + strProjectCode + '&JobCode=' + strJobCode + '&N1=' + strN1 + '&N2=' + strN2 + '&N3=' + strN3 + '&N4=' + strN4 + '&N5=' + strN5 + '&N6=' + strN6 + '&N7=' + strN7 + '&N8=' + strN8 + '&N9=' + strN9 + '&N10=' + strN10 + '&N11=' + strN11 + '&N12=' + strN12 + '&N13=' + strN13 + '&N14=' + strN14 + '&N15=' + strN15 + '&NodeKey=' + strNodeKey + '&UserID=' + userid;
            //            console.log(urlFinal);
            document.getElementById('idResult').innerHTML = "Loading...";
            $("#idSpinner").show();
            $("#idLoader").show();
            w3.getHttpObject(urlFinal, getResult);
            setTimeout(function () {
                pageRefresh();
                clearValue();
            }, 1500);
        }
    });
    $("#btnSearch").click(function () {
        //        $("#idTable").hide();
        var url = serverAddress + "DynamicSelect_AOI";
        var strLine = $(this).closest("form").find("input[name='Line']").val();
        var strStation = $(this).closest("form").find("select[id='idStationList']").val();
        var strSku = $(this).closest("form").find("input[name='Sku']").val();
        var strCommandType = $(this).closest("form").find("select[id='idCommandType']").val();
        var strProjectCode = $(this).closest("form").find("input[name='ProjectCode']").val();
        var strJobCode = $(this).closest("form").find("input[name='JobCode']").val();
        var strN1 = $(this).closest("form").find("input[name='N1']").val();
        var strN2 = $(this).closest("form").find("input[name='N2']").val();
        var strN3 = $(this).closest("form").find("input[name='N3']").val();
        var strN4 = $(this).closest("form").find("input[name='N4']").val();
        var strN5 = $(this).closest("form").find("input[name='N5']").val();
        var strN6 = $(this).closest("form").find("input[name='N6']").val();
        var strN7 = $(this).closest("form").find("input[name='N7']").val();
        var strN8 = $(this).closest("form").find("input[name='N8']").val();
        var strN9 = $(this).closest("form").find("input[name='N9']").val();
        var strN10 = $(this).closest("form").find("input[name='N10']").val();
        var strN11 = $(this).closest("form").find("input[name='N11']").val();
        var strN12 = $(this).closest("form").find("input[name='N12']").val();
        var strN13 = $(this).closest("form").find("input[name='N13']").val();
        var strN14 = $(this).closest("form").find("input[name='N14']").val();
        var strN15 = $(this).closest("form").find("input[name='N15']").val();
        var strNodeKey = $(this).closest("form").find("input[name='NodeKey']").val();
        var urlFinal = url + '?Line=' + strLine + '&Station=' + strStation + '&Sku=' + strSku + '&CommandType=' + strCommandType + '&ProjectCode=' + strProjectCode + '&JobCode=' + strJobCode + '&N1=' + strN1 + '&N2=' + strN2 + '&N3=' + strN3 + '&N4=' + strN4 + '&N5=' + strN5 + '&N6=' + strN6 + '&N7=' + strN7 + '&N8=' + strN8 + '&N9=' + strN9 + '&N10=' + strN10 + '&N11=' + strN11 + '&N12=' + strN12 + '&N13=' + strN13 + '&N14=' + strN14 + '&N15=' + strN15 + '&NodeKey=' + strNodeKey;
        console.log(urlFinal);
        document.getElementById('idResult').innerHTML = "Loading...";
        $("#idSpinner").show();
        $("#idLoader").show();
        w3.getHttpObject(urlFinal, getSelectResult);
    });
    $("#btnDelete").click(function () {
        document.getElementById('idConfirm').innerHTML = "Are you sure to delete SID: " + strCcd_setting_sid + " ?";
        $("#idDeleteConfirm").show();
        $("#btnDeleteYes").click(function () {
            $("#idDeleteConfirm").hide();
            var url = serverAddress + "Delete_AOI";
            var urlFinal = url + '?Ccd_setting_sid=' + strCcd_setting_sid;
            //        console.log(url);
            document.getElementById('idResult').innerHTML = "Loading...";
            $("#idSpinner").show();
            $("#idLoader").show();
            w3.getHttpObject(urlFinal, getResult);
            setTimeout(function () {
                pageRefresh();
                clearValue();
            }, 1500);
        });
    });
    $("#btnUpdate").click(function () {
        document.getElementById('idUpdateConfirm').innerHTML = "Are you sure to update SID: " + strCcd_setting_sid + " ?";
        $("#idDivUpdateConfirm").show();
        $("#btnUpdateYes").click(function () {
            $("#idDivUpdateConfirm").hide();
            if ($('#idForm').valid()) {
                var url = serverAddress + "Update_AOI";
                //        var url = "http://localhost:8085/TMTSFCWeb/Update_AOI";
                var strLine = $('#idForm').find("input[name='Line']").val();
                var strStation = $('#idForm').find("select[id='idStationList']").val();
                var strSku = $('#idForm').find("input[name='Sku']").val();
                var strCommandType = $('#idForm').find("select[id='idCommandType']").val();
                var strProjectCode = $('#idForm').find("input[name='ProjectCode']").val();
                var strJobCode = $('#idForm').find("input[name='JobCode']").val();
                var strN1 = $('#idForm').find("input[name='N1']").val();
                var strN2 = $('#idForm').find("input[name='N2']").val();
                var strN3 = $('#idForm').find("input[name='N3']").val();
                var strN4 = $('#idForm').find("input[name='N4']").val();
                var strN5 = $('#idForm').find("input[name='N5']").val();
                var strN6 = $('#idForm').find("input[name='N6']").val();
                var strN7 = $('#idForm').find("input[name='N7']").val();
                var strN8 = $('#idForm').find("input[name='N8']").val();
                var strN9 = $('#idForm').find("input[name='N9']").val();
                var strN10 = $('#idForm').find("input[name='N10']").val();
                var strN11 = $('#idForm').find("input[name='N11']").val();
                var strN12 = $('#idForm').find("input[name='N12']").val();
                var strN13 = $('#idForm').find("input[name='N13']").val();
                var strN14 = $('#idForm').find("input[name='N14']").val();
                var strN15 = $('#idForm').find("input[name='N15']").val();
                var strNodeKey = $('#idForm').find("input[name='NodeKey']").val();
                var userid = $.cookie('userid');
                //        console.log(strCommandType);
                //            console.log(checkingTextHasValue());
                var urlFinal = url + '?Ccd_setting_sid=' + strCcd_setting_sid + '&Line=' + strLine + '&Station=' + strStation + '&Sku=' + strSku + '&CommandType=' + strCommandType + '&ProjectCode=' + strProjectCode + '&JobCode=' + strJobCode + '&N1=' + strN1 + '&N2=' + strN2 + '&N3=' + strN3 + '&N4=' + strN4 + '&N5=' + strN5 + '&N6=' + strN6 + '&N7=' + strN7 + '&N8=' + strN8 + '&N9=' + strN9 + '&N10=' + strN10 + '&N11=' + strN11 + '&N12=' + strN12 + '&N13=' + strN13 + '&N14=' + strN14 + '&N15=' + strN15 + '&NodeKey=' + strNodeKey + '&UserID=' + userid;
                //            console.log(urlFinal);
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
    strCcd_setting_sid = $(this).find("td:eq(0)").text().trim();
    var strLine = $(this).find("td:eq(1)").text().trim();
    var strStation = $(this).find("td:eq(2)").text().trim();
    var strSku = $(this).find("td:eq(3)").text().trim();
    var strCommandType = $(this).find("td:eq(4)").text().trim();
    var strCommand = $(this).find("td:eq(5)").text().trim();
    var strNodeKey = $(this).find("td:eq(6)").text().trim();
    var strN1 = $(this).find("td:eq(7)").text().trim();
    var strN2 = $(this).find("td:eq(8)").text().trim();
    var strN3 = $(this).find("td:eq(9)").text().trim();
    var strN4 = $(this).find("td:eq(10)").text().trim();
    var strN5 = $(this).find("td:eq(11)").text().trim();
    var strN6 = $(this).find("td:eq(12)").text().trim();
    var strN7 = $(this).find("td:eq(13)").text().trim();
    var strN8 = $(this).find("td:eq(14)").text().trim();
    var strN9 = $(this).find("td:eq(15)").text().trim();
    var strN10 = $(this).find("td:eq(16)").text().trim();
    var strN11 = $(this).find("td:eq(17)").text().trim();
    var strN12 = $(this).find("td:eq(18)").text().trim();
    var strN13 = $(this).find("td:eq(19)").text().trim();
    var strN14 = $(this).find("td:eq(20)").text().trim();
    var strN15 = $(this).find("td:eq(21)").text().trim();
    //    $("input[name='Line']").val(strCcd_setting_sid);
    var arrCommand = strCommand.split(';', 2)
    $("input[name='Line']").val(strLine);
    $("select[id='idStationList']").val(strStation);
    $("input[name='Sku']").val(strSku);
    $("select[id='idCommandType']").val(strCommandType);
    $("input[name='ProjectCode']").val(arrCommand[0]);
    $("input[name='JobCode']").val(arrCommand[1]);
    $("input[name='NodeKey']").val(strNodeKey);
    $("input[name='N1']").val(strN1);
    $("input[name='N2']").val(strN2);
    $("input[name='N3']").val(strN3);
    $("input[name='N4']").val(strN4);
    $("input[name='N5']").val(strN5);
    $("input[name='N6']").val(strN6);
    $("input[name='N7']").val(strN7);
    $("input[name='N8']").val(strN8);
    $("input[name='N9']").val(strN9);
    $("input[name='N10']").val(strN10);
    $("input[name='N11']").val(strN11);
    $("input[name='N12']").val(strN12);
    $("input[name='N13']").val(strN13);
    $("input[name='N14']").val(strN14);
    $("input[name='N15']").val(strN15);
    displayDiv(strCommandType);
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

function displayDiv(selected) {
    if (selected == "BARCODE") {
        $("#idBarcode").show();
    }
    else {
        $("#idBarcode").hide();
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
    var url = serverAddress + "DynamicSelect_AOI";
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
            else {
                $("#idSpinner").hide();
                document.getElementById('idResult').innerHTML = "Get station list failed, please check.";
                $('#idLoader').delay(1500).fadeOut('fast')
                $("#idTable").hide();
            }
        }
        else {
            $("#idSpinner").hide();
            document.getElementById('idResult').innerHTML = "Get station list failed, please check.";
            $('#idLoader').delay(1500).fadeOut('fast')
            $("#idTable").hide();
        }
    });
}

function clearValue() {
    $("input:text").val("");
    $("select").val("");
}