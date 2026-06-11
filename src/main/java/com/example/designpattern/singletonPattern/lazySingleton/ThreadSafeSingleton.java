/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.singletonPattern.eagerSingleton
 * 所含类: ThreadSafeSingleton
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/11  14:58      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.singletonPattern.lazySingleton;

/**
 * <p>Titile:ThreadSafeSingleton</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.singletonPattern.eagerSingleton
 * @Author: zh
 * @CreateTime: 2026/6/11  14:58
 * @Description: TODO
 * @Version: 1.0
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton threadSafeSingleton = null;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (threadSafeSingleton == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }

}
