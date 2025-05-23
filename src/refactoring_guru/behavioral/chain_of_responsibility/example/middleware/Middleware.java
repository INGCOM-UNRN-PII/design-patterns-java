package refactoring_guru.behavioral.chain_of_responsibility.example.middleware;

/**
 * EN: Base middleware class.
 *
 * RU: Базовый класс цепочки.
 */
public abstract class Middleware {
    private Middleware next;

    /**
     * EN: Builds chains of middleware objects.
     *
     * RU: Помогает строить цепь из объектов-проверок.
     */
    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * EN: Subclasses will implement this method with concrete checks.
     *
     * RU: Подклассы реализуют в этом методе конкретные проверки.
     */
    public abstract boolean check(String email, String password);

    /**
     * EN: Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     *
     * RU: Запускает проверку в следующем объекте или завершает проверку, если
     * мы в последнем элементе цепи.
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
