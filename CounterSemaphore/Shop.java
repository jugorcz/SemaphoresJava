/**
 * Created by Justyna Gorczyca on 23.10.2017.
 */
public class Shop {
    public CounterSemaphore baskets;

    public Shop(int basketNumber) {
        baskets = new CounterSemaphore(basketNumber);
    }

    public void giveBasket() {
        baskets.lock();
    }

    public void returnBasket() {
        baskets.unlock();
    }
}
