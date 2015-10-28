package br.com.store.infrastructure.tracking;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomUtils;

public class Tracker {

    public static final String REQUEST = "REQUEST";
    public static final String SESSION = "SESSION";
    public static final String IP = "IP";
    public static final String PORT = "PORT";
    public static final String URI = "URI";
    public static final String VALIDATION_VERSION = "VALIDATION_VERSION";
    public static final String ID_PARTNER = "ID_PARTNER";
    

    private static final ThreadLocal<HashMap<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    private Tracker() {
    }

    public static void clear(){
        THREAD_LOCAL.set(new HashMap<String, Object>());
    }

    /**
     * Cria um novo tracker de key no escopo da thread atual.
     */
    public static Object insert(String key, String value) {
        HashMap<String, Object> data = getTrackerData();
        return data.put(key, value);
    }

    public static Object insert(String key, Object value) {
        HashMap<String, Object> data = getTrackerData();
        return data.put(key, value);
    }

    /**
     * Retorna o valor armazenado no Tracker de acordo com o key
     * 
     * @param key
     *            id
     * @return
     */
    public static Object get(String key) {
        HashMap<String, Object> data = getTrackerData();
        return data.get(key);
    }

    public static String getString(String key) {
        HashMap<String, Object> data = getTrackerData();
        return (String) data.get(key);
    }

    public static long getLong(String key) {
        HashMap<String, Object> data = getTrackerData();
        return Long.parseLong(data.get(key).toString());
    }

    /**
     * Recupera o pool de trackers IDs
     * 
     * @return
     */
    private static HashMap<String, Object> getTrackerData() {
        HashMap<String, Object> data = THREAD_LOCAL.get();

        if (data == null) {
            data = new HashMap<>();
            THREAD_LOCAL.set(data);
        }

        return data;
    }

    /**
     * Gera um novo TrackerID
     * 
     * @return
     */
    public static String createTrackerId() {

        String tracker = Long.toString(System.nanoTime()) + Long.toString(RandomUtils.nextLong(1, Long.MAX_VALUE));
        byte[] encodedBytes = Base64.encodeBase64(tracker.getBytes(StandardCharsets.UTF_8));
        tracker = new String(encodedBytes, StandardCharsets.UTF_8);
        tracker = tracker.substring(0, tracker.length() - 2);
        return tracker;
    }
}
