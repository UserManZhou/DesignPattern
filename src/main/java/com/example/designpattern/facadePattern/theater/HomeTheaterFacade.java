/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.facadePattern.theater
 * 所含类: HomeTheaterFacade
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/9/15  19:33      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.facadePattern.theater;

import com.example.designpattern.facadePattern.device.*;

/**
 * <p>Titile:HomeTheaterFacade</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.facadePattern.theater
 * @Author: zh
 * @CreateTime: 2026/9/15  19:33
 * @Description: TODO
 * @Version: 1.0
 */
public class HomeTheaterFacade {

    private Computer computer;

    private Light light;

    private Player player;

    private PopcornPopper popcornPopper;

    private Projector projector;

    public HomeTheaterFacade(Computer computer, Light light, Player player, PopcornPopper popcornPopper, Projector projector) {
        this.computer = computer;
        this.light = light;
        this.player = player;
        this.popcornPopper = popcornPopper;
        this.projector = projector;
    }

    public void watchMovie() {
        computer.on();
        light.on();
        popcornPopper.on();
        projector.on();
        player.on();
        System.out.println("Watch movie...");
    }

    public void endMovie() {
        computer.off();
        light.off();
        popcornPopper.off();
        projector.off();
        player.off();
        System.out.println("End movie...");
    }

}

