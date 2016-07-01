package enterprise.module_1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Evaluator evaluator = new Evaluator();
        evaluator.printResult("SIZE = 10K", 10_000);
        evaluator.printResult("SIZE = 100K", 100_000);
        evaluator.printResult("SIZE = 1000K", 1_000_000);
        evaluator.writeToFile("result.txt");

    }
}
