package org.telegram.ui.spnet;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.telegram.spnet.SPNetUserData;
import org.telegram.spnet.SPNetUserManager;
import org.telegram.ui.ActionBar.BaseFragment;

public class SPNetStoreActivity extends BaseFragment {

    @Override
    public android.view.View createView(Context context) {

        actionBar.setTitle("SP NET Store");

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

       final TextView balance =
                new TextView(context);

        balance.setText(
                "🪙 Coins: " + user.getCoins() +
                "\n💎 Diamonds: " + user.getDiamonds()
        );

        layout.addView(balance);
final TextView status =
        new TextView(context);

status.setText(
        "🛒 Welcome to SP NET Store"
);

layout.addView(status);
TextView badgeHeader =
        new TextView(context);

badgeHeader.setText(
        "\n🏆 BADGES"
);

layout.addView(badgeHeader);

        Button verifiedBadge =
                new Button(context);

        verifiedBadge.setText(
                "🏆 Buy Verified Badge (5 Diamonds)"
        );

verifiedBadge.setOnClickListener(v -> {

if (user.getDiamonds() < 5) {

    status.setText(
            "❌ Not enough diamonds"
    );

    android.widget.Toast.makeText(
            context,
            "Not enough diamonds",
            android.widget.Toast.LENGTH_SHORT
    ).show();

    return;
}
    org.telegram.spnet.diamonds
            .SPNetDiamondShopManager
            .getInstance()
            .buyVerifiedBadge(1L);

    balance.setText(
            "🪙 Coins: " + user.getCoins() +
            "\n💎 Diamonds: " + user.getDiamonds()
    );

status.setText(
        "✅ Verified Badge Purchased"
);

    android.widget.Toast.makeText(
            context,
            "Verified Badge Purchased!",
            android.widget.Toast.LENGTH_SHORT
    ).show();
});
        layout.addView(verifiedBadge);
TextView verifiedInfo =
        new TextView(context);

verifiedInfo.setText(
        "Get a verified badge on your profile."
);

layout.addView(verifiedInfo);

TextView premiumHeader =
        new TextView(context);

premiumHeader.setText(
        "\n⭐ PREMIUM"
);

Button premiumMonth =
        new Button(context);

premiumMonth.setText(
        "⭐ Buy Premium Month (10 Diamonds)"
);

premiumMonth.setOnClickListener(v -> {

    if (user.getDiamonds() < 10) {

        status.setText(
                "❌ Not enough diamonds"
        );

        android.widget.Toast.makeText(
                context,
                "Not enough diamonds",
                android.widget.Toast.LENGTH_SHORT
        ).show();

        return;
    }

    balance.setText(
            "🪙 Coins: " + user.getCoins() +
            "\n💎 Diamonds: " + user.getDiamonds()
    );

    status.setText(
            "✅ Premium Month Purchased"
    );

    android.widget.Toast.makeText(
            context,
            "Premium Month Purchased!",
            android.widget.Toast.LENGTH_SHORT
    ).show();
});
layout.addView(premiumMonth);
TextView premiumInfo =
        new TextView(context);

premiumInfo.setText(
        "Unlock premium features for 30 days."
);

layout.addView(premiumInfo);

Button premiumDay =
        new Button(context);

premiumDay.setText(
        "🪙 Buy Premium Day (100 Coins)"
);

premiumDay.setOnClickListener(v -> {

if (user.getCoins() < 100) {

    status.setText(
            "❌ Not enough coins"
    );

    android.widget.Toast.makeText(
            context,
            "Not enough coins",
            android.widget.Toast.LENGTH_SHORT
    ).show();

    return;
}
    org.telegram.spnet.coins
            .SPNetShopManager
            .getInstance()
            .buyPremiumDay(1L);

    balance.setText(
            "🪙 Coins: " + user.getCoins() +
            "\n💎 Diamonds: " + user.getDiamonds()
    );

status.setText(
        "✅ Premium Day Purchased"
);

    android.widget.Toast.makeText(
            context,
            "Premium Day Purchased!",
            android.widget.Toast.LENGTH_SHORT
    ).show();
});

layout.addView(premiumDay);
TextView premiumDayInfo =
        new TextView(context);

premiumDayInfo.setText(
        "Unlock premium features for 24 hours."
);

layout.addView(premiumDayInfo);

TextView stats =
        new TextView(context);

stats.setText(
        "\n📊 STORE STATS\n" +
        "Coins: " + user.getCoins() +
        "\nDiamonds: " + user.getDiamonds()
);

layout.addView(stats);

TextView history =
        new TextView(context);

history.setText(
        "\n🕒 STORE HISTORY\n" +
        "Purchases are recorded in wallet transactions."
);

layout.addView(history);

fragmentView = scrollView;

return fragmentView;

    }
}
