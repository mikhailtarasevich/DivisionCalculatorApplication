package com.mikhail.tarasevich.divisioncalculatorapplication.provider;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.mikhail.tarasevich.divisioncalculatorapplication.domain.DivisionStep;

class DivisionViewProviderImplTest {

    DivisionViewProviderImpl divisionViewProvider = new DivisionViewProviderImpl();

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision1() {

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

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 78945, 4);
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

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision2() {
        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(0);
        ds1.setSubtrahend(0);

        devisionStepList.add(ds1);

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 0, 10);

        final String expected = "_0|10\n" + 
                                " 0|---\n" + 
                                " -|0\n" + 
                                " 0\n";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision3() {
        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(0);
        ds1.setSubtrahend(0);

        devisionStepList.add(ds1);

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 9, 11);
        final String expected = "_9|11\n" + 
                                " 0|---\n" + 
                                " -|0\n" + 
                                " 9\n";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision4() {
        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(7073);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(155);
        ds2.setSubtrahend(154);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(16);
        ds3.setSubtrahend(0);
        final DivisionStep ds4 = new DivisionStep();
        ds4.setIntermediateResult(162);
        ds4.setSubtrahend(154);
        final DivisionStep ds5 = new DivisionStep();
        ds5.setIntermediateResult(81);
        ds5.setSubtrahend(66);

        devisionStepList.add(ds1);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds4);
        devisionStepList.add(ds5);

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 155621, 22);
        final String expected = "_155621|22\n" + 
                                " 154   |-----\n" + 
                                " ---   |7073\n" + 
                                "  _16\n" + 
                                "    0\n" + 
                                "   --\n" + 
                                "  _162\n" + 
                                "   154\n" + 
                                "   ---\n" + 
                                "    _81\n" + 
                                "     66\n" + 
                                "     --\n" + 
                                "     15\n";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision5() {
        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(128144);
        ds1.setSubtrahend(7);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(8);
        ds2.setSubtrahend(7);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(19);
        ds3.setSubtrahend(14);
        final DivisionStep ds4 = new DivisionStep();
        ds4.setIntermediateResult(57);
        ds4.setSubtrahend(56);
        final DivisionStep ds5 = new DivisionStep();
        ds5.setIntermediateResult(10);
        ds5.setSubtrahend(7);
        final DivisionStep ds6 = new DivisionStep();
        ds6.setIntermediateResult(31);
        ds6.setSubtrahend(28);
        final DivisionStep ds7 = new DivisionStep();
        ds7.setIntermediateResult(32);
        ds7.setSubtrahend(28);

        devisionStepList.add(ds1);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds4);
        devisionStepList.add(ds5);
        devisionStepList.add(ds6);
        devisionStepList.add(ds7);

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 897012, 7);
        final String expected = "_897012|7\n" + 
                                " 7     |-------\n" + 
                                " -     |128144\n" + 
                                "_19\n" + 
                                " 14\n" + 
                                " --\n" + 
                                " _57\n" + 
                                "  56\n" + 
                                "  --\n" + 
                                "  _10\n" + 
                                "    7\n" + 
                                "   --\n" + 
                                "   _31\n" + 
                                "    28\n" + 
                                "    --\n" + 
                                "    _32\n" + 
                                "     28\n" + 
                                "     --\n" + 
                                "      4\n";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision6() {
        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(10001011);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(1);
        ds2.setSubtrahend(1);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(0);
        ds3.setSubtrahend(0);

        devisionStepList.add(ds1);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds3);
        devisionStepList.add(ds3);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds2);
        devisionStepList.add(ds2);

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 10001011, 1);
        final String expected = "_10001011|1\n" + 
                                " 1       |---------\n" + 
                                " -       |10001011\n" + 
                                " 0\n" + 
                                "    _1\n" + 
                                "     1\n" + 
                                "     -\n" + 
                                "     0\n" + 
                                "      _1\n" + 
                                "       1\n" + 
                                "       -\n" + 
                                "       _1\n" + 
                                "        1\n" + 
                                "        -\n" + 
                                "        0\n";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision7() {
        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(10001010);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(1);
        ds2.setSubtrahend(1);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(0);
        ds3.setSubtrahend(0);

        devisionStepList.add(ds1);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds3);
        devisionStepList.add(ds3);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 10001010, 1);
        final String expected = "_10001010|1\n" + 
                                " 1       |---------\n" + 
                                " -       |10001010\n" + 
                                " 0\n" + 
                                "    _1\n" + 
                                "     1\n" + 
                                "     -\n" + 
                                "     0\n" + 
                                "      _1\n" + 
                                "       1\n" + 
                                "       -\n" + 
                                "       0\n" + 
                                "        0\n" + 
                                "        -\n" + 
                                "        0\n";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision8() {
        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(5006);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(10);
        ds2.setSubtrahend(10);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(0);
        ds3.setSubtrahend(0);
        final DivisionStep ds4 = new DivisionStep();
        ds4.setIntermediateResult(1);
        ds4.setSubtrahend(0);
        final DivisionStep ds5 = new DivisionStep();
        ds5.setIntermediateResult(12);
        ds5.setSubtrahend(12);

        devisionStepList.add(ds1);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds4);
        devisionStepList.add(ds5);

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 10012, 2);
        final String expected = "_10012|2\n" + 
                                " 10   |-----\n" + 
                                " --   |5006\n" + 
                                "  0\n" + 
                                "   _12\n" + 
                                "    12\n" + 
                                "    --\n" + 
                                "     0\n";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void viewProvider_inputAreLisOfDivisionStepAndTwoIntegerDigit_expectedStringOfDivision9() {
        final List<DivisionStep> devisionStepList = new ArrayList<>();
        final DivisionStep ds1 = new DivisionStep();
        ds1.setIntermediateResult(25000);
        ds1.setSubtrahend(0);
        final DivisionStep ds2 = new DivisionStep();
        ds2.setIntermediateResult(75);
        ds2.setSubtrahend(60);
        final DivisionStep ds3 = new DivisionStep();
        ds3.setIntermediateResult(150);
        ds3.setSubtrahend(150);
        final DivisionStep ds4 = new DivisionStep();
        ds4.setIntermediateResult(0);
        ds4.setSubtrahend(0);
        final DivisionStep ds5 = new DivisionStep();
        ds5.setIntermediateResult(3);
        ds5.setSubtrahend(1);

        devisionStepList.add(ds1);
        devisionStepList.add(ds2);
        devisionStepList.add(ds3);
        devisionStepList.add(ds4);
        devisionStepList.add(ds4);
        devisionStepList.add(ds5);

        final String actual = divisionViewProvider.viewProvider(devisionStepList, 750003, 30);
        final String expected = "_750003|30\n" + 
                                " 60    |------\n" + 
                                " --    |25000\n" + 
                                "_150\n" + 
                                " 150\n" + 
                                " ---\n" + 
                                "   0\n" + 
                                "     _3\n" + 
                                "      1\n" + 
                                "      -\n" + 
                                "      2\n";
        assertThat(actual).isEqualTo(expected);
    }

}
