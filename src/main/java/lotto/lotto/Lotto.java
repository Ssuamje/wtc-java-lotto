package lotto.lotto;

import lotto.ExceptionStatus;
import lotto.Validatable;
import lotto.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto implements Validatable {
    private final LottoConfig lottoConfig;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers, LottoConfig lottoConfig) {
        this.numbers = numbers;
        this.lottoConfig = lottoConfig;
        Validator.throwIfInvalidConstruction(this);
    }

    @Override
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

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                ", lottoConfig=" + lottoConfig +
                '}';
    }

    /**
     * 이러면 Lotto 객체가 LottoConfig에 대해 종속성을 갖게 되지 않나?
     */
    private boolean isNotInRange(int number) {
        return number < lottoConfig.getLottoMinNumber() || number > lottoConfig.getLottoMaxNumber();
    }

    private boolean isDuplicated(int number) {
        return Collections.frequency(numbers, number) > 1;
    }
}
