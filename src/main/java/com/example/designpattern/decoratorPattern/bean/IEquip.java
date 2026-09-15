/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.decoratorPattern.bean
 * 所含类: IEquip
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/9/10  15:52      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.decoratorPattern.bean;

/**
 * <p>Titile:IEquip</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.decoratorPattern.bean
 * @Author: zh
 * @CreateTime: 2026/9/10  15:52
 * @Description: TODO
 * @Version: 1.0
 */
public interface IEquip {

    /**
     * 计算攻击力
     *
     * @param
     * @return {@link int}
     * @throws Exception
     * @title caculateAttack
     * @description
     * @author zh
     * @date 2026-09-10 15:52
     *
     **/
    int caculateAttack();

    /**
     * 描述
     *
     * @param
     * @return {@link String}
     * @throws Exception
     * @title description
     * @description
     * @author zh
     * @date 2026-09-10 15:53
     *
     **/
    String description();

}
