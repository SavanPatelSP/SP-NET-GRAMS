package org.telegram.spnet.coins;

public class SPNetShopManager {

    private static SPNetShopManager instance;

    private SPNetShopManager() {
    }

    public static synchronized SPNetShopManager getInstance() {
        if (instance == null) {
            instance = new SPNetShopManager();
        }
        return instance;
    }

    public boolean buyPremiumDay(long userId) {
        return SPNetCoinManager.getInstance()
                .spendCoins(userId, 100);
    }

    public boolean buyBadge(long userId) {
        return SPNetCoinManager.getInstance()
                .spendCoins(userId, 50);
    }
}

