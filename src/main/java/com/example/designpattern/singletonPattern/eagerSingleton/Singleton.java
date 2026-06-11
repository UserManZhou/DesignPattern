/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.singletonPattern.eagerSingleton
 * 所含类: Singleton
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/11  11:27      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.singletonPattern.eagerSingleton;

/**
 * <p>Titile:Singleton</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.singletonPattern.eagerSingleton
 * @Author: zh
 * @CreateTime: 2026/6/11  11:27
 * @Description: TODO
 * @Version: 1.0
 */
public class Singleton {

    // @author zh @date 2026-06-11 11:27:58 @description 饿汉式单例
    private static Singleton singleton = new Singleton();

    // @author zh @date 2026-06-11 11:28:08 @description 获取单例对象
    private Singleton() {
    }

    // @author zh @date 2026-06-11 11:28:34 @description 获取单例对象
    public static Singleton getInstance() {
        return singleton;
    }

}
