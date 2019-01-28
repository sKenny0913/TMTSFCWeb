var strOpc_node_sid;
$(document).ready(function () {
    $("#idTable").hide();
    $("#btnAdd").click(function () {
        if ($('#idForm').valid()) {
            var url = serverAddress + "Insert_OPC";
            var strNodeName = $(this).closest("form").find("input[name='NodeName']").val();
            var strDataType = $(this).closest("form").find("select[id='idDataType']").val();
            var strAddress = $(this).closest("form").find("input[name='Address']").val();
            var strDesc = $(this).closest("form").find("input[name='Desc']").val();
            var userid = $.cookie('userid');
            strOpc_node_sid = strNodeName;
            var urlFinal = url + '?NodeName=' + strNodeName + '&DataType=' + strDataType + '&Address=' + strAddress + '&Desc=' + strDesc + '&UserID=' + userid;
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
    });
    $("#btnSearch").click(function () {
        var url = serverAddress + "DynamicSelect_OPC";
        var strNodeName = $(this).closest("form").find("input[name='NodeName']").val();
        var strDataType = $(this).closest("form").find("select[id='idDataType']").val();
        var strAddress = $(this).closest("form").find("input[name='Address']").val();
        var strDesc = $(this).closest("form").find("input[name='Desc']").val();
        var urlFinal = url + '?NodeName=' + strNodeName + '&DataType=' + strDataType + '&Address=' + strAddress + '&Desc=' + strDesc;
        //        console.log(urlFinal);
        document.getElementById('idResult').innerHTML = "Loading...";
        $("#idSpinner").show();
        $("#idLoader").show();
        w3.getHttpObject(urlFinal, getSelectResult);
    });
    $("#btnDelete").click(function () {
        document.getElementById('idConfirm').innerHTML = "Are you sure to delete SID: " + strOpc_node_sid + " ?";
        $("#idDeleteConfirm").show();
        $("#btnYes").click(function () {
            $("#idDeleteConfirm").hide();
            var url = serverAddress + "Delete_OPC";
            var urlFinal = url + '?Opc_node_sid=' + strOpc_node_sid;
            //console.log(url);
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
        if ($('#idForm').valid()) {
            var url = serverAddress + "Update_OPC";
            //        var url = "http://localhost:8085/TMTSFCWeb/Update_OPC";
            var strNodeName = $(this).closest("form").find("input[name='NodeName']").val();
            var strDataType = $(this).closest("form").find("select[id='idDataType']").val();
            var strAddress = $(this).closest("form").find("input[name='Address']").val();
            var strDesc = $(this).closest("form").find("input[name='Desc']").val();
            var userid = $.cookie('userid');
            //console.log(strCommandType);
            var urlFinal = url + '?Opc_node_sid=' + strOpc_node_sid + '&NodeName=' + strNodeName + '&DataType=' + strDataType + '&Address=' + strAddress + '&Desc=' + strDesc + '&UserID=' + userid;
            //        console.log(urlFinal);
            document.getElementById('idResult').innerHTML = "Loading...";
            $("#idSpinner").show();
            $("#idLoader").show();
            w3.getHttpObject(urlFinal, getResult);
            setTimeout(function () {
                pageRefresh();
            }, 1500);
        }
    });
    $('#idForm').keypress(function (e) {
        if (e.which == 13) {
            alert("Please click button.");
        }
    });
});
$(document).on('click', '.w3-medium', function () {
    strOpc_node_sid = $(this).find("td:eq(0)").text().trim();
    var strNodeName = $(this).find("td:eq(1)").text().trim();
    var strDATA_TYPE = $(this).find("td:eq(2)").text().trim();
    var strADDRESS = $(this).find("td:eq(3)").text().trim();
    var strDESCR = $(this).find("td:eq(4)").text().trim();
    var arrSplit = strADDRESS.split('##.')
    $("input[name='NodeName']").val(strNodeName);
    $('select').val(strDATA_TYPE);
    $("input[name='Address']").val(arrSplit[1]);
    $("input[name='Desc']").val(strDESCR);
    //console.log(url);
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
    var url = serverAddress + "DynamicSelect_OPC";
    var urlFinal = url;
    //console.log(url);
    document.getElementById('idResult').innerHTML = "Loading...";
    $("#idSpinner").show();
    $("#idLoader").show();
    w3.getHttpObject(urlFinal, function (dataArray) {
        //    console.log(dataArray);
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

    function clearValue() {
        $("input:text").val("");
        $("select").val("");
    }
}