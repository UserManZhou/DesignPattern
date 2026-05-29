/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.simpleFactory.factory
 * 所含类: SimpleRouJiaMoFactroy
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  16:22      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.factoryMethod.factory;

import com.example.designpattern.factory.factoryMethod.constant.RouJiaMoConstant;
import com.example.designpattern.factory.factoryMethod.repository.RouJiaMo;
import com.example.designpattern.factory.factoryMethod.repository.XianLaRouJiaMo;
import com.example.designpattern.factory.factoryMethod.repository.XianTianRouJiaMo;

/**
 * <p>Titile:SimpleRouJiaMoFactroy</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.simpleFactory.factory
 * @Author: zh
 * @CreateTime: 2026/5/22  16:22
 * @Description: TODO
 * @Version: 1.0
 */
public class XianSimpleRoujiaMoFactory {


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
            roujiaMo = new XianLaRouJiaMo();
        } else if (RouJiaMoConstant.LA_ROU_JIA_MO.equals(type)) {
            roujiaMo = new XianLaRouJiaMo();
        } else if (RouJiaMoConstant.TIAN_ROU_JIA_MO.equals(type)) {
            roujiaMo = new XianTianRouJiaMo();
        }
        return roujiaMo;
    }

}
