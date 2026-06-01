/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.simpleFactory
 * 所含类: SimpleFactory
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  16:40      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.simpleFactory;

import com.example.designpattern.factory.simpleFactory.constant.RouJiaMoConstant;
import com.example.designpattern.factory.simpleFactory.factory.SimpleRouJiaMoFactory;
import com.example.designpattern.factory.simpleFactory.product.RouJiaMo;
import com.example.designpattern.factory.simpleFactory.store.RouJiaMoStore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:SimpleFactory</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.simpleFactory
 * @Author: zh
 * @CreateTime: 2026/5/22  16:40
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class SimpleFactoryTest {

    @Test
    public void test() {
        RouJiaMoStore rouJiaMoStore = new RouJiaMoStore(new SimpleRouJiaMoFactory());
        RouJiaMo rouJiaMo = rouJiaMoStore.sellRoujiaMo(RouJiaMoConstant.SUAN_ROU_JIA_MO);
        RouJiaMo rouJiaMo2 = rouJiaMoStore.sellRoujiaMo(RouJiaMoConstant.LA_ROU_JIA_MO);
        RouJiaMo rouJiaMo3 = rouJiaMoStore.sellRoujiaMo(RouJiaMoConstant.TIAN_ROU_JIA_MO);
    }

}
