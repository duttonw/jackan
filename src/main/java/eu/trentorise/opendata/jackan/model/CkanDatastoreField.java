package eu.trentorise.opendata.jackan.model;

public class CkanDatastoreField {

    private String type;
    private String id;

    public CkanDatastoreField(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public CkanDatastoreField() {

    }
    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
