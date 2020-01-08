package heroes;

import common.Constants;

public class PyromancerStrategy extends HeroStrategy {
    public PyromancerStrategy() {
        super(Constants.PYROMANCER_MIN_LIMIT, Constants.PYROMANCER_MAX_LIMIT,
                Constants.PYROMANCER_ATTACK_BOOST, Constants.PYROMANCER_DEFENSE_BOOST,
                Constants.PYROMANCER_LOSS_HP, Constants.PYROMANCER_WIN_HP);
    }
}
