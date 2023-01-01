package essentialaddons.utils;

//#if MC >= 11900
import carpet.api.settings.SettingsManager;
import carpet.utils.Translations;
import essentialaddons.EssentialSettings;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
//#endif

import net.fabricmc.api.DedicatedServerModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Ripped from Carpet
public class EssentialRuleGenerator implements DedicatedServerModInitializer {
	private static final String START =
	"""
	# EssentialAddons
	
	[![Discord](https://badgen.net/discord/online-members/gn99m4QRY4?icon=discord&label=Discord&list=what)](https://discord.gg/gn99m4QRY4)
	[![GitHub downloads](https://img.shields.io/github/downloads/super-santa/essentialaddons/total?label=Github%20downloads&logo=github)](https://github.com/Super-Santa/EssentialAddons/releases)
	
	[Fabric Carpet](https://github.com/gnembon/fabric-carpet) extension that adds  things from the Spigot plugin Essentials, or other features I think are needed for Minecraft.
	
	This mod is currently supporting **1.17.1**, **1.18.2**, and **1.19.3**
	
	Feel free to contribute by adding as many features as you want!
	
	""";

	@Override
	public void onInitializeServer() {
		//#if MC >= 11900
		String[] args = Arrays.stream(FabricLoader.getInstance().getLaunchArguments(true)).filter(opt -> !opt.equals("--")).toArray(String[]::new);

		// Prepare an OptionParser for our parameters
		OptionParser parser = new OptionParser();
		OptionSpec<String> pathSpec = parser.accepts("generate").withRequiredArg();

		// Minecraft may need more stuff later that we don't want to special-case
		parser.allowsUnrecognizedOptions();
		OptionSet options = parser.parse(args);

		// If our flag isn't set, continue regular launch
		if (!options.has(pathSpec)) {
			return;
		}

		Logger logger = LogManager.getLogger("EssentialRuleGenerator");

		PrintStream outputStream;
		try {
			Path path = Path.of(options.valueOf(pathSpec));
			logger.info("Generating Rules for Path: {}", path.toString());
			Files.createDirectories(path.getParent());
			outputStream = new PrintStream(Files.newOutputStream(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Translations.updateLanguage();
		SettingsManager manager = new SettingsManager("1.2.0", "carpet", "EssentialAddons");
		manager.parseSettingsClass(EssentialSettings.class);
		logger.info("Rule Count: {}", manager.getCarpetRules().size());
		outputStream.println(START);
		manager.dumpAllRulesToStream(outputStream, null);
		outputStream.close();
		logger.info("Complete");
		System.exit(0);
		//#endif
	}
}
