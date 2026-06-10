package org.telegram.spnet;

import java.util.HashMap;
import java.util.Map;

public class SPNetUserManager {

    private static SPNetUserManager instance;

    private final Map<Long, SPNetUserData> users = new HashMap<>();

    private SPNetUserManager() {
    }

    public static synchronized SPNetUserManager getInstance() {
        if (instance == null) {
            instance = new SPNetUserManager();
        }
        return instance;
    }

    public SPNetUserData getUser(long userId) {
        return users.computeIfAbsent(userId, SPNetUserData::new);
    }

    public void addCoins(long userId, int amount) {
        SPNetUserData user = getUser(userId);
        user.setCoins(user.getCoins() + amount);
    }

    public void addDiamonds(long userId, int amount) {
        SPNetUserData user = getUser(userId);
        user.setDiamonds(user.getDiamonds() + amount);
    }

    public void addReferral(long userId) {
        SPNetUserData user = getUser(userId);
        user.setReferralCount(user.getReferralCount() + 1);
    }
}
