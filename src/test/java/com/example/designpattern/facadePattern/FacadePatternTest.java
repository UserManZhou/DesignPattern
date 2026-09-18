/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.facadePattern
 * 所含类: FacadePatternTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/9/15  19:39      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.facadePattern;

import com.example.designpattern.facadePattern.device.*;
import com.example.designpattern.facadePattern.theater.HomeTheaterFacade;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:FacadePatternTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.facadePattern
 * @Author: zh
 * @CreateTime: 2026/9/15  19:39
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class FacadePatternTest {

    @Test
    public void testFacadePattern() {
        Computer computer = new Computer();
        Light light = new Light();
        PopcornPopper popcornPopper = new PopcornPopper();
        Projector projector = new Projector();
        Player player = new Player();
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(computer, light, player, popcornPopper, projector);
        homeTheaterFacade.watchMovie();
        homeTheaterFacade.endMovie();
    }

}
