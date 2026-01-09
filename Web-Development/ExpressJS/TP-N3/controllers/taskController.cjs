const Task = require("../models/taskModel.cjs");

function valider(data) {
	if (!data) {
		return "Les données sont requises";
	}

	if (typeof data !== "object") {
		return "Les données doivent être un objet";
	}

	if (!data.title || typeof data.title !== "string") {
		return "Le champ 'title' est requis et doit être une chaîne de caractères";
	}

	if (data.completed === undefined || typeof data.completed !== "boolean") {
		return "Le champ 'completed' doit être un booléen (true/false)";
	}

	return null;
}

function taskList(req, res) {
	Task.getAll()
		.then((tasks) => {
			if (!tasks) {
				return next({ status: 404, message: "Tâches non trouvées" });
			}

			return res.json(tasks);
		})
		.catch((err) => next(err));
}

function taskById(req, res, next) {
	const id = req.params.id;

	const task = Task.getById(id).then((task) => {
		if (!task) {
			return next({ status: 404, message: "Tâche non trouvée" });
		}

		return res.json(task);
	});
}

function taskCreate(req, res, next) {
	const errMsg = valider(req.body);

	if (errMsg) {
		return next({ status: 400, message: errMsg });
	}

	const newTask = Task.create({
		title: req.body.title,
		completed: req.body.completed,
	})
		.then((task) => {
			return res.status(201).json(task);
		})
		.catch((err) => next(err));
}

function taskUpdate(req, res, next) {
	const id = req.params.id;
	const errMsg = valider(req.body);

	if (errMsg) {
		return next({ status: 400, message: errMsg });
	}

	const updated = Task.update(id, {
		title: req.body.title,
		completed: req.body.completed,
	})
		.then((task) => {
			return res.status(200).json(task);
		})
		.catch((err) => next(err));
}

function taskDelete(req, res, next) {
	const id = req.params.id;

	const ok = Task.remove(id)
		.then((ok) => {
			if (!ok) {
				return next({ status: 404, message: "Tâche non trouvée" });
			}

			return res.status(204).end();
		})
		.catch((err) => next(err));
}

module.exports = {
	taskList,
	taskById,
	taskCreate,
	taskUpdate,
	taskDelete,
};
