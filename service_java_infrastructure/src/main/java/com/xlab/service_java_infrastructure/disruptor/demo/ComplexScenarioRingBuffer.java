/**
 * @create 2019-07-14 09:32
 * @desc use ringbuffer in complex scenario
 **/
package com.xlab.service_java_infrastructure.disruptor.demo;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexScenarioRingBuffer {

    public static void main(String[] args) throws InterruptedException {

        long beginTime=System.currentTimeMillis();
        int bufferSize=1024;
        ExecutorService executor= Executors.newFixedThreadPool(8);

        Disruptor<Trade> disruptor = new Disruptor<Trade>(new EventFactory<Trade>() {
            @Override
            public Trade newInstance() {
                return new Trade();
            }
        }, bufferSize, executor, ProducerType.SINGLE, new BusySpinWaitStrategy());

        //菱形操作
        /**
         //使用disruptor创建消费者组C1,C2
         EventHandlerGroup<Trade> handlerGroup =
         disruptor.handleEventsWith(new PreOrderHandler(), new MatchingMachineryHandler());
         //声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
         handlerGroup.then(new Handler3());
         */

        //顺序操作
        /**
         disruptor.handleEventsWith(new PreOrderHandler()).
         handleEventsWith(new MatchingMachineryHandler()).
         handleEventsWith(new Handler3());
         */

        //六边形操作.
        /**
         PreOrderHandler h1 = new PreOrderHandler();
         MatchingMachineryHandler h2 = new MatchingMachineryHandler();
         Handler3 h3 = new Handler3();
         Handler4 h4 = new Handler4();
         Handler5 h5 = new Handler5();
         disruptor.handleEventsWith(h1, h2);
         disruptor.after(h1).handleEventsWith(h4);
         disruptor.after(h2).handleEventsWith(h5);
         disruptor.after(h4, h5).handleEventsWith(h3);
         */



        disruptor.start();//启动
        CountDownLatch latch=new CountDownLatch(1);
        //生产者准备
        executor.submit(new TradePublisher(latch, disruptor));

        latch.await();//等待生产者完事.

        disruptor.shutdown();
        executor.shutdown();
        System.out.println("总耗时:"+(System.currentTimeMillis()-beginTime));
    }
}

