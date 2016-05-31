package com.toolbar.ddstar.frxjava2;

/**
 * Created by DDstar on 2016/5/30.
 */
public interface FunTR<T,R> {
    /**
     *  中途转换函数，
     *  将一个类型的参数处理后
     *  转换成另一种类型
     *  然后返回
     *------->称之为值得映射
     * @param t  输入参数
     * @return  r  返回结果
     */
    R  funCall(T t);
}
