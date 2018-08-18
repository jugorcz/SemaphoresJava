public class BinSemaphore {
    private boolean locked;
    public BinSemaphore()
    {
        locked = false;
    }
    public BinSemaphore(Boolean locked)
    {
        this.locked = locked;
    }

    public synchronized void lock() {
        while(locked) {
            try {
                    wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notifyAll();
    }
}
