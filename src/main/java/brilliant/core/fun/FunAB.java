package brilliant.core.fun;

@FunctionalInterface
public interface FunAB<A,B> {
    A run(B b);
}
