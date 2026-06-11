/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.simpleFactory.factory
 * 所含类: SimpleRouJiaMoFactroy
 * 文件作用描述 简单肉夹馍工厂类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  16:22      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.simpleFactory.factory;

import com.example.designpattern.factoryPattern.simpleFactory.constant.RouJiaMoConstant;
import com.example.designpattern.factoryPattern.simpleFactory.product.LaRouJiaMo;
import com.example.designpattern.factoryPattern.simpleFactory.product.RouJiaMo;
import com.example.designpattern.factoryPattern.simpleFactory.product.SuanRouJiaMo;
import com.example.designpattern.factoryPattern.simpleFactory.product.TianRouJiaMo;

/**
 * <p>Titile:SimpleRouJiaMoFactroy</p >
 * <p>ProjectName: </p >
 * <p>Description:简单肉夹馍工厂类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.simpleFactory.factory
 * @Author: zh
 * @CreateTime: 2026/5/22  16:22
 * @Description: 简单肉夹馍工厂类
 * @Version: 1.0
 */
public class SimpleRouJiaMoFactory {


    /**
     * 创建肉夹馍
     *
     * @param type
     * @return {@link RouJiaMo}
     * @throws Exception
     * @title createRouJiaMo
     * @description
     * @author zh
     * @date 2026-05-22 16:23
     *
     **/
    public RouJiaMo createRouJiaMo(String type) {
        RouJiaMo roujiaMo = null;
        if (RouJiaMoConstant.SUAN_ROU_JIA_MO.equals(type)) {
            roujiaMo = new SuanRouJiaMo();
        } else if (RouJiaMoConstant.LA_ROU_JIA_MO.equals(type)) {
            roujiaMo = new LaRouJiaMo();
        } else if (RouJiaMoConstant.TIAN_ROU_JIA_MO.equals(type)) {
            roujiaMo = new TianRouJiaMo();
        }
        return roujiaMo;
    }

}
