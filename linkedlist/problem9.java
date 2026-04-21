public class problem9 {
	static final class TicketNode {
		int ticketId;
		String customerName;
		String movieName;
		String seatNumber;
		String bookingTime;
		TicketNode next;

		TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
			this.ticketId = ticketId;
			this.customerName = customerName;
			this.movieName = movieName;
			this.seatNumber = seatNumber;
			this.bookingTime = bookingTime;
		}

		@Override
		public String toString() {
			return ticketId + " | " + customerName + " | " + movieName + " | " + seatNumber + " | " + bookingTime;
		}
	}

	static final class TicketReservationSystem {
		private TicketNode head;

		public void addLast(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
			TicketNode node = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
			if (head == null) {
				head = node;
				node.next = node;
				return;
			}
			TicketNode tail = getTail();
			tail.next = node;
			node.next = head;
		}

		public boolean removeByTicketId(int ticketId) {
			if (head == null) {
				return false;
			}
			TicketNode prev = getTail();
			TicketNode node = head;
			do {
				if (node.ticketId == ticketId) {
					if (node == head && node.next == head) {
						head = null;
						return true;
					}
					prev.next = node.next;
					if (node == head) {
						head = node.next;
					}
					return true;
				}
				prev = node;
				node = node.next;
			} while (node != head);
			return false;
		}

		public String displayTickets() {
			if (head == null) {
				return "No tickets";
			}
			StringBuilder builder = new StringBuilder();
			TicketNode node = head;
			do {
				builder.append(node).append(System.lineSeparator());
				node = node.next;
			} while (node != head);
			return builder.toString().trim();
		}

		public TicketNode searchByCustomerName(String customerName) {
			if (head == null) {
				return null;
			}
			TicketNode node = head;
			do {
				if (node.customerName.equalsIgnoreCase(customerName)) {
					return node;
				}
				node = node.next;
			} while (node != head);
			return null;
		}

		public TicketNode searchByMovieName(String movieName) {
			if (head == null) {
				return null;
			}
			TicketNode node = head;
			do {
				if (node.movieName.equalsIgnoreCase(movieName)) {
					return node;
				}
				node = node.next;
			} while (node != head);
			return null;
		}

		public int totalBookedTickets() {
			if (head == null) {
				return 0;
			}
			int count = 0;
			TicketNode node = head;
			do {
				count++;
				node = node.next;
			} while (node != head);
			return count;
		}

		private TicketNode getTail() {
			if (head == null) {
				return null;
			}
			TicketNode node = head;
			while (node.next != head) {
				node = node.next;
			}
			return node;
		}
	}
}