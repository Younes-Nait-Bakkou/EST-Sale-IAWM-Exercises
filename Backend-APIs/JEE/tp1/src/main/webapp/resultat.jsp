<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Résultat</title>
    </head>

    <%
        double a=0, b=0, c=0;

        String color="white", msg="" ;

        try{

            String aStr = request.getParameter("a");
            String bStr = request.getParameter("b");
            String cStr = request.getParameter("c");

            if (aStr != null){
                a = Double.parseDouble(aStr);
                b = Double.parseDouble(bStr);
                c = Double.parseDouble(cStr);


                double delta = (b * b) - (4 * a * c);

                if (delta < 0 ){
                    color = "red";
                    msg = "Delta (" + delta + "), pas de solution reelle";
                } else if (delta == 0){
                    color = "white";
                    double x = -b / (2 * a);
                    msg = "Delta est nul. Une solution unique : x " + x;
                    
                } else {
                    color = "lightgreen";
                    double x1 = (-b - Math.sqrt(delta)) / (2*a);
                    double x2 = (-b + Math.sqrt(delta)) / (2*a);

                    msg = "Delta (" + delta + ") > 0. Deux solutions : <br>" +
                              "x1 = " + x1 + "<br>" +
                              "x2 = " + x2;
                }
            } 
        } catch (Exception e) {
            msg = "Erreur : " + e.getMessage();

        }
    %>

    <body style="background-color: <%= color %>;">
        <h2> Resultat </h2>
        <div style="background: white; padding: 20px; border: 1px solid black; display: inline-block;">
            <p> <%= msg %> </p>
        </div>

        <br><br>
        <a href="index.html">Recommencer</a>

    </body>
</html>
