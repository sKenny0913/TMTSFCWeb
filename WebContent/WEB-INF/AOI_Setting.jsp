<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <title>TMT SFC Web</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/w3.css">
    <link rel="stylesheet" href="css/Montserrat.css">
    <link rel="stylesheet" href="css/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->
    <link rel="stylesheet" href="css/search.css">

    <body class="w3-black">
        <script src="javascripts/w3.js"></script>
        <script src="javascripts/jquery.min.js"></script>
        <script src="javascripts/AOI_setting.js"></script>
        <script src="javascripts/Login.js"></script>
        <script src="javascripts/jquery.cookie.js"></script>
        <script src="javascripts/jquery.validate.min.js"></script>
        <!-- Icon Bar (Sidebar - hidden on small screens) -->
        <div id="nav-placeholder"> </div>
        <!-- Page Content -->
        <div class="w3-padding-large" id="main">
            <!-- Header/Home -->
            <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
                <h1 class="w3-jumbo">AOI Setting</h1>
                <p></p>
            </header>
            <!-- Contact Section -->
            <!--        <div class="w3-padding-16 w3-col l6 m8">-->
            <form id="idForm">
                <div class="w3-row-padding" style="margin:8px -16px;">
                    <div class="w3-quarter w3-margin-bottom">
                        <label> Line:</label>
                        <input class="w3-input w3-border" type="text" name="Line" required> </div>
                    <div class="w3-quarter">
                        <label> Station:</label>
                        <select id="idStationList" class="w3-input w3-border" name="Station" required>
                            <option></option>
                            <option w3-repeat="stationList">{{OPERATION}}</option>
                        </select>
                    </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label> Sku:</label>
                        <input class="w3-input w3-border" type="text" name="Sku" required> </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label> Command Type:</label>
                        <select id="idCommandType" class="w3-input w3-border" name="Command Type" onchange="displayDiv(this.value)" required>
                            <option></option>
                            <option value="AOI">AOI</option>
                            <option value="BARCODE">Barcode</option>
                        </select>
                    </div>
                </div>
                <div class="w3-row-padding" style="margin:0 -16px;">
                    <div class="w3-quarter w3-margin-bottom">
                        <label> Project Code:</label>
                        <input class="w3-input w3-border" type="text" name="ProjectCode" required> </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label> Job Code:</label>
                        <input class="w3-input w3-border" type="text" name="JobCode" required> </div>
                    <div class="w3-quarter">
                        <label> NodeKey:</label>
                        <input class="w3-input w3-border" type="text" name="NodeKey" required> </div>
                    <div class="w3-quarter">
                        <label> N1:</label>
                        <input class="w3-input w3-border" type="text" name="N1" required> </div>
                </div>
                <div id="idBarcode">
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N2:</label>
                            <input class="w3-input w3-border" type="text" name="N2"> </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N3:</label>
                            <input class="w3-input w3-border" type="text" name="N3"> </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N4:</label>
                            <input class="w3-input w3-border" type="text" name="N4"> </div>
                        <div class="w3-quarter">
                            <label> N5:</label>
                            <input class="w3-input w3-border" type="text" name="N5"> </div>
                    </div>
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N6:</label>
                            <input class="w3-input w3-border" type="text" name="N6"> </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N7:</label>
                            <input class="w3-input w3-border" type="text" name="N7"> </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N8:</label>
                            <input class="w3-input w3-border" type="text" name="N8"> </div>
                        <div class="w3-quarter">
                            <label> N9:</label>
                            <input class="w3-input w3-border" type="text" name="N9"> </div>
                    </div>
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N10:</label>
                            <input class="w3-input w3-border" type="text" name="N10"> </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N11:</label>
                            <input class="w3-input w3-border" type="text" name="N11"> </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N12:</label>
                            <input class="w3-input w3-border" type="text" name="N12"> </div>
                        <div class="w3-quarter">
                            <label> N13:</label>
                            <input class="w3-input w3-border" type="text" name="N13"> </div>
                    </div>
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N14:</label>
                            <input class="w3-input w3-border" type="text" name="N14"> </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label> N15:</label>
                            <input class="w3-input w3-border" type="text" name="N15"> </div>
                    </div>
                </div>
                <!--                <input type="button" class="w3-button w3-dark-grey" id="btnSelectAll" value="Select All ">-->
                <input type="button" class="AOI w3-button w3-dark-grey" id="btnSearch" name='button' value="Select">
                <input type="button" class="AOI w3-button w3-dark-grey" id="btnAdd" value="Add" name='button'>
                <!--              <button class="w3-button w3-dark-grey" type="submit" id="btnAdd">Add</button>-->
                <input type="button" class="AOI w3-button w3-dark-grey" id="btnUpdate" value="Update" name='button'>
                <input type="button" class="w3-button w3-dark-grey" id="btnDelete" value="Delete" name='button'>
                <input type="button" class="AOI w3-button w3-dark-grey" id="btnClear" value="Clear" name='button'> </form>
            <div id="idTable">
                <h2 class="w3-text-light-grey">Result:</h2>
                <hr style="width:200px" class="w3-opacity">
                <div class="clsStations w3-section w3-responsive" id="idDivStations">
                    <a href="#idForm">
                        <table class="w3-table-all w3-light-grey w3-hoverable" id="idStations2">
                            <tr class="w3-large">
                                <th onclick="sortTable(0)">CCD_SETTING_SID</th>
                                <th onclick="sortTable(1)">LINE</th>
                                <th onclick="sortTable(2)">STATION</th>
                                <th onclick="sortTable(3)">SKU</th>
                                <th onclick="sortTable(4)">COMMAND_TYPE</th>
                                <th onclick="sortTable(5)">COMMAND</th>
                                <th onclick="sortTable(5)">NODEKEY</th>
                                <th onclick="sortTable(6)">N1</th>
                                <th onclick="sortTable(7)">N2</th>
                                <th onclick="sortTable(8)">N3</th>
                                <th onclick="sortTable(9)">N4</th>
                                <th onclick="sortTable(10)">N5</th>
                                <th onclick="sortTable(11)">N6</th>
                                <th onclick="sortTable(12)">N7</th>
                                <th onclick="sortTable(13)">N8</th>
                                <th onclick="sortTable(14)">N9</th>
                                <th onclick="sortTable(15)">N10</th>
                                <th onclick="sortTable(16)">N11</th>
                                <th onclick="sortTable(17)">N12</th>
                                <th onclick="sortTable(18)">N13</th>
                                <th onclick="sortTable(19)">N14</th>
                                <th onclick="sortTable(20)">N15</th>
                                <th onclick="sortTable(21)">USERID</th>
                                <th onclick="sortTable(22)">UPDATETIME</th>
                            </tr>
                            <tr class="w3-medium" w3-repeat="stations">
                                <td>{{CCD_SETTING_SID}}</td>
                                <td>{{LINE}}</td>
                                <td>{{STATION}}</td>
                                <td>{{SKU}}</td>
                                <td>{{COMMAND_TYPE}}</td>
                                <td>{{COMMAND}}</td>
                                <td>{{NODEKEY}}</td>
                                <td>{{N1}}</td>
                                <td>{{N2}}</td>
                                <td>{{N3}}</td>
                                <td>{{N4}}</td>
                                <td>{{N5}}</td>
                                <td>{{N6}}</td>
                                <td>{{N7}}</td>
                                <td>{{N8}}</td>
                                <td>{{N9}}</td>
                                <td>{{N10}}</td>
                                <td>{{N11}}</td>
                                <td>{{N12}}</td>
                                <td>{{N13}}</td>
                                <td>{{N14}}</td>
                                <td>{{N15}}</td>
                                <td>{{USERID}}</td>
                                <td>{{UPDATETIME}}</td>
                            </tr>
                        </table>
                    </a>
                </div>
            </div>
            <!-- End Contact Section -->
            <!-- Footer -->
            <footer class="w3-content w3-padding-8 w3-text-grey w3-xlarge">
                <p class="w3-medium">Powered by QSI MIC</p>
                <!-- End footer -->
            </footer>
            <!-- END PAGE CONTENT -->
        </div>
        <!------------Loader/Result--------------->
        <div id="idLoader" class="w3-modal">
            <div class="w3-modal-content w3-display-middle w3-black"> <span onclick="document.getElementById('idLoader').style.display='none'" class=" w3-large w3-button w3-display-topright">&times;</span>
                <div class="w3-container w3-padding-64"> <i id="idSpinner" class="fa fa-spinner fa-pulse fa-2x fa-fw"></i> <span id="idResult" class="w3-xlarge">Loading...</span> </div>
            </div>
        </div>
        <!------------Delete Confirm--------------->
        <div id="idDeleteConfirm" class="w3-modal">
            <div class="w3-modal-content w3-display-middle w3-black"> <span onclick="document.getElementById('idDeleteConfirm').style.display='none'" class=" w3-large w3-button w3-display-topright">&times;</span>
                <div class="w3-container w3-padding-64 " style="text-align:center"> <span id="idConfirm" class="w3-xlarge"></span>
                    <br>
                    <input type="button" class="w3-button w3-dark-grey w3-margin-top" id="btnDeleteYes" value="Yes">
                    <input type="button" class="w3-button w3-dark-grey w3-margin-top" id="btnDeleteNo" value="No" onclick="document.getElementById('idDeleteConfirm').style.display='none'"> </div>
            </div>
        </div>
        <!------------Update Confirm--------------->
        <div id="idDivUpdateConfirm" class="w3-modal">
            <div class="w3-modal-content w3-display-middle w3-black"> <span onclick="document.getElementById('idDivUpdateConfirm').style.display='none'" class=" w3-large w3-button w3-display-topright">&times;</span>
                <div class="w3-container w3-padding-64 " style="text-align:center"> <span id="idUpdateConfirm" class="w3-xlarge"></span>
                    <br>
                    <input type="button" class="w3-button w3-dark-grey w3-margin-top" id="btnUpdateYes" value="Yes">
                    <input type="button" class="w3-button w3-dark-grey w3-margin-top" id="btnUpdateNo" value="No" onclick="document.getElementById('idDivUpdateConfirm').style.display='none'"> </div>
            </div>
        </div>
        <div id="login-placeholder"> </div>
        <div id="report-placeholder"> </div>
    </body>

    </html>