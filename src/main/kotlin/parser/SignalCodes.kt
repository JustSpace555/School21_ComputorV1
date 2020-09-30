package parser

enum class SignalCodes {
	OK,

	HIGHER_SECOND_DEGREE,
	WRONG_DEGREE_FORMAT,
	WRONG_NUMBER_FORMAT,
	WRONG_AMOUNT_ARGS,
	WRONG_AMOUNT_EQUAL_SIGNS,
	WRONG_ARGUMENT_NAME,

	NO_SOLUTION,
	EVERY_NUMBER_IS_SOLUTION
}