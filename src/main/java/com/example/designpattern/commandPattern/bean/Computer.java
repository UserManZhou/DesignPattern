/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.commandPattern.bean
 * 所含类: Computer
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/28  17:10      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.commandPattern.bean;

/**
 * <p>Titile:Computer</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.commandPattern.bean
 * @Author: zh
 * @CreateTime: 2026/8/28  17:10
 * @Description: TODO
 * @Version: 1.0
 */
public class Computer {

    /**
     * 打开电脑
     *
     * @param
     * @return
     * @throws Exception
     * @title on
     * @description
     * @author zh
     * @date 2026-08-28 17:10
     *
     **/
    public void on() {
        System.out.println("打开电脑");
    }

    /**
     * 关闭电脑
     *
     * @param
     * @return
     * @throws Exception
     * @title off
     * @description
     * @author zh
     * @date 2026-08-28 17:10
     *
     **/
    public void off() {
        System.out.println("关闭电脑");
    }
}
