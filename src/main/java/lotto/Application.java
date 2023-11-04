package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.LottoException;
import lotto.lotto.LottoExceptionStatus;
import lotto.lotto.LottoParser;

public class Application {

	public static void main(String[] args) {
		LottoParser lottoParser = new LottoParser();
		try {
			lottoParser.toPurchaseAmount(Console.readLine());
			lottoParser.toWinningNumbers(Console.readLine());
			lottoParser.toBonusNumber(Console.readLine());
		} catch (NumberFormatException e) {
			throw new LottoException(LottoExceptionStatus.INVALID_RANGED_NUMBER)
					.asIlleagalArgumentException();
		}

	}
}
