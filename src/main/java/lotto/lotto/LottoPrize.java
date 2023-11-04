package lotto.lotto;

public enum LottoPrize {
	FIRST(2000000000),
	SECOND(30000000),
	THIRD(1500000),
	FOURTH(50000),
	FIFTH(5000),
	;

	private final long prize;

	LottoPrize(long prize) {
		this.prize = prize;
	}

	public long getPrize() {
		return prize;
	}

	public String asWon() {
		String prize = this.prize == 0
				? "0"
				: String.format("%,d", this.prize);
		return prize + "원";
	}
}
