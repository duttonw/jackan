package eu.trentorise.opendata.jackan.model;

public class CkanLinks {

    /**
     * Next set of results if available
     */
    private String next;

    /**
     * Start of result set
     */
    private String start;

    public CkanLinks(String next, String start) {
        this.next = next;
        this.start = start;
    }

    public CkanLinks(){

    }

    public String getNext() {
        return next;
    }


    public String getStart() {
        return start;
    }
}
