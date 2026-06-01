/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.staticFactory
 * 所含类: staticFactoryTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  10:17      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.staticFactory;

import com.example.designpattern.factory.staticFactory.constant.CarConstant;
import com.example.designpattern.factory.staticFactory.factory.CarSimpleFactory;
import com.example.designpattern.factory.staticFactory.product.Car;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:staticFactoryTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.staticFactory
 * @Author: zh
 * @CreateTime: 2026/5/22  10:17
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class staticFactoryTest {

    @Test
    public void test() throws Exception {
        // @author zh @date 2026-05-22 10:22:37 @description 测试静态工厂方法
        Car car = CarSimpleFactory.getCar(CarConstant.AUDI);
        // @author zh @date 2026-05-22 10:22:41 @description 测试静态工厂方法
        car.run();
        // @author zh @date 2026-05-22 10:22:45 @description 测试静态工厂方法
        car = CarSimpleFactory.createByd();
        // @author zh @date 2026-05-22 10:22:49 @description 测试静态工厂方法
        car.run();
    }

}
