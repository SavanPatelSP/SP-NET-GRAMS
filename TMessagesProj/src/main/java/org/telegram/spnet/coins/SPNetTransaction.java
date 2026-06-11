package org.telegram.spnet.coins;

public class SPNetTransaction {

    private final long timestamp;
    private final int amount;
    private final String reason;

    public SPNetTransaction(int amount, String reason) {
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
