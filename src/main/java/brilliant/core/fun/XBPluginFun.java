package brilliant.core.fun;

/**
 * @Created by: Yukai
 * @Date: 2019/1/24 11:05
 * @Description : Yukai is so handsome xxD
 */
@FunctionalInterface
public interface XBPluginFun<A,B> {
    // a perfect solution to trigger the server xxxDDDDD
    // A - > XBApplication B->args
    void run(A a, B b) throws Exception;
}
