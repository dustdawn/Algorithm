package com.dustdawn.thread;

/**
 * @author dustdawn
 * @date 2019/9/22 10:02
 */

/**
 * 三个线程轮流打印ABC5次
 */
public class ABCThread extends Thread {
    private Lock lock;
    private String flag;
    public ABCThread(String flag, Lock lock) {
        this.flag = flag;
        this.lock = lock;
    }
    @Override
    public void run() {
        int count = 5;
        //System.out.println(Thread.currentThread().getName()+"线程启动");
        while (count > 0) {
            synchronized (lock) {
                if (lock.getFlag().equals(flag)) {
                    System.out.print(flag);
                    count--;
                    if("A".equals(flag))
                        lock.setFlag("B");//线程执行完方法后释放该方法的对象锁
                    else if("B".equals(flag))
                        lock.setFlag("C");
                    else if("C".equals(flag))
                        lock.setFlag("A");
                }
            }
        }
    }

    public static void main(String[] args) {
        Lock lock = new Lock();
        lock.setFlag("A");
        ABCThread thread1 = new ABCThread("A", lock);
        ABCThread thread2 = new ABCThread("B", lock);
        ABCThread thread3 = new ABCThread("C", lock);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Lock
{
    private String flag;

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }
}
