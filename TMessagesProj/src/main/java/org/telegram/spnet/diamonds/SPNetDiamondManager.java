package org.telegram.spnet.diamonds;

import org.telegram.spnet.SPNetUserData;
import org.telegram.spnet.SPNetUserManager;
import org.telegram.spnet.diamonds.SPNetDiamondTransactionManager;

public class SPNetDiamondManager {

    private static SPNetDiamondManager instance;

    private SPNetDiamondManager() {
    }

    public static synchronized SPNetDiamondManager getInstance() {
        if (instance == null) {
            instance = new SPNetDiamondManager();
        }
        return instance;
    }

    public int getDiamonds(long userId) {
        return SPNetUserManager.getInstance()
                .getUser(userId)
                .getDiamonds();
    }

    public void addDiamonds(long userId, int amount) {
        SPNetUserManager.getInstance()
                .addDiamonds(userId, amount);
SPNetDiamondTransactionManager.getInstance()

            .recordTransaction(

                    userId,

                    amount,

                    "Diamond Reward"

            );
    }

    public boolean spendDiamonds(long userId, int amount) {
        SPNetUserData user =
                SPNetUserManager.getInstance()
                        .getUser(userId);

        if (user.getDiamonds() < amount) {
            return false;
        }

        user.setDiamonds(
                user.getDiamonds() - amount
        );
SPNetDiamondTransactionManager.getInstance()

        .recordTransaction(

                userId,

                -amount,

                "Diamond Spend"

        );

        return true;
    }
}
