package com.recycle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-10 0010.
 */
public class DataBiz {

    public static List<OrderBean> getDataSources() {
        List<OrderBean> list = new ArrayList<OrderBean>();
        for (int i = 0; i < 23; i++) {
            OrderBean ob = new OrderBean();
            ob.setHeader(R.drawable.default_male);
            ob.setName("simon" + i + "_test");
            ob.setPhone("168168" + i);
            ob.setPrice("88元");
            ob.setTitle("护理方式");
            list.add(ob);
        }
        return list;
    }

}
