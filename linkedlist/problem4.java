public class problem4 {
	static final class InventoryNode {
		String itemName;
		int itemId;
		int quantity;
		double price;
		InventoryNode next;

		InventoryNode(String itemName, int itemId, int quantity, double price) {
			this.itemName = itemName;
			this.itemId = itemId;
			this.quantity = quantity;
			this.price = price;
		}

		@Override
		public String toString() {
			return itemId + " | " + itemName + " | " + quantity + " | " + price;
		}
	}

	static final class InventoryList {
		private InventoryNode head;

		public void addFirst(String itemName, int itemId, int quantity, double price) {
			InventoryNode node = new InventoryNode(itemName, itemId, quantity, price);
			node.next = head;
			head = node;
		}

		public void addLast(String itemName, int itemId, int quantity, double price) {
			InventoryNode node = new InventoryNode(itemName, itemId, quantity, price);
			if (head == null) {
				head = node;
				return;
			}
			InventoryNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}

		public boolean addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
			if (position <= 1 || head == null) {
				addFirst(itemName, itemId, quantity, price);
				return true;
			}
			InventoryNode current = head;
			for (int index = 1; index < position - 1 && current.next != null; index++) {
				current = current.next;
			}
			InventoryNode node = new InventoryNode(itemName, itemId, quantity, price);
			node.next = current.next;
			current.next = node;
			return true;
		}

		public boolean removeByItemId(int itemId) {
			if (head == null) {
				return false;
			}
			if (head.itemId == itemId) {
				head = head.next;
				return true;
			}
			InventoryNode current = head;
			while (current.next != null && current.next.itemId != itemId) {
				current = current.next;
			}
			if (current.next == null) {
				return false;
			}
			current.next = current.next.next;
			return true;
		}

		public boolean updateQuantity(int itemId, int quantity) {
			InventoryNode node = searchByItemId(itemId);
			if (node == null) {
				return false;
			}
			node.quantity = quantity;
			return true;
		}

		public InventoryNode searchByItemId(int itemId) {
			InventoryNode current = head;
			while (current != null) {
				if (current.itemId == itemId) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		public InventoryNode searchByItemName(String itemName) {
			InventoryNode current = head;
			while (current != null) {
				if (current.itemName.equalsIgnoreCase(itemName)) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		public double totalInventoryValue() {
			double total = 0.0;
			InventoryNode current = head;
			while (current != null) {
				total += current.price * current.quantity;
				current = current.next;
			}
			return total;
		}

		public void sortByName(boolean ascending) {
			head = mergeSort(head, (left, right) -> ascending
				? left.itemName.compareToIgnoreCase(right.itemName)
				: right.itemName.compareToIgnoreCase(left.itemName));
		}

		public void sortByPrice(boolean ascending) {
			head = mergeSort(head, (left, right) -> ascending
				? Double.compare(left.price, right.price)
				: Double.compare(right.price, left.price));
		}

		public String displayAll() {
			StringBuilder builder = new StringBuilder();
			InventoryNode current = head;
			while (current != null) {
				builder.append(current).append(System.lineSeparator());
				current = current.next;
			}
			return builder.length() == 0 ? "No inventory records" : builder.toString().trim();
		}

		private InventoryNode mergeSort(InventoryNode node, java.util.Comparator<InventoryNode> comparator) {
			if (node == null || node.next == null) {
				return node;
			}
			InventoryNode middle = split(node);
			InventoryNode left = mergeSort(node, comparator);
			InventoryNode right = mergeSort(middle, comparator);
			return merge(left, right, comparator);
		}

		private InventoryNode split(InventoryNode headNode) {
			InventoryNode slow = headNode;
			InventoryNode fast = headNode.next;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			InventoryNode middle = slow.next;
			slow.next = null;
			return middle;
		}

		private InventoryNode merge(InventoryNode left, InventoryNode right, java.util.Comparator<InventoryNode> comparator) {
			if (left == null) {
				return right;
			}
			if (right == null) {
				return left;
			}
			if (comparator.compare(left, right) <= 0) {
				left.next = merge(left.next, right, comparator);
				return left;
			}
			right.next = merge(left, right.next, comparator);
			return right;
		}
	}
}