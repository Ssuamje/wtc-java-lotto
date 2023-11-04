package lotto.lotto;

public enum LottoExceptionStatus {
	INVALID_LOTTO_PRICE("유효하지 않은 로또 구입 금액입니다.",
			"로또 구입 금액은 1000원 단위로 입력해주세요."),
	INVALID_RANGED_NUMBER("유효하지 않은 로또 번호입니다.",
			"로또 번호는 1 ~ 45 사이의 자연수만 가능합니다."),

	INVALID_SIZE("유효하지 않은 로또 번호의 개수입니다.",
			"로또 번호의 개수는 6개 이어야 합니다."),

	DUPLICATED_NUMBER("유효하지 않은 로또 번호입니다.",
			"로또 번호에 중복된 숫자가 있습니다."),
	;

	private final String message;
	private final String usage;

	LottoExceptionStatus(String message, String usage) {
		this.message = message;
		this.usage = usage;
	}

	public String getMessage() {
		return message;
	}

	public String getUsage() {
		return usage;
	}
}
