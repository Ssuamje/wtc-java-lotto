package lotto.lotto;

import lotto.Validator;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
		Validator.throwIfInvalidConstruction(this);
	}


	@Override
	public String toString() {
		return "Lotto{" +
				"numbers=" + numbers +
				'}';
	}
}
