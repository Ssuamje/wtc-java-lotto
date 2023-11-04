package lotto.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
	public static final int PRICE = 1000;
	public static final int SIZE = 6;
	public static final int MIN = 1;
	public static final int MAX = 45;
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = Collections.unmodifiableList(numbers);
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != SIZE) {
			throw new LottoException(LottoExceptionStatus.INVALID_SIZE)
					.asIllegalArgumentException();
		}
		if (numbers.stream().anyMatch(number -> number < MIN || number > MAX)) {
			throw new LottoException(LottoExceptionStatus.INVALID_RANGED_NUMBER)
					.asIllegalArgumentException();
		}
		if (numbers.stream().anyMatch(number -> isDuplicated(numbers, number))) {
			throw new LottoException(LottoExceptionStatus.DUPLICATED_NUMBER)
					.asIllegalArgumentException();
		}
	}

	private boolean isDuplicated(List<Integer> numbers, Integer number) {
		int once = 1;
		return Collections.frequency(numbers, number) > once;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		return "Lotto{" +
				"numbers=" + numbers +
				'}';
	}
}
