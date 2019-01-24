package brilliant.core.fun;

@FunctionalInterface
public interface FunBA<B,A> {
    A run(B b);
}
