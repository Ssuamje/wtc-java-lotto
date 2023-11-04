package lotto;

import lotto.lotto.LottoGame;
import lotto.lotto.LottoParser;
import lotto.lotto.LottoPrinter;

public class Application {

	public static void main(String[] args) {
		LottoParser lottoParser = new LottoParser();
		LottoPrinter lottoPrinter = new LottoPrinter();
		LottoGame lottoGame = new LottoGame(lottoParser, lottoPrinter);

		lottoGame.play();
	}
}
