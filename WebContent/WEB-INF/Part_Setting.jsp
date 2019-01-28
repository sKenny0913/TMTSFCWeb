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
        <script src="javascripts/Part_setting.js"></script>
        <script src="javascripts/Login.js"></script>
        <script src="javascripts/jquery.cookie.js"></script>
        <script src="javascripts/jquery.validate.min.js"></script>
        <!-- Icon Bar (Sidebar - hidden on small screens) -->
        <div id="nav-placeholder"> </div>
        <!-- Page Content -->
        <div class="w3-padding-large" id="main">
            <!-- Header/Home -->
            <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
                <h1 class="w3-jumbo">Part Setting</h1>
                <p></p>
            </header>
            <!-- Contact Section -->
            <!--        <div class="w3-padding-16 w3-col l6 m8">-->
            <form id="idForm">
                <div class="w3-row-padding" style="margin:8px -16px;">
                    <div class="w3-quarter w3-margin-bottom">
                        <label> Part No.:</label>
                        <input class="w3-input w3-border" type="text" name="PartNo" readonly> </div>
                    <div class="w3-quarter">
                        <label> Capacity:</label>
                        <input class="w3-input w3-border" type="text" name="Capacity" required> </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label> Year:</label>
                        <input class="w3-input w3-border" type="text" name="Year" required> </div>
                </div>
                <input type="button" class="Part w3-button w3-dark-grey" id="btnSearch" name='button' value="Select">
                <input type="button" class="Part w3-button w3-dark-grey" id="btnUpdate" value="Update" name='button'>
                <input type="button" class="Part w3-button w3-dark-grey" id="btnClear" value="Clear" name='button'> </form>
            <div id="idTable">
                <h2 class="w3-text-light-grey">Result:</h2>
                <hr style="width:200px" class="w3-opacity">
                <div class="clsStations w3-section w3-responsive" id="idDivStations">
                    <a href="#idForm">
                        <table class="w3-table-all w3-light-grey w3-hoverable" id="idStations2">
                            <tr class="w3-large">
                                <th onclick="sortTable(0)">Part_No</th>
                                <th onclick="sortTable(1)">Capacity</th>
                                <th onclick="sortTable(2)">Year</th>
                            </tr>
                            <tr class="w3-medium" w3-repeat="stations">
                                <td>{{PART_NO}}</td>
                                <td>{{HDD_VALUE}}</td>
                                <td>{{YEAR_LIMITATION}}</td>
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