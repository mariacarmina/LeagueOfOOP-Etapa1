package heroes;

import common.Constants;

public class KnightStrategy extends HeroStrategy {

    public KnightStrategy() {
        super(Constants.KNIGHT_MIN_LIMIT, Constants.KNIGHT_MAX_LIMIT,
                Constants.KNIGHT_ATTACK_BOOST, Constants.KNIGHT_DEFENSE_BOOST,
                Constants.KNIGHT_LOSS_HP, Constants.KNIGHT_WIN_HP);
    }

}
