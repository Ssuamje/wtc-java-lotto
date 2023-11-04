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

	public long countByMatchCountAndHasBonusNumber(int matchCount) {
		return results.stream()
				.filter(result -> result.getMatchCount() == matchCount)
				.filter(LottoResult::hasBonusNumber)
				.count();
	}

	public double calculateYieldAsPercentage() {
		return ((double) calculateProfit() / purchaseAmount) * 100;
	}

	public long calculateProfit() {
		return results.stream()
				.mapToLong(this::calculatePrize)
				.sum();
	}

	private long calculatePrize(LottoResult lottoResult) {
		if (lottoResult.getMatchCount() == 3) {
			return LottoPrize.FIFTH.getPrize();
		}
		if (lottoResult.getMatchCount() == 4) {
			return LottoPrize.FOURTH.getPrize();
		}
		if (lottoResult.getMatchCount() == 5) {
			if (lottoResult.hasBonusNumber()) {
				return LottoPrize.SECOND.getPrize();
			}
			return LottoPrize.THIRD.getPrize();
		}
		if (lottoResult.getMatchCount() == 6) {
			return LottoPrize.FIRST.getPrize();
		}
		return 0;
	}
}
