package org.telegram.spnet.coins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SPNetTransactionManager {

    private static SPNetTransactionManager instance;

    private final Map<Long, List<SPNetTransaction>> transactions =
            new HashMap<>();

    private SPNetTransactionManager() {
    }

    public static synchronized SPNetTransactionManager getInstance() {
        if (instance == null) {
            instance = new SPNetTransactionManager();
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
                        new SPNetTransaction(
                                amount,
                                reason
                        )
                );
    }

    public List<SPNetTransaction> getTransactions(
            long userId
    ) {
        return transactions.getOrDefault(
                userId,
                new ArrayList<>()
        );
    }
}
