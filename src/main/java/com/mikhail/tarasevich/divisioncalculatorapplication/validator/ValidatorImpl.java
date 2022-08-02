package com.mikhail.tarasevich.divisioncalculatorapplication.validator;

public class ValidatorImpl implements Validator {

    @Override
    public void validate(int division, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can not be ZERO - division by ZERO!");
        }
        if (division < 0 || divisor < 0) {
            throw new IllegalArgumentException("Division and divisor have to be positive. \n"
                    + "In Your case division = " + division + " and divisor = " + divisor);
        }
    }
}
