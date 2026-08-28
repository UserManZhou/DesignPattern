/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.commandPattern
 * 所含类: LightOffCommond
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/28  17:12      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.commandPattern;

import com.example.designpattern.commandPattern.bean.Light;

/**
 * <p>Titile:LightOffCommond</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.commandPattern
 * @Author: zh
 * @CreateTime: 2026/8/28  17:12
 * @Description: TODO
 * @Version: 1.0
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
