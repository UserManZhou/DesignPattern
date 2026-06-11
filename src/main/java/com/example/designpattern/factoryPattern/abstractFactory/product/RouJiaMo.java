/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.abstractFactory.product
 * 所含类: RouJiaMo
 * 文件作用描述 肉夹馍抽象类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/1  16:03      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.abstractFactory.product;

import com.example.designpattern.factoryPattern.abstractFactory.factory.RouJiaMoYLRactory;
import com.example.designpattern.factoryPattern.abstractFactory.ingredient.Meet;
import com.example.designpattern.factoryPattern.abstractFactory.ingredient.YuanLiao;

/**
 * <p>Titile:RouJiaMo</p >
 * <p>ProjectName: </p >
 * <p>Description:肉夹馍抽象类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.abstractFactory.product
 * @Author: zh
 * @CreateTime: 2026/6/1  16:03
 * @Description: 肉夹馍抽象类
 * @Version: 1.0
 */
public abstract class RouJiaMo {

    protected String name;

    /**
     * 创建原料
     *
     * @param rouJiaMoYLRactory
     * @return
     * @throws Exception
     * @title prepare
     * @description
     * @author zh
     * @date 2026-06-01 16:09
     *
     **/
    public final void prepare(RouJiaMoYLRactory rouJiaMoYLRactory) {
        Meet meet = rouJiaMoYLRactory.createMeet();
        YuanLiao yuanLiao = rouJiaMoYLRactory.createYuanLiao();
        System.out.println("---RoujiaMo:" + "使用官方的原料 ---" + name + ": 揉面-剁肉-完成准备工作 yuanLiao:" + meet + "yuanLiao:" + yuanLiao);
    }

    /**
     *
     * @param
     * @return
     * @throws Exception
     * @title fire
     * @description
     * @author zh
     * @date 2026-06-01 16:10
     *
     **/
    public void fire() {
        System.out.println("---RoujiaMo:" + "开始 firing ---" + name);
    }

    /**
     * 创建面
     *
     * @param
     * @return
     * @throws Exception
     * @title pack
     * @description
     * @author zh
     * @date 2026-06-01 16:10
     *
     **/

    public void pack() {
        System.out.println("---RoujiaMo:" + "开始 pack ---" + name);
    }

}
