public class problem3 {
	static final class TaskNode {
		int taskId;
		String taskName;
		int priority;
		String dueDate;
		TaskNode next;

		TaskNode(int taskId, String taskName, int priority, String dueDate) {
			this.taskId = taskId;
			this.taskName = taskName;
			this.priority = priority;
			this.dueDate = dueDate;
		}

		@Override
		public String toString() {
			return taskId + " | " + taskName + " | " + priority + " | " + dueDate;
		}
	}

	static final class CircularTaskScheduler {
		private TaskNode head;
		private TaskNode current;

		public void addFirst(int taskId, String taskName, int priority, String dueDate) {
			TaskNode node = new TaskNode(taskId, taskName, priority, dueDate);
			if (head == null) {
				head = current = node;
				node.next = node;
				return;
			}
			TaskNode tail = getTail();
			node.next = head;
			head = node;
			tail.next = head;
		}

		public void addLast(int taskId, String taskName, int priority, String dueDate) {
			TaskNode node = new TaskNode(taskId, taskName, priority, dueDate);
			if (head == null) {
				head = current = node;
				node.next = node;
				return;
			}
			TaskNode tail = getTail();
			tail.next = node;
			node.next = head;
		}

		public boolean addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
			if (position <= 1 || head == null) {
				addFirst(taskId, taskName, priority, dueDate);
				return true;
			}
			TaskNode currentNode = head;
			for (int index = 1; index < position - 1 && currentNode.next != head; index++) {
				currentNode = currentNode.next;
			}
			if (currentNode.next == head) {
				addLast(taskId, taskName, priority, dueDate);
				return true;
			}
			TaskNode node = new TaskNode(taskId, taskName, priority, dueDate);
			node.next = currentNode.next;
			currentNode.next = node;
			return true;
		}

		public boolean removeByTaskId(int taskId) {
			if (head == null) {
				return false;
			}
			TaskNode prev = getTail();
			TaskNode node = head;
			do {
				if (node.taskId == taskId) {
					if (node == head && node.next == head) {
						head = current = null;
						return true;
					}
					prev.next = node.next;
					if (node == head) {
						head = node.next;
					}
					if (node == current) {
						current = node.next;
					}
					return true;
				}
				prev = node;
				node = node.next;
			} while (node != head);
			return false;
		}

		public String viewCurrentTask() {
			return current == null ? "No task" : current.toString();
		}

		public String moveToNextTask() {
			if (current == null) {
				return "No task";
			}
			current = current.next;
			return current.toString();
		}

		public String displayAllTasks() {
			if (head == null) {
				return "No task records";
			}
			StringBuilder builder = new StringBuilder();
			TaskNode node = head;
			do {
				builder.append(node).append(System.lineSeparator());
				node = node.next;
			} while (node != head);
			return builder.toString().trim();
		}

		public java.util.List<TaskNode> searchByPriority(int priority) {
			java.util.List<TaskNode> matches = new java.util.ArrayList<>();
			if (head == null) {
				return matches;
			}
			TaskNode node = head;
			do {
				if (node.priority == priority) {
					matches.add(node);
				}
				node = node.next;
			} while (node != head);
			return matches;
		}

		private TaskNode getTail() {
			if (head == null) {
				return null;
			}
			TaskNode node = head;
			while (node.next != head) {
				node = node.next;
			}
			return node;
		}
	}
}