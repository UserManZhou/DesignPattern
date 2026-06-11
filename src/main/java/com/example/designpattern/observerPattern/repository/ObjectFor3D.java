/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.design.model.observer.repository
 * 所含类: ObjectFor3D
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/21  9:24      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.observerPattern.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Titile:ObjectFor3D</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO(3D服务号)  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.design.model.observer.repository
 * @Author: zh
 * @CreateTime: 2026/5/21  9:24
 * @Description: TODO
 * @Version: 1.0
 */
public class ObjectFor3D implements Subject {

    // @author zh @date 2026-05-21 09:25:49 @description 观察者列表
    private List<Observer> listeners = new ArrayList<>();

    // @author zh @date 2026-05-21 09:26:06 @description 3D服务号信息
    private String msg;

    @Override
    public void registerObserver(Observer observer) {
        listeners.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int indexOf = listeners.indexOf(observer);
        if (indexOf >= 0) {
            listeners.remove(indexOf);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer listener : listeners) {
            listener.update(msg);
        }
    }

    /**
     * 设置3D服务号信息
     *
     * @param msg
     * @return
     * @throws Exception
     * @title setMsg
     * @description
     * @author zh
     * @date 2026-05-21 9:28
     *
     **/
    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();
    }
}
