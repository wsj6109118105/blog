package com.springboottest.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/9/5
 * 将查询结果从Object转化为对应的类型
 **/
public class CastUtils {
    public static <T> List<T> objectConvertToList(Object obj, Class<T> clazz){
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }
}
