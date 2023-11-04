package lotto.lotto;

public class LottoDrawer {

	public LottoResult draw(Lotto winningLotto, Lotto lotto, int bonusNumber) {
		return new LottoResult(
				countMatch(winningLotto, lotto), isLottoHasBonusNumber(lotto, bonusNumber));
	}

	private long countMatch(Lotto src, Lotto cmp) {
		return src.getNumbers().stream()
				.filter(cmp.getNumbers()::contains)
				.count();
	}

	private boolean isLottoHasBonusNumber(Lotto lotto, int bonusNumber) {
		return lotto.getNumbers().contains(bonusNumber);
	}
}
