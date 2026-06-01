/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.simpleFactory.product
 * 所含类: SuanRouJiaMo
 * 文件作用描述 酸味肉夹馍具体产品类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  16:16      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.simpleFactory.product;

/**
 * <p>Titile:SuanRouJiaMo</p >
 * <p>ProjectName: </p >
 * <p>Description:酸味肉夹馍具体产品类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.simpleFactory.product
 * @Author: zh
 * @CreateTime: 2026/5/22  16:16
 * @Description: 酸味肉夹馍具体产品类
 * @Version: 1.0
 */
public class SuanRouJiaMo extends RouJiaMo {

    /**
     * 构造函数
     *
     * @param
     * @return {@link null}
     * @throws Exception
     * @title SuanRouJiaMo
     * @description
     * @author zh
     * @date 2026-05-22 16:18
     *
     **/
    public SuanRouJiaMo() {
        this.name = "酸味肉夹馍";
    }

}
