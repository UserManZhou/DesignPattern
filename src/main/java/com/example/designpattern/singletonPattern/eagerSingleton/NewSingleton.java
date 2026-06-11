/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.singletonPattern.eagerSingleton
 * 所含类: NewSingleton
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/11  14:49      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.singletonPattern.eagerSingleton;

/**
 * <p>Titile:NewSingleton</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.singletonPattern.eagerSingleton
 * @Author: zh
 * @CreateTime: 2026/6/11  14:49
 * @Description: TODO
 * @Version: 1.0
 */
public class NewSingleton {

    private static NewSingleton newSingleton;

    static {
        System.out.println("静态方法加载");
        newSingleton = new NewSingleton();
    }

    private NewSingleton() {
    }

    public static NewSingleton getInstance() {
        return newSingleton;
    }

}
