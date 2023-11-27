class Station extends Thread {
    private int ticketCount = 20;
    public synchronized void sell() {
        if (ticketCount > 0) {
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + " sold ticket " + (20 - ticketCount));
        } else {
            System.out.println("All tickets have been sold.");
        }
    }

    @Override
    public void run() {
        while (ticketCount > 0) {
            sell();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Station st = new Station();
        Thread st1 = new Thread(st);
        Thread st2 = new Thread(st);
        Thread st3 = new Thread(st);

        st1.start();
        st2.start();
        st3.start();
    }
}
