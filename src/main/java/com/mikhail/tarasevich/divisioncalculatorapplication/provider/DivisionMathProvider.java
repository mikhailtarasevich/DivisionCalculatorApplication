package com.mikhail.tarasevich.divisioncalculatorapplication.provider;

import java.util.List;

import com.mikhail.tarasevich.divisioncalculatorapplication.domain.DivisionStep;

public interface DivisionMathProvider {
    List<DivisionStep> divide(int division, int divisor);
}
