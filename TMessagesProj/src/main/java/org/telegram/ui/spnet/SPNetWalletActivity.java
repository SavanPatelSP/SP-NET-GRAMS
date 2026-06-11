package org.telegram.ui.spnet;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.telegram.spnet.SPNetUserData;
import org.telegram.spnet.SPNetUserManager;
import org.telegram.ui.spnet.SPNetStoreActivity;
import org.telegram.ui.ActionBar.BaseFragment;

public class SPNetWalletActivity extends BaseFragment {

    @Override
    public android.view.View createView(Context context) {

        actionBar.setTitle("SP NET Wallet");

        SPNetUserData user =
                SPNetUserManager.getInstance()
                        .getUser(1L);

        ScrollView scrollView =
                new ScrollView(context);

        LinearLayout layout =
                new LinearLayout(context);

        layout.setOrientation(
                LinearLayout.VERTICAL
        );

        scrollView.addView(layout);

        TextView header =
                new TextView(context);

String walletLevel = "Bronze";

if (user.getCoins() > 1000) {
    walletLevel = "Silver";
}

if (user.getCoins() > 5000) {
    walletLevel = "Gold";
}

if (user.getCoins() > 10000) {
    walletLevel = "Platinum";
}

header.setText(
        "💰 SP NET WALLET\n\n" +
        "Net Worth: " + walletLevel
);

        layout.addView(header);

        TextView balance =
                new TextView(context);

        balance.setText(
                "\n🪙 COINS\n" +
                user.getCoins() +
                "\n\n💎 DIAMONDS\n" +
                user.getDiamonds()
        );

        layout.addView(balance);

android.widget.Button claimRewardButton =
        new android.widget.Button(context);

claimRewardButton.setText(
        "🎁 Claim Daily Reward"
);

claimRewardButton.setOnClickListener(v -> {

    org.telegram.spnet.coins.SPNetRewardManager
            .getInstance()
            .giveDailyReward(1L);

    org.telegram.spnet.diamonds.SPNetDiamondRewardManager
            .getInstance()
            .giveDailyReward(1L);

});

layout.addView(claimRewardButton);

        TextView progress =
                new TextView(context);

int coinsNeeded =
        Math.max(0, 1000 - user.getCoins());

progress.setText(
        "\n⭐ PREMIUM PROGRESS\n" +
        "Coins Needed: " +
        coinsNeeded
);

        layout.addView(progress);

android.widget.Button earnCoins =
        new android.widget.Button(context);

earnCoins.setText("🪙 Earn Coins");

earnCoins.setOnClickListener(v ->
        org.telegram.spnet.coins.SPNetRewardManager
                .getInstance()
                .giveDailyReward(1L)
);

layout.addView(earnCoins);

android.widget.Button earnDiamonds =
        new android.widget.Button(context);

earnDiamonds.setText("💎 Earn Diamonds");

earnDiamonds.setOnClickListener(v ->
        org.telegram.spnet.diamonds.SPNetDiamondRewardManager
                .getInstance()
                .giveDailyReward(1L)
);

layout.addView(earnDiamonds);

android.widget.Button buyBadge =
        new android.widget.Button(context);

buyBadge.setText("🏆 Buy Badge");

buyBadge.setOnClickListener(v ->
        org.telegram.spnet.coins.SPNetShopManager
                .getInstance()
                .buyBadge(1L)
);

layout.addView(buyBadge);

android.widget.Button upgradePremium =
        new android.widget.Button(context);

upgradePremium.setText("⭐ Upgrade Premium");

upgradePremium.setOnClickListener(v ->
        org.telegram.spnet.diamonds.SPNetDiamondShopManager
                .getInstance()
                .buyPremiumMonth(1L)
);

layout.addView(upgradePremium);
android.widget.Button openStore =
        new android.widget.Button(context);

openStore.setText("🛒 Open Store");

openStore.setOnClickListener(v ->
        presentFragment(
                new SPNetStoreActivity()
        )
);

layout.addView(openStore);
        TextView stats =
                new TextView(context);

int transactionCount =
        org.telegram.spnet.coins.SPNetTransactionManager
                .getInstance()
                .getTransactions(1L)
                .size();

stats.setText(
        "\n📊 STATISTICS\n" +
        "Wallet Level: " + walletLevel + "\n" +
        "Transactions: " + transactionCount + "\n" +
        "Coins: " + user.getCoins() + "\n" +
        "Diamonds: " + user.getDiamonds() + "\n" +
        "Referrals: " + user.getReferralCount()
);

        layout.addView(stats);

        TextView achievements =
                new TextView(context);

        achievements.setText(
                "\n🏆 ACHIEVEMENTS\n" +
                "First Login\n" +
                "Coin Collector\n" +
                "Diamond Hunter"
        );

        layout.addView(achievements);

        TextView history =
                new TextView(context);

java.util.List<
        org.telegram.spnet.coins.SPNetTransaction
> transactions =
        org.telegram.spnet.coins.SPNetTransactionManager
                .getInstance()
                .getTransactions(1L);

StringBuilder activity =
        new StringBuilder(
                "\n🕒 RECENT ACTIVITY\n"
        );

if (transactions.isEmpty()) {

    activity.append(
            "No transactions yet"
    );

} else {

    int start =
            Math.max(
                    0,
                    transactions.size() - 5
            );

    for (int i = transactions.size() - 1;
         i >= start;
         i--) {

        org.telegram.spnet.coins.SPNetTransaction t =
                transactions.get(i);

        activity.append("\n");

        if (t.getAmount() > 0) {
            activity.append("+");
        }

        activity.append(
                t.getAmount()
        );

        activity.append(" ");

        activity.append(
                t.getReason()
        );
    }
}

history.setText(
        activity.toString()
);
        layout.addView(history);

        fragmentView = scrollView;

        return fragmentView;
    }
}
