/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.strategyPattern.bean
 * 所含类: RoleC
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/20  9:52      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.strategyPattern.bean;

/**
 * <p>Titile:RoleC</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.strategyPattern.bean
 * @Author: zh
 * @CreateTime: 2026/8/20  9:52
 * @Description: TODO
 * @Version: 1.0
 */
public class RoleC extends Role {

    public RoleC(String name) {
        this.name = name;
    }
/*
    @Override
    protected void display() {
        System.out.println("样子1");//从RoleA中拷贝
    }

    @Override
    protected void run() {
        System.out.println("烟雾弹");
    }

    @Override
    protected void attack() {
        System.out.println("九阳神功");
    }

    @Override
    protected void defend() {
        System.out.println("铁布衫");//从B中拷贝
    }*/
}
