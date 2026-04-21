import java.util.ArrayDeque;
import java.util.Deque;

public class problem4 {

	static final class SlidingWindowMaximum {
		public int[] maxSlidingWindow(int[] values, int windowSize) {
			if (values == null || windowSize <= 0 || values.length == 0) {
				return new int[0];
			}
			if (windowSize > values.length) {
				windowSize = values.length;
			}

			int[] result = new int[values.length - windowSize + 1];
			Deque<Integer> deque = new ArrayDeque<>();

			for (int index = 0; index < values.length; index++) {
				while (!deque.isEmpty() && deque.peekFirst() <= index - windowSize) {
					deque.pollFirst();
				}

				while (!deque.isEmpty() && values[deque.peekLast()] <= values[index]) {
					deque.pollLast();
				}

				deque.offerLast(index);

				if (index >= windowSize - 1) {
					result[index - windowSize + 1] = values[deque.peekFirst()];
				}
			}

			return result;
		}
	}
}