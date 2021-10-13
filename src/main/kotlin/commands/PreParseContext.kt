package commands

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.TextChannel

open class PreParseContext(
    val channel: TextChannel,
    val jda: JDA,
    val author: Member,
    val contentRaw: String,
    val triggerUsed: String
) {
    fun <Parameters> constructTextCommandContext(parameters: Parameters): TextCommandContext<Parameters> {
        return TextCommandContext(
            channel,
            jda,
            author,
            contentRaw,
            parameters,
            triggerUsed
        )
    }
}