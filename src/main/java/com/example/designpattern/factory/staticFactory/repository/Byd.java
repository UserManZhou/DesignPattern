/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.staticFactory.repository
 * 所含类: Byd
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  10:14      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.staticFactory.repository;

/**
 * <p>Titile:Byd</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.staticFactory.repository
 * @Author: zh
 * @CreateTime: 2026/5/22  10:14
 * @Description: TODO
 * @Version: 1.0
 */
public class Byd implements Car {
    @Override
    public void run() {
        System.out.println("比亚迪运行");
    }
}
