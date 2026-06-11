package org.telegram.spnet.coins;

public class SPNetRewardManager {

    private static SPNetRewardManager instance;

    private SPNetRewardManager() {
    }

    public static synchronized SPNetRewardManager getInstance() {
        if (instance == null) {
            instance = new SPNetRewardManager();
        }
        return instance;
    }

    public void giveDailyReward(long userId) {
        SPNetCoinManager.getInstance()
                .addCoins(userId, 10);
    }

    public void giveReferralReward(long userId) {
        SPNetCoinManager.getInstance()
                .addCoins(userId, 50);
    }
}
