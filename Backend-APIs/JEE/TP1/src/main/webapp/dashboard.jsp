<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Old School Dashboard</title>
        <style>
            body {
                font-family: monospace;
                background: #222;
                color: #0f0;
                padding: 20px;
            }
            .card {
                border: 1px solid #444;
                padding: 15px;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <h1>System Dashboard</h1>
        <% %>

        <div class="card">
            <% String user = "Admin"; java.util.Date now = new java.util.Date(); %>

            <p>User: <strong><%= user %></strong></p>
            <p>Server Time: <%= now %></p>
        </div>

        <div class="card">
            <h3>Dynamic Message</h3>
            <p>
                Message from Servlet:
                <span style="color: yellow"> <%= request.getAttribute("secretMessage") %> </span>
            </p>
        </div>
    </body>
</html>
