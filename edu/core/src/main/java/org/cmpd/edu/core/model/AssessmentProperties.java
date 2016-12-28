package org.cmpd.edu.core.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ovoievodin on 28.12.2016.
 */
public class AssessmentProperties {
    public static final String CLASS = "CLASS";
    public static final String MATERIAL = "MATERIAL";
    public static final String CREATED_DATE = "CREATED_DATE";
    private Map<String, Object> props;

    public void put(String key, Object value) {
        props.put(key, value);
    }

    public Map<String, Object> getAllProps() {
        return new HashMap<>(props);
    }
}
