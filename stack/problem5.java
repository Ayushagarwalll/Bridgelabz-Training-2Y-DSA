public class problem5 {

	static final class CircularTourSolver {
		public int findStartingPump(int[] petrol, int[] distance) {
			if (petrol == null || distance == null || petrol.length != distance.length || petrol.length == 0) {
				return -1;
			}

			int start = 0;
			int surplus = 0;
			int deficit = 0;

			for (int index = 0; index < petrol.length; index++) {
				surplus += petrol[index] - distance[index];
				if (surplus < 0) {
					start = index + 1;
					deficit += surplus;
					surplus = 0;
				}
			}

			return surplus + deficit >= 0 ? start % petrol.length : -1;
		}
	}
}