package com.justai.jaicf.template

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.caila.CailaIntentActivator
import com.justai.jaicf.activator.caila.CailaNLUSettings
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.channel.jaicp.logging.JaicpConversationLogger
import com.justai.jaicf.template.scenario.MainScenario
import java.util.*

val accessToken: String = System.getenv("JAICP_API_TOKEN") ?: Properties().run {
    load(CailaNLUSettings::class.java.getResourceAsStream("/jaicp.properties"))
    getProperty("apiToken")
}

private val cailaNLUSettings = CailaNLUSettings(
    accessToken = accessToken
)

const val CA_URL = "http://test-ha01.lo.test-ai.net"

val templateBot = BotEngine(
    model = MainScenario.model,
    conversationLoggers = arrayOf(
        JaicpConversationLogger(accessToken, url = CA_URL)
    ),
    activators = arrayOf(
        CailaIntentActivator.Factory(cailaNLUSettings),
        RegexActivator
    )
)
