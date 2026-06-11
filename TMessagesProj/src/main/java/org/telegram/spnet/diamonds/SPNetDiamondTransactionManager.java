package org.telegram.spnet.diamonds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SPNetDiamondTransactionManager {

    private static SPNetDiamondTransactionManager instance;

    private final Map<Long, List<SPNetDiamondTransaction>> transactions =
            new HashMap<>();

    private SPNetDiamondTransactionManager() {
    }

    public static synchronized SPNetDiamondTransactionManager getInstance() {
        if (instance == null) {
            instance = new SPNetDiamondTransactionManager();
        }
        return instance;
    }

    public void recordTransaction(
            long userId,
            int amount,
            String reason
    ) {
        transactions
                .computeIfAbsent(
                        userId,
                        k -> new ArrayList<>()
                )
                .add(
                        new SPNetDiamondTransaction(
                                amount,
                                reason
                        )
                );
    }

    public List<SPNetDiamondTransaction> getTransactions(
            long userId
    ) {
        return transactions.getOrDefault(
                userId,
                new ArrayList<>()
        );
    }
}
