const Task = require("./Task.cjs");

async function getAll() {
	const tasks = await Task.find();
	return tasks;
}

async function getById(id) {
	return await Task.findOne({ _id: id });
}

async function create(task) {
	return await Task.create(task);
}

async function update(id, data) {
	return await Task.findOneAndUpdate({ _id: id }, data);
}

async function remove(id) {
	return await Task.deleteOne({ _id: id });
}

module.exports = {
	getAll,
	getById,
	create,
	update,
	remove,
};
