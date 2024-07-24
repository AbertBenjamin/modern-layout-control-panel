package com.abertbenjamin

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

class ModernLayoutControlPanelTest {

	fun main(args: Array<String>) {
		ExternalPluginManager.loadBuiltin(ModernLayoutControlPanel::class.java)
		RuneLite.main(args)

	}

}