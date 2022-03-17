package seedu.address.logic.parser;

import seedu.address.logic.commands.SetDefaultGroupCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Group;
import seedu.address.model.person.Mod;

import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GROUP;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MOD;

public class SetDefaultGroupCommandParser implements Parser<SetDefaultGroupCommand> {

public SetDefaultGroupCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
        ArgumentTokenizer.tokenize(args, PREFIX_MOD, PREFIX_GROUP);
        if (!arePrefixesPresent(argMultimap, PREFIX_MOD, PREFIX_GROUP)
        || !argMultimap.getPreamble().isEmpty()) {
        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetDefaultGroupCommand.MESSAGE_USAGE));
        }

        Mod mod = ParserUtil.parseMod(argMultimap.getValue(PREFIX_MOD).get());
        Group group = ParserUtil.parseGroup(argMultimap.getValue(PREFIX_GROUP).get());
        String defaultValue = group.value;

        return new SetDefaultGroupCommand(mod, defaultValue);
}

private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
}

}
