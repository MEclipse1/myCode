package other.jquanchazhe;

/**
 *    被观察者
 * @author drx
 *
 */
public interface Observerable {
	public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
