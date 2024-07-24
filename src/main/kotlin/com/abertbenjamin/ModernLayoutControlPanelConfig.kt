package com.abertbenjamin;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("plugin")
interface ModernLayoutControlPanelConfig : Config {

	@ConfigItem(
		keyName = "unblockKeys",
		name = "Unblock Keys",
		description = "Keys that unblock the inventory toggle hotkey. Use comma-separated key codes (e.g., 27, 13 for ESC and ENTER).",
		position = 3
	)
	fun unblockKeys(): String {
		return "49,50,51,52,53,81,69,27" // Default to ESC (27) and ENTER (13)
	}

	enum class Taster(val keyCode: Int) {
		ESCAPE(127),
		ONE(112),
		TWO(113),
		THREE(114),
		FOUR(115),
		Q(116),
		E(117),
		Z(118),
		X(119),
		C(120),
		V(121),
		B(66)
	}

	@ConfigItem(
		keyName = "taster",
		name = "taster å blokkere",
		description = "taster som ",
		position = 0
	)
	fun getTasterAaBlokkere(): String {
		return ""
	}
}
