package com.mikhail.tarasevich.divisioncalculatorapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mikhail.tarasevich.divisioncalculatorapplication.domain.DivisionStep;
import com.mikhail.tarasevich.divisioncalculatorapplication.provider.DivisionMathProvider;
import com.mikhail.tarasevich.divisioncalculatorapplication.provider.DivisionViewProvider;
import com.mikhail.tarasevich.divisioncalculatorapplication.validator.Validator;

@ExtendWith(MockitoExtension.class)
class DivisionCalculatorTest {

    @InjectMocks
    private DivisionCalculator divisionCalculator;

    @Mock
    private Validator validator;

    @Mock
    private DivisionMathProvider divisionMathProvider;

    @Mock
    private DivisionViewProvider divisionViewProvider;

    @Mock
    private DivisionStep devisionStep;

    int division = 78945;
    int divisor = 4;
    final String expected = "_78945|4\n" + 
                            " 4    |------\n" + 
                            " -    |19736\n" + 
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" + 
                            " _29\n" + 
                            "  28\n" + 
                            "  --\n" + 
                            "  _14\n" + 
                            "   12\n" + 
                            "   --\n" + 
                            "   _25\n" + 
                            "    24\n" + 
                            "    --\n" + 
                            "     1\n";

    @Test
    void divide_inputAreTwoIntegerDigit_expectedStringOfDivision() {

        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(19736);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(7);
        ds2.setSubtrahend(4);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(38);
        ds3.setSubtrahend(36);
        final DivisionStep ds4 = new DivisionStep();
        ds4.setIntermediateResult(29);
        ds4.setSubtrahend(28);
        final DivisionStep ds5 = new DivisionStep();
        ds5.setIntermediateResult(14);
        ds5.setSubtrahend(12);
        final DivisionStep ds6 = new DivisionStep();
        ds6.setIntermediateResult(25);
        ds6.setSubtrahend(24);

        devisionStepList.add(ds1);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds4);
        devisionStepList.add(ds5);
        devisionStepList.add(ds6);

        doNothing().when(validator).validate(division, divisor);
        when(divisionMathProvider.divide(division, divisor)).thenReturn(devisionStepList);
        when(divisionViewProvider.viewProvider(devisionStepList, division, divisor)).thenReturn(expected);

        assertEquals(divisionCalculator.divide(division, divisor), expected);

        verify(validator).validate(division, divisor);
        verify(divisionMathProvider).divide(division, divisor);
        verify(divisionViewProvider).viewProvider(devisionStepList, division, divisor);
    }

    @Test
    void divide_inputDivisorIsZero_expectedException() {

        doThrow(new IllegalArgumentException("Divisor can not be ZERO - division by ZERO!")).when(validator)
                .validate(division, 0);
        assertThrows(IllegalArgumentException.class, () -> divisionCalculator.divide(division, 0));
        verify(validator).validate(division, 0);
        verifyNoMoreInteractions(divisionMathProvider, divisionViewProvider);
    }

}
