SCRIPTS_FOLDER = scripts
DEPENDENCIES_FOLDER = Dependencies

COMPILER_FOLDER = $(DEPENDENCIES_FOLDER)/kotlinc/bin
COMPILER = $(COMPILER_FOLDER)/kotlinc
JUNIT_FOLDER = $(DEPENDENCIES_FOLDER)/junit/

SRC_FOLDER = src/main/kotlin
TEST_FOLDER = src/test/kotlin

NAME = computor

SRC =	$(SRC_FOLDER)/ComputorMain.kt \
		$(SRC_FOLDER)/calculations/CalculateSolutions.kt \
		$(SRC_FOLDER)/globalextensions/NumberExtensions.kt \
		$(SRC_FOLDER)/models/Discriminant.kt \
		$(SRC_FOLDER)/models/PolynomialTerm.kt \
		$(SRC_FOLDER)/models/Complex.kt \
		$(SRC_FOLDER)/output/error/PrintErrorOutput.kt \
		$(SRC_FOLDER)/output/ok/PrintOkOutput.kt \
		$(SRC_FOLDER)/output/ok/PrintSolutions.kt \
		$(SRC_FOLDER)/parser/extensions/FindMaxDegree.kt \
		$(SRC_FOLDER)/parser/extensions/PutSpaces.kt \
		$(SRC_FOLDER)/parser/extensions/SimplifyPolynomial.kt \
		$(SRC_FOLDER)/parser/extensions/ToPolynomialList.kt \
		$(SRC_FOLDER)/parser/extensions/ToPolynomialTerm.kt \
		$(SRC_FOLDER)/parser/ParserMain.kt \
		$(SRC_FOLDER)/parser/SignalCodes.kt

SRC_TEST =	$(TEST_FOLDER)/ParserTests.kt \
			$(TEST_FOLDER)/PolynomialTermTests.kt \
			$(TEST_FOLDER)/SolverTest.kt

BUILD_TEST = $(subst $(TEST_FOLDER)/,,$(SRC_TEST))

all:
	@bash $(SCRIPTS_FOLDER)/GetDependencies.bash
	@$(COMPILER) $(SRC) -include-runtime -d $(NAME).jar

tests:
	@bash $(SCRIPTS_FOLDER)/GetTestDependencies.bash
	@$(COMPILER) -cp $(DEPENDENCIES_FOLDER)/junit/junit.jar:. $(SRC_TEST) $(SRC)
	@$(COMPILER_FOLDER)/kotlin -cp $(JUNIT_FOLDER)/junit.jar:$(JUNIT_FOLDER)/hamcrest-core.jar:. org.junit.runner.JUnitCore $(BUILD_TEST:.kt=)
	@rm -rf calculations globalextensions META-INF models output parser *.class

clean:
	@rm -rf $(NAME).jar

fclean: clean
	@rm -rf $(DEPENDENCIES_FOLDER)

re: clean all
