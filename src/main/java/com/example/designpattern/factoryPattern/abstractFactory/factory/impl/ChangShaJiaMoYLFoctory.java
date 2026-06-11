/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.abstractFactory.factory.impl
 * 所含类: ChangShajiaMoYLFoctory
 * 文件作用描述 长沙肉夹馍工厂实现类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/1  16:06      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.abstractFactory.factory.impl;

import com.example.designpattern.factoryPattern.abstractFactory.factory.RouJiaMoYLRactory;
import com.example.designpattern.factoryPattern.abstractFactory.ingredient.ChangShaFreshMeet;
import com.example.designpattern.factoryPattern.abstractFactory.ingredient.ChangShaTeSeYuanLiao;
import com.example.designpattern.factoryPattern.abstractFactory.ingredient.Meet;
import com.example.designpattern.factoryPattern.abstractFactory.ingredient.YuanLiao;

/**
 * <p>Titile:ChangShajiaMoYLFoctory</p >
 * <p>ProjectName: </p >
 * <p>Description:长沙肉夹馍工厂实现类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.abstractFactory.factory.impl
 * @Author: zh
 * @CreateTime: 2026/6/1  16:06
 * @Description: 长沙肉夹馍工厂实现类
 * @Version: 1.0
 */
public class ChangShaJiaMoYLFoctory implements RouJiaMoYLRactory {
    @Override
    public Meet createMeet() {
        return new ChangShaFreshMeet();
    }

    @Override
    public YuanLiao createYuanLiao() {
        return new ChangShaTeSeYuanLiao();
    }
}
