const express = require("express");
const path = require("path");

const app = express();
const PORT = 3000;

// Serve static files from public folder
app.use(express.static(path.join(__dirname, "public")));

app.get("/page1", (req, res) => {
	res.sendFile(path.join(__dirname, "public", "page1.html"));
});

app.get("/bonjour", (req, res) => {
	res.type("html");
	res.send("<h1>Bonjour Servlet</h1>");
});

app.get("/table/:n/:m", (req, res) => {
	const n = parseInt(req.params.n, 10);
	const m = parseInt(req.params.m, 10);

	let html = '<table border="1">';
	for (let i = 0; i < n; i++) {
		html += "<tr>";
		for (let j = 0; j < m; j++) {
			html += `<td>${i},${j}</td>`;
		}
		html += `</tr>`;
	}
	html += "</table>";
	res.send(html);
});

app.get("/date", (req, res) => {
	const now = new Date();
	res.send(`<p>Nous sommes le ${now.toLocaleDateString()} à ${now.toLocaleTimeString()}</p>`);
});

app.get("/messages", (req, res) => {
	res.send("<p>Ligne 1 : Bonjour !</p><p>Ligne 2 : Bienvenue sur notre site.</p>");
});

app.get("/moyennes", (req, res) => {
	const n = 5;
	const students = [];

	for (let i = 1; i <= n; i++) {
		const moyenne = Math.round(Math.random() * 20);
		students.push({ nom: "Etudiant " + i, moyenne });
	}

	let html = "<ul>";

	for (const s of students) {
		html += `<li>${s.nom} : ${s.moyenne}/20</li>`;
	}

	html += "</ul>";

	res.send(html);
});

app.listen(PORT, () => {
	console.log(`Server is running on port ${PORT}`);
});
