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
			throw new IllegalArgumentException("로또 번호의 개수는 6개 이어야 합니다.");
		}
		if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUM || number > LOTTO_MAX_NUM)) {
			throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
		}
		if (numbers.stream().anyMatch(number -> Collections.frequency(numbers, number) > 1)) {
			throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
		}
	}

	@Override
	public String toString() {
		return "Lotto{" +
				"numbers=" + numbers +
				'}';
	}
}
