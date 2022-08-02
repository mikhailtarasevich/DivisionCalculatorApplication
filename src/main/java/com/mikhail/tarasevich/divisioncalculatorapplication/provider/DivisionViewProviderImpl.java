package com.mikhail.tarasevich.divisioncalculatorapplication.provider;

import java.util.List;

import com.mikhail.tarasevich.divisioncalculatorapplication.domain.DivisionStep;

public class DivisionViewProviderImpl implements DivisionViewProvider {

    private static final String LINE_BRAKE = "\n";
    private static final String DOWN_SPACE = "_";
    private static final String VERTICAL = "|";
    private static final String MINUS = "-";
    private static final String SPACE = " ";
    private int intermediateNumberOfSpaces = 0;

    public String viewProvider(List<DivisionStep> result, int division, int divisor) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(DOWN_SPACE).append(division).append(VERTICAL).append(divisor).append(LINE_BRAKE);
        if (result.size() <= 2) {
            resultString.append(stringMakerForResultSizeLessTwo(result, division, divisor));
        }
        if (result.size() > 2) {
            resultString.append(stringMakerForFirstThreeLines(result, division))
                        .append(stringMakerForLinesAfterThree(result));
        }
        return resultString.toString();
    }

    private StringBuilder stringMakerForResultSizeLessTwo(List<DivisionStep> result, int division, int divisor) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(addSpecialSigns(String.valueOf(division).length()
                - String.valueOf(result.get(0).getIntermediateResult() * divisor).length() + 1, SPACE));
        resultString.append(result.get(0).getIntermediateResult() * divisor);
        resultString.append(VERTICAL);
        resultString.append(addSpecialSigns(String.valueOf(divisor).length() + 1, MINUS));
        resultString.append(LINE_BRAKE).append(SPACE);
        resultString.append(addSpecialSigns(String.valueOf(division).length(), MINUS));
        resultString.append(VERTICAL).append(result.get(0).getIntermediateResult()).append(LINE_BRAKE);
        resultString.append(addSpecialSigns(String.valueOf(division).length()
                    - String.valueOf((division - result.get(0).getIntermediateResult() * divisor)).length() + 1,
                    SPACE));
        resultString.append(division - result.get(0).getIntermediateResult() * divisor).append(LINE_BRAKE);
        
        return resultString;
    }

    private StringBuilder stringMakerForFirstThreeLines(List<DivisionStep> result, int division) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(addSpecialSigns(String.valueOf(result.get(1).getIntermediateResult()).length()
                    - String.valueOf(result.get(1).getSubtrahend()).length() + 1, SPACE));
        resultString.append(result.get(1).getSubtrahend());
        resultString.append(addSpecialSigns(String.valueOf(division).length()
                    - String.valueOf(result.get(1).getIntermediateResult()).length(),
                    SPACE));
        resultString.append(VERTICAL);
        resultString.append(addSpecialSigns(String.valueOf(result.get(0).getIntermediateResult()).length() + 1, MINUS));
        resultString.append(LINE_BRAKE).append(SPACE);
        resultString.append(addSpecialSigns(String.valueOf(result.get(1).getIntermediateResult()).length(), MINUS));
        resultString.append(addSpecialSigns(String.valueOf(division).length() 
                    - String.valueOf(result.get(1).getIntermediateResult()).length(),
                    SPACE));
        resultString.append(VERTICAL).append(result.get(0).getIntermediateResult()).append(LINE_BRAKE);
        if (result.get(1).getIntermediateResult() - result.get(1).getSubtrahend() == 0)
            intermediateNumberOfSpaces = intermediateNumberOfSpacesCalculator(result, 1) + 1;
        else
            intermediateNumberOfSpaces = intermediateNumberOfSpacesCalculator(result, 1);

        return resultString;
    }

    private StringBuilder stringMakerForLinesAfterThree(List<DivisionStep> result) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 2; i < result.size(); i++) {
            if (result.get(i).getIntermediateResult() == 0 || result.get(i).getSubtrahend() == 0 && result.get(i - 1).getSubtrahend() == 0)
                stringMakerIfCoupleSubtrahendsOrIntermidiateResultsInSequenceAreZero(resultString, result, i);
            else stringMakerIfSequenceOfSubtrahendsOrIntermidiateResultsAreNotZero(resultString, result, i);
        }
        return resultString;
    }

    private StringBuilder stringMakerIfCoupleSubtrahendsOrIntermidiateResultsInSequenceAreZero(
            StringBuilder resultString, List<DivisionStep> result, int i) {
        if (result.get(i - 1).getIntermediateResult() != 0) {
            resultString.append(addSpecialSigns(intermediateNumberOfSpaces, SPACE));
            resultString.append(result.get(i).getIntermediateResult()).append(LINE_BRAKE);
        }
        if (i + 1 < result.size()) {
            if (result.get(i).getIntermediateResult() - result.get(i).getSubtrahend() == 0)
                intermediateNumberOfSpaces = intermediateNumberOfSpacesCalculator(result, i) + 1;
            else
                intermediateNumberOfSpaces = intermediateNumberOfSpacesCalculator(result, i);
        } else {
            for (int j = 0; j < intermediateNumberOfSpacesCalculator(result, i) + 1; j++) {
                resultString.append(SPACE);
            }
            resultString.append(result.get(result.size() - 1).getSubtrahend()).append(LINE_BRAKE);
            resultString.append(addSpecialSigns(intermediateNumberOfSpaces + 1, SPACE));
            resultString.append(addSpecialSigns(String.valueOf(result.get(i).getIntermediateResult()).length(), MINUS));
            resultString.append(LINE_BRAKE);
            resultString.append(addSpecialSigns(intermediateNumberOfSpacesCalculator(result, i) + 1, SPACE));
            resultString.append(result.get(i).getIntermediateResult() - result.get(i).getSubtrahend())
                        .append(LINE_BRAKE);
        }
        return resultString;
    }

    private StringBuilder stringMakerIfSequenceOfSubtrahendsOrIntermidiateResultsAreNotZero(StringBuilder resultString,
            List<DivisionStep> result, int i) {
        resultString.append(addSpecialSigns(intermediateNumberOfSpaces, SPACE));
        resultString.append(DOWN_SPACE).append(result.get(i).getIntermediateResult()).append(LINE_BRAKE);
        if (i + 1 < result.size()) {
            resultString
                    .append(addSpecialSigns(intermediateNumberOfSpacesCalculatorForLastIteration(result, i), SPACE));
            resultString.append(String.valueOf(result.get(i).getSubtrahend())).append(LINE_BRAKE);
            resultString.append(addSpecialSigns(intermediateNumberOfSpaces + 1, SPACE));
            resultString.append(addSpecialSigns(String.valueOf(result.get(i).getIntermediateResult()).length(), MINUS));
            if (result.get(i).getIntermediateResult() - result.get(i).getSubtrahend() == 0)
                intermediateNumberOfSpaces = intermediateNumberOfSpacesCalculator(result, i) + 1;
            else
                intermediateNumberOfSpaces = intermediateNumberOfSpacesCalculator(result, i);
            resultString.append(LINE_BRAKE);
        } else {
            resultString.append(addSpecialSigns(intermediateNumberOfSpacesCalculatorForLastIteration(result, i), SPACE));
            resultString.append(result.get(result.size() - 1).getSubtrahend() + LINE_BRAKE);
            resultString.append(addSpecialSigns(intermediateNumberOfSpaces + 1, SPACE));
            resultString.append(addSpecialSigns(String.valueOf(result.get(i).getIntermediateResult()).length(), MINUS));
            resultString.append(LINE_BRAKE);
            resultString.append(addSpecialSigns(intermediateNumberOfSpacesCalculator(result, i) + 1, SPACE));
            resultString.append(result.get(i).getIntermediateResult() - result.get(i).getSubtrahend())
                        .append(LINE_BRAKE);
        }
        return resultString;
    }

    private StringBuilder addSpecialSigns(int numberOfSpecialSign, String specialSignType) {
        StringBuilder addedString = new StringBuilder();
        for (int j = 0; j < numberOfSpecialSign; j++) {
            addedString.append(specialSignType);
        }
        return addedString;
    }

    private int intermediateNumberOfSpacesCalculator(List<DivisionStep> result, int i) {
        return intermediateNumberOfSpaces + String.valueOf(result.get(i).getIntermediateResult()).length()
                - String.valueOf(result.get(i).getIntermediateResult() - result.get(i).getSubtrahend()).length();
    }

    private int intermediateNumberOfSpacesCalculatorForLastIteration(List<DivisionStep> result, int i) {
        return intermediateNumberOfSpaces + String.valueOf(result.get(i).getIntermediateResult()).length()
                - String.valueOf(result.get(i).getSubtrahend()).length() + 1;
    }

}
