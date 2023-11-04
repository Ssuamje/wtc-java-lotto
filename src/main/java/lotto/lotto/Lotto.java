package lotto.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final int LOTTO_SIZE = 6;
	private static final int LOTTO_MIN_NUM = 1;
	private static final int LOTTO_MAX_NUM = 45;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = Collections.unmodifiableList(numbers);
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			throw new LottoException(LottoExceptionStatus.INVALID_SIZE)
					.asIlleagalArgumentException();
		}
		if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUM || number > LOTTO_MAX_NUM)) {
			throw new LottoException(LottoExceptionStatus.INVALID_RANGED_NUMBER)
					.asIlleagalArgumentException();
		}
		if (numbers.stream().anyMatch(number -> isDuplicated(numbers, number))) {
			throw new LottoException(LottoExceptionStatus.DUPLICATE_NUMBERS)
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
