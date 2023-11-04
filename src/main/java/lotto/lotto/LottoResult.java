package lotto.lotto;

public class LottoResult {
	private final long matchCount;
	private final boolean hasBonusNumber;

	public LottoResult(long matchCount, boolean hasBonusNumber) {
		this.matchCount = matchCount;
		this.hasBonusNumber = hasBonusNumber;
	}

	public long getMatchCount() {
		return matchCount;
	}

	public boolean hasBonusNumber() {
		return hasBonusNumber;
	}
}
