package chapter02.section02;

public class Thread_2_2_2_synchronizedOneThreadIn {

    public static void main(String[] args) {
        ObjectService service = new ObjectService();

        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }

    static class ObjectService {

        public void serviceMethod() {
            try {
                synchronized (this) {
                    System.out.println("begin time=" + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println("end    end=" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread {

        private ObjectService service;

        public ThreadA(ObjectService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.serviceMethod();
        }

    }

    static class ThreadB extends Thread {
        private ObjectService service;

        public ThreadB(ObjectService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.serviceMethod();
        }
    }

}
