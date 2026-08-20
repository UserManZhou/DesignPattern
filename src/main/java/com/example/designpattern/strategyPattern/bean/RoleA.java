/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.strategyPattern.bean
 * 所含类: RoleA
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/20  9:50      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.strategyPattern.bean;

/**
 * <p>Titile:RoleA</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.strategyPattern.bean
 * @Author: zh
 * @CreateTime: 2026/8/20  9:50
 * @Description: TODO
 * @Version: 1.0
 */
public class RoleA extends Role {

    public RoleA(String name) {
        this.name = name;
    }
/*
    @Override
    protected void display() {
        System.out.println("样子1");
    }

    @Override
    protected void run() {
        System.out.println("金蝉脱壳");
    }

    @Override
    protected void attack() {
        System.out.println("降龙十八掌");
    }

    @Override
    protected void defend() {
        System.out.println("铁头功");
    }*/
}
