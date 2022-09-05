package com.mikhail.tarasevich.divisioncalculatorapplication.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorImplTest {

	final ValidatorImpl validatorImpl = new ValidatorImpl();

	@Test
	void validate_inputDivisorIsZero_expectedIllegalArgumentException() {
		assertThatThrownBy(() -> validatorImpl.validate(105, 0)).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Divisor can not be ZERO - division by ZERO!");
	}

	@Test
	void validate_InputDivisionOrDivisorAreZero_ExpectedIllegalArgumentException() {
		assertThatThrownBy(() -> validatorImpl.validate(-105, 25)).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Division and divisor have to be positive. \n" + "In Your case division = "
						+ "-105" + " and divisor = " + "25");

		assertThatThrownBy(() -> validatorImpl.validate(105, -25)).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Division and divisor have to be positive. \n" + "In Your case division = "
						+ "105" + " and divisor = " + "-25");

		assertThatThrownBy(() -> validatorImpl.validate(-105, -25)).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Division and divisor have to be positive. \n" + "In Your case division = "
						+ "-105" + " and divisor = " + "-25");
	}

	@Test
	void validate_inputDivisionAndDivisorPositive_expectedNothing() {	
		assertThatCode(() -> validatorImpl.validate(105, 25)).doesNotThrowAnyException();
	}

}
