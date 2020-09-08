package by.ginko.one;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner t = new Scanner(System.in);
        int m = Integer.parseInt(t.nextLine());
        Semaphore sem = new Semaphore(m); // m разрешений
        (new CountThread(sem,"Студент 1")).start();
        (new CountThread(sem,"Студент 2")).start();
        (new CountThread(sem,"Студент 3")).start();
        (new CountThread(sem,"Студент 4")).start();
        (new CountThread(sem,"Студент 5")).start();
        (new CountThread(sem,"Студент 6")).start();
        (new CountThread(sem,"Студент 7")).start();
        (new CountThread(sem,"Студент 8")).start();
        (new CountThread(sem,"Студент 9")).start();
        (new CountThread(sem,"Студент 10")).start();
        (new CountThread(sem,"Студент 11")).start();

        //Thread.sleep(3000);
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");


//        final BlockingQueue<String> queue =  new ArrayBlockingQueue<String>(2);
//        final BlockingQueue<String> queue2 =  new ArrayBlockingQueue<String>(2);
//        new Thread() {
//            public void run() {
//                for (int i = 1; i < 14; i++) {
//                    try {
//                        Thread.sleep(1_000); // извлечение одного
//                        if(queue.size() <= queue2.size()) {
//                            queue.put(" " + i); // добавление
//                            System.out.println("посетитель " + i + "  стал в очередь 1");
//                        }else
//                        {
//                            queue2.put(" " + i);
//                            System.out.println("посетитель " + i + "  стал в очередь 2");
//                        }
//                    }catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//        Thread.sleep(4_000); // извлечение одного
//        new Thread() {
//            public void run() {
//                for (int i = 1; i < 14; i++) {
//                    try {
//                        Thread.sleep(1000); // извлечение одного
//                        if(queue.size() >0) {
//                            System.out.println("посетитель "
//                                    + queue.take() + " вышел из очереди 1");
//                        }
//                        if(queue2.size() >0) {
//                            System.out.println("посетитель "
//                                    + queue2.take() + " вышел из очереди 2");
//                        }
//                    }catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//        Lizi qw = new Lizi(3);
//        new Client(qw).start();
//        new Prod(qw).start();
    }
}
