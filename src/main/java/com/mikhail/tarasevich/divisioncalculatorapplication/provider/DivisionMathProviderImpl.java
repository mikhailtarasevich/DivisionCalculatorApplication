package com.mikhail.tarasevich.divisioncalculatorapplication.provider;

import java.util.ArrayList;
import java.util.List;

import com.mikhail.tarasevich.divisioncalculatorapplication.domain.DivisionStep;

public class DivisionMathProviderImpl implements DivisionMathProvider {

    @Override
    public List<DivisionStep> divide(int division, int divisor) {
        List<DivisionStep> resultList = new ArrayList<>();
        DivisionStep stepResult = new DivisionStep();
        division = Math.abs(division);
        divisor = Math.abs(divisor);
        if (division < divisor) {
            stepResult.setIntermediateResult(0);
            stepResult.setSubtrahend(0);
            resultList.add(stepResult);
        } else {
            int[] divisionArray = Integer.toString(division).chars().map(digit -> digit - '0').toArray();
            int result = division / divisor;
            int[] resultArray = Integer.toString(result).chars().map(digit -> digit - '0').toArray();
            stepResult.setIntermediateResult(result);
            stepResult.setSubtrahend(0);
            resultList.add(stepResult);
            int j = 0;
            int k = 0;
            int currentDivision = divisionArray[j];
            int currentSubtrahend = resultArray[k] * divisor;

            for (int i = 0; i < divisionArray.length; i++) {
                DivisionStep step = new DivisionStep();
                if (currentDivision >= currentSubtrahend) {
                    int currentReminder = currentDivision - currentSubtrahend;
                    step.setIntermediateResult(currentDivision);
                    step.setSubtrahend(currentSubtrahend);
                    resultList.add(step);
                    j++;
                    if (j < divisionArray.length)
                        currentDivision = Integer.parseInt(String.valueOf(currentReminder) + String.valueOf(divisionArray[j]));
                    if (k < resultArray.length - 1) {
                        currentSubtrahend = resultArray[k + 1] * divisor;
                        k++;
                    }
                    continue;
                }
                currentDivision = Integer.parseInt(String.valueOf(currentDivision) + String.valueOf(divisionArray[j + 1]));
                j++;
            }
        }
        return resultList;
    }
}
