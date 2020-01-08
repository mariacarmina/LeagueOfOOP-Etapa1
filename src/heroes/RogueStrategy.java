package heroes;

import common.Constants;

public class RogueStrategy extends HeroStrategy {
    public RogueStrategy() {
        super(Constants.ROGUE_MIN_LIMIT, Constants.ROGUE_MAX_LIMIT,
                Constants.ROGUE_ATTACK_BOOST, Constants.ROGUE_DEFENSE_BOOST,
                Constants.ROGUE_LOSS_HP, Constants.ROGUE_WIN_HP);
    }
}
