import java.util.ArrayDeque;
import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Buffer {

        private String message;
        private BinSemaphore readSem;
        private BinSemaphore writeSem;

        public Buffer(){
            readSem = new BinSemaphore(true);
            writeSem = new BinSemaphore();
        }

        public void put(String message) throws InterruptedException {
            writeSem.lock();
            this.message = message;
            readSem.unlock();
        }

        public String take() throws InterruptedException {
            String message;
            readSem.lock();
            message = this.message;
            writeSem.unlock();
            return message;
        }
}
