package lotto;

import java.util.List;

public class Validator {

	private static final String ERROR_PREFIX = "[ERROR]";

	public static void throwIfInvalidConstruction(Validatable validatable) {
		List<ExceptionStatus> exceptionStatuses = validatable.findExceptionStatuses();
		if (!exceptionStatuses.isEmpty())
			throw new IllegalArgumentException(
					ERROR_PREFIX + "\n"
					+ validatable.toString() + "\n"
					+ concatExceptionStatuses(exceptionStatuses)
			);
	}

	private static String concatExceptionStatuses(List<ExceptionStatus> exceptionStatuses) {
		StringBuilder sb = new StringBuilder();
		for (ExceptionStatus exceptionStatus : exceptionStatuses) {
			sb.append(exceptionStatus.getMessage());
			sb.append("\n");
			sb.append(exceptionStatus.getUsage());
			sb.append("\n");
		}
		return sb.toString();
	}
}
