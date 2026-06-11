package org.telegram.spnet.coins;

import org.telegram.spnet.SPNetUserData;
import org.telegram.spnet.SPNetUserManager;
import org.telegram.spnet.coins.SPNetTransactionManager;

public class SPNetCoinManager {

    private static SPNetCoinManager instance;

    private SPNetCoinManager() {
    }

    public static synchronized SPNetCoinManager getInstance() {
        if (instance == null) {
            instance = new SPNetCoinManager();
        }
        return instance;
    }

    public int getCoins(long userId) {
        return SPNetUserManager.getInstance()
                .getUser(userId)
                .getCoins();
    }

    public void addCoins(long userId, int amount) {
        SPNetUserManager.getInstance()
                .addCoins(userId, amount);
    SPNetTransactionManager.getInstance()
        .recordTransaction(
                userId,
                amount,
                "Coin Reward"
        );
    }

    public boolean spendCoins(long userId, int amount) {
        SPNetUserData user =
                SPNetUserManager.getInstance()
                        .getUser(userId);

        if (user.getCoins() < amount) {
            return false;
        }

        user.setCoins(user.getCoins() - amount);

SPNetTransactionManager.getInstance()
        .recordTransaction(
                userId,
                -amount,
                "Coin Spend"
        );

return true;
    }
}
