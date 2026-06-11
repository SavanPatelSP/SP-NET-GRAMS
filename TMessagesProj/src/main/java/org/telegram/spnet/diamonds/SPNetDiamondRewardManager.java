package org.telegram.spnet.diamonds;

public class SPNetDiamondRewardManager {

    private static SPNetDiamondRewardManager instance;

    private SPNetDiamondRewardManager() {
    }

    public static synchronized SPNetDiamondRewardManager getInstance() {
        if (instance == null) {
            instance = new SPNetDiamondRewardManager();
        }
        return instance;
    }

    public void giveDailyReward(long userId) {
        SPNetDiamondManager.getInstance()
                .addDiamonds(userId, 1);
    }

    public void giveReferralReward(long userId) {
        SPNetDiamondManager.getInstance()
                .addDiamonds(userId, 5);
    }
}
