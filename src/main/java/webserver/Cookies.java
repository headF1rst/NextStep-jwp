package webserver;

import java.util.*;
import java.util.stream.Collectors;

public class Cookies {

    private static final String COOKIE_DELIMITER = "; ";
    private static final String KEY_VALUE_DELIMITER = "=";

    private Map<String, String> cookies;

    private Cookies(Map<String, String> cookies) {
        this.cookies = Collections.unmodifiableMap(cookies);
    }

    public static Cookies from(String cookie) {
        List<String> splitValues = List.of(cookie.split(COOKIE_DELIMITER));
        return from(splitValues.stream()
                .filter(splitValue -> splitValue.contains(KEY_VALUE_DELIMITER))
                .map(Cookies::parseToEntry)
                .collect(Collectors.toUnmodifiableMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue))
        );
    }

    public static Cookies from(Map<String, String> cookie) {
        return new Cookies(Objects.requireNonNullElse(cookie, Collections.emptyMap()));
    }

    private static Map.Entry<String, String> parseToEntry(String pair) {
        String[] splitValues = pair.split(KEY_VALUE_DELIMITER);
        return Map.entry(splitValues[0].trim(), splitValues[1].trim());
    }

    public Optional<String> getCookieValue(String key) {
        return Optional.ofNullable(cookies.get(key));
    }

    public Set<Map.Entry<String, String>> getCookies() {
        return cookies.entrySet();
    }
}
