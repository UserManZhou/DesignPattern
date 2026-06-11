/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.abstractFactory
 * 所含类: AbstractFactoryTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/1  16:26      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.abstractFactory;

import com.example.designpattern.factoryPattern.abstractFactory.factory.impl.XianRouJiaMoProduceFactory;
import com.example.designpattern.factoryPattern.abstractFactory.product.RouJiaMo;
import com.example.designpattern.factoryPattern.abstractFactory.store.RouJiaMoStore;
import com.example.designpattern.factoryPattern.abstractFactory.store.XianRouJiaMoStore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:AbstractFactoryTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.abstractFactory
 * @Author: zh
 * @CreateTime: 2026/6/1  16:26
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class AbstractFactoryTest {

    @Test
    public void test() {
        RouJiaMoStore roujiaMoStore = new XianRouJiaMoStore(new XianRouJiaMoProduceFactory());
        RouJiaMo suanRoujiaMo = roujiaMoStore.sellRouJiaMo("Suan");
    }

}
