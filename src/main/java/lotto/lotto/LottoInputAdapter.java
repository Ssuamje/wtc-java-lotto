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
			System.out.println(new LottoException(LottoExceptionStatus.INVALID_LOTTO_NUMBER_INPUT)
					.createExceptionInformation());
			return parseInputAsIntegerListTillValid();
		}
	}

	public int parseInputAsPurchaseAmountTillValid() {
		int purchaseAmount = 0;
		String purchaseAmountString = Console.readLine();

		try {
			purchaseAmount = Integer.parseInt(purchaseAmountString);
		} catch (NumberFormatException e) {
			System.out.println(new LottoException(LottoExceptionStatus.INVALID_PURCHASE_AMOUNT_INPUT)
					.createExceptionInformation());
			purchaseAmount = parseInputAsPurchaseAmountTillValid();
		}

		if (purchaseAmount < Lotto.PRICE || purchaseAmount % Lotto.PRICE != 0) {
			System.out.println(new LottoException(LottoExceptionStatus.INVALID_LOTTO_PRICE)
					.createExceptionInformation());
			purchaseAmount = parseInputAsPurchaseAmountTillValid();
		}
		return purchaseAmount;
	}

	public List<Integer> parseInputAsWinningNumbersTillValid() {
		List<Integer> winningNumbers = parseInputAsIntegerListTillValid();

		if (winningNumbers.size() != Lotto.SIZE) {
			System.out.println(new LottoException(LottoExceptionStatus.INVALID_SIZE)
					.createExceptionInformation());
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
			System.out.println(new LottoException(LottoExceptionStatus.INVALID_LOTTO_NUMBER_INPUT)
					.createExceptionInformation());
			bonusNumber = getInputBonusNumberTillValid();
		}

		if (bonusNumber < Lotto.MIN || bonusNumber > Lotto.MAX) {
			System.out.println(new LottoException(LottoExceptionStatus.INVALID_RANGED_NUMBER)
					.createExceptionInformation());
			bonusNumber = getInputBonusNumberTillValid();
		}
		return bonusNumber;
	}

	public void done() {
		Console.close();
	}
}
