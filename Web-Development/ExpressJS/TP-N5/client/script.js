let tasks = [];

const taskInput = document.getElementById("taskInput");
const addTaskBtn = document.getElementById("addTaskBtn");
const taskList = document.getElementById("taskList");

const API_URL = "http://localhost:3000/tasks";

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
			fetch(API_URL + "/" + index, {
				method: "PUT",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({ completed: checkbox.checked }),
			})
				.then((res) => res.json())
				.then((task) => {
					tasks[index] = task;
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
