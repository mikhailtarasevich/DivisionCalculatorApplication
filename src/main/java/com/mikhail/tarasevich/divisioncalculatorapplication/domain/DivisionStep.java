package com.mikhail.tarasevich.divisioncalculatorapplication.domain;

import java.util.Objects;

public class DivisionStep {
    private int intermediateResult;
    private int subtrahend;

    public int getIntermediateResult() {
        return intermediateResult;
    }

    public void setIntermediateResult(int intermediateResult) {
        this.intermediateResult = intermediateResult;
    }

    public int getSubtrahend() {
        return subtrahend;
    }

    public void setSubtrahend(int subtrahend) {
        this.subtrahend = subtrahend;
    }

    @Override
    public String toString() {
        return "DevisionStep [intermidiateResult=" + intermediateResult + ", subtrahend=" + subtrahend + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(intermediateResult, subtrahend);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DivisionStep other = (DivisionStep) obj;
        return intermediateResult == other.intermediateResult && subtrahend == other.subtrahend;
    }
}
