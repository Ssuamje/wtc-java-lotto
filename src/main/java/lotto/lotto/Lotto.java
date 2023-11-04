package lotto.lotto;

import java.util.List;

public class Lotto {
    private final LottoConfig lottoConfig;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers, LottoConfig lottoConfig) {
        this.numbers = numbers;
        this.lottoConfig = lottoConfig;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != lottoConfig.getLottoSize()) {
            throw new IllegalArgumentException("로또 번호의 개수는 " + lottoConfig.getLottoSize() + "개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != lottoConfig.getLottoSize()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        if (numbers.stream().anyMatch(number -> !isInRange(number))) {
            throw new IllegalArgumentException("로또 번호는 " + lottoConfig.getLottoMinNumber() + " ~ " + lottoConfig.getLottoMaxNumber() + " 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 이러면 Lotto 객체가 LottoConfig에 대해 종속성을 갖게 되지 않나?
     */
    private boolean isInRange(int number) {
        return lottoConfig.getLottoMinNumber() <= number && number <= lottoConfig.getLottoMaxNumber();
    }
}
