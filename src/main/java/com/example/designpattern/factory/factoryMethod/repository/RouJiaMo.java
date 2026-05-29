/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.factoryMethod.repository
 * 所含类: RouJiaMo
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/28  16:25      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.factoryMethod.repository;

/**
 * <p>Titile:RouJiaMo</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.factoryMethod.repository
 * @Author: zh
 * @CreateTime: 2026/5/28  16:25
 * @Description: TODO
 * @Version: 1.0
 */
public class RouJiaMo {

    // @author zh @date 2026-05-28 16:26:17 @description 名称
    protected String name;

    /**
     * 揉面-剁肉-完成准备工作
     *
     * @param
     * @return
     * @throws Exception
     * @title prepare
     * @description
     * @author zh
     * @date 2026-05-22 16:10
     *
     **/
    public void prepare() {
        System.out.println(name + "揉面-剁肉-完成准备工作");
    }

    /**
     * 包装-完成准备工作
     *
     * @param
     * @return
     * @throws Exception
     * @title pack
     * @description
     * @author zh
     * @date 2026-05-22 16:11
     *
     **/
    public void pack() {
        System.out.println(name + "肉夹馍-专用袋-包装");
    }

    /**
     * 烘烤-完成准备工作
     *
     * @param
     * @return
     * @throws Exception
     * @title fire
     * @description
     * @author zh
     * @date 2026-05-22 16:11
     *
     **/
    public void fire() {
        System.out.println(name + "肉夹馍-专用设备-烘烤");
    }
}
