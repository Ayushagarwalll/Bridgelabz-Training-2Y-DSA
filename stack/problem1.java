import java.util.ArrayDeque;
import java.util.Deque;

public class problem1 {
	static final class QueueUsingStacks<T> {
		private final Deque<T> enqueueStack = new ArrayDeque<>();
		private final Deque<T> dequeueStack = new ArrayDeque<>();

		public void enqueue(T value) {
			enqueueStack.push(value);
		}

		public T dequeue() {
			moveIfNeeded();
			if (dequeueStack.isEmpty()) {
				return null;
			}
			return dequeueStack.pop();
		}

		public T peek() {
			moveIfNeeded();
			return dequeueStack.peek();
		}

		public boolean isEmpty() {
			return enqueueStack.isEmpty() && dequeueStack.isEmpty();
		}

		public int size() {
			return enqueueStack.size() + dequeueStack.size();
		}

		private void moveIfNeeded() {
			if (dequeueStack.isEmpty()) {
				while (!enqueueStack.isEmpty()) {
					dequeueStack.push(enqueueStack.pop());
				}
			}
		}
	}
}