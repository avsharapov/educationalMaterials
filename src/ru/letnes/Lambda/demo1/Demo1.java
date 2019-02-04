package ru.letnes.Lambda.demo1;

public class Demo1 {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        FormulaClass formulaClass = new FormulaClass();

        // anonim
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
        // class
        System.out.println(formulaClass.calculate(100));
        System.out.println(formulaClass.sqrt(16));

    }


    static class FormulaClass implements Formula {
        @Override
        public double calculate(int a) {
            return sqrt(a * 100);
        }
    }

}
