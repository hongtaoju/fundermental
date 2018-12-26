/*
 * module: fundermental
 * file: DirtyReadConcurrentSimulator.java
 * date: 12/26/18 10:03 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 10:02
 * @desc test of dirty read
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.concurrent.TimeUnit;

public class DirtyReadConcurrentSimulator {

    private double shareDouble = 0.0;

    public synchronized void setShareDouble(double shared) {

        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.shareDouble = shared;
    }

    public double getShareDouble() {
        return this.shareDouble;
    }

    public static void main(String[] args) {
        DirtyReadConcurrentSimulator dirtyReadConcurrentSimulator = new DirtyReadConcurrentSimulator();

        new Thread(new Runnable() {
            @Override
            public void run() {
                dirtyReadConcurrentSimulator.setShareDouble(100);
            }
        }).start();

        System.out.println("first get shared double " + dirtyReadConcurrentSimulator.getShareDouble());

        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second get shared double after sleep 2 seconds " + dirtyReadConcurrentSimulator.getShareDouble());
    }
}

