package com.mikhail.tarasevich.divisioncalculatorapplication.provider;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.mikhail.tarasevich.divisioncalculatorapplication.domain.DivisionStep;

class DivisionMathProviderImplTest {

    private final DivisionMathProviderImpl divisionMathProviderImpl = new DivisionMathProviderImpl();

    @Test
    void divide_inputTwoIntDigits_expectedArrayListOfDivisionStep1() {
        final List<DivisionStep> expected = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(36);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(72);
        ds2.setSubtrahend(60);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(121);
        ds3.setSubtrahend(120);

        expected.add(ds1);
        expected.add(ds2);
        expected.add(ds3);

        final List<DivisionStep> actual = divisionMathProviderImpl.divide(721, 20);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void divide_inputTwoIntDigits_expectedArrayListOfDivisionStep2() {
        final List<DivisionStep> expected = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(0);
        ds1.setSubtrahend(0);

        expected.add(ds1);

        final List<DivisionStep> actual = divisionMathProviderImpl.divide(0, 10);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void divide_inputTwoIntDigits_expectedArrayListOfDivisionStep3() {
        final List<DivisionStep> expected = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(0);
        ds1.setSubtrahend(0);

        expected.add(ds1);

        final List<DivisionStep> actual = divisionMathProviderImpl.divide(9, 10);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void divide_inputTwoIntDigits_expectedArrayListOfDivisionStep4() {
        final List<DivisionStep> expected = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(100001011);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(1);
        ds2.setSubtrahend(1);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(0);
        ds3.setSubtrahend(0);

        expected.add(ds1);
        expected.add(ds2);
        expected.add(ds3);
        expected.add(ds3);
        expected.add(ds3);
        expected.add(ds3);
        expected.add(ds2);
        expected.add(ds3);
        expected.add(ds2);
        expected.add(ds2);

        final List<DivisionStep> actual = divisionMathProviderImpl.divide(100001011, 1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void divide_inputTwoIntDigits_expectedArrayListOfDivisionStep5() {
        final List<DivisionStep> expected = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(128);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(8970);
        ds2.setSubtrahend(7001);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(19691);
        ds3.setSubtrahend(14002);
        final DivisionStep ds4 = new DivisionStep();
        ds4.setIntermediateResult(56892);
        ds4.setSubtrahend(56008);

        expected.add(ds1);
        expected.add(ds2);
        expected.add(ds3);
        expected.add(ds4);

        final List<DivisionStep> actual = divisionMathProviderImpl.divide(897012, 7001);

        assertThat(actual).isEqualTo(expected);
    }
}
