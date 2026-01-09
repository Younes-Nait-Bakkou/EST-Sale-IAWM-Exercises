const express = require("express");
const path = require("path");

const app = express();
const PORT = 3000;

// Serve static files from public folder
app.use(express.static(path.join(__dirname, "public")));

app.set("view engine", "ejs");
app.set("views", "./views");

app.get("/", (req, res) => {
  res.send("Home page");
});

app.get("/page", (req, res) => {
  res.render("index", {
    title: "My page",
    paragraph: "My paragraph",
  });
});

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
