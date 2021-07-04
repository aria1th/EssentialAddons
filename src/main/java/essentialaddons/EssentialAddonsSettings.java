package essentialaddons;

import carpet.CarpetSettings;
import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import carpet.settings.Validator;
import carpet.utils.Messenger;

import static carpet.settings.RuleCategory.*;

public class EssentialAddonsSettings {

    private final static String ESSENTIAL = "essential";

    @Rule(
            desc = "Toggles the ability to fly while in survival mode",
            extra = "Using this also disables fall damage",
            validate = {Validator._COMMAND_LEVEL_VALIDATOR.class},
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND}
    )
    public static String commandFly = "false";

    @Rule(
            desc = "Allows /repair to be used to repair any item the player is holding",
            validate = {Validator._COMMAND_LEVEL_VALIDATOR.class},
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND}
    )
    public static String commandRepair = "false";

    @Rule(
            desc = "Allows /gmc, /gms, /gmsp, and /gma to be used",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND, CREATIVE}
    )
    public static String commandGM = "false";

    @Rule(
            desc = "Allows /heal to be used to heal and feed the player",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND}
    )
    public static String commandHeal = "false";

    @Rule(
            desc = "Allows /extinguish to be used to extinguish the player",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND}
    )
    public static String commandExtinguish = "false";

    @Rule(
            desc = "Toggles invulnerability",
            extra = "Can be buggy if used while in creative mode",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND}
    )
    public static String commandGod = "false";

    @Rule(
            desc = "Enables /defuse to be used to stop any tnt from exploding within a given range",
            extra = "Usage: /defuse (Range)",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND, CREATIVE}
    )
    public static String commandDefuse = "false";

    @Rule(
            desc = "Allows /more to be used to give a full stack of whatever item the player is holding",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND}
    )
    public static String commandMore = "false";

    @Rule(
            desc = "Toggles strength",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND, CREATIVE}
    )
    public static String commandStrength = "false";

    @Rule(
            desc = "Toggles night vision",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND, CREATIVE}
    )
    public static String commandNightVision = "false";

    @Rule(
            desc = "Allows the player to teleport to different dimensions",
            extra = "If you are in the overworld/nether then it will teleport you to equivalent coords, else it will teleport you to 0,0",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND, CREATIVE}
    )
    public static String commandDimensions = "false";

    @Rule(
            desc = "Allows players to warp using /setwarp and /warp",
            extra = "You are only able to set one warp which will be removed after server restart",
            options = {"ops", "false", "true"},
            category = {ESSENTIAL, COMMAND, CREATIVE}
    )
    public static String commandWarp = "false";

    @Rule(
            desc = "Allows your to edit a sign after its places by right clicking it while sneaking",
            options = {"true", "false"},
            category = {ESSENTIAL, EXPERIMENTAL}
    )
    public static boolean editableSigns = false;

    @Rule(
            desc = "Survival friendly spectator mode, similar to the cs script by Kdender",
            extra = "Saves location after server reset and adds functionality for cameraModeSurvivalRestrictions",
            options = {"false", "true"},
            category = {ESSENTIAL, EXPERIMENTAL, SURVIVAL}
    )
    public static boolean commandCameraMode = false;

    @Rule(
            desc = "Ports cameraModeSurvivalRestrictions from carpet 1.12 into commandCameraMode",
            extra = "Does not allow you to use /cs if you are in danger",
            options = {"false", "true"},
            category = {ESSENTIAL, EXPERIMENTAL, SURVIVAL}
    )
    public static boolean cameraModeSurvivalRestrictions = false;

    @Rule(
            desc = "Restricts the use of /cs when you are in danger",
            options = {"false", "true"},
            category = {ESSENTIAL, EXPERIMENTAL, SURVIVAL}
    )
    public static boolean cameraModeRestoreLocation = false;
}


