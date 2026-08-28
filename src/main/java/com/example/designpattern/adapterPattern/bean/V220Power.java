/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.adapterPattern.bean
 * 所含类: V220Power
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/27  9:05      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.adapterPattern.bean;

/**
 * <p>Titile:V220Power</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.adapterPattern.bean
 * @Author: zh
 * @CreateTime: 2026/8/27  9:05
 * @Description: TODO
 * @Version: 1.0
 */
public class V220Power {

    /**
     * 提供220V交流电压
     *
     * @param
     * @return {@link int}
     * @throws Exception
     * @title provideV220Power
     * @description
     * @author zh
     * @date 2026-08-27 9:05
     *
     **/
    public int provideV220Power() {
        System.out.println("我提供220V交流电压。");
        return 220;
    }

}
