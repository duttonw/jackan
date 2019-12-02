package eu.trentorise.opendata.jackan.util;

import eu.trentorise.opendata.jackan.CkanDatastoreQuery;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class CkanUtil {
    /**
     * @param key       string, key to set
     * @param value     string, value to set
     *
     * if value is not null and length is more than 0;
     * Will add to params the &key=value
     */
    public static void appendParam(String key, String value, StringBuilder params) {
        checkNotNull(key, "Need a valid key!");
        checkNotNull(params, "Need a valid string builder!");

        if (value != null && value.length() > 0){
            params.append("&")
                .append(key)
                .append("=")
                .append(value);
        }
    }

    /**
     * @param key       string, key to set
     * @param value     RecordFormat if set
     */
    public static void appendParam(String key, CkanDatastoreQuery.RecordFormat value, StringBuilder params) {
        checkNotNull(key, "Need a valid key!");
        checkNotNull(params, "Need a valid string builder!");

        if (value != null){
            params.append("&")
                .append(key)
                .append("=")
                .append(value.toString());
        }
    }

    /**
     * @param key       string, key to set
     * @param value     Boolean object if required
     */
    public static void appendParam(String key, Boolean value, StringBuilder params) {
        checkNotNull(key, "Need a valid key!");
        checkNotNull(params, "Need a valid string builder!");

        if (value != null){
            params.append("&")
                .append(key)
                .append("=")
                .append((value) ? "true" : "false");
        }
    }

    /**
     * @param key       string, key to set
     * @param value     Map<String, String> object if required
     *
     * if value is not null or empty
     * generate {"key1":"a","key2":"b"}
     */
    public static void appendParam(String key, Map<String, String> value, StringBuilder params) {
        checkNotNull(key, "Need a valid key!");
        checkNotNull(params, "Need a valid string builder!");

        if (value != null && !value.isEmpty()){
            params.append("&")
                .append(value.entrySet().stream().map( x ->
                //This makes "key1":"a"
                "\"" + x + "\":\"" + x.getValue() + "\"")
                        .collect(Collectors.toList()).stream()
                    .collect(Collectors.joining(",", "{ ", " }"))
            );
        }
    }

    /**
     * @param key       string, key to set
     * @param value     List<String> object if required
     *
     * if value is not null or empty
     * generate a,b
     */
    public static void appendParam(String key, List<String> value, StringBuilder params) {
        checkNotNull(key, "Need a valid key!");
        checkNotNull(params, "Need a valid string builder!");

        if (value != null){
            params.append("&")
                .append(value.stream()
                    .collect(Collectors.joining(",", "", ""))
                );
        }
    }

    /**
     * @param fqPrefix either "" or " AND "
     * @param list     list of names of ckan objects
     */
    public static String appendNamesList(String fqPrefix, String key, List<String> list, StringBuilder fq) {
        checkNotNull(fqPrefix, "Need a valid prefix!");
        checkNotNull(key, "Need a valid key!");
        checkNotNull(list, "Need a valid list!");
        checkNotNull(fq, "Need a valid string builder!");

        if (!list.isEmpty()) {
            fq.append(fqPrefix)
                .append("(");
            String prefix = "";
            for (String n : list) {
                fq.append(prefix)
                    .append(key)
                    .append(":")
                    .append('"' + n + '"');
                prefix = " AND ";
            }
            fq.append(")");
            return " AND ";
        } else {
            return "";
        }

    }
}
