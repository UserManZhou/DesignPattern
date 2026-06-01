/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.factoryMethod.store
 * 所含类: XianRouJiaMoStore
 * 文件作用描述 西安肉夹馍商店实现类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/28  16:27      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.factoryMethod.store;

import com.example.designpattern.factory.factoryMethod.factory.XianSimpleRoujiaMoFactory;
import com.example.designpattern.factory.factoryMethod.product.RouJiaMo;

/**
 * <p>Titile:XianRouJiaMoStore</p >
 * <p>ProjectName: </p >
 * <p>Description:西安肉夹馍商店实现类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.factoryMethod.store
 * @Author: zh
 * @CreateTime: 2026/5/28  16:27
 * @Description: 西安肉夹馍商店实现类
 * @Version: 1.0
 */
public class XianRouJiaMoStore extends RouJiaMoStore {


    private XianSimpleRoujiaMoFactory factory;

    public XianRouJiaMoStore(XianSimpleRoujiaMoFactory factory) {
        this.factory = factory;
    }


    @Override
    public RouJiaMo sellRouJiaMo(String type) {
        RouJiaMo rouJiaMo = factory.createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }
}
