package lotto.lotto;

import java.util.List;

public class LottoResultStatistics {
	private final List<LottoResult> results;
	private final int purchaseAmount;

	public LottoResultStatistics(List<LottoResult> results, int purchaseAmount) {
		this.results = results;
		this.purchaseAmount = purchaseAmount;
	}

	public long countByMatchCount(int matchCount) {
		return results.stream()
				.filter(result -> result.getMatchCount() == matchCount)
				.count();
	}

	public long countByMatchCountAndHasBonusNumber(int matchCount, boolean hasBonusNumber) {
		return results.stream()
				.filter(result -> result.getMatchCount() == matchCount)
				.filter(result -> result.hasBonusNumber() == hasBonusNumber)
				.count();
	}

	public double calculateYieldAsPercentage() {
		return (calculateProfit() / purchaseAmount) * 100;
	}

	public double calculateProfit() {
		return results.stream()
				.mapToDouble(this::calculatePrize)
				.sum();
	}

	private double calculatePrize(LottoResult lottoResult) {
		if (lottoResult.getMatchCount() == 3) {
			return LottoGame.FIFTH_PRIZE;
		}
		if (lottoResult.getMatchCount() == 4) {
			return LottoGame.FOURTH_PRIZE;
		}
		if (lottoResult.getMatchCount() == 5) {
			if (lottoResult.hasBonusNumber()) {
				return LottoGame.SECOND_PRIZE;
			}
			return LottoGame.THIRD_PRIZE;
		}
		if (lottoResult.getMatchCount() == 6) {
			return LottoGame.FIRST_PRIZE;
		}
		return 0;
	}
}
