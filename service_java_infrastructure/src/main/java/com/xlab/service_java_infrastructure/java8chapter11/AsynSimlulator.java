/*
 * module: fundermental
 * file: AsynSimlulator.java
 * date: 18-6-30 下午3:02
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-06-30 15:02
 * @desc asyn
 **/
package com.xlab.service_java_infrastructure.java8chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AsynSimlulator {

    private static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));
    public static void main(String[] args) {

        /*Shop shop = new Shop("BestBuy");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("pork");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");
        // 执行更多任务，比如查询其他商店
        doSomethingElse();
        // 在计算商品价格的同时
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");*/

        long start = System.nanoTime();
        System.out.println(findPriceWithCompletableFuture("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");


    }

    private static void doSomethingElse() {
        long sum = 0;
        for (int i=0;i<100000;i++){
            if (i%4==0) {
                sum = sum+i;
            }
        }
    }

    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public static List<String> findPriceWithParalletStream(String product) {
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f",shop.getName(),shop.getPrice(product))).collect(toList());
    }


    //使用CompletableFuture实现findPrices方法
    public static List<String> findPriceWithCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(()->String.format("%s price is %.2f",shop.getName(),shop.getPrice(product)))).collect(toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }
}
