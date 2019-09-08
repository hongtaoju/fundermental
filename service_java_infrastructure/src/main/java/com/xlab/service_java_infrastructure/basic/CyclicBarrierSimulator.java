/*
 * module: fundermental
 * file: CyclicBarrierSimulator.java
 * date: 9/8/19 6:15 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-08 18:15
 * @desc simulate of cyclic barrier
 **/
package com.xlab.service_java_infrastructure.basic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSimulator {

    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for(int i=0;i<N;i++)
        {
            new Writer(barrier).start();
        }


    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000); //以睡眠来模拟线程需要预定写入数据操作
                System.out.println(" 线程" + Thread.currentThread().getName() + " 写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}

