/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.abstractFactory.factory.impl
 * 所含类: XianRouJiaMoFactory
 * 文件作用描述 西安肉夹馍工厂实现类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/6/1  16:24      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.abstractFactory.factory.impl;

import com.example.designpattern.factory.abstractFactory.factory.RouJiaMoYLRactory;
import com.example.designpattern.factory.abstractFactory.ingredient.Meet;
import com.example.designpattern.factory.abstractFactory.ingredient.XianRouJiaMoMeet;
import com.example.designpattern.factory.abstractFactory.ingredient.XianRouJiaMoYuanLiao;
import com.example.designpattern.factory.abstractFactory.ingredient.YuanLiao;

/**
 * <p>Titile:XianRouJiaMoFactory</p >
 * <p>ProjectName: </p >
 * <p>Description:西安肉夹馍工厂实现类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.abstractFactory.factory.impl
 * @Author: zh
 * @CreateTime: 2026/6/1  16:24
 * @Description: 西安肉夹馍工厂实现类
 * @Version: 1.0
 */
public class XianRouJiaMoFactory implements RouJiaMoYLRactory {
    @Override
    public Meet createMeet() {
        return new XianRouJiaMoMeet();
    }

    @Override
    public YuanLiao createYuanLiao() {
        return new XianRouJiaMoYuanLiao();
    }
}
