package lotto.lotto;

public class LottoDrawer {

	public LottoResult draw(Lotto winningLotto, Lotto lotto, int bonusNumber) {
		return new LottoResult(
				countMatchWithWinningLotto(winningLotto, lotto), hasBonusNumber(winningLotto, bonusNumber));
	}

	private long countMatchWithWinningLotto(Lotto winningLotto, Lotto lotto) {
		return lotto.getNumbers().stream()
				.filter(winningLotto.getNumbers()::contains)
				.count();
	}

	private boolean hasBonusNumber(Lotto winningLotto, int bonusNumber) {
		return winningLotto.getNumbers().contains(bonusNumber);
	}
}
