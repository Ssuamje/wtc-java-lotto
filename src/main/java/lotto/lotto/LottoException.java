package lotto.lotto;

public class LottoException {

	private static final String ERROR_PREFIX = "[ERROR]";

	private final LottoExceptionStatus status;

	public LottoException(LottoExceptionStatus status) {
		this.status = status;
	}

	public IllegalArgumentException asIllegalArgumentException() {
		return new IllegalArgumentException(createExceptionInformation());
	}

	public IllegalStateException asIllegalStateException() {
		return new IllegalStateException(createExceptionInformation());
	}

	public String createExceptionInformation() {
		return ERROR_PREFIX + "\n"
				+ status.getMessage() + "\n"
				+ status.getUsage();
	}
}
