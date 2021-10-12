package modules.test.commands

import commands.TextCommand
import commands.TextCommandContext
import commands.TextCommandParameter
import commands.TextCommandParameterType
import net.dv8tion.jda.api.MessageBuilder
import utils.sendSafe

class TestCommand : TextCommand(
    "test",
    hashMapOf(
        "number" to TextCommandParameter(TextCommandParameterType.INT),
        "text" to TextCommandParameter(TextCommandParameterType.STRING),
        "anotherNumber" to TextCommandParameter(TextCommandParameterType.INT)
    ),
    hashMapOf()
) {
    override fun check(context: TextCommandContext): Boolean {
        return true
    }

    override fun handler(context: TextCommandContext) {
        val params = context.parameters
        val text = params.entries
            .map entryMap@{ mutableEntry -> return@entryMap "${mutableEntry.key}: ${mutableEntry.value}" }
            .joinToString( "\n")

        val messageBuilder = MessageBuilder()
            .setContent(text)

        context.channel.sendSafe(messageBuilder).queue()
    }
}