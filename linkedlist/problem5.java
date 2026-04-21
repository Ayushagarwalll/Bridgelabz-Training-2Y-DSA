public class problem5 {
	static final class BookNode {
		String bookTitle;
		String author;
		String genre;
		int bookId;
		boolean available;
		BookNode next;
		BookNode prev;

		BookNode(String bookTitle, String author, String genre, int bookId, boolean available) {
			this.bookTitle = bookTitle;
			this.author = author;
			this.genre = genre;
			this.bookId = bookId;
			this.available = available;
		}

		@Override
		public String toString() {
			return bookId + " | " + bookTitle + " | " + author + " | " + genre + " | " + available;
		}
	}

	static final class LibraryList {
		private BookNode head;
		private BookNode tail;

		public void addFirst(String bookTitle, String author, String genre, int bookId, boolean available) {
			BookNode node = new BookNode(bookTitle, author, genre, bookId, available);
			if (head == null) {
				head = tail = node;
				return;
			}
			node.next = head;
			head.prev = node;
			head = node;
		}

		public void addLast(String bookTitle, String author, String genre, int bookId, boolean available) {
			BookNode node = new BookNode(bookTitle, author, genre, bookId, available);
			if (head == null) {
				head = tail = node;
				return;
			}
			tail.next = node;
			node.prev = tail;
			tail = node;
		}

		public boolean addAtPosition(int position, String bookTitle, String author, String genre, int bookId, boolean available) {
			if (position <= 1 || head == null) {
				addFirst(bookTitle, author, genre, bookId, available);
				return true;
			}
			BookNode current = head;
			for (int index = 1; index < position - 1 && current.next != null; index++) {
				current = current.next;
			}
			if (current.next == null) {
				addLast(bookTitle, author, genre, bookId, available);
				return true;
			}
			BookNode node = new BookNode(bookTitle, author, genre, bookId, available);
			node.next = current.next;
			node.prev = current;
			current.next.prev = node;
			current.next = node;
			return true;
		}

		public boolean removeByBookId(int bookId) {
			BookNode node = searchByBookId(bookId);
			if (node == null) {
				return false;
			}
			if (node.prev != null) {
				node.prev.next = node.next;
			} else {
				head = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			} else {
				tail = node.prev;
			}
			return true;
		}

		public BookNode searchByBookTitle(String bookTitle) {
			BookNode current = head;
			while (current != null) {
				if (current.bookTitle.equalsIgnoreCase(bookTitle)) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		public BookNode searchByAuthor(String author) {
			BookNode current = head;
			while (current != null) {
				if (current.author.equalsIgnoreCase(author)) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		public boolean updateAvailability(int bookId, boolean available) {
			BookNode node = searchByBookId(bookId);
			if (node == null) {
				return false;
			}
			node.available = available;
			return true;
		}

		public String displayForward() {
			StringBuilder builder = new StringBuilder();
			BookNode current = head;
			while (current != null) {
				builder.append(current).append(System.lineSeparator());
				current = current.next;
			}
			return builder.length() == 0 ? "No book records" : builder.toString().trim();
		}

		public String displayReverse() {
			StringBuilder builder = new StringBuilder();
			BookNode current = tail;
			while (current != null) {
				builder.append(current).append(System.lineSeparator());
				current = current.prev;
			}
			return builder.length() == 0 ? "No book records" : builder.toString().trim();
		}

		public int countBooks() {
			int count = 0;
			BookNode current = head;
			while (current != null) {
				count++;
				current = current.next;
			}
			return count;
		}

		private BookNode searchByBookId(int bookId) {
			BookNode current = head;
			while (current != null) {
				if (current.bookId == bookId) {
					return current;
				}
				current = current.next;
			}
			return null;
		}
	}
}