<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Success</title>

    <style>
        /* Reset margins and padding */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Style the body */
        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f0f0f0; /* Light background */
            font-family: Arial, sans-serif;
        }

        /* Container for message and button */
        .container {
            text-align: center;
            background-color: #ecf0f1;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        /* Success message styling */
        h1 {
            color: #27ae60; /* Green color for success */
            margin-bottom: 20px;
        }

        /* View Cars button styling */
        a {
            display: inline-block;
            text-decoration: none;
            background-color: #3498db; /* Blue button */
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
        }

        /* Hover effect for the button */
        a:hover {
            background-color: #2980b9; /* Darker blue */
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Login Successful</h1>
        <a href="ViewCars">View Car Details</a>
    </div>

</body>
</html>
