package lotto.lotto;

import java.util.List;

public class LottoPrinter {
	private static final String ERROR_PREFIX = "[ERROR]";
	
	public static void printExceptionInformation(LottoExceptionStatus exceptionStatus) {
		System.out.println(ERROR_PREFIX + " " + exceptionStatus.getMessage());
	}

	public void printLotto(Lotto lotto) {
		String numbersAsString = createNumbersAsString(lotto.getNumbers());
		System.out.println(numbersAsString);
	}

	public void printLottoResultStatistics(LottoResultStatistics lottoResultStatistics) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println("3개 일치 (" + LottoPrize.FIFTH.asWon() + ") - " + lottoResultStatistics.countByMatchCount(3) + "개");
		System.out.println("4개 일치 (" + LottoPrize.FOURTH.asWon() + ") - " + lottoResultStatistics.countByMatchCount(4) + "개");
		System.out.println("5개 일치 (" + LottoPrize.THIRD.asWon() + ") - " + lottoResultStatistics.countByMatchCount(5) + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (" + LottoPrize.SECOND.asWon() + ") - " + lottoResultStatistics.countByMatchCountAndHasBonusNumber(5) + "개");
		System.out.println("6개 일치 (" + LottoPrize.FIRST.asWon() + ") - " + lottoResultStatistics.countByMatchCount(6) + "개");
	}

	public void printYield(LottoResultStatistics lottoResultStatistics) {
		System.out.println("총 수익률은 " + String.format("%.1f", lottoResultStatistics.calculateYieldAsPercentage()) + "%입니다.");
	}

	public void printLottoCount(int lottoCount) {
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

	private String createNumbersAsString(List<Integer> numbers) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < numbers.size(); i++) {
			sb.append(numbers.get(i));
			if (i != numbers.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
