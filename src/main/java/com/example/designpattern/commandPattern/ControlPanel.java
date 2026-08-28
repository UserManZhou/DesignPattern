/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.commandPattern
 * 所含类: ControlPanel
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/28  17:26      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.commandPattern;

/**
 * <p>Titile:ControlPanel</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.commandPattern
 * @Author: zh
 * @CreateTime: 2026/8/28  17:26
 * @Description: TODO
 * @Version: 1.0
 */
public class ControlPanel {

    private static final int CONTROL_SIZE = 9;

    private Command[] commands;

    public ControlPanel() {
        commands = new Command[CONTROL_SIZE];
        for (int i = 0; i < CONTROL_SIZE; i++) {
            commands[i] = new NoCommand();
        }
    }

    /**
     * 设置命令
     *
     * @param slot
     * @param command
     * @return
     * @throws Exception
     * @title setCommand
     * @description
     * @author zh
     * @date 2026-08-28 17:26
     *
     **/
    public void setCommand(int slot, Command command) {
        commands[slot] = command;
    }

    /**
     * 按下按钮
     *
     * @param slot
     * @return
     * @throws Exception
     * @title pressButton
     * @description
     * @author zh
     * @date 2026-08-28 17:26
     *
     **/
    public void pressButton(int slot) {
        commands[slot].execute();
    }
}
