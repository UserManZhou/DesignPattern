/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.commandPattern
 * 所含类: QuickCommand
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/31  9:29      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.commandPattern;

/**
 * <p>Titile:QuickCommand</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.commandPattern
 * @Author: zh
 * @CreateTime: 2026/8/31  9:29
 * @Description: TODO
 * @Version: 1.0
 */
public class QuickCommand implements Command {

    private Command[] commands;

    public QuickCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
