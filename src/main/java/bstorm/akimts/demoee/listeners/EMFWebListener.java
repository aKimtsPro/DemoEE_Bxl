package bstorm.akimts.demoee.listeners;

import javax.persistence.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class EMFWebListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private static EntityManagerFactory factory;
    public static EntityManager createEntityManager(){
        return factory.createEntityManager();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // au deployement
        factory = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // à l'arrêt
        factory.close();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // attribut ajouté à la session
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // attribut supprimé de la session
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // attribut modifié dans la session
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // session créée
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // session détruite
    }
}
