package by.ginko.one;

class Lizi{
    public int x;
    public int max;
    private Lizi(){}
    public Lizi(int x)
    {
        this.x = x;
        this.max = x;
    }

    public synchronized void get() throws InterruptedException {
        if(x == 0) {
            System.out.println("Лыж нет");
            wait();
        }
        System.out.println("Лыжи взяты");
        x -= 1;
        notify();
    }
    public synchronized void put() throws InterruptedException {

        System.out.println("Лыжи отданы");
        x += 1;
        if(x == max)
        {
            wait();
        }
        notify();
    }
}

class Client extends Thread{
    Client(Lizi q)
    {
        this.liz = q;
    }
    Lizi liz;
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                liz.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Prod extends Thread{
    Prod(Lizi q)
    {
        this.liz = q;
    }
    Lizi liz;
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                liz.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}