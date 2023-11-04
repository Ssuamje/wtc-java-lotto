package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Factory {

	public List<ExceptionStatus> findExceptionStatuses() {
		List<ExceptionStatus> exceptionStatuses = new ArrayList<>();
		if (numbers.size() != lottoConfig.getLottoSize()) {
			exceptionStatuses.add(ExceptionStatus.INVALID_LOTTO_SIZE);
		}
		if (numbers.stream().anyMatch(this::isDuplicated)) {
			exceptionStatuses.add(ExceptionStatus.DUPLICATE_LOTTO_NUMBERS);
		}
		if (numbers.stream().anyMatch(this::isNotInRange)) {
			exceptionStatuses.add(ExceptionStatus.INVALID_LOTTO_NUMBERS);
		}
		return Collections.unmodifiableList(exceptionStatuses);
	}

	private boolean isNotInRange(int number) {
		return number < lottoConfig.getLottoMinNumber() || number > lottoConfig.getLottoMaxNumber();
	}

	private boolean isDuplicated(int number) {
		return Collections.frequency(numbers, number) > 1;
	}
}
