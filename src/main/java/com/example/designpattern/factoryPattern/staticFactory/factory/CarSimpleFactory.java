/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.staticFactory.factory
 * 所含类: CarSimpleFactory
 * 文件作用描述 汽车静态工厂类
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  10:14      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factoryPattern.staticFactory.factory;

import com.example.designpattern.factoryPattern.staticFactory.constant.CarConstant;
import com.example.designpattern.factoryPattern.staticFactory.product.Audi;
import com.example.designpattern.factoryPattern.staticFactory.product.Byd;
import com.example.designpattern.factoryPattern.staticFactory.product.Car;

/**
 * <p>Titile:CarSimpleFactory</p >
 * <p>ProjectName: </p >
 * <p>Description:汽车静态工厂类</p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.staticFactory.factory
 * @Author: zh
 * @CreateTime: 2026/5/22  10:14
 * @Description: 汽车静态工厂类
 * @Version: 1.0
 */
public class CarSimpleFactory {

    /**
     * 根据名称获取车辆对象
     *
     * @param name
     * @return {@link Car}
     * @throws Exception
     * @title getCar
     * @description
     * @author zh
     * @date 2026-05-22 10:16
     *
     **/
    public static Car getCar(String name) throws Exception {
        if (CarConstant.AUDI.equals(name)) {
            return new Audi();
        } else if (CarConstant.BYD.equals(name)) {
            return new Byd();
        } else {
            throw new Exception("没有此车辆");
        }
    }

    /**
     * 创建奥迪对象
     *
     * @param
     * @return {@link Audi}
     * @throws Exception
     * @title createAudi
     * @description
     * @author zh
     * @date 2026-05-22 10:16
     *
     **/
    public static Audi createAudi() {
        return new Audi();
    }

    /**
     * 创建比亚迪对象
     *
     * @param
     * @return {@link Byd}
     * @throws Exception
     * @title createByd
     * @description
     * @author zh
     * @date 2026-05-22 10:16
     *
     **/
    public static Byd createByd() {
        return new Byd();
    }

}
