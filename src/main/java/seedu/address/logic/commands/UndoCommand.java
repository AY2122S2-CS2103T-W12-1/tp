package seedu.address.logic.commands;


import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

/**
 * Undoes the previous command that commits to contact list.
 */
public class UndoCommand extends Command {
    public static final String COMMAND_WORD = "undo";

    public static final String MESSAGE_EARLIEST_VERSION = "There are no versions before this";
    public static final String MESSAGE_SUCCESS = "Contents have been changed to previous version";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.isEarliestContentVersion()) {
            throw new CommandException(MESSAGE_EARLIEST_VERSION);
        }

        model.undoContents();

        return new CommandResult(MESSAGE_SUCCESS);

    }

    @Override
    public boolean equals(Object other) {
        return other instanceof UndoCommand;
    }
}
