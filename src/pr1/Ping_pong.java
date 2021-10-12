package pr1;

class Ping_pong implements Runnable{
    String word;
//    флаг для "бесконечного" цикла
    boolean running = true;

    private Object lock;

    public Ping_pong(String word, Object lock){
        this.word = word;
        this.lock = lock;
    }

    @Override
    public void run() {
//        предыдущий вариант задачи
//        while(running){
//            System.out.println(word);
//        }

        synchronized (lock) {
            while (true) {
                System.out.println(word);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                продолжаем работу потока, который ранее был на ожидании от метода wait()
                lock.notify();

                try {
//                    ставим поток на ожидание на 1 секунду
                    lock.wait(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    особый метод для остановки потока
    public void setStop() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException{
        Object locker = new Object();
        Ping_pong p1 = new Ping_pong("Ping", locker);
        Ping_pong p2 = new Ping_pong("Pong", locker);

//        инициализация двух потоков для двух "звуков"
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();

//        предыдущий вариант задачи
//        t2.sleep(5000);
//        p2.setStop();
//        t2.join();
    }
}