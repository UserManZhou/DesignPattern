/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.design.model.observer.repository
 * 所含类: Observer
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/21  9:23      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.observerPattern.repository;

/**
 * <p>Titile:Observer</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO(所有的观察者都需要实现此接口)  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.design.model.observer.repository
 * @Author: zh
 * @CreateTime: 2026/5/21  9:23
 * @Description: TODO
 * @Version: 1.0
 */
public interface Observer {

    /**
     * 更新
     *
     * @param msg
     * @return
     * @throws Exception
     * @title update
     * @description
     * @author zh
     * @date 2026-05-21 9:24
     *
     **/
    void update(String msg);

}
