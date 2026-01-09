const express = require("express");
const router = express.Router();
const taskCtrl = require("../controllers/taskController.cjs");

router.get("/", taskCtrl.taskList);
router.get("/:id", taskCtrl.taskById);
router.post("/", taskCtrl.taskCreate);
router.put("/:id", taskCtrl.taskUpdate);
router.delete("/:id", taskCtrl.taskDelete);

module.exports = router;
