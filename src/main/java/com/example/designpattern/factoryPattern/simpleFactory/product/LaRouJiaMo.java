/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.simpleFactory.product
 * 所含类: LaRouJiaMo
 * 文件作用描述 辣味肉夹馍具体产品类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  16:15      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.simpleFactory.product;

/**
 * <p>Titile:LaRouJiaMo</p >
 * <p>ProjectName: </p >
 * <p>Description:辣味肉夹馍具体产品类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.simpleFactory.product
 * @Author: zh
 * @CreateTime: 2026/5/22  16:15
 * @Description: 辣味肉夹馍具体产品类
 * @Version: 1.0
 */
public class LaRouJiaMo extends RouJiaMo {

    /**
     * 构造方法
     *
     * @param
     * @return {@link null}
     * @throws Exception
     * @title LaRouJiaMo
     * @description
     * @author zh
     * @date 2026-05-22 16:18
     *
     **/
    public LaRouJiaMo() {
        this.name = "辣肉夹馍";
    }

}
