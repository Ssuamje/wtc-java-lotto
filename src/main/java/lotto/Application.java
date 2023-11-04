package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoConfig;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    public static void main(String[] args) {

        LottoConfig lottoConfig = new LottoConfig(LOTTO_SIZE, LOTTO_MIN_NUM, LOTTO_MAX_NUM);
    }
}
