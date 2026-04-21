public class problem8 {
	static final class StateNode {
		String text;
		StateNode next;
		StateNode prev;

		StateNode(String text) {
			this.text = text;
		}
	}

	static final class UndoRedoTextEditor {
		private final int capacity;
		private StateNode head;
		private StateNode tail;
		private StateNode current;
		private int size;

		UndoRedoTextEditor(int capacity) {
			this.capacity = Math.max(1, capacity);
		}

		public void addTextState(String text) {
			if (current != null && current != tail) {
				truncateAfterCurrent();
			}

			StateNode node = new StateNode(text);
			if (head == null) {
				head = tail = current = node;
				size = 1;
				return;
			}

			tail.next = node;
			node.prev = tail;
			tail = node;
			current = node;
			size++;

			while (size > capacity) {
				head = head.next;
				if (head != null) {
					head.prev = null;
				}
				size--;
			}

			if (head == null) {
				head = tail = current = node;
				size = 1;
			}
		}

		public String undo() {
			if (current == null || current.prev == null) {
				return current == null ? "" : current.text;
			}
			current = current.prev;
			return current.text;
		}

		public String redo() {
			if (current == null || current.next == null) {
				return current == null ? "" : current.text;
			}
			current = current.next;
			return current.text;
		}

		public String currentState() {
			return current == null ? "" : current.text;
		}

		private void truncateAfterCurrent() {
			StateNode node = current.next;
			current.next = null;
			tail = current;
			while (node != null) {
				StateNode next = node.next;
				node.prev = null;
				node.next = null;
				node = next;
				size--;
			}
		}
	}
}