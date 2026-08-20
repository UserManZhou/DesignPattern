/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.strategyPattern
 * 所含类: strategyTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/20  10:33      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.strategyPattern;

import com.example.designpattern.strategyPattern.bean.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:strategyTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.strategyPattern
 * @Author: zh
 * @CreateTime: 2026/8/20  10:33
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class strategyTest {

    @Test
    public void test() {
        Role roleA = new RoleA("A");

        roleA.setiAttackBehavior(new AttackJY())
                .setiDefendBehavior(new DefendTBS())
                .setiDisplayBehavior(new DisplayA())
                .setiRunBehavior(new RunJCTQ());
        System.out.println(roleA.getName() + ";");
        roleA.run();
        roleA.attack();
        roleA.defend();
        roleA.display();
    }

}
