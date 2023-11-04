package lotto.lotto;

import lotto.ExceptionStatus;
import lotto.Validatable;
import lotto.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoConfig implements Validatable {
	private final int lottoSize;
	private final int lottoMinNumber;
	private final int lottoMaxNumber;

	public LottoConfig(int lottoSize, int lottoMinNumber, int lottoMaxNumber) {
		this.lottoSize = lottoSize;
		this.lottoMinNumber = lottoMinNumber;
		this.lottoMaxNumber = lottoMaxNumber;
		Validator.throwIfInvalidConstruction(this);
	}

	public int getLottoSize() {
		return lottoSize;
	}

	public int getLottoMinNumber() {
		return lottoMinNumber;
	}

	public int getLottoMaxNumber() {
		return lottoMaxNumber;
	}

	@Override
	public List<ExceptionStatus> findExceptionStatuses() {
		List <ExceptionStatus> exceptionStatuses = new ArrayList<>();
		if  (lottoSize <= 0) {
			exceptionStatuses.add(ExceptionStatus.INVALID_LOTTO_SIZE_RANGE);
		}
		if (lottoMinNumber <= 0 || lottoMaxNumber <= 0) {
			exceptionStatuses.add(ExceptionStatus.INVALID_LOTTO_NUMBER_RANGE);
		}
		if (lottoMinNumber > lottoMaxNumber) {
			exceptionStatuses.add(ExceptionStatus.INVALID_LOTTO_MIN_MAX);
		}
		return Collections.unmodifiableList(exceptionStatuses);
	}

	@Override
	public String toString() {
		return "LottoConfig{" +
				"lottoSize=" + lottoSize +
				", lottoMinNumber=" + lottoMinNumber +
				", lottoMaxNumber=" + lottoMaxNumber +
				'}';
	}
}
