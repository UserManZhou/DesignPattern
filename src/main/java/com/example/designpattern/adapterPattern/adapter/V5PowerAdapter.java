/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.adapterPattern.adapter
 * 所含类: V5PowerAdapter
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/27  9:06      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.adapterPattern.adapter;

import com.example.designpattern.adapterPattern.bean.V220Power;
import com.example.designpattern.adapterPattern.bean.V5Power;

/**
 * <p>Titile:V5PowerAdapter</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.adapterPattern.adapter
 * @Author: zh
 * @CreateTime: 2026/8/27  9:06
 * @Description: TODO
 * @Version: 1.0
 */
public class V5PowerAdapter implements V5Power {

    private V220Power v220Power;

    public V5PowerAdapter(V220Power v220Power) {
        this.v220Power = v220Power;
    }

    @Override
    public int provideV5Power() {
        int power = v220Power.provideV220Power();
        //power经过各种操作-->5
        System.out.println("适配器：我悄悄的适配了电压。");
        return 5;
    }
}
