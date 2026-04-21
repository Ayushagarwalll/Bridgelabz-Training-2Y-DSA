
public class problem1 {
	static final class StudentNode {
		int rollNumber;
		String name;
		int age;
		String grade;
		StudentNode next;

		StudentNode(int rollNumber, String name, int age, String grade) {
			this.rollNumber = rollNumber;
			this.name = name;
			this.age = age;
			this.grade = grade;
		}

		@Override
		public String toString() {
			return rollNumber + " | " + name + " | " + age + " | " + grade;
		}
	}

	static final class StudentList {
		private StudentNode head;

		public void addFirst(int rollNumber, String name, int age, String grade) {
			StudentNode node = new StudentNode(rollNumber, name, age, grade);
			node.next = head;
			head = node;
		}

		public void addLast(int rollNumber, String name, int age, String grade) {
			StudentNode node = new StudentNode(rollNumber, name, age, grade);
			if (head == null) {
				head = node;
				return;
			}
			StudentNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}

		public boolean addAtPosition(int position, int rollNumber, String name, int age, String grade) {
			if (position <= 1 || head == null) {
				addFirst(rollNumber, name, age, grade);
				return true;
			}
			StudentNode current = head;
			for (int index = 1; index < position - 1 && current.next != null; index++) {
				current = current.next;
			}
			StudentNode node = new StudentNode(rollNumber, name, age, grade);
			node.next = current.next;
			current.next = node;
			return true;
		}

		public boolean deleteByRollNumber(int rollNumber) {
			if (head == null) {
				return false;
			}
			if (head.rollNumber == rollNumber) {
				head = head.next;
				return true;
			}
			StudentNode current = head;
			while (current.next != null && current.next.rollNumber != rollNumber) {
				current = current.next;
			}
			if (current.next == null) {
				return false;
			}
			current.next = current.next.next;
			return true;
		}

		public StudentNode searchByRollNumber(int rollNumber) {
			StudentNode current = head;
			while (current != null) {
				if (current.rollNumber == rollNumber) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		public boolean updateGrade(int rollNumber, String newGrade) {
			StudentNode node = searchByRollNumber(rollNumber);
			if (node == null) {
				return false;
			}
			node.grade = newGrade;
			return true;
		}

		public String displayAll() {
			StringBuilder builder = new StringBuilder();
			StudentNode current = head;
			while (current != null) {
				builder.append(current).append(System.lineSeparator());
				current = current.next;
			}
			return builder.length() == 0 ? "No student records" : builder.toString().trim();
		}
	}
}
