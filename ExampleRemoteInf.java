
import javax.ejb.Remote;

/**
 * Created by bkhosrojerdi on 2/8/17.
 */
@Remote
public interface ExampleRemoteInf {

    public final String JNDI = "java:global/core/ExampleImpl!com.example.factory.ExampleRemoteInf";

    public  final String JNDI_REMOTE = "ejb:/core//ExampleImpl!com.example.factory.ExampleRemoteInf";



}
