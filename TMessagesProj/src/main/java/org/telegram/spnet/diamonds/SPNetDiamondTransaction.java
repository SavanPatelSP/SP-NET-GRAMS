package org.telegram.spnet.diamonds;

public class SPNetDiamondTransaction {

    private final long timestamp;
    private final int amount;
    private final String reason;

    public SPNetDiamondTransaction(
            int amount,
            String reason
    ) {
        this.timestamp = System.currentTimeMillis();
        this.amount = amount;
        this.reason = reason;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }
}

