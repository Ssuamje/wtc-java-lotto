package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.LottoConfig;

public class Application {
	private static final int LOTTO_SIZE = 6;
	private static final int LOTTO_MIN_NUM = 1;
	private static final int LOTTO_MAX_NUM = 45;
	private static final int LOTTO_PRICE = 1000;

	public static void main(String[] args) {
		System.out.println("로또 구입 금액을 입력해 주세요. - " + LOTTO_PRICE + "원 단위");
		String purchaseAmount = Console.readLine();
		System.out.println("당첨 번호를 입력해주세요.");
		String winningNumbers = Console.readLine();
		System.out.println("보너스 번호를 입력해주세요.");
		String bonusNumber = Console.readLine();


		LottoConfig lottoConfig = new LottoConfig(LOTTO_SIZE, LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_PRICE);

	}
}
