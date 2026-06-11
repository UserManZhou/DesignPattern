/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.abstractFactory.store
 * 所含类: RoujiaMoStore
 * 文件作用描述 肉夹馍商店抽象类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/1  16:13      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.abstractFactory.store;

import com.example.designpattern.factoryPattern.abstractFactory.product.RouJiaMo;

/**
 * <p>Titile:RoujiaMoStore</p >
 * <p>ProjectName: </p >
 * <p>Description:肉夹馍商店抽象类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.abstractFactory.store
 * @Author: zh
 * @CreateTime: 2026/6/1  16:13
 * @Description: 肉夹馍商店抽象类
 * @Version: 1.0
 */
public abstract class RouJiaMoStore {

    // @author zh @date 2026-06-01 16:14:17 @description 创建 RoujiaMo
    public abstract RouJiaMo sellRouJiaMo(String type);

}
