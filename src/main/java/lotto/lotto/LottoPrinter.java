package lotto.lotto;

import java.util.List;

public class LottoPrinter {

	public void printLotto(Lotto lotto) {
		String numbersAsString = createNumbersAsString(lotto.getNumbers());
		System.out.println(numbersAsString);
	}

	private String createNumbersAsString(List<Integer> numbers) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < numbers.size(); i++) {
			sb.append(numbers.get(i));
			if (i != numbers.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
