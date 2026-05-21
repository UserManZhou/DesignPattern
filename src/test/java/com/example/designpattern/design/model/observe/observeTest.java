/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.design.model.observe
 * 所含类: observeTest
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/21  9:32      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.design.model.observe;

import com.example.designpattern.design.model.observer.repository.ObjectFor3D;
import com.example.designpattern.design.model.observer.repository.service.Observer1;
import com.example.designpattern.design.model.observer.repository.service.Observer2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Titile:observeTest</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.design.model.observe
 * @Author: zh
 * @CreateTime: 2026/5/21  9:32
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class observeTest {

    @Test
    public void test() {
        // @author zh @date 2026-05-21 09:54:11 @description 测试观察者模式
        ObjectFor3D objectFor3D = new ObjectFor3D();
        // @author zh @date 2026-05-21 09:54:15 @description 创建观察者对象
        Observer1 observer1 = new Observer1(objectFor3D);
        // @author zh @date 2026-05-21 09:54:18 @description 创建观察者对象
        Observer2 observer2 = new Observer2(objectFor3D);
        // @author zh @date 2026-05-21 09:54:21 @description 模拟发布消息
        objectFor3D.setMsg("20140420的3D号码是：127");
        // @author zh @date 2026-05-21 09:54:25 @description 模拟发布消息
        objectFor3D.setMsg("20140421的3D号码是：333");
    }

}
