package lotto;

public enum ExceptionStatus {

	// 이후에 타입 인터페이스를 이용해서 단순히 Type으로만 구분하고 구체적인 ExceptionStatus를 만들 수 있을 듯
	/*-------------------------------------LottoConfig-------------------------------------*/
	INVALID_LOTTO_NUMBER_RANGE("로또 번호의 범위가 유효하지 않습니다.",
			"로또 번호는 자연수여야 합니다"),
	INVALID_LOTTO_MIN_MAX("로또 번호의 범위가 유효하지 않습니다.",
			"로또 번호의 최솟값은 최댓값보다 작아야 합니다."),
	INVALID_LOTTO_SIZE_RANGE("로또 번호의 수가 유효하지 않습니다.",
			"로또 번호의 수는 한 개 이상이어야 합니다."),

	/*-------------------------------------Lotto-------------------------------------*/
	INVALID_LOTTO_NUMBERS("로또 번호의 범위가 유효하지 않습니다.",
			"로또 번호는 로또 구성(Config)의 범위에 알맞는 숫자여야 합니다."),
	INVALID_LOTTO_SIZE("로또 번호의 수가 유효하지 않습니다.",
			"로또 개수는 로또 구성(Config)에 설정된 갯수에 알맞아야 합니다."),
	DUPLICATE_LOTTO_NUMBERS("로또 번호가 중복되었습니다.",
			"로또 번호는 중복되지 않아야 합니다."),
	;

	private final String message;
	private final String usage;

	ExceptionStatus(String message, String usage) {
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
