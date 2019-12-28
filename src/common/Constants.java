package common;

public final class Constants {

    //Moves
    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';

    //HP
    public static final int KNIGHT_HP = 900;
    public static final int KNIGHT_EXTRA_HP = 80;
    public static final int PYROMANCER_HP = 500;
    public static final int PYROMANCER_EXTRA_HP = 50;
    public static final int ROGUE_HP = 600;
    public static final int ROGUE_EXTRA_HP = 40;
    public static final int WIZARD_HP = 400;
    public static final int WIZARD_EXTRA_HP = 30;
    public static final float BASE_LIMIT_HP_EXECUTE = 0.2f;
    public static final float PER_LEVEL_LIMIT_HP_EXECUTE = 0.01f;
    public static final float MAXIMUM_HP_EXECUTE = 0.4f;
    public static final float MULTIPLIER_HP_DRAIN = 0.3f;

    //XP
    public static final int XP_LVL_1 = 250;
    public static final int PER_LEVEL_XP = 50;
    public static final int XP_WINNER = 200;
    public static final int MULTIPLIER_XP_WINNER = 40;

    //Land modifiers characters
    public static final char PYROMANCER_LAND_MODIFIER_CHAR = 'V';
    public static final char KNIGHT_LAND_MODIFIER_CHAR = 'L';
    public static final char WIZARD_LAND_MODIFIER_CHAR = 'D';
    public static final char ROGUE_LAND_MODIFIER_CHAR = 'W';

    //Land modifiers percentages
    public static final float PYROMANCER_LAND_MODIFIER_BONUS = 1.25f;
    public static final float KNIGHT_LAND_MODIFIER_BONUS = 1.15f;
    public static final float WIZARD_LAND_MODIFIER_BONUS = 1.1f;
    public static final float ROGUE_LAND_MODIFIER_BONUS = 1.15f;
    public static final float STANDARD_LAND_MODIFIER_BONUS = 1f;

    //Abilities base damage
    public static final float BASE_DAMAGE_FIREBLAST = 350f;
    public static final float BASE_DAMAGE_IGNITE = 150f;
    public static final float BASE_DAMAGE_EXECUTE = 200f;
    public static final float BASE_DAMAGE_SLAM = 100f;
    public static final float BASE_DAMAGE_DRAIN = 0.2f;
    public static final float BASE_DAMAGE_DEFLECT = 0.35f;
    public static final float MAXIMUM_PERCENTAGE = 0.7f;
    public static final float BASE_DAMAGE_BACKSTAB = 200f;
    public static final float BASE_DAMAGE_PARALYSIS = 40f;

    //Abilities multiplier per level
    public static final float PER_LEVEL_BASE_DAMAGE_FIREBLAST = 50f;
    public static final float PER_LEVEL_BASE_DAMAGE_IGNITE = 20f;
    public static final float PER_LEVEL_BASE_DAMAGE_EXECUTE = 30f;
    public static final float PER_LEVEL_BASE_DAMAGE_SLAM = 40f;
    public static final float PER_LEVEL_BASE_DAMAGE_DRAIN = 0.05f;
    public static final float PER_LEVEL_BASE_DAMAGE_DEFLECT = 0.02f;
    public static final float PER_LEVEL_BASE_DAMAGE_BACKSTAB = 20f;
    public static final float PER_LEVEL_BASE_DAMAGE_PARALYSIS = 10f;

    //Abilities with damage per round
    public static final float DAMAGE_PER_ROUND_IGNITE = 50f;
    public static final float DAMAGE_PER_ROUND_PARALYSIS = 40f;

    //Abilities multiplier per level for damage per round
    public static final float PER_LEVEL_DAMAGE_PER_ROUND_IGNITE = 30f;
    public static final float PER_LEVEL_DAMAGE_PER_ROUND_PARALYSIS = 10f;
    public static final float BONUS_CRITICAL = 1.5f;

    //Race modifier for Fireblast
    public static final float ROGUE_MODIFIER_FIREBLAST = 0.8f;
    public static final float KNIGHT_MODIFIER_FIREBLAST = 1.2f;
    public static final float PYROMANCER_MODIFIER_FIREBLAST = 0.9f;
    public static final float WIZARD_MODIFIER_FIREBLAST = 1.05f;

    //Race modifier for Ignite
    public static final float ROGUE_MODIFIER_IGNITE = 0.8f;
    public static final float KNIGHT_MODIFIER_IGNITE = 1.2f;
    public static final float PYROMANCER_MODIFIER_IGNITE = 0.9f;
    public static final float WIZARD_MODIFIER_IGNITE = 1.05f;

    //Race modifier for Execute
    public static final float ROGUE_MODIFIER_EXECUTE = 1.15f;
    public static final float KNIGHT_MODIFIER_EXECUTE = 1f;
    public static final float PYROMANCER_MODIFIER_EXECUTE = 1.1f;
    public static final float WIZARD_MODIFIER_EXECUTE = 0.8f;

    //Race modifier for Slam
    public static final float ROGUE_MODIFIER_SLAM = 0.8f;
    public static final float KNIGHT_MODIFIER_SLAM = 1.2f;
    public static final float PYROMANCER_MODIFIER_SLAM = 0.9f;
    public static final float WIZARD_MODIFIER_SLAM = 1.05f;

    //Race modifier for Drain
    public static final float ROGUE_MODIFIER_DRAIN = 0.8f;
    public static final float KNIGHT_MODIFIER_DRAIN = 1.2f;
    public static final float PYROMANCER_MODIFIER_DRAIN = 0.9f;
    public static final float WIZARD_MODIFIER_DRAIN = 1.05f;

    //Race modifier for Deflect
    public static final float ROGUE_MODIFIER_DEFLECT = 1.2f;
    public static final float KNIGHT_MODIFIER_DEFLECT = 1.4f;
    public static final float PYROMANCER_MODIFIER_DEFLECT = 1.3f;

    //Race modifier for Backstab
    public static final float ROGUE_MODIFIER_BACKSTAB = 1.2f;
    public static final float KNIGHT_MODIFIER_BACKSTAB = 0.9f;
    public static final float PYROMANCER_MODIFIER_BACKSTAB = 1.25f;
    public static final float WIZARD_MODIFIER_BACKSTAB = 1.25f;

    //Race modifier for Paralysis
    public static final float ROGUE_MODIFIER_PARALYSIS = 0.9f;
    public static final float KNIGHT_MODIFIER_PARALYSIS = 0.8f;
    public static final float PYROMANCER_MODIFIER_PARALYSIS = 1.2f;
    public static final float WIZARD_MODIFIER_PARALYSIS = 1.25f;

    //
    public static final int CRITICAL_ROUNDS = 3;
    public static final int PARALYSIS_ROUNDS = 3;

    private Constants() {
    }
}
