/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.strategyPattern.bean
 * 所含类: Role
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/8/10  17:19      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.strategyPattern.bean;

/**
 * <p>Titile:Role</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.strategyPattern.bean
 * @Author: zh
 * @CreateTime: 2026/8/10  17:19
 * @Description: TODO
 * @Version: 1.0
 */
public abstract class Role {

    // @author zh @date 2026-08-10 17:19:27 @description 角色名称
    protected String name;

   /* // @author zh @date 2026-08-10 17:27:16 @description 角色显示
    protected abstract void display();

    // @author zh @date 2026-08-10 17:27:37 @description 角色运行
    protected abstract void run();

    // @author zh @date 2026-08-10 17:28:14 @description 角色攻击
    protected abstract void attack();

    // @author zh @date 2026-08-10 17:28:31 @description 角色防御
    protected abstract void defend();*/

    // ----------------------优化---------------------------------

    protected IDefendBehavior iDefendBehavior;

    protected IDisplayBehavior iDisplayBehavior;

    protected IRunBehavior iRunBehavior;

    protected IAttackBehavior iAttackBehavior;

    public IDefendBehavior getiDefendBehavior() {
        return iDefendBehavior;
    }

    public Role setiDefendBehavior(IDefendBehavior iDefendBehavior) {
        this.iDefendBehavior = iDefendBehavior;
        return this;
    }

    public IDisplayBehavior getiDisplayBehavior() {
        return iDisplayBehavior;
    }

    public Role setiDisplayBehavior(IDisplayBehavior iDisplayBehavior) {
        this.iDisplayBehavior = iDisplayBehavior;
        return this;
    }

    public IRunBehavior getiRunBehavior() {
        return iRunBehavior;
    }

    public Role setiRunBehavior(IRunBehavior iRunBehavior) {
        this.iRunBehavior = iRunBehavior;
        return this;
    }

    public IAttackBehavior getiAttackBehavior() {
        return iAttackBehavior;
    }

    public Role setiAttackBehavior(IAttackBehavior iAttackBehavior) {
        this.iAttackBehavior = iAttackBehavior;
        return this;
    }

    public void display() {
        iDisplayBehavior.display();
    }

    public void run() {
        iRunBehavior.run();
    }

    public void attack() {
        iAttackBehavior.attack();
    }

    public void defend() {
        iDefendBehavior.defend();
    }

    public String getName() {
        return this.name;
    }

}
