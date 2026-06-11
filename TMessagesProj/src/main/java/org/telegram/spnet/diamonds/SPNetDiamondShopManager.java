package org.telegram.spnet.diamonds;

public class SPNetDiamondShopManager {

    private static SPNetDiamondShopManager instance;

    private SPNetDiamondShopManager() {
    }

    public static synchronized SPNetDiamondShopManager getInstance() {
        if (instance == null) {
            instance = new SPNetDiamondShopManager();
        }
        return instance;
    }

    public boolean buyPremiumMonth(long userId) {
        return SPNetDiamondManager.getInstance()
                .spendDiamonds(userId, 10);
    }

    public boolean buyVerifiedBadge(long userId) {
        return SPNetDiamondManager.getInstance()
                .spendDiamonds(userId, 5);
    }
}
