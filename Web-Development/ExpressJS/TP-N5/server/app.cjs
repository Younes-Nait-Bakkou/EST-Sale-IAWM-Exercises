const express = require("express");
const path = require("path");
const cors = require("cors");

const app = express();
const PORT = 8000;

app.use(
	cors({
		origin: "http://127.0.0.1:8080",
	})
);

const mongoose = require("mongoose");

mongoose
	.connect("mongodb://localhost:27017/TP3")
	.then(() => {
		console.log("Connected to MongoDB");
	})
	.catch((err) => {
		console.error(err);
	});

const taskRoutes = require("./routes/taskRouters.cjs");

app.use(express.json());

app.use("/tasks", taskRoutes);

app.use((err, req, res, next) => {
	console.error(err);

	const status = err.status || 500;
	const message = err.message || "Erreur interne du serveur";

	res.status(status).json({ erreur: message });
});

app.listen(PORT, () => {
	console.log(`Server is running on port ${PORT}`);
});
