package com.mikhail.tarasevich.divisioncalculatorapplication;

import com.mikhail.tarasevich.divisioncalculatorapplication.provider.DivisionMathProvider;
import com.mikhail.tarasevich.divisioncalculatorapplication.provider.DivisionMathProviderImpl;
import com.mikhail.tarasevich.divisioncalculatorapplication.provider.DivisionViewProvider;
import com.mikhail.tarasevich.divisioncalculatorapplication.provider.DivisionViewProviderImpl;
import com.mikhail.tarasevich.divisioncalculatorapplication.validator.Validator;
import com.mikhail.tarasevich.divisioncalculatorapplication.validator.ValidatorImpl;

public class DivisionCalculatorApplication {

    public static void main(String[] args) {

        Validator validator = new ValidatorImpl();
        DivisionMathProvider divisionMathProvider = new DivisionMathProviderImpl();
        DivisionViewProvider divisionViewProvider = new DivisionViewProviderImpl();
        DivisionCalculator divisionCalculator = new DivisionCalculator(validator, divisionMathProvider, divisionViewProvider);

        System.out.println(divisionCalculator.divide(12653, 75));
    }
}
