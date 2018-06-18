package com.guanqi.test;

import com.guanqi.Enum.CountryEnum;
import sun.applet.Main;

import java.util.concurrent.CountDownLatch;

public class ThreadDemo {
    /**
     * 有一个变量，初始值为0，
     * 有四个线程，对变量加1后再减1，循环10次
     *
     * 多线程编程的模板：
     *      1.编写资源类（空调）
     *      2.要求：高内聚，低耦合
     *
     *     判断，干活，通知
     */
    public static void main(String[] args) throws InterruptedException {
       /* DataClass dataClass = new DataClass();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    dataClass.increaseNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ,"AA").start();
        new Thread( () -> {
            for (int i = 0; i < 20; i++) {
                try {
                    dataClass.descNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();*/

      /*  LockDemo lockdemo = new LockDemo();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                lockdemo.print5(i);
            }
        },
                "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                lockdemo.print10(i);
            }
        },
                "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                lockdemo.print15(i);
            }
        },
                "CC").start();*/
        CountDownLatch cdl = new CountDownLatch(4);
        for (int i = 1; i <= 4; i++) {
            new Thread( () -> {
                System.out.println(Thread.currentThread().getName()+"\t灭亡");
                cdl.countDown();
            }, CountryEnum.getCountryMsg(i).getCode()).start();

        }
        cdl.await();
        System.out.println("六国灭亡，秦一统天下");
        System.out.println(CountryEnum.QI.getCode());
        System.out.println(CountryEnum.QI.getIndex());

    }
}
