package lamdba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 学习使用lamdba表达式
 */
public class lamdba {
    public static void main(String[] args) {
        // 创建一个list 然后遍历
        List<lamdbaBean> list = new ArrayList<>(10);

        // 往list里面添加数据
        // 设置了一个能够链式调用的bean
        list.add(new lamdbaBean().setId(1).setName("n1"));
        list.add(new lamdbaBean().setId(2).setName("n2"));
        list.add(new lamdbaBean().setId(3).setName("n3"));

        // 通常使用的方法
        // ArrayList的遍历数组,获取其中一个字段
        for (lamdbaBean s : list) {
            System.out.println(s.getName());
        }

        // 用lamdba表达式遍历并过滤数组,获取任意一个字段
        Predicate<lamdbaBean> predicate = (lamdbaBean) -> lamdbaBean.getId() != 1;
        predicate = predicate.and(lamdbaBean -> lamdbaBean.getId() != 2);

        List result = filterList(list, predicate, (lamdbaBean) -> lamdbaBean.getName());
        System.out.println(result.toString());

        // list有一个foreach的方法可以遍历数组:这个方法把数据遍历出来了,遍历出来的数据的具体使用方式通过接口调用
        // 这个方法是传入一个叫Consumer的函数接口:Consumer接口,用来消费类数据
        // 关于泛型的方法需要用static关继子标注

        //=============================
        // java8常用的函数式接口的整理
        // Predicate 添加判断条件
        // Funcation 类型转换等
        // Consumer  使用数据
        //=============================
    }

    /**
     * 过滤数组并获取其中一列
     *
     * @param datas     待过滤集合
     * @param condition 过滤条件
     * @param function  需要返回的数据类型
     * @param <R>
     * @return
     */
    public static <R> List<R> filterList(List<lamdbaBean> datas, Predicate<lamdbaBean> condition, Function<lamdbaBean, R> function) {
        // 给数组赋初始化长度减少扩容带来的性能损耗.
        List<R> list = new ArrayList<>(10);
        datas.forEach(data -> {
            if (condition.test(data)) {
                list.add(function.apply(data));
            }
        });
        return list;
    }
}
