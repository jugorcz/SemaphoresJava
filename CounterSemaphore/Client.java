/**
 * Created by Justyna Gorczyca on 23.10.2017.
 */
import java.util.Random;

public class Client implements Runnable {
    private Shop shop;
    private int id;
    public Client(int id, Shop shop) {
        this.id = id;
        this.shop = shop;
    }

    @Override
    public void run() {
        startShopping();
        endShopping();
    }

    public void startShopping() {
        System.out.println(id + " Oczekiwanie na koszyk");
        shop.giveBasket();
        System.out.println(id + " Pobrano koszyk");

        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000) + 500);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void endShopping() {
        System.out.println(id + " Oddano koszyk");
        shop.returnBasket();
    }
}
