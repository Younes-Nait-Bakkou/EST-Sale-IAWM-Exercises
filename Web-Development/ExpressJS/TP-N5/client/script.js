let tasks = [];

const taskInput = document.getElementById("taskInput");
const addTaskBtn = document.getElementById("addTaskBtn");
const taskList = document.getElementById("taskList");

const API_URL = "http://localhost:8000/tasks";

fetch(API_URL)
	.then((res) => res.json())
	.then((tasks_obj) => {
		tasks = tasks_obj;
		renderTasks();
	})
	.catch((err) => {
		alert("Error fetching tasks");
		console.error(err);
	});

addTaskBtn.addEventListener("click", () => {
	const title = taskInput.value.trim();

	if (!title) return;

	fetch(API_URL, {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify({ title }),
	})
		.then((res) => res.json())
		.then((task) => {
			tasks.push(task);
			renderTasks();
		})
		.catch((err) => {
			alert("Error adding task");
			console.error(err);
		});
});

function renderTasks() {
	taskList.innerHTML = "";

	tasks.forEach((task, index) => {
		const li = document.createElement("li");

		const checkbox = document.createElement("input");
		checkbox.type = "checkbox";
		checkbox.checked = task.completed;

		checkbox.addEventListener("change", () => {
			fetch(API_URL + "/" + task._id, {
				method: "PUT",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({ ...task, completed: checkbox.checked }),
			})
				.then((res) => res.json())
				.then((task) => {
					tasks[index] = { ...task, completed: checkbox.checked };
					renderTasks();
				})
				.catch((err) => {
					alert("Error updating task");
					console.error(err);
				});
		});

		const span = document.createElement("span");
		span.textContent = ` ${task.title}`;

		li.appendChild(checkbox);
		li.appendChild(span);
		taskList.appendChild(li);
	});
}
