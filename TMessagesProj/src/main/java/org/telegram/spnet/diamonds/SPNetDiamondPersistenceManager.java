package org.telegram.spnet.diamonds;

public class SPNetDiamondPersistenceManager {

    private static SPNetDiamondPersistenceManager instance;

    private SPNetDiamondPersistenceManager() {
    }

    public static synchronized SPNetDiamondPersistenceManager getInstance() {
        if (instance == null) {
            instance = new SPNetDiamondPersistenceManager();
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
