

import javax.enterprise.context.Dependent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Created by reza on 7/2/15.
 */
@Dependent
public class Lookup {

    private InitialContext ctx = null;

    public <T> T get(String jndiName, String ip, String port, String username, String password) throws NamingException {

        Properties properties = new Properties();

        try {
            properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            properties.put("remote.connections", "1");
            properties.put("remote.connection.1.host", ip);
            properties.put("remote.connection.1.port", port);
            properties.put("remote.connection.1.username", username);
            properties.put("remote.connection.1.password", password);
            properties.put("org.jboss.ejb.client.scoped.context", "true");

            // The environment property jboss.naming.client.ejb.context indicates that the InitialContext implementation
            // of the remote naming project will also create an internal EJB client context via the EJB client library.
            // This allows the invocation of EJB components with the remote naming project.
            ctx = new InitialContext(properties);

            return (T) ctx.lookup(jndiName);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        // All proxies become invalid if .close() for the related javax.naming.InitalContext is invoked,
        // or the InitialContext is not longer referenced and gets garbage-collected.

        throw new NamingException("Service not available on specified servers " + ip);
    }

    public void close() {

        if (ctx != null) {
            try {
                ( (Context) ctx.lookup("ejb:") ).close();
                ctx.close();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
    }

	// ---------- ModuleNotLoadException is a costum Exception ------------
    public Object get(String jndi) throws ModuleNotLoadException {

        Context jndiContext = null;
        try {
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            jndiProperties.put("jboss.naming.client.ejb.context", true);
            jndiContext = new InitialContext(jndiProperties);
            return jndiContext.lookup(jndi);
        } catch (Exception e) {
            throw new ModuleNotLoadException(e);
        }
    }

    public Object get(String jndi, String ip, String port) throws ModuleNotLoadException {

        Context jndiContext = null;
        try {
            final Hashtable jndiProperties = new Hashtable();
//            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//            jndiProperties.put("jboss.naming.client.ejb.context", true);
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://" + ip + ":" + port + "");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "username");
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "123456");
            jndiContext = new InitialContext(jndiProperties);
            return jndiContext.lookup(jndi);
        } catch (Exception e) {
            throw new ModuleNotLoadException(e);
        }
    }
}
