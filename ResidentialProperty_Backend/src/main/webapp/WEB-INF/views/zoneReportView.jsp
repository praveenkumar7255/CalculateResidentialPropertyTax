<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zonal-wise Report</title>
    <style>
        .form-container {
            max-width: 600px;
            margin: 0 auto;
        }

        .form-row {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }

        .form-label {
            flex: 1;
            text-align: right;
            padding-right: 30px;
        }

        .form-input {
            flex: 2;
        }

        .form-buttons {
            margin-top: 15px;
            text-align: center;
        }

        .button-cancel,
        .button-report {
            padding: 10px;
            margin-right: 110px;
            border: none;
            cursor: pointer;
        }

        .button-cancel {
            background-color: blue;
            color: white;
        }

        .button-report {
            background-color: blue;
            color: white;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Zonal-wise Report</h1>

        <form id="reportForm" method="get">

            <div class="form-row">
                <label class="form-label" for="assessmentYear">Assessment Year:</label>
                <div class="form-input">
                    <input type="text" id="assessmentYear" name="assessmentYear" style="width: 40%;" required><br>
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="zonalClassification">Zonal Classification:</label>
                <div class="form-input">
                    <select id="zonalClassification" name="zonalClassification" style="width: 20%;" required>
                        <option value="Zone A">Zone A</option>
                        <option value="Zone B">Zone B</option>
                        <option value="Zone C">Zone C</option>
                    </select>
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="status">Status:</label>
                <div class="form-input">
                    <select id="status" name="status" style="width: 20%;" required>
                        <option value="Tenanted">Tenanted</option>
                        <option value="Owner">Owner</option>
                    </select>             
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="calculatedValue">Report Calculated Value:</label>
                <div class="form-input">
                    <input type="text" id="calculatedValue" name="calculatedValue" style="width: 40%;" readonly>
                </div>
            </div>

            <div class="form-buttons">
                <button type="button" class="button-cancel" onClick="cancelButton()">Cancel</button>
                <button type="button" class="button-report" onClick="reportButton()">Report</button>
            </div>
        </form>
    </div>

    <script>
    function cancelButton() {
        window.location.href = "/propertyTax/home";
    }

    function reportButton() {

        var form = document.getElementById("reportForm");
        var formData = new FormData(form);

        var url = "/propertyTax/total_amount?" + new URLSearchParams(formData).toString();

        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.text();
            })
            .then(data => {
                document.getElementById('calculatedValue').value = data;
            })
            .catch(error => {
                console.error("Error fetching data:", error);
            });
    }
</script>
    
</body>
</html>
