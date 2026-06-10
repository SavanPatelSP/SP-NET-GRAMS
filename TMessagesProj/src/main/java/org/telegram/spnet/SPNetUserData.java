package org.telegram.spnet;

public class SPNetUserData {

    private long userId;
    private int coins;
    private int diamonds;
    private String premiumTier;
    private String badge;
    private int referralCount;
    private long createdAt;

    public SPNetUserData(long userId) {
        this.userId = userId;
        this.coins = 0;
        this.diamonds = 0;
        this.premiumTier = "FREE";
        this.badge = "NONE";
        this.referralCount = 0;
        this.createdAt = System.currentTimeMillis();
    }

    public long getUserId() {
        return userId;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(int diamonds) {
        this.diamonds = diamonds;
    }

    public String getPremiumTier() {
        return premiumTier;
    }

    public void setPremiumTier(String premiumTier) {
        this.premiumTier = premiumTier;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public int getReferralCount() {
        return referralCount;
    }

    public void setReferralCount(int referralCount) {
        this.referralCount = referralCount;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
