package ru.letnes.testing;

public class MegaCalculator {
    private iCalculator calc;

    public MegaCalculator(iCalculator calc) {
        this.calc = calc;
    }

    public int getMultipleSum(int sumX, int sumY, int multiplicator){
        int sum = calc.getSum(sumX, sumY);
        return calc.getMultiple(multiplicator, sum);
    }

    public iCalculator getCalc() {
        return calc;
    }

    public int getNumOps(){
        return calc.getNumOps();
    }
}
