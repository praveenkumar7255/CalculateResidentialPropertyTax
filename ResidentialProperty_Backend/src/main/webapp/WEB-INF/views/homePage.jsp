<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
    
            .form-container {
            max-width: 600px;
            margin: 0 auto;
        }
        body {
            font-family: Arial, sans-serif;
        }
                h1 {
            font-family: 'Helvetica', sans-serif;
            font-size: 40px;
        }
        
               ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        li {
            margin-bottom: 15px;
        }

        li a {
            text-decoration: none; 
            font-size: 25px; 
            color: #3366cc; 
        }
        </style>
</head>
<body>
 <div class="form-container">
    <h1>Welcome to the Home Page</h1>
    <br>

    <ul>
        <li><a href="/propertyTax/selfAssessmentForm">a) Self-Assessment Form</a></li>
        <br>
        <li><a href="/propertyTax/zonalReport">b) Zonal-wise Report</a></li>
    </ul>
    </div>
</body>
</html>