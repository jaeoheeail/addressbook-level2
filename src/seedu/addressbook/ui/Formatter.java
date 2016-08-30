package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

import seedu.addressbook.commands.CommandResult;

/**
 * Formats Text before showing to user
 */
public class Formatter {
	
	private static final String DIVIDER = "===================================================";
	
	 /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
	
	/** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    /** Checks command line format */
    public static boolean checkCommentLineFormat(String rawInputLine) {
		return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
	}
       
    /**
     * Formats welcome message
     * 
     * @return Formatted welcome message to show to user
     */
    public static String[] getFormattedWelcomeMessage(String version, String storageFilePath) {
    	String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    	String[] formatted = {DIVIDER, DIVIDER,
    			              MESSAGE_WELCOME,
    			              version,
    			              MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
    			              storageFileInfo, DIVIDER};
    	return formatted;
    }
    
    /**
     * Formats goodbye message
     * 
     * @return Formatted goodbye message to show to user
     */
    public static String[] getFormattedGoodbyeMessage() {
    	String[] formatted = {MESSAGE_GOODBYE,
    			              DIVIDER, DIVIDER};
    	return formatted;
    }
    
    /**
     * Formats initialization failed message
     * 
     * @return Formatted initialization failed message to show to user
     */
    public static String[] getFormattedInitFailedMessage() {
    	String[] formatted = {MESSAGE_INIT_FAILED,
    			              DIVIDER, DIVIDER};
    	return formatted;
    }
    
    /**
     * Formats result of a command execution
     * 
     * @return Formatted result of a command execution to show to user
     */
    public static String[] getFormattedResult(CommandResult result) {
    	String[] formatted = {result.feedbackToUser, DIVIDER};
    	return formatted;
    }
     
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
