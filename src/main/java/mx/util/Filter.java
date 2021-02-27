package mx.util;

import com.google.common.base.Optional;
import java.util.HashMap;
import java.util.Map;

public class Filter {
    private Map<String, Object> filters = new HashMap<>();

    private Filter() {}

    private Filter(String key, Object value) {
        filters.put(key, value);
    }

    public static Filter create(String key, Object value) {
        return new Filter(key, value);
    }

    public Filter add(String key, Object value) {
        this.filters.put(key, value);
        return this;
    }

    public Optional<Object> get(String key) {
        return Optional.of(this.filters.get(key));
    }
}
