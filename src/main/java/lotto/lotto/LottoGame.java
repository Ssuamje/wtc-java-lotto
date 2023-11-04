package lotto.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	private final LottoParser lottoParser;
	private final LottoPrinter lottoPrinter;

	public LottoGame(LottoParser lottoParser, LottoPrinter lottoPrinter) {
		this.lottoParser = lottoParser;
		this.lottoPrinter = lottoPrinter;
	}

	public void play() {
		int purchaseAmount = lottoParser.toPurchaseAmount(Console.readLine());
		List<Lotto> lottoList = createLottoListByAmount(purchaseAmount);

		List<Integer> winningNumbers = lottoParser.toWinningNumbers(Console.readLine());
		int bonusNumber = lottoParser.toBonusNumber(Console.readLine());


	}

	private List<Lotto> createLottoListByAmount(int purchaseAmount) {
		int lottoCount = purchaseAmount / Lotto.PRICE;
		List<Lotto> result = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			Lotto lotto = createLotto();
			lottoPrinter.printLotto(lotto);
			result.add(lotto);
		}
		return result;
	}

	private Lotto createLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN, Lotto.MAX, Lotto.SIZE);
		return new Lotto(numbers);
	}
}
