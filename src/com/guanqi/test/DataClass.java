package com.guanqi.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类(空调)，所有对资源类的操作都应该放在资源类(空调的功能都在空调内部实现)
 */
public class DataClass {
    private Integer number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increaseNumber() throws InterruptedException {
        lock.lock();
        try {
            while( !number.equals(0) ){
                condition.await();
            }
            ++number;
            System.out.println(Thread.currentThread().getName()+"\t:"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void descNumber() throws InterruptedException {
        lock.lock();
        try {
            while( number.equals(0) ){
                condition.await();
            }
            --number;
            System.out.println(Thread.currentThread().getName()+"\t:"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}
