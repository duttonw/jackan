package eu.trentorise.opendata.jackan.test.datagov;

import eu.trentorise.opendata.jackan.CkanClient;
import eu.trentorise.opendata.jackan.model.CkanDataset;
import org.junit.Test;

/**
 * Created by jdl50 on 5/1/18.
 */
public class ClientTest {
    @Test
    public void test() {
        CkanClient ckanClient = new CkanClient("http://catalog.data.gov/");
        CkanDataset dataset = ckanClient.getDataset("02b5e413-d746-43ee-bd52-eac4e33ecb41");
        System.out.println(dataset.getNotes());
    }
}
