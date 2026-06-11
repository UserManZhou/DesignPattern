/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.singletonPattern
 * 所含类: EagerSingletonTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/11  11:28      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.singletonPattern;

import com.example.designpattern.singletonPattern.eagerSingleton.NewSingleton;
import com.example.designpattern.singletonPattern.eagerSingleton.Singleton;
import com.example.designpattern.singletonPattern.innerClassSingleton.InnerClassSingleton;
import com.example.designpattern.singletonPattern.lazySingleton.DoubleCheckLockSingleton;
import com.example.designpattern.singletonPattern.lazySingleton.ThreadSafeSingleton;
import com.example.designpattern.singletonPattern.lazySingleton.ThreadUnsafeSingleton;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Titile:EagerSingletonTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.singletonPattern
 * @Author: zh
 * @CreateTime: 2026/6/11  11:28
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class EagerSingletonTest {

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton + " " + Thread.currentThread().getName());
        };
        for (int i = 0; i < 10; i++) {
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    @Test
    public void test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            NewSingleton singleton = NewSingleton.getInstance();
            System.out.println(singleton + " " + Thread.currentThread().getName());
        };
        for (int i = 0; i < 10; i++) {
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    @Test
    public void test3() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            ThreadUnsafeSingleton singleton = ThreadUnsafeSingleton.getInstance();
            System.out.println(singleton + " " + Thread.currentThread().getName());
        };
        for (int i = 0; i < 10; i++) {
            executorService.execute(runnable);
            executorService.execute(runnable);
            executorService.execute(runnable);
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    @Test
    public void test4() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
            System.out.println(singleton + " " + Thread.currentThread().getName());
        };
        for (int i = 0; i < 10; i++) {
            executorService.execute(runnable);
            executorService.execute(runnable);
            executorService.execute(runnable);
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }


    @Test
    public void test5() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            DoubleCheckLockSingleton singleton = DoubleCheckLockSingleton.getInstance();
            System.out.println(singleton + " " + Thread.currentThread().getName());
        };
        for (int i = 0; i < 10; i++) {
            executorService.execute(runnable);
            executorService.execute(runnable);
            executorService.execute(runnable);
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }


    @Test
    public void test6() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            InnerClassSingleton singleton = InnerClassSingleton.getInstance();
            System.out.println(singleton + " " + Thread.currentThread().getName());
        };
        for (int i = 0; i < 10; i++) {
            executorService.execute(runnable);
            executorService.execute(runnable);
            executorService.execute(runnable);
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

}
