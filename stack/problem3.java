import java.util.ArrayDeque;
import java.util.Deque;

public class problem3 {

	static final class StockSpanCalculator {
		public int[] calculateSpans(int[] prices) {
			if (prices == null) {
				return new int[0];
			}

			int[] spans = new int[prices.length];
			Deque<Integer> stack = new ArrayDeque<>();

			for (int day = 0; day < prices.length; day++) {
				while (!stack.isEmpty() && prices[stack.peek()] <= prices[day]) {
					stack.pop();
				}
				spans[day] = stack.isEmpty() ? day + 1 : day - stack.peek();
				stack.push(day);
			}

			return spans;
		}
	}
}