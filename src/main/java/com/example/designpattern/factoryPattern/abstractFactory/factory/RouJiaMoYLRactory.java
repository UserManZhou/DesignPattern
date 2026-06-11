/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.abstractFactory.factory
 * 所含类: RouJiaMoYLRactory
 * 文件作用描述 肉夹馍抽象工厂接口
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/1  16:01      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.abstractFactory.factory;

import com.example.designpattern.factoryPattern.abstractFactory.ingredient.Meet;
import com.example.designpattern.factoryPattern.abstractFactory.ingredient.YuanLiao;

/**
 * <p>Titile:RouJiaMoYLRactory</p >
 * <p>ProjectName: </p >
 * <p>Description:肉夹馍抽象工厂接口</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.abstractFactory.factory
 * @Author: zh
 * @CreateTime: 2026/6/1  16:01
 * @Description: 肉夹馍抽象工厂接口
 * @Version: 1.0
 */
public interface RouJiaMoYLRactory {

    /**
     * 创建 meet
     *
     * @param
     * @return {@link Meet}
     * @throws Exception
     * @title createMeet
     * @description
     * @author zh
     * @date 2026-06-01 16:05
     *
     **/
    Meet createMeet();

    /**
     * 创建原料
     *
     * @param
     * @return {@link YuanLiao}
     * @throws Exception
     * @title createYuanLiao
     * @description
     * @author zh
     * @date 2026-06-01 16:05
     *
     **/
    YuanLiao createYuanLiao();

}
