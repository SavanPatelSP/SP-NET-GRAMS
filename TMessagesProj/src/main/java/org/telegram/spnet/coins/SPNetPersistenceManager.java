package org.telegram.spnet.coins;

public class SPNetPersistenceManager {

    private static SPNetPersistenceManager instance;

    private SPNetPersistenceManager() {
    }

    public static synchronized SPNetPersistenceManager getInstance() {
        if (instance == null) {
            instance = new SPNetPersistenceManager();
        }
        return instance;
    }

    public void save() {
        // TODO: SharedPreferences / Database
    }

    public void load() {
        // TODO: SharedPreferences / Database
    }
}
