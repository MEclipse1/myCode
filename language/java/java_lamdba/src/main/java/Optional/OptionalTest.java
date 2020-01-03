package Optional;

import java.util.Optional;

/**
 * java java.util.Optinnal类的使用
 * 用来解决空指针问题
 */
public class OptionalTest {
    public static void main(String[] args) {
        String test = "hello world";

        // 建立一个空的Optinal类
        Optional optional = Optional.empty();

        //建立一个不为空的Optional类
        Optional<String> optional1 = Optional.of("hello world");

        // 建立一个根据value的值判断建立空的或者非空的Optional类
        Optional optional2 = Optional.ofNullable(null);

        // 获取保存在optional的值
        String s = optional1.get();

        // 判断是否为空,为空返回false
        Boolean bool = optional.isPresent();

        // 判断是否为空, 为空返回true
        Boolean bool1 = optional.isEmpty();

        // 如果不为空,执行以下步骤
        optional1.ifPresent((b)-> System.out.println(b));

        // 如果不为空,执行步骤1如果为空,执行步骤2
        optional1.ifPresentOrElse(
            (b)-> System.out.println(b),
            ()->{ System.out.println("is null"); }
        );

        // 判断是否有这个值
        optional1.filter((t)->t.startsWith("hello"));


    }
}
