package com.mikhail.tarasevich.divisioncalculatorapplication.provider;

import java.util.List;

import com.mikhail.tarasevich.divisioncalculatorapplication.domain.DivisionStep;

public interface DivisionViewProvider {
    String viewProvider(List<DivisionStep> result, int division, int divisor);
}
