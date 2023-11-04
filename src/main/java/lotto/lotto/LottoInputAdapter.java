package lotto.lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoInputAdapter {

	private static List<Integer> parseInputAsIntegerListTillValid() {
		String numbersString = Console.readLine();

		try {
			return Arrays.stream(numbersString.split(","))
					.map(Integer::parseInt).toList();
		} catch (NumberFormatException e) {
			LottoPrinter.printExceptionInformation(LottoExceptionStatus.INVALID_LOTTO_NUMBER_INPUT);
			return parseInputAsIntegerListTillValid();
		}
	}

	public int parseInputAsPurchaseAmountTillValid() {
		int purchaseAmount = 0;
		String purchaseAmountString = Console.readLine();

		try {
			purchaseAmount = Integer.parseInt(purchaseAmountString);
		} catch (NumberFormatException e) {
			LottoPrinter.printExceptionInformation(LottoExceptionStatus.INVALID_PURCHASE_AMOUNT_INPUT);
			purchaseAmount = parseInputAsPurchaseAmountTillValid();
		}

		if (purchaseAmount < Lotto.PRICE || purchaseAmount % Lotto.PRICE != 0) {
			LottoPrinter.printExceptionInformation(LottoExceptionStatus.INVALID_LOTTO_PRICE);
			purchaseAmount = parseInputAsPurchaseAmountTillValid();
		}
		return purchaseAmount;
	}

	public List<Integer> parseInputAsWinningNumbersTillValid() {
		List<Integer> winningNumbers = parseInputAsIntegerListTillValid();

		if (winningNumbers.size() != Lotto.SIZE) {
			LottoPrinter.printExceptionInformation(LottoExceptionStatus.INVALID_WINNING_NUMBERS_INPUT);
			winningNumbers = parseInputAsWinningNumbersTillValid();
		}
		return winningNumbers;
	}

	public int getInputBonusNumberTillValid() {
		int bonusNumber = 0;
		String bonusNumberString = Console.readLine();

		try {
			bonusNumber = Integer.parseInt(bonusNumberString);
		} catch (NumberFormatException e) {
			LottoPrinter.printExceptionInformation(LottoExceptionStatus.INVALID_LOTTO_NUMBER_INPUT);
			bonusNumber = getInputBonusNumberTillValid();
		}

		if (bonusNumber < Lotto.MIN || bonusNumber > Lotto.MAX) {
			LottoPrinter.printExceptionInformation(LottoExceptionStatus.INVALID_RANGED_NUMBER);
			bonusNumber = getInputBonusNumberTillValid();
		}
		return bonusNumber;
	}

	public void done() {
		Console.close();
	}
}
