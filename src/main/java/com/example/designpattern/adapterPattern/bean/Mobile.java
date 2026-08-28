/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.adapterPattern.bean
 * 所含类: Mobile
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/27  9:03      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.adapterPattern.bean;

/**
 * <p>Titile:Mobile</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.adapterPattern.bean
 * @Author: zh
 * @CreateTime: 2026/8/27  9:03
 * @Description: TODO
 * @Version: 1.0
 */
public class Mobile {

    /**
     * 输入电源V5
     *
     * @param v5Power
     * @return
     * @throws Exception
     * @title inputPower
     * @description
     * @author zh
     * @date 2026-08-27 9:04
     *
     **/
    public void inputPower(V5Power v5Power) {
        int provideV5Power = v5Power.provideV5Power();
        System.out.println("手机（客户端）：我需要5V电压充电，现在是-->" + provideV5Power + "V");
    }

}
