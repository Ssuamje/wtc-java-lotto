package lotto.lotto;

public class LottoConfig {
	private final int lottoSize;
	private final int lottoMinNumber;
	private final int lottoMaxNumber;

	public LottoConfig(int lottoSize, int lottoMinNumber, int lottoMaxNumber) {
		this.lottoSize = lottoSize;
		this.lottoMinNumber = lottoMinNumber;
		this.lottoMaxNumber = lottoMaxNumber;
	}

	public int getLottoSize() {
		return lottoSize;
	}

	public int getLottoMinNumber() {
		return lottoMinNumber;
	}

	public int getLottoMaxNumber() {
		return lottoMaxNumber;
	}

	public boolean isValid() {
		return lottoSize > 0
				&& lottoMinNumber > 0
				&& lottoMaxNumber > 0;
	}
}
