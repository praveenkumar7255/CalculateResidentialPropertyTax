<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Residential Property Tax</title>
</head>
    
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
        .button-pay-tax {
            padding: 10px;
            margin-right: 110px;
            border: none;
            cursor: pointer;
        }

        .button-cancel {
            background-color: blue;
            color: white;
        }

        .button-pay-tax {
            background-color: blue;
            color: white;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Self Assessment of Property Tax Form</h1>

        <form:form modelAttribute="residentialPropertyRequestPayload" method="post" action="/propertyTax/submit">

            <div class="form-row">
                <label class="form-label" for="assessmentYear">Assessment Year:</label>
                <div class="form-input">
                    <input type="text" id="assessmentYear" name="assessmentYear" style="width: 40%;"><br>
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="ownerName">Owner Name:</label>
                <div class="form-input">
                    <input type="text" id="ownerName" name="ownerName" style="width: 60%;"><br>
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="email">Email:</label>
                <div class="form-input">
                            <input type="text" id="email" name="email" style="width: 70%;"><br>
                </div>
            </div>

            <div class="form-row">
    <label class="form-label" for="address">Address:</label>
    <div class="form-input">
                <textarea id="address" name="address" rows="4" style="width: 80%;"></textarea>
    </div>
</div>            
            
                    <div class="form-row">
                <label class="form-label" for="zonalClassification">Zonal Classification:</label>
                <div class="form-input">
                    <select id="zonalClassification" name="zonalClassification" style="width: 20%;">
                        <option value="Zone A">Zone A</option>
                        <option value="Zone B">Zone B</option>
                        <option value="Zone C">Zone C</option>
                    </select>
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="description">Description:</label>
                <div class="form-input">
                <select id="description" name="description" style="width: 100%;">
                        <option value="RCC buildings">RCC buildings</option>
                        <option value="RCC buildings with cement or red-oxide flooring">RCC buildings with cement or red-oxide flooring</option>
                        <option value="Tiled/Sheet of all kinds">Tiled/Sheet of all kinds</option>
                    </select>
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="status">Status:</label>
                <div class="form-input">
                <select id="status" name="status" style="width: 20%;">
                        <option value="Tenanted">Tenanted</option>
                        <option value="Owner">Owner</option>
                        </Select>             
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="constructedYear">Constructed Year:</label>
                <div class="form-input">
                             <input type="text" id="constructedYear" name="constructedYear" style="width: 40%;"><br>
                     
                </div>
            </div>

            <div class="form-row">
                <label class="form-label" for="builtUpArea">Built-up Area:</label>
                <div class="form-input">
                            <input type="text" id="builtUpArea" name="builtUpArea" style="width: 40%;"><br>
                    
                </div>
            </div>
            
            <div class="form-row">
                <label class="form-label" for="totalPropertyTax">Total Tax Payable:</label>
                <div class="form-input">
                            <textarea id="totalPropertyTax" name="totalPropertyTax" rows="2" style="width: 40%;"></textarea>
                    
                </div>
            </div>

            <div class="form-buttons">
                <button type="button" class="button-cancel" onClick="cancelButton()">Cancel</button>
                <input type="submit" class="button-pay-tax" value="Pay Tax" onClick="onSubmitForm()" />
            </div>
        </form:form>
    </div>

   <script>
        
        function cancelButton() {
    window.location.href = "/propertyTax/home";
}
        
        function getAndValidateInputValue(inputId) {
    var input = document.getElementById(inputId);

    if (!input) {
        alert("Error accessing form field. Please try again.");
        return null;
    }

    var value = String(input.value).trim();

    if (!value) {
        alert("Please fill in all required fields.");
        return null;
    }

    return value;
}
        
    function onSubmitForm() {
    
     // Get and validate input values
    var assessmentYear = getAndValidateInputValue("assessmentYear");
    var ownerName = getAndValidateInputValue("ownerName");
    var email = getAndValidateInputValue("email");
    var address = getAndValidateInputValue("address");
    var zonalClassification = getAndValidateInputValue("zonalClassification");
    var description = getAndValidateInputValue("description");
    var status = getAndValidateInputValue("status");
    var constructedYear = getAndValidateInputValue("constructedYear");
    var builtUpArea = getAndValidateInputValue("builtUpArea");

    // If any validation failed, stop form submission
    if (assessmentYear === null || ownerName === null || email === null ||
        address === null || zonalClassification === null || description === null ||
        status === null || constructedYear === null || builtUpArea === null) {
        return;
    }

    // Data dynamically extracted from the form
    var dataToSend = {
        "assessmentYear": assessmentYear,
        "ownerName": ownerName,
        "email": email,
        "address": address,
        "zonalClassification": zonalClassification,
        "description": description,
        "status": status,
        "constructedYear": constructedYear,
        "builtUpArea": builtUpArea
    };

    var xhr = new XMLHttpRequest();
    var url = 'http://localhost:8080/propertyTax/submit';

    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/json');

      xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                alert("Form submitted successfully!");

                try {
                    var response = JSON.parse(xhr.responseText);

                    if (typeof response === 'object' && 'totalPropertyTax' in response) {
                        var totalPropertyTax = response.totalPropertyTax;
                        document.getElementById("totalPropertyTax").value = totalPropertyTax;
                    } else if (typeof response === 'number') {
                        document.getElementById("totalPropertyTax").value = response;
                    } else {
                        console.error("Invalid response format. 'totalPropertyTax' not found.");
                    }

                } catch (error) {
                    console.error("Error parsing response:", error);
                }
            } else {
                alert("Error submitting form. Please try again.");
            }
        }
    };

    xhr.send(JSON.stringify(dataToSend));
}
       
    </script>
    </body>
    
</html>
