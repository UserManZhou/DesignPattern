/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.commandPattern
 * 所含类: CommandPatternTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/31  9:17      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.commandPattern;

import com.example.designpattern.commandPattern.bean.Computer;
import com.example.designpattern.commandPattern.bean.Door;
import com.example.designpattern.commandPattern.bean.Light;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:CommandPatternTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.commandPattern
 * @Author: zh
 * @CreateTime: 2026/8/31  9:17
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class CommandPatternTest {

    @Test
    public void testCommandPattern() {
        Door door = new Door();
        Light light = new Light();
        Computer computer = new Computer();

        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setCommand(0, new LightOnCommand(light));
        controlPanel.setCommand(1, new LightOffCommand(light));
        controlPanel.setCommand(2, new ComputerOnCommand(computer));
        controlPanel.setCommand(3, new ComputerOffCommand(computer));

        controlPanel.pressButton(0);
        controlPanel.pressButton(1);
        controlPanel.pressButton(2);
        controlPanel.pressButton(3);

        System.out.println("****点击一键搞定按钮****");
        QuickCommand quickCommand = new QuickCommand(new Command[]{new LightOnCommand(light), new LightOffCommand(light), new ComputerOnCommand(computer), new ComputerOffCommand(computer)});
        quickCommand.execute();
    }

}
