/*
 * module: fundermental
 * file: OverrideConcurrentSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: OverrideConcurrentSimulator.java
 * date: 12/26/18 10:40 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 10:40
 * @desc test of override concurrent
 * 子类同步方法覆盖父类同步方法。可以指定调用父类的同步方法
 * 相当于锁的重入。
 **/
package com.xlab.service_java_infrastructure.concurrent;


import java.util.concurrent.TimeUnit;

public class OverrideConcurrentSimulator {

    synchronized void notifyMsg() {

        System.out.println(" this is super notifyMsg() ");
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" this is end super notifyMsg() ");
    }

    public static void main(String[] args) {
        SubOverrideConcurrentSimulator overrideConcurrentSimulator = new SubOverrideConcurrentSimulator();
       overrideConcurrentSimulator.notifyMsg();
    }

    /**
     * this is the result in my Macos 10.14.2
     *  this is sub notifyMsg()
     *  this is super notifyMsg()
     *  this is end super notifyMsg()
     *  this is end sub notifyMsg()
     */

}

