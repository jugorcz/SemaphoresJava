/**
 * Created by Justyna Gorczyca on 23.10.2017.
 */

//zaimplementuj semafor licznikowy za pomoca metod wait i notify/notifyall
//przetestuj semafor na prostej symulacji samoobslugowego sklepu z ograniczona lp koszykow

public class Main {
    public static void main(String[] args){

        int basket = 4;
        int clientNumber = 10;

        Shop shop = new Shop(basket);
        Thread[] clientThreads = new Thread[clientNumber];

        for(int i = 0; i < clientNumber; i++) {
            clientThreads[i] = new Thread(new Client(i, shop));
            clientThreads[i].start();
        }

        for(int i = 0; i < clientNumber; i++)
            try {
                clientThreads[i].join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
    }
}
