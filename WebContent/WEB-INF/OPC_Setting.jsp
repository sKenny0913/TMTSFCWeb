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
        <script src="javascripts/OPC_setting.js"></script>
        <script src="javascripts/Login.js"></script>
        <script src="javascripts/jquery.cookie.js"></script>
        <script src="javascripts/jquery.validate.min.js"></script>
        <!-- Icon Bar (Sidebar - hidden on small screens) -->
        <div id="nav-placeholder"> </div>
        <!-- Page Content -->
        <div class="w3-padding-large" id="main">
            <!-- Header/Home -->
            <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
                <h1 class="w3-jumbo">OPC Setting</h1>
                <p></p>
            </header>
            <!-- Contact Section -->
            <!--        <div class="w3-padding-16 w3-col l6 m8">-->
            <form id="idForm">
                <div class="w3-row-padding" style="margin:8px -16px;">
                    <div class="w3-half w3-margin-bottom">
                        <label> Node:</label>
                        <input class="w3-input w3-border" type="text" name="NodeName" required> </div>
                    <div class="w3-half">
                        <label>Data type:</label>
                        <select id="idDataType" class="w3-input w3-border" required>
                            <option></option>
                            <option value="uint">Unsigned integer</option>
                            <option value="string">String</option>
                            <option value="bool">Boolean</option>
                        </select>
                    </div>
                </div>
                <div class="w3-row-padding" style="margin:0 -16px;">
                    <div class="w3-half w3-margin-bottom">
                        <label> Address:</label>
                        <input class="w3-input w3-border" type="text" name="Address" required> </div>
                    <div class="w3-half">
                        <label> Description:</label>
                        <input class="w3-input w3-border" type="text" name="Desc" required> </div>
                </div>
                <input type="button" class="OPC w3-button w3-dark-grey" id="btnSearch" name='button' value="Select">
                <input type="button" class="OPC w3-button w3-dark-grey" id="btnAdd" value="Add" name='button'>
                <input type="button" class="OPC w3-button w3-dark-grey" id="btnUpdate" value="Update" name='button'>
                <input type="button" class="w3-button w3-dark-grey" id="btnDelete" value="Delete" name='button'>
                <input type="button" class="OPC w3-button w3-dark-grey" id="btnClear" value="Clear" name='button'> </form>
            <div id="idTable">
                <h2 class="w3-text-light-grey">Result:</h2>
                <hr style="width:200px" class="w3-opacity">
                <div class="clsStations w3-section w3-responsive" id="idDivStations">
                    <a href="#idForm">
                        <table class="w3-table-all w3-light-grey w3-hoverable" id="idStations2">
                            <tr class="w3-large">
                                <th onclick="sortTable(0)">OPC_NODE_SID</th>
                                <th onclick="sortTable(1)">NODE</th>
                                <th onclick="sortTable(2)">DATA_TYPE</th>
                                <th onclick="sortTable(3)">ADDRESS</th>
                                <th onclick="sortTable(4)">DESCR</th>
                                <th onclick="sortTable(5)">USERID</th>
                                <th onclick="sortTable(6)">UPDATETIME</th>
                            </tr>
                            <tr class="w3-medium" w3-repeat="stations">
                                <td>{{OPC_NODE_SID}}</td>
                                <td>{{NODE}}</td>
                                <td>{{DATA_TYPE}}</td>
                                <td>{{ADDRESS}}</td>
                                <td>{{DESCR}}</td>
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
                    <input type="button" class="w3-button w3-dark-grey w3-margin-top" id="btnYes" value="Yes">
                    <input type="button" class="w3-button w3-dark-grey w3-margin-top" id="btnNo" value="No" onclick="document.getElementById('idDeleteConfirm').style.display='none'"> </div>
            </div>
        </div>
        <div id="login-placeholder"> </div>
        <div id="report-placeholder"> </div>
    </body>

    </html>