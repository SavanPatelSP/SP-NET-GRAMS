package org.telegram.spnet.achievements;

import java.util.ArrayList;
import java.util.List;

public class SPNetAchievementManager {

    private static SPNetAchievementManager instance;

    private final List<SPNetAchievement> achievements =
            new ArrayList<>();

    private SPNetAchievementManager() {

        achievements.add(
                new SPNetAchievement(
                        "first_login",
                        "🏆 First Login",
                        "Open SP NET for the first time"
                )
        );

        achievements.add(
                new SPNetAchievement(
                        "first_purchase",
                        "💎 First Purchase",
                        "Buy an item from the store"
                )
        );

        achievements.add(
                new SPNetAchievement(
                        "coin_collector",
                        "🪙 Coin Collector",
                        "Earn 1000 coins"
                )
        );

        achievements.add(
                new SPNetAchievement(
                        "diamond_hunter",
                        "💎 Diamond Hunter",
                        "Earn 100 diamonds"
                )
        );

unlock("first_login");
    }

    public static SPNetAchievementManager getInstance() {

        if (instance == null) {
            instance = new SPNetAchievementManager();
        }

        return instance;
    }

    public List<SPNetAchievement> getAchievements() {
        return achievements;
    }
public void unlock(String id) {

    for (SPNetAchievement achievement : achievements) {

        if (achievement.getId().equals(id)) {

            achievement.unlock();
            return;
        }
    }
}
}
