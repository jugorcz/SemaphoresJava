/**
 * Created by Justyna Gorczyca on 23.10.2017.
 */
public class CounterSemaphore {
    private int counter;

    public CounterSemaphore(int val) throws IllegalArgumentException {
        if(val < 0)
            throw new IllegalArgumentException();
        this.counter = val;
    }

    public synchronized void lock() {
        while(counter == 0)
            try {
                wait();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        counter--;
    }

    public synchronized void unlock() {
        counter++;
        notifyAll();
    }
}
