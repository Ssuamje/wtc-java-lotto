package lotto.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final int SIZE = 6;
	private static final int MIN = 1;
	private static final int MAX = 45;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = Collections.unmodifiableList(numbers);
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != SIZE) {
			throw new LottoException(LottoExceptionStatus.INVALID_SIZE)
					.asIlleagalArgumentException();
		}
		if (numbers.stream().anyMatch(number -> number < MIN || number > MAX)) {
			throw new LottoException(LottoExceptionStatus.INVALID_RANGED_NUMBER)
					.asIlleagalArgumentException();
		}
		if (numbers.stream().anyMatch(number -> isDuplicated(numbers, number))) {
			throw new LottoException(LottoExceptionStatus.DUPLICATED_NUMBER)
					.asIlleagalArgumentException();
		}
	}

	private boolean isDuplicated(List<Integer> numbers, Integer number) {
		int once = 1;
		return Collections.frequency(numbers, number) > once;
	}

	@Override
	public String toString() {
		return "Lotto{" +
				"numbers=" + numbers +
				'}';
	}
}
