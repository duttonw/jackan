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
package eu.trentorise.opendata.jackan;


import eu.trentorise.opendata.jackan.exceptions.JackanException;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Usage example:  {@code
 *      CkanDatastoreQuery.filter().byText("litigations").byRecordsFormat("csv")
 * }
 *
 * https://docs.ckan.org/en/2.8/maintaining/datastore.html
 *
 * https://staging.data.qld.gov.au/api/3/action/datastore_search?resource_id=84fc0093-cc1c-4506-81f3-09b9d1cc1ce5&limit=2&records_format=lists
 * https://www.data.qld.gov.au/api/action/datastore_search_sql?sql=SELECT%20%22Title%22%2C%22Latitude%22%2C%22Longitude%22%2C%22Closure%22%20from%20%22919a8e0f-f538-44df-bb3f-a6cccba0381f%22%20WHERE%20(upper(%22Title%22)%20LIKE%20upper(%27%25QGSC%25%27))%20UNION%20ALL%20SELECT%20%22Title%22%2C%22Latitude%22%2C%22Longitude%22%2C%22Closure%22%20from%20%2244d457a4-b1ad-40a4-af9f-670989ce36bb%22%20ORDER%20BY%20%22Title%22
 * 
 * @author William Dutton
 */
public final class CkanDatastoreQuery {

    private String text = "";
    private Map<String, String> textDict = new HashMap<>();
    private String resourceId;
    private Map<String, String> filters = new HashMap<>();
    private Boolean distinct;
    private Boolean plain;
    private String language;
    private List<String> fields = new ArrayList<>();
    private List<String> sort = new ArrayList<>();
    private Boolean includeTotal;
    private RecordFormat recordsFormat;

    private CkanDatastoreQuery() {
    }

    /**
     * Factory method to start creating the query.
     */
    public static CkanDatastoreQuery filter() {
        return new CkanDatastoreQuery();
    }

    /**
     * @param values q (string or dictionary) i.e. "health care London" or ("key", "a", "key2", "b"):
     * - Full text query. If it’s a string, it’ll search on all fields on each row.
     * - If it’s a dictionary as ("key", "a", "key2", "b") which will output {“key1”: “a”, “key2”: “b”}, it’ll search on each specific field (optional)
     */
    public CkanDatastoreQuery byText(String... values) {
        //If one value,
        if (values.length == 1) {
            this.text = values[0];
            this.textDict = null;
            return this;
        }
        if (values.length % 2 == 0) {
            HashMap<String, String> value = new HashMap<>(values.length / 2);
            for (int i = 0; i < values.length; i = i + 2) {
                value.put(values[i], values[i + 1]);
            }
            this.setTextDict(value);

            this.text = null;
            return this;
        }
        throw new JackanException("Input is single string, or multiple strings divisible by 2 to make key,value map");
    }

    public String getText() {
        return text;
    }

    public Map<String, String> getTextDict() {
        return textDict;
    }

    public CkanDatastoreQuery setTextDict(Map<String, String> textDict) {
        this.textDict = textDict;
        this.text = null;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId resource_id (string) – id or alias of the resource to be searched against
     */
    public CkanDatastoreQuery byResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public Map<String, String> getFilters() {
        return filters;
    }

    /**
     * @param filters "key1, "a", "key2", "b"
     *                (dictionary) – matching conditions to select, e.g {“key1”: “a”, “key2”: “b”} (optional)
     */
    public CkanDatastoreQuery byFilters(String... filters) {
        if (filters.length % 2 == 0) {
            HashMap<String, String> value = new HashMap<>(filters.length / 2);
            for (int i = 0; i < filters.length; i = i + 2) {
                value.put(filters[i], filters[i + 1]);
            }
            this.filters = value;

            return this;
        }
        throw new JackanException("Input is multiple strings divisible by 2 to make key,value map");

    }

    public Boolean getDistinct() {
        return distinct;
    }

    /**
     * @param  distinct (bool) – return only distinct rows (optional, default: false)
     */
    public CkanDatastoreQuery byDistinct(Boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    public Boolean getPlain() {
        return plain;
    }

    /**
     * @param plain (bool) – treat as plain text query (optional, default: true)
     */
    public CkanDatastoreQuery byPlain(Boolean plain) {
        this.plain = plain;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    /**
     * @param language (string) – language of the full text query (optional, default: english)
     */
    public CkanDatastoreQuery byLanguage(String language) {
        this.language = language;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    /**
     * @param fields (list or comma separated string) – fields to return (optional, default: all fields in original order)
     */
    public CkanDatastoreQuery byFields(String... fields) {
        this.fields =  new ArrayList<>(Arrays.asList(fields));
        return this;
    }

    public List<String> getSort() {
        return sort;
    }

    /**
     * @param sort (string) – comma separated field names with ordering e.g.: “fieldname1, fieldname2 desc
     */
    public CkanDatastoreQuery bySort(String... sort) {
        this.sort = new ArrayList<>(Arrays.asList(sort));
        return this;
    }

    public Boolean getIncludeTotal() {
        return includeTotal;
    }

    /**
     * @param includeTotal include_total (bool) – True to return total matching record count (optional, default: true)
     */
    public CkanDatastoreQuery byIncludeTotal(Boolean includeTotal) {
        this.includeTotal = includeTotal;
        return this;
    }

    public RecordFormat getRecordsFormat() {
        return recordsFormat;
    }

    /**
     * @param recordsFormat records_format (controlled list) – the format for the records return value:
     * ‘objects’ (default) list of {fieldname1: value1, …} dicts,
     * ‘lists’ list of [value1, value2, …] lists,
     * ‘csv’ string containing comma-separated values with no header,
     * ‘tsv’ string containing tab-separated values with no header
     *
     */
    public CkanDatastoreQuery byRecordsFormat(RecordFormat recordsFormat) {
        this.recordsFormat = recordsFormat;
        return this;
    }

    public enum RecordFormat {
        LIST("list"), CSV("csv"), TSV("tvs");

        private String value;

        RecordFormat(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
