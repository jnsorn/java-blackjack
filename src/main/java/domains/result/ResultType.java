package domains.result;

import domains.user.Player;
import domains.user.money.ProfitMoney;

public enum ResultType {
    WIN(1),
    LOSE(-1),
    DRAW(0),
    BLACKJACK(1.5);

    private double profitRate;

    ResultType(double profitRate) {
        this.profitRate = profitRate;
    }

    public ResultType oppose() {
        if (this == WIN || this == BLACKJACK) {
            return LOSE;
        }
        if (this == LOSE) {
            return WIN;
        }
        return DRAW;
    }

    public ProfitMoney calculateProfitMoney(Player player) {
        return player.getBettingMoney().multiply(this.profitRate);
    }
}
