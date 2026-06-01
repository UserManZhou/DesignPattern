/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.simpleFactory.store
 * 所含类: RoujiaMoStore
 * 文件作用描述 肉夹馍商店类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  16:08      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.simpleFactory.store;

import com.example.designpattern.factory.simpleFactory.factory.SimpleRouJiaMoFactory;
import com.example.designpattern.factory.simpleFactory.product.RouJiaMo;

/**
 * <p>Titile:RoujiaMoStore</p >
 * <p>ProjectName: </p >
 * <p>Description:肉夹馍商店类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.simpleFactory.store
 * @Author: zh
 * @CreateTime: 2026/5/22  16:08
 * @Description: 肉夹馍商店类
 * @Version: 1.0
 */
public class RouJiaMoStore {

    private SimpleRouJiaMoFactory simpleRouJiaMoFactory;

    public RouJiaMoStore(SimpleRouJiaMoFactory simpleRouJiaMoFactory) {
        this.simpleRouJiaMoFactory = simpleRouJiaMoFactory;
    }

    /**
     * 卖肉夹馍
     *
     * @param type
     * @return {@link RouJiaMo}
     * @throws Exception
     * @title sellRoujiaMo
     * @description
     * @author zh
     * @date 2026-05-22 16:24
     *
     **/
    public RouJiaMo sellRoujiaMo(String type) {
        RouJiaMo roujiaMo = simpleRouJiaMoFactory.createRouJiaMo(type);
        roujiaMo.prepare();
        roujiaMo.fire();
        roujiaMo.pack();
        return roujiaMo;
    }


}
