public class problem7 {
	static final class FriendNode {
		int friendId;
		FriendNode next;

		FriendNode(int friendId) {
			this.friendId = friendId;
		}
	}

	static final class UserNode {
		int userId;
		String name;
		int age;
		FriendNode friendHead;
		UserNode next;

		UserNode(int userId, String name, int age) {
			this.userId = userId;
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return userId + " | " + name + " | " + age;
		}
	}

	static final class SocialNetworkList {
		private UserNode head;

		public void addUser(int userId, String name, int age) {
			if (findUserById(userId) != null) {
				return;
			}
			UserNode node = new UserNode(userId, name, age);
			node.next = head;
			head = node;
		}

		public boolean addFriendConnection(int firstUserId, int secondUserId) {
			UserNode first = findUserById(firstUserId);
			UserNode second = findUserById(secondUserId);
			if (first == null || second == null || firstUserId == secondUserId) {
				return false;
			}
			addFriendId(first, secondUserId);
			addFriendId(second, firstUserId);
			return true;
		}

		public boolean removeFriendConnection(int firstUserId, int secondUserId) {
			UserNode first = findUserById(firstUserId);
			UserNode second = findUserById(secondUserId);
			if (first == null || second == null) {
				return false;
			}
			removeFriendId(first, secondUserId);
			removeFriendId(second, firstUserId);
			return true;
		}

		public java.util.List<Integer> mutualFriends(int firstUserId, int secondUserId) {
			UserNode first = findUserById(firstUserId);
			UserNode second = findUserById(secondUserId);
			java.util.Set<Integer> friends = new java.util.HashSet<>();
			java.util.List<Integer> mutual = new java.util.ArrayList<>();
			if (first == null || second == null) {
				return mutual;
			}
			FriendNode current = first.friendHead;
			while (current != null) {
				friends.add(current.friendId);
				current = current.next;
			}
			current = second.friendHead;
			while (current != null) {
				if (friends.contains(current.friendId)) {
					mutual.add(current.friendId);
				}
				current = current.next;
			}
			return mutual;
		}

		public String displayFriends(int userId) {
			UserNode user = findUserById(userId);
			if (user == null) {
				return "User not found";
			}
			StringBuilder builder = new StringBuilder();
			FriendNode current = user.friendHead;
			while (current != null) {
				builder.append(current.friendId).append(System.lineSeparator());
				current = current.next;
			}
			return builder.length() == 0 ? "No friends" : builder.toString().trim();
		}

		public UserNode searchByName(String name) {
			UserNode current = head;
			while (current != null) {
				if (current.name.equalsIgnoreCase(name)) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		public UserNode searchByUserId(int userId) {
			return findUserById(userId);
		}

		public String countFriendsForEachUser() {
			StringBuilder builder = new StringBuilder();
			UserNode current = head;
			while (current != null) {
				builder.append(current.userId)
					.append(" -> ")
					.append(countFriends(current))
					.append(System.lineSeparator());
				current = current.next;
			}
			return builder.length() == 0 ? "No users" : builder.toString().trim();
		}

		private UserNode findUserById(int userId) {
			UserNode current = head;
			while (current != null) {
				if (current.userId == userId) {
					return current;
				}
				current = current.next;
			}
			return null;
		}

		private void addFriendId(UserNode user, int friendId) {
			if (containsFriend(user, friendId)) {
				return;
			}
			FriendNode node = new FriendNode(friendId);
			node.next = user.friendHead;
			user.friendHead = node;
		}

		private void removeFriendId(UserNode user, int friendId) {
			FriendNode current = user.friendHead;
			FriendNode previous = null;
			while (current != null) {
				if (current.friendId == friendId) {
					if (previous == null) {
						user.friendHead = current.next;
					} else {
						previous.next = current.next;
					}
					return;
				}
				previous = current;
				current = current.next;
			}
		}

		private boolean containsFriend(UserNode user, int friendId) {
			FriendNode current = user.friendHead;
			while (current != null) {
				if (current.friendId == friendId) {
					return true;
				}
				current = current.next;
			}
			return false;
		}

		private int countFriends(UserNode user) {
			int count = 0;
			FriendNode current = user.friendHead;
			while (current != null) {
				count++;
				current = current.next;
			}
			return count;
		}
	}
}