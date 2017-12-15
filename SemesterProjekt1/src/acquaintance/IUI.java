package acquaintance;

/**
 *<h1>IUI Interface</h1>
 * @author Gruppe 20
 * This interface is used to be able to inject the businesslayer into the presentation layer and then to start the application if implemented.
 * This is part of the layered arcitecture.
 */
public interface IUI {
    void injectBusiness(IBusiness businessLayer);
    void startApplication(String[] args);
}
