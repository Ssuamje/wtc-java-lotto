package lotto.lotto;

import java.util.Arrays;
import java.util.List;

public class LottoParser {
	private static final int PRICE = 1000;

	private static List<Integer> parseAsIntegerList(String numbersString) throws NumberFormatException {
		return Arrays.stream(numbersString.split(","))
				.map(Integer::parseInt).toList();
	}

	public int toPurchaseAmount(String purchaseAmountString) throws NumberFormatException {
		int purchaseAmount = Integer.parseInt(purchaseAmountString);
		if (purchaseAmount < PRICE || purchaseAmount % PRICE != 0) {
			throw new LottoException(LottoExceptionStatus.INVALID_LOTTO_PRICE)
					.asIlleagalArgumentException();
		}
		return purchaseAmount;
	}

	public List<Integer> toWinningNumbers(String numbersString) throws NumberFormatException {
		List<Integer> winningNumbers = parseAsIntegerList(numbersString);
		if (winningNumbers.size() != Lotto.SIZE) {
			throw new LottoException(LottoExceptionStatus.INVALID_SIZE)
					.asIlleagalArgumentException();
		}
		return winningNumbers;
	}

	public int toBonusNumber(String bonusNumberString) throws NumberFormatException {
		int bonusNumber = Integer.parseInt(bonusNumberString);
		if (bonusNumber < Lotto.MIN || bonusNumber > Lotto.MAX) {
			throw new LottoException(LottoExceptionStatus.INVALID_RANGED_NUMBER)
					.asIlleagalArgumentException();
		}
		return bonusNumber;
	}
}
