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
        <script src="javascripts/report_07.js"></script>
        <script src="javascripts/Login.js"></script>
        <script src="javascripts/jquery.cookie.js"></script>
        <script src="javascripts/jquery.validate.min.js"></script>
        <!-- Icon Bar (Sidebar - hidden on small screens) -->
        <div id="nav-placeholder"> </div>
        <!-- Page Content -->
        <div class="w3-padding-large" id="main">
            <!-- Header/Home -->
            <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
                <h1 class="w3-xxlarge">Get Weight Data By WO and Station</h1>
                <p></p>
            </header>
            <!-- Contact Section -->
            <!--        <div class="w3-padding-16 w3-col l6 m8">-->
            <form id="idForm">
                <div class="w3-row-padding" style="margin:8px -16px;">
                    <div class="w3-quarter w3-margin-bottom">
                        <label> WO:</label>
                        <input class="w3-input w3-border" type="text" name="WO" required> </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label>Station:</label>
                        <select id="idStationList" class="w3-input w3-border" name="Station" required>
                            <option></option>
                            <option w3-repeat="stationList">{{OPERATION}}</option>
                        </select>
                    </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label> SKU:</label>
                        <input class="w3-input w3-border" type="text" name="SKU" required> </div>
                    <div class="w3-quarter">
                        <label> SN:</label>
                        <input class="w3-input w3-border" type="text" name="SN" required> </div>
                </div>
                <input type="button" class="Report w3-button w3-dark-grey" id="btnSearch" value="Select">
                <input type="button" class="Report w3-button w3-dark-grey" id="btnClear" value="Clear"> </form>
            <div id="idTable">
                <h2 class="w3-text-light-grey">Result:</h2>
                <hr style="width:200px" class="w3-opacity">
                <div class="clsStations w3-section w3-responsive" id="idDivStations">
                    <a href="#idForm">
                        <table class="w3-table-all w3-light-grey w3-hoverable" id="idStations2">
                            <tr class="w3-large">
                                <th onclick="sortTable(0)">SN</th>
                                <th onclick="sortTable(1)">SKU</th>
                                <th onclick="sortTable(2)">BILL_NO</th>
                                <th onclick="sortTable(3)">STATION_CODE</th>
                                <th onclick="sortTable(4)">PRODUCT_LEVEL</th>
                                <th onclick="sortTable(5)">PARAMETER</th>
                                <th onclick="sortTable(6)">VALUE</th>
                                <th onclick="sortTable(7)">UPDATETIME</th>
                            </tr>
                            <tr class="w3-medium" w3-repeat="stations">
                                <td>{{SN}}</td>
                                <td>{{SKU}}</td>
                                <td>{{BILL_NO}}</td>
                                <td>{{STATION_CODE}}</td>
                                <td>{{PRODUCT_LEVEL}}</td>
                                <td>{{PARAMETER}}</td>
                                <td>{{VALUE}}</td>
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
        <div id="login-placeholder"> </div>
        <div id="report-placeholder"> </div>
    </body>

    </html>