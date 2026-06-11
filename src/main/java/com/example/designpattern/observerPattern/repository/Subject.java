/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.design.model.observer.repository
 * 所含类: Subject
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/21  9:21      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.observerPattern.repository;

import org.springframework.stereotype.Component;

/**
 * <p>Titile:Subject</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO(主题接口)  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.design.model.observer.repository
 * @Author: zh
 * @CreateTime: 2026/5/21  9:21
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public interface Subject {

    /**
     * 注册观察者
     *
     * @param observer
     * @return
     * @throws Exception
     * @title registerObserver
     * @description
     * @author zh
     * @date 2026-05-21 9:23
     *
     **/
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer
     * @return
     * @throws Exception
     * @title removeObserver
     * @description
     * @author zh
     * @date 2026-05-21 9:23
     *
     **/
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     *
     * @param
     * @return
     * @throws Exception
     * @title notifyObservers
     * @description
     * @author zh
     * @date 2026-05-21 9:23
     *
     **/
    void notifyObservers();

}
