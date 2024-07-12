package task;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<BigInteger> {
    int value;

    public FactorialTask(int value) {
        this.value = value;
    }

    @Override
    protected BigInteger compute() {
        if (value <= 1) {
            return BigInteger.ONE;
        } else {
            FactorialTask subTask = new FactorialTask(value - 1);
            subTask.fork();
            return BigInteger.valueOf(value).multiply(subTask.join());
        }
    }
}
