<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <body>
        <h2> Calcul la norme </h2>

        <jsp:useBean id="monPoint" class="com.est.sale.beans.Point" scope="page" />

        <jsp:setProperty name="monPoint" property="x" value="10.50" />
        <jsp:setProperty name="monPoint" property="y" value="20.22" />

        <p>
            X = <jsp:getProperty name="monPoint" property="x" />
            Y = <jsp:getProperty name="monPoint" property="y" />

            Resultat
            norme = <jsp:getProperty name="monPoint" property="norme"/>

        </p>
    </body>
</html>
