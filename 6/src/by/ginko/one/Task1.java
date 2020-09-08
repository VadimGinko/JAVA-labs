package by.ginko.one;

import java.util.concurrent.Semaphore;

class CountThread extends Thread{
    Semaphore sem;
    String name;
    CountThread(Semaphore sem, String name){
        this.sem=sem;
        this.name=name;
    }
    public void run(){
        try{
            System.out.println(name + " стоит в очереди чтобы помыться");
            sem.acquire();
            {System.out.println(name + " моется");
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {System.out.println(e.getMessage());}
        System.out.println(name + " освободил место в душевой");
        sem.release();

        /////////////3//////////

    }
}
