package com.song.common.utils;

import java.util.concurrent.*;

/**
 *
 * 公共的线程池服务
 * @author shizuku
 * @date 2019/9/7 13:15
 */
public class ThreadPoolUtils {

    private static ExecutorService executorService;

    static {
        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(512);
        RejectedExecutionHandler policy = new ThreadPoolExecutor.DiscardPolicy();
        executorService = new ThreadPoolExecutor(poolSize, poolSize,
                0, TimeUnit.SECONDS,
                queue,
                policy);
    }

    /**
     * 异步任务处理
     * @param runnable
     */
    public static void handleAsynTask(Runnable runnable){
        executorService.submit(runnable);
    }
}
