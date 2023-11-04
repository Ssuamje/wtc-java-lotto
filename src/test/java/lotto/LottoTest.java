package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
	/**
	 * 비즈니스로직이 테스트에서 드러나도 괜찮은가? -> 오히려 지향해야하는가?
	 * 하지만 비즈니스 로직이 테스트에 드러난다는 것 자체가 테스트가 변화에 닫혀있다는 것 아닌가?
	 * -> 라는 얘기는 결국 1 ~ 45의 범위를 정해놓는 것이 아닌 주입 받을 수 있도록 열어놓아야 하는게 아닐까?
	 * <p>
	 * 사실상 Lotto 객체는 이미 과제에서 주어질 때 부터 일급 컬렉션 객체로서의 역할을 암시하는 것 같다.
	 * -> 그렇다면 굳이 LottoNums와 같은 별도의 객체를 만들고 래핑하기보다, Lotto 자체를 이용하는 편이 낫겠다.
	 */
	private List<Integer> createRandomNumbers(int min, int max, int size) {
		return Randoms.pickUniqueNumbersInRange(min, max, size);
	}

	private Integer createLottoNumberByRange(int min, int max) {
		return Randoms.pickNumberInRange(min, max);
	}

	@Nested
	@DisplayName("로또를 생성할 때,")
	class Constructor {
		private static final int SIZE = 6;
		private static final int MIN = 1;
		private static final int MAX = 45;

		@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
		@Test
		void createLottoByOverSize() {
			List<Integer> lottoNumbers = createRandomNumbers(MIN, MAX, SIZE + 1);
			assertThatThrownBy(() -> new Lotto(lottoNumbers))
					.isInstanceOf(IllegalArgumentException.class);
		}

		@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
		@Test
		void createLottoByDuplicatedNumber() {
			List<Integer> numbers = createRandomNumbers(MIN, MAX, 4);
			Integer duplicated = 5;
			numbers.add(duplicated);
			numbers.add(duplicated);

			assertThatThrownBy(() -> new Lotto(numbers))
					.isInstanceOf(IllegalArgumentException.class);
		}
	}
}