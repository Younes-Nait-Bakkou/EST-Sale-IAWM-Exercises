<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Saisie Étudiant</title>
</head>
<body>
    <h2>Nouvel Étudiant</h2>
    
    <form action="saveStudent" method="POST">
        <label>Nom :</label> 
        <input type="text" name="nom" required> <br><br>
        
        <label>Note :</label> 
        <input type="number" name="note" step="0.5" required> <br><br>
        
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
