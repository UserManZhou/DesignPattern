/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.abstractFactory.factory.impl
 * 所含类: XianRouJiaMoProduceFactory
 * 文件作用描述 西安肉夹馍生产工厂（普通工厂）
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/1  16:15      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.abstractFactory.factory.impl;

import com.example.designpattern.factory.abstractFactory.product.RouJiaMo;
import com.example.designpattern.factory.abstractFactory.product.XianSuanRouJiaMo;

/**
 * <p>Titile:XianRouJiaMoProduceFactory</p >
 * <p>ProjectName: </p >
 * <p>Description:西安肉夹馍生产工厂（普通工厂）</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.abstractFactory.factory.impl
 * @Author: zh
 * @CreateTime: 2026/6/1  16:15
 * @Description: 西安肉夹馍生产工厂（普通工厂）
 * @Version: 1.0
 */
public class XianRouJiaMoProduceFactory {

    /**
     * 创建肉夹馍
     *
     * @param type
     * @return {@link RouJiaMo}
     * @throws Exception
     * @title creatRoujiaMo
     * @description
     * @author zh
     * @date 2026-06-01 16:22
     *
     **/
    public RouJiaMo creatRoujiaMo(String type) {
        RouJiaMo roujiaMo = null;
        switch (type) {
            case "Suan":
                roujiaMo = new XianSuanRouJiaMo();
                break;
            case "La":
//                roujiaMo = new XianKuRoujiMo();
                break;
            case "Tian":
//                roujiaMo = new XianlaRoujiMo();
                break;
            default:// 默认为酸肉夹馍
                roujiaMo = new XianSuanRouJiaMo();
                break;
        }
        return roujiaMo;
    }
}
