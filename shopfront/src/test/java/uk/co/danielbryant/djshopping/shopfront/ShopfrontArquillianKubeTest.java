package uk.co.danielbryant.djshopping.shopfront;

import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.fabric8.kubernetes.assertions.Assertions.assertThat;

@RunWith(Arquillian.class)
public class ShopfrontArquillianKubeTest {

    @ArquillianResource
    KubernetesClient client;

    @ArquillianResource
    Session session;

    @Test
    public void testAtLeastOnePod() throws Exception {
        assertThat(client).pods().runningStatus().filterNamespace(session.getNamespace()).hasSize(1);
    }
}
