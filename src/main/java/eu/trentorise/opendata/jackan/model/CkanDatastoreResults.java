/*
 * Copyright 2015 Trento Rise  (trentorise.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.trentorise.opendata.jackan.model;

import javax.annotation.concurrent.Immutable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author William Dutton
 */
@Immutable
public class CkanDatastoreResults {

    private boolean includeTotal;
    private String resourceId;
    private List<CkanDatastoreField> fields;
    private int limit;
    private List<Map<String, Object>> records;
    private String recordsFormat;
    private int total;
    private CkanLinks links;


    public CkanDatastoreResults(boolean includeTotal, String resourceId, List<CkanDatastoreField> fields, String recordsFormat,  List<Map<String, Object>> records, int limit, CkanLinks links, int total) {
        this.includeTotal = includeTotal;
        this.resourceId = resourceId;
        this.fields = fields;
        this.recordsFormat = recordsFormat;
        this.records =records;
        this.limit = limit;
        this.links = links;
        this.total = total;
    }

    private CkanDatastoreResults() {
    }

    /**
     * Returns the number of records on the server, which may be greater than
     * the datastore search.
     */
    public int getTotal() {
        return total;
    }

    public List<CkanDatastoreField> getFields() {
        return fields;
    }

    public boolean isIncludeTotal() {
        return includeTotal;
    }

    public int getLimit() {
        return limit;
    }

    public List<Map<String, Object>> getRecords() {
        return records;
    }

    public String getRecordsFormat() {
        return recordsFormat;
    }

    public String getResourceId() {
        return resourceId;
    }

    public CkanLinks getLinks() {
        return links;
    }
}
