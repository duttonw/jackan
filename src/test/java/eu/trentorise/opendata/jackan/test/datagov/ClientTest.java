package eu.trentorise.opendata.jackan.test.datagov;

import eu.trentorise.opendata.jackan.CkanClient;
import eu.trentorise.opendata.jackan.CkanDatastoreQuery;
import eu.trentorise.opendata.jackan.CkanQuery;
import eu.trentorise.opendata.jackan.model.CkanDataset;
import eu.trentorise.opendata.jackan.model.CkanDatastoreField;
import eu.trentorise.opendata.jackan.model.CkanDatastoreResults;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by jdl50 on 5/1/18.
 */
public class ClientTest {
    @Test
    public void test() {
        CkanClient ckanClient = new CkanClient("http://catalog.data.gov/");

        CkanQuery query = CkanQuery.filter().byTagNames("nndss");
        List<CkanDataset> filteredDatasets = ckanClient.searchDatasets(query, 10, 0).getResults();
        for (CkanDataset dataset : filteredDatasets) {
            System.out.println(dataset.getId());
        }
        //CkanDataset dataset = ckanClient.getDataset("02b5e413-d746-43ee-bd52-eac4e33ecb41");
        //System.out.println(dataset.getExtrasAsHashMap().get("identifier"));
    }

    @Test
    public void testDataStoreSearch() {
        CkanClient ckanClient = new CkanClient("https://www.data.qld.gov.au/");

        CkanDatastoreQuery query = CkanDatastoreQuery.filter().byResourceId("9e48f2bd-bcc8-416e-97c5-54c88f7ada39");
        CkanDatastoreResults datastoreResults = ckanClient.datastoreSearch(query, 2, 0);
        for (CkanDatastoreField field : datastoreResults.getFields()) {
            System.out.println(field.getId() + ":" + field.getType());
        }
        for (Map<String, Object> field : datastoreResults.getRecords()) {
            field.forEach((k, v) ->
                System.out.println(k + ":" + v)
            );
        }
    }

    @Test
    public void testDataStoreSearchFiltered() {
        CkanClient ckanClient = new CkanClient("https://www.data.qld.gov.au/");

        CkanDatastoreQuery query = CkanDatastoreQuery.filter().byResourceId("9e48f2bd-bcc8-416e-97c5-54c88f7ada39")
            .byFields("Category", "_id")
            //.byFilters("_id", "1")
            .byText("_id", "CED");
        CkanDatastoreResults datastoreResults = ckanClient.datastoreSearch(query, 2, 0);
        for (CkanDatastoreField field : datastoreResults.getFields()) {
            System.out.println("field: " + field.getId() + ": with type:" + field.getType());
        }
        for (Map<String, Object> field : datastoreResults.getRecords()) {
            field.forEach((k,v) ->
                System.out.println(k + ":" + v)
            );
        }
    }
}
