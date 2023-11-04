package lotto.lotto;

import java.util.Arrays;
import java.util.List;

public class LottoParser {


	private static List<Integer> parseAsIntegerList(String numbersString) {
		try {
			return Arrays.stream(numbersString.split(","))
					.map(Integer::parseInt).toList();
		} catch (NumberFormatException e) {
			throw new LottoException(LottoExceptionStatus.INVALID_WINNING_NUMBERS_INPUT)
					.asIlleagalArgumentException();
		}
	}

	public int toPurchaseAmount(String purchaseAmountString) {
		int purchaseAmount = 0;

		try {
			purchaseAmount = Integer.parseInt(purchaseAmountString);
		} catch (NumberFormatException e) {
			throw new LottoException(LottoExceptionStatus.INVALID_PURCHASE_AMOUNT_INPUT)
					.asIlleagalArgumentException();
		}

		if (purchaseAmount < Lotto.PRICE || purchaseAmount % Lotto.PRICE != 0) {
			throw new LottoException(LottoExceptionStatus.INVALID_LOTTO_PRICE)
					.asIlleagalArgumentException();
		}
		return purchaseAmount;
	}

	public List<Integer> toWinningNumbers(String numbersString) {
		List<Integer> winningNumbers = parseAsIntegerList(numbersString);
		if (winningNumbers.size() != Lotto.SIZE) {
			throw new LottoException(LottoExceptionStatus.INVALID_SIZE)
					.asIlleagalArgumentException();
		}
		return winningNumbers;
	}

	public int toBonusNumber(String bonusNumberString) {
		int bonusNumber = 0;

		try {
			bonusNumber = Integer.parseInt(bonusNumberString);
		} catch (NumberFormatException e) {
			throw new LottoException(LottoExceptionStatus.INVALID_LOTTO_NUMBER_INPUT)
					.asIlleagalArgumentException();
		}

		if (bonusNumber < Lotto.MIN || bonusNumber > Lotto.MAX) {
			throw new LottoException(LottoExceptionStatus.INVALID_RANGED_NUMBER)
					.asIlleagalArgumentException();
		}
		return bonusNumber;
	}
}
