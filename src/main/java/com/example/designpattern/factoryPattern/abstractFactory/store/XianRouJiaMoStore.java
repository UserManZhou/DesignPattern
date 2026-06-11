/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.abstractFactory.store
 * 所含类: XianRouJiaMoStore
 * 文件作用描述 西安肉夹馍商店实现类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/1  16:14      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.abstractFactory.store;

import com.example.designpattern.factoryPattern.abstractFactory.factory.impl.XianRouJiaMoFactory;
import com.example.designpattern.factoryPattern.abstractFactory.factory.impl.XianRouJiaMoProduceFactory;
import com.example.designpattern.factoryPattern.abstractFactory.product.RouJiaMo;

/**
 * <p>Titile:XianRouJiaMoStore</p >
 * <p>ProjectName: </p >
 * <p>Description:西安肉夹馍商店实现类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.abstractFactory.store
 * @Author: zh
 * @CreateTime: 2026/6/1  16:14
 * @Description: 西安肉夹馍商店实现类
 * @Version: 1.0
 */
public class XianRouJiaMoStore extends RouJiaMoStore {

    private XianRouJiaMoProduceFactory xianRouJiaMoProduceFactory;

    public XianRouJiaMoStore(XianRouJiaMoProduceFactory xianRouJiaMoProduceFactory) {
        this.xianRouJiaMoProduceFactory = xianRouJiaMoProduceFactory;
    }

    @Override
    public RouJiaMo sellRouJiaMo(String type) {
        RouJiaMo rouJiaMo = xianRouJiaMoProduceFactory.creatRoujiaMo(type);
        rouJiaMo.prepare(new XianRouJiaMoFactory());
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }
}
