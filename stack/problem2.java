import java.util.ArrayDeque;
import java.util.Deque;

public class problem2 {

	static final class RecursiveStackSorter {
		public void sortStack(Deque<Integer> stack) {
			if (stack == null || stack.size() <= 1) {
				return;
			}
			int top = stack.pop();
			sortStack(stack);
			insertSorted(stack, top);
		}

		private void insertSorted(Deque<Integer> stack, int value) {
			if (stack.isEmpty() || stack.peek() <= value) {
				stack.push(value);
				return;
			}
			int top = stack.pop();
			insertSorted(stack, value);
			stack.push(top);
		}

		public Deque<Integer> createStack(int... values) {
			Deque<Integer> stack = new ArrayDeque<>();
			for (int index = values.length - 1; index >= 0; index--) {
				stack.push(values[index]);
			}
			return stack;
		}
	}
}