/**
 * ============================================================
 * 版权： 广州市新维数据科技有限公司新架构产品部所有(c) 2026
 * 文件：com.example.designpattern.factory.simpleFactory
 * 所含类: RoujiaMoStore
 * 文件作用描述 TODO
 * 修改记录：
 * 日期                                      作者         版本     内容
 * =============================================================
 * 2026/5/22  16:08      zh     v1.0.0   新建
 * =============================================================
 */

package com.example.designpattern.factory.simpleFactory.factory;

import com.example.designpattern.factory.simpleFactory.repository.RouJiaMo;

/**
 * <p>Titile:RoujiaMoStore</p >
 * <p>ProjectName: </p >
 * <p>Description:TODO()  </p >
 * <p>Copyright: Copyright (c) 2023</p >
 * <p>Company: 新维数据 </p >
 *
 * @BelongsProject: DesignPattern
 * @BelongsPackage: com.example.designpattern.factory.simpleFactory
 * @Author: zh
 * @CreateTime: 2026/5/22  16:08
 * @Description: TODO
 * @Version: 1.0
 */
public class RouJiaMoStore {

    private SimpleRouJiaMoFactory simpleRouJiaMoFactory;

    public RouJiaMoStore(SimpleRouJiaMoFactory simpleRouJiaMoFactory) {
        this.simpleRouJiaMoFactory = simpleRouJiaMoFactory;
    }

    /**
     * 卖肉夹馍
     *
     * @param type
     * @return {@link RouJiaMo}
     * @throws Exception
     * @title sellRoujiaMo
     * @description
     * @author zh
     * @date 2026-05-22 16:14
     *
     **/
    /*public RouJiaMo sellRoujiaMo(String type) {
        RouJiaMo roujiaMo = null;
        if (RouJiaMoConstant.SUAN_ROU_JIA_MO.equals(type)) {
            roujiaMo = new SuanRouJiaMo();
        } else if (RouJiaMoConstant.LA_ROU_JIA_MO.equals(type)) {
            roujiaMo = new LaRouJiaMo();
        } else if (RouJiaMoConstant.TIAN_ROU_JIA_MO.equals(type)) {
            roujiaMo = new TianRouJiaMo();
        }
        roujiaMo.prepare();
        roujiaMo.fire();
        roujiaMo.pack();
        return roujiaMo;
    }*/

    /**
     * 卖肉夹馍
     *
     * @param type
     * @return {@link RouJiaMo}
     * @throws Exception
     * @title sellRoujiaMo
     * @description
     * @author zh
     * @date 2026-05-22 16:24
     *
     **/
    public RouJiaMo sellRoujiaMo(String type) {
        RouJiaMo roujiaMo = simpleRouJiaMoFactory.createRouJiaMo(type);
        roujiaMo.prepare();
        roujiaMo.fire();
        roujiaMo.pack();
        return roujiaMo;
    }


}
