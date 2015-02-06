package example;

public class ChainOfResponsibilityExample {

	private static Logger createChain() {
		// Build the chain of responsibility

		Logger logger = new StdoutLogger(Logger.DEBUG);

		Logger logger1 = new EmailLogger(Logger.NOTICE);
		logger.setNext(logger1);

		Logger logger2 = new StderrLogger(Logger.ERR);
		logger1.setNext(logger2);

		return logger;
	}

	public static void main(String[] args) {
		Logger chain = createChain();

		// Handled by StdoutLogger (level = 7)
		chain.message("Entering function y.", Logger.DEBUG);

		// Handled by StdoutLogger and EmailLogger (level = 5)
		chain.message("Step1 completed.", Logger.NOTICE);

		// Handled by all three loggers (level = 3)
		chain.message("An error has occurred.", Logger.ERR);
	}
}

// The output is:
// Writing to stdout: Entering function y.
// Writing to stdout: Step1 completed.
// Sending via e-mail: Step1 completed.
// Writing to stdout: An error has occurred.
// Sending via e-mail: An error has occurred.
// Sending to stderr: An error has occurred.

