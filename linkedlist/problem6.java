public class problem6 {
	static final class ProcessNode {
		int processId;
		int burstTime;
		int priority;
		int remainingTime;
		int completionTime;
		ProcessNode next;

		ProcessNode(int processId, int burstTime, int priority) {
			this.processId = processId;
			this.burstTime = burstTime;
			this.priority = priority;
			this.remainingTime = burstTime;
		}

		@Override
		public String toString() {
			return processId + " | " + burstTime + " | " + remainingTime + " | " + priority;
		}
	}

	static final class SimulationResult {
		double averageWaitingTime;
		double averageTurnaroundTime;
		String log;

		SimulationResult(double averageWaitingTime, double averageTurnaroundTime, String log) {
			this.averageWaitingTime = averageWaitingTime;
			this.averageTurnaroundTime = averageTurnaroundTime;
			this.log = log;
		}
	}

	static final class RoundRobinScheduler {
		private ProcessNode head;

		public void addProcessAtEnd(int processId, int burstTime, int priority) {
			ProcessNode node = new ProcessNode(processId, burstTime, priority);
			if (head == null) {
				head = node;
				node.next = node;
				return;
			}
			ProcessNode tail = getTail();
			tail.next = node;
			node.next = head;
		}

		public boolean removeProcessById(int processId) {
			if (head == null) {
				return false;
			}
			ProcessNode prev = getTail();
			ProcessNode current = head;
			do {
				if (current.processId == processId) {
					if (current == head && current.next == head) {
						head = null;
						return true;
					}
					prev.next = current.next;
					if (current == head) {
						head = current.next;
					}
					return true;
				}
				prev = current;
				current = current.next;
			} while (current != head);
			return false;
		}

		public String displayProcesses() {
			if (head == null) {
				return "No processes";
			}
			StringBuilder builder = new StringBuilder();
			ProcessNode node = head;
			do {
				builder.append(node).append(System.lineSeparator());
				node = node.next;
			} while (node != head);
			return builder.toString().trim();
		}

		public SimulationResult simulateRoundRobin(int quantum) {
			if (head == null || quantum <= 0) {
				return new SimulationResult(0.0, 0.0, "No execution");
			}

			StringBuilder log = new StringBuilder();
			int time = 0;
			int completed = 0;
			int totalWaiting = 0;
			int totalTurnaround = 0;
			ProcessNode current = head;

			while (head != null) {
				ProcessNode process = current;
				ProcessNode next = current.next;
				int executed = Math.min(quantum, process.remainingTime);
				time += executed;
				process.remainingTime -= executed;
				log.append("Executed P").append(process.processId)
					.append(" for ").append(executed)
					.append(" | time=").append(time)
					.append(System.lineSeparator());

				if (process.remainingTime == 0) {
					process.completionTime = time;
					totalTurnaround += process.completionTime;
					totalWaiting += process.completionTime - process.burstTime;
					completed++;
					removeProcessById(process.processId);
				}

				log.append(displayProcesses()).append(System.lineSeparator());
				if (head == null) {
					break;
				}
				current = next;
				if (!contains(current)) {
					current = head;
				}
			}

			double averageWaiting = completed == 0 ? 0.0 : (double) totalWaiting / completed;
			double averageTurnaround = completed == 0 ? 0.0 : (double) totalTurnaround / completed;
			return new SimulationResult(averageWaiting, averageTurnaround, log.toString().trim());
		}

		private boolean contains(ProcessNode node) {
			if (head == null || node == null) {
				return false;
			}
			ProcessNode current = head;
			do {
				if (current == node) {
					return true;
				}
				current = current.next;
			} while (current != head);
			return false;
		}

		private ProcessNode getTail() {
			if (head == null) {
				return null;
			}
			ProcessNode node = head;
			while (node.next != head) {
				node = node.next;
			}
			return node;
		}
	}
}