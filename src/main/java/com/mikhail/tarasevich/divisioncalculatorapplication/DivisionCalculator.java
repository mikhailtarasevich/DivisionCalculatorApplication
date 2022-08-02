package com.mikhail.tarasevich.divisioncalculatorapplication;

import com.mikhail.tarasevich.divisioncalculatorapplication.provider.DivisionMathProvider;
import com.mikhail.tarasevich.divisioncalculatorapplication.provider.DivisionViewProvider;
import com.mikhail.tarasevich.divisioncalculatorapplication.validator.Validator;

public class DivisionCalculator {

    private final Validator vlidator;
    private final DivisionMathProvider divisionMathProvider;
    private final DivisionViewProvider divisionViewProvider;

    public DivisionCalculator(Validator vlidator, DivisionMathProvider divisionMathProvider, DivisionViewProvider divisionViewProvider) {
        this.vlidator = vlidator;
        this.divisionMathProvider = divisionMathProvider;
        this.divisionViewProvider = divisionViewProvider;
    }

    public String divide(int division, int divisor) {
        vlidator.validate(division, divisor);
        return divisionViewProvider.viewProvider(divisionMathProvider.divide(division, divisor), division, divisor);
    }
}
