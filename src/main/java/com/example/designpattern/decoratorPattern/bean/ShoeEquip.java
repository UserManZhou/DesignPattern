/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.decoratorPattern.bean
 * 所含类: ShoeEquip
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/9/10  16:00      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.decoratorPattern.bean;

/**
 * <p>Titile:ShoeEquip</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.decoratorPattern.bean
 * @Author: zh
 * @CreateTime: 2026/9/10  16:00
 * @Description: TODO
 * @Version: 1.0
 */
public class ShoeEquip implements IEquip {
    @Override
    public int caculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "圣战靴子";
    }
}
