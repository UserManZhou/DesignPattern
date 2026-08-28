/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.commandPattern.bean
 * 所含类: Door
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/28  17:08      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.commandPattern.bean;

/**
 * <p>Titile:Door</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.commandPattern.bean
 * @Author: zh
 * @CreateTime: 2026/8/28  17:08
 * @Description: TODO
 * @Version: 1.0
 */
public class Door {

    /**
     * 打开门
     *
     * @param
     * @return
     * @throws Exception
     * @title open
     * @description
     * @author zh
     * @date 2026-08-28 17:09
     *
     **/
    public void open() {
        System.out.println("打开门");
    }

    /**
     * 关闭门
     *
     * @param
     * @return
     * @throws Exception
     * @title close
     * @description
     * @author zh
     * @date 2026-08-28 17:09
     *
     **/
    public void close() {
        System.out.println("关闭门");
    }

}
