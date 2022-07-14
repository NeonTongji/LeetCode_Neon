import java.util.concurrent.CountDownLatch;

public class Lu {

    public static void main(String[] args) throws InterruptedException {

        MyInteger n = new MyInteger();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        long startTime1 = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (n) {
                    for (int j = 0; j < 10000; j++) {
                        int v = n.getIntValue();
                        v++;
                        n.setIntValue(v);
                    }

                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName() + ": " + n.getIntValue());
                    }
                }
            }).start();
        }

        countDownLatch.await();
        System.out.println("最终： " + n.getIntValue());
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime1));

    }
}


class MyInteger {
    private int i;

    public MyInteger() {
        i = 0;
    }

    public int  getIntValue() {
        return i;
    }

    public void setIntValue(int val) {
        i = val;
    }
}
