/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.design.model.observer.repository
 * 所含类: Observer2
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/21  9:30      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.design.model.observer.repository.service;

import com.example.designpattern.design.model.observer.repository.Observer;
import com.example.designpattern.design.model.observer.repository.Subject;

/**
 * <p>Titile:Observer2</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO(使用者2)  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.design.model.observer.repository
 * @Author: zh
 * @CreateTime: 2026/5/21  9:30
 * @Description: TODO
 * @Version: 1.0
 */
public class Observer2 implements Observer {

    public Observer2(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("observer2 得到 3D 号码  -->" + msg + ", 我要记下来。");
    }
}
