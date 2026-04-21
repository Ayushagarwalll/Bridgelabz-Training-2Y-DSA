public class problem2 {
	static final class MovieNode {
		String title;
		String director;
		int yearOfRelease;
		double rating;
		MovieNode next;
		MovieNode prev;

		MovieNode(String title, String director, int yearOfRelease, double rating) {
			this.title = title;
			this.director = director;
			this.yearOfRelease = yearOfRelease;
			this.rating = rating;
		}

		@Override
		public String toString() {
			return title + " | " + director + " | " + yearOfRelease + " | " + rating;
		}
	}

	static final class MovieList {
		private MovieNode head;
		private MovieNode tail;

		public void addFirst(String title, String director, int yearOfRelease, double rating) {
			MovieNode node = new MovieNode(title, director, yearOfRelease, rating);
			if (head == null) {
				head = tail = node;
				return;
			}
			node.next = head;
			head.prev = node;
			head = node;
		}

		public void addLast(String title, String director, int yearOfRelease, double rating) {
			MovieNode node = new MovieNode(title, director, yearOfRelease, rating);
			if (head == null) {
				head = tail = node;
				return;
			}
			tail.next = node;
			node.prev = tail;
			tail = node;
		}

		public boolean addAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
			if (position <= 1 || head == null) {
				addFirst(title, director, yearOfRelease, rating);
				return true;
			}
			MovieNode current = head;
			for (int index = 1; index < position - 1 && current.next != null; index++) {
				current = current.next;
			}
			if (current.next == null) {
				addLast(title, director, yearOfRelease, rating);
				return true;
			}
			MovieNode node = new MovieNode(title, director, yearOfRelease, rating);
			node.next = current.next;
			node.prev = current;
			current.next.prev = node;
			current.next = node;
			return true;
		}

		public boolean removeByTitle(String title) {
			MovieNode current = head;
			while (current != null && !current.title.equalsIgnoreCase(title)) {
				current = current.next;
			}
			if (current == null) {
				return false;
			}
			if (current.prev != null) {
				current.prev.next = current.next;
			} else {
				head = current.next;
			}
			if (current.next != null) {
				current.next.prev = current.prev;
			} else {
				tail = current.prev;
			}
			return true;
		}

		public MovieNode searchByDirector(String director) {
			MovieNode current = head;
			while (current != null) {
				if (current.director.equalsIgnoreCase(director)) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		public MovieNode searchByRating(double rating) {
			MovieNode current = head;
			while (current != null) {
				if (Double.compare(current.rating, rating) == 0) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		public boolean updateRating(String title, double newRating) {
			MovieNode current = head;
			while (current != null) {
				if (current.title.equalsIgnoreCase(title)) {
					current.rating = newRating;
					return true;
				}
				current = current.next;
			}
			return false;
		}

		public String displayForward() {
			StringBuilder builder = new StringBuilder();
			MovieNode current = head;
			while (current != null) {
				builder.append(current).append(System.lineSeparator());
				current = current.next;
			}
			return builder.length() == 0 ? "No movie records" : builder.toString().trim();
		}

		public String displayReverse() {
			StringBuilder builder = new StringBuilder();
			MovieNode current = tail;
			while (current != null) {
				builder.append(current).append(System.lineSeparator());
				current = current.prev;
			}
			return builder.length() == 0 ? "No movie records" : builder.toString().trim();
		}
	}
}