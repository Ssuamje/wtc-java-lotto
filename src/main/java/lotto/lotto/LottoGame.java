package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	public static final double FIRST_PRIZE = 2000000000;
	public static final double SECOND_PRIZE = 30000000;
	public static final double THIRD_PRIZE = 1500000;
	public static final double FOURTH_PRIZE = 50000;
	public static final double FIFTH_PRIZE = 5000;
	private final LottoInputAdapter lottoInputAdapter;
	private final LottoPrinter lottoPrinter;
	private final LottoDrawer lottoDrawer;

	public LottoGame(LottoInputAdapter lottoInputAdapter, LottoPrinter lottoPrinter, LottoDrawer lottoDrawer) {
		this.lottoInputAdapter = lottoInputAdapter;
		this.lottoPrinter = lottoPrinter;
		this.lottoDrawer = lottoDrawer;
	}

	public void play() {
		int purchaseAmount = lottoInputAdapter.parseInputAsPurchaseAmountTillValid();
		List<Lotto> lottoList = createLottoListByAmount(purchaseAmount);
		lottoList.forEach(lottoPrinter::printLotto);

		List<Integer> winningNumbers = lottoInputAdapter.parseInputAsWinningNumbersTillValid();
		int bonusNumber = lottoInputAdapter.getInputBonusNumberTillValid();
		lottoInputAdapter.done();

		Lotto winningLotto = new Lotto(winningNumbers);
		List<LottoResult> lottoResults = lottoList.stream()
				.map(lotto -> lottoDrawer.draw(winningLotto, lotto, bonusNumber))
				.toList();

		LottoResultStatistics lottoResultStatistics = new LottoResultStatistics(lottoResults, purchaseAmount);
		lottoPrinter.printLottoResultStatistics(lottoResultStatistics);
		lottoPrinter.printYield(lottoResultStatistics);
	}

	private List<Lotto> createLottoListByAmount(int purchaseAmount) {
		int lottoCount = purchaseAmount / Lotto.PRICE;
		List<Lotto> result = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			Lotto lotto = createLotto();
			result.add(lotto);
		}
		lottoPrinter.printLottoCount(lottoCount);
		return result;
	}

	private Lotto createLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN, Lotto.MAX, Lotto.SIZE);
		return new Lotto(numbers);
	}
}
