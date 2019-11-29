package com.common;

public class Constants {
    public static final int KNIGHT_HP = 900;
    public static final int KNIGHT_EXTRA_HP = 80;
    public static final int PYROMANCER_HP = 500;
    public static final int PYROMANCER_EXTRA_HP = 50;
    public static final int ROGUE_HP = 600;
    public static final int ROGUE_EXTRA_HP = 40;
    public static final int WIZARD_HP = 400;
    public static final int WIZARD_EXTRA_HP = 30;

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
    public static final int BASE_DAMAGE_FIREBLAST = 350;
    public static final int BASE_DAMAGE_IGNITE = 150;
    public static final int BASE_DAMAGE_EXECUTE = 200;
    public static final int BASE_DAMAGE_SLAM = 100;
    public static final int BASE_DAMAGE_DRAIN = 20;
    public static final int BASE_DAMAGE_DEFLECT = 35;

    //Abilities multiplier per level
    public static final int MULTIPLIER_PER_LEVEL_BASE_DAMAGE_FIREBLAST = 50;
    public static final int MULTIPLIER_PER_LEVEL_BASE_DAMAGE_IGNITE = 20;
    public static final int MULTIPLIER_PER_LEVEL_BASE_DAMAGE_EXECUTE = 30;
    public static final int MULTIPLIER_PER_LEVEL_BASE_DAMAGE_SLAM = 40;
    public static final int MULTIPLIER_PER_LEVEL_BASE_DAMAGE_DRAIN = 5;
    public static final int MULTIPLIER_PER_LEVEL_BASE_DAMAGE_DEFLECT = 2;

    //Abilities with damage per round
    public static final int DAMAGE_PER_ROUND_IGNITE = 50;

    //Abilities multiplier per level for damage per round
    public static final int MULTIPLIER_PER_LEVEL_DAMAGE_PER_ROUND_IGNITE = 30;


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
    public static final float WIZARD_MODIFIER_DEFLECT = 0f;

}
