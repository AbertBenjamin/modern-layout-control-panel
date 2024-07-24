package com.abertbenjamin;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager
import net.runelite.client.input.KeyListener
import net.runelite.client.input.KeyManager
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager
import java.awt.event.KeyEvent

import javax.inject.Inject;
import kotlin.system.exitProcess

@Slf4j
@PluginDescriptor(
	name = "Modern-Layout-Control-Panel"
)
class ModernLayoutControlPanel : Plugin() {

	@Inject
	private lateinit var config: ModernLayoutControlPanelConfig

	@Inject
	private lateinit var keyManager: KeyManager

	private val unblockKeys: Set<Int> get () {
		val keyString = config.unblockKeys() ?: "112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 66, 27"
		return keyString.split(",")
			.mapNotNull { it.trim().toIntOrNull() }
			.toSet()
	}


	private var lastPressedKey: Int? = null
	private var isBlocked = false


	private val keyListener = object : KeyListener {
		override fun keyTyped(e: KeyEvent?) {

		}

		override fun keyPressed(event: KeyEvent?) {
			if(event == null) { println("key event is null"); return }
			println(event.keyCode)
			val keyCode = event!!.keyCode

			if (keyCode in unblockKeys) {
				isBlocked = true
			} else {
				isBlocked = false
			}

			if (isBlocked && keyCode == lastPressedKey) {
				event.consume()
			}

			lastPressedKey = keyCode
			println("last pressed key: $lastPressedKey")

		}

		override fun keyReleased(e: KeyEvent?) {

		}
	}


	override fun startUp() {
		println("modern-layout-control-panel started!");
		keyManager.registerKeyListener(keyListener)
	}

	override fun shutDown() {
		println("modern-layout-control-panel stopped!");
		keyManager.unregisterKeyListener(keyListener)
	}


	@Provides
	fun provideConfig(configManager: ConfigManager): ModernLayoutControlPanelConfig {
		return configManager.getConfig(ModernLayoutControlPanelConfig::class.java)
	}
}
