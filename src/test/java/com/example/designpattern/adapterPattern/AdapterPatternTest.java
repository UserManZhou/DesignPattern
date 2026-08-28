/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.adapterPattern
 * 所含类: AdapterPatternTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/27  9:12      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.adapterPattern;

import com.example.designpattern.adapterPattern.adapter.V5PowerAdapter;
import com.example.designpattern.adapterPattern.bean.Mobile;
import com.example.designpattern.adapterPattern.bean.V220Power;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:AdapterPatternTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.adapterPattern
 * @Author: zh
 * @CreateTime: 2026/8/27  9:12
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class AdapterPatternTest {

    @Test
    public void Test() {
        Mobile mobile = new Mobile();
        V5PowerAdapter v5PowerAdapter = new V5PowerAdapter(new V220Power());
        mobile.inputPower(v5PowerAdapter);
        System.out.println("电压为：" + v5PowerAdapter.provideV5Power() + "V");
    }

}
