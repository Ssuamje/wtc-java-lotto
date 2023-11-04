package lotto;

import lotto.lotto.LottoDrawer;
import lotto.lotto.LottoGame;
import lotto.lotto.LottoInputAdapter;
import lotto.lotto.LottoPrinter;

public class Application {

	public static void main(String[] args) {
		LottoInputAdapter lottoInputAdapter = new LottoInputAdapter();
		LottoPrinter lottoPrinter = new LottoPrinter();
		LottoDrawer lottoDrawer = new LottoDrawer();
		LottoGame lottoGame = new LottoGame(lottoInputAdapter, lottoPrinter, lottoDrawer);

		lottoGame.play();
	}
}
