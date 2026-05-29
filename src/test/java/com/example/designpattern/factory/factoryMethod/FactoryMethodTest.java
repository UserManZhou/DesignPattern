/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.factoryMethod
 * 所含类: FactoryMethodTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/28  16:30      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.factoryMethod;

import com.example.designpattern.factory.factoryMethod.constant.RouJiaMoConstant;
import com.example.designpattern.factory.factoryMethod.factory.RouJiaMoStore;
import com.example.designpattern.factory.factoryMethod.factory.XianSimpleRoujiaMoFactory;
import com.example.designpattern.factory.factoryMethod.repository.XianRouJiaMoStore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:FactoryMethodTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.factoryMethod
 * @Author: zh
 * @CreateTime: 2026/5/28  16:30
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class FactoryMethodTest {

    @Test
    public void test() {
        RouJiaMoStore xianRouJiaMoStore = new XianRouJiaMoStore(new XianSimpleRoujiaMoFactory());
        xianRouJiaMoStore.sellRouJiaMo(RouJiaMoConstant.SUAN_ROU_JIA_MO);
    }

}
