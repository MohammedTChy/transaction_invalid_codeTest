import java.util.*;

class MovingAverage {
private Queue<Integer> queue;
private int size;
private double sum;

public MovingAverage(Integer N) {
    queue = new LinkedList<>();
    size = N;
    sum = 0.0;
}

public Double add(Integer X) {
    queue.offer(X);
    sum += X;

    if (queue.size() > size) {
        sum -= queue.poll();
    }

    return sum / queue.size();
    }
}