package heroes;

import common.Constants;

public class WizardStrategy extends HeroStrategy {
    public WizardStrategy() {
        super(Constants.WIZARD_MIN_LIMIT, Constants.WIZARD_MAX_LIMIT,
                Constants.WIZARD_ATTACK_BOOST, Constants.WIZARD_DEFENSE_BOOST,
                Constants.WIZARD_LOSS_HP, Constants.WIZARD_WIN_HP);
    }
}
