/**
 * Jexer - Java Text User Interface
 *
 * License: LGPLv3 or later
 *
 * This module is licensed under the GNU Lesser General Public License
 * Version 3.  Please see the file "COPYING" in this directory for more
 * information about the GNU Lesser General Public License Version 3.
 *
 *     Copyright (C) 2015  Kevin Lamonte
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, see
 * http://www.gnu.org/licenses/, or write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA
 *
 * @author Kevin Lamonte [kevin.lamonte@gmail.com]
 * @version 1
 */
package jexer;

/**
 * This class encapsulates a user command event.  User commands can be
 * generated by menu actions, keyboard accelerators, and other UI elements.
 * Commands can operate on both the application and individual widgets.
 */
public class TCommand {

    /**
     * The following types are predefined for the entire system.
     *
     * TODO: Switch this to int so that TCommand can be subclassed so that
     * applications can add more.
     */
    public enum Type {
        /**
         * Immediately abort the application (e.g. remote side closed
         * connection).
         */
        ABORT,

        /**
         * File open dialog.
         */
        OPEN,

        /**
         * Exit application.
         */
        EXIT,

        /**
         * Spawn OS shell window.
         */
        SHELL,

        /**
         * Cut selected text and copy to the clipboard.
         */
        CUT,

        /**
         * Copy selected text to clipboard.
         */
        COPY,

        /**
         * Paste from clipboard.
         */
        PASTE,

        /**
         * Clear selected text without copying it to the clipboard.
         */
        CLEAR,

        /**
         * Tile windows.
         */
        TILE,

        /**
         * Cascade windows.
         */
        CASCADE,

        /**
         * Close all windows.
         */
        CLOSE_ALL,

        /**
         * Move (move/resize) window.
         */
        WINDOW_MOVE,

        /**
         * Zoom (maximize/restore) window.
         */
        WINDOW_ZOOM,

        /**
         * Next window (like Alt-TAB).
         */
        WINDOW_NEXT,

        /**
         * Previous window (like Shift-Alt-TAB).
         */
        WINDOW_PREVIOUS,

        /**
         * Close window.
         */
        WINDOW_CLOSE,

    }

    /**
     * Type of command, one of EXIT, CASCADE, etc.
     */
    private Type type;

    /**
     * Public constructor.
     *
     * @param type the Type of command, one of EXIT, CASCADE, etc.
     */
    public TCommand(final Type type) {
        this.type = type;
    }

    /**
     * Make human-readable description of this TCommand.
     *
     * @return displayable String
     */
    @Override
    public final String toString() {
        return String.format("%s", type);
    }

    /**
     * Comparison check.  All fields must match to return true.
     *
     * @param rhs another TCommand instance
     * @return true if all fields are equal
     */
    @Override
    public final boolean equals(final Object rhs) {
        if (!(rhs instanceof TCommand)) {
            return false;
        }

        TCommand that = (TCommand) rhs;
        return (type == that.type);
    }

    public static final TCommand cmAbort      = new TCommand(TCommand.Type.ABORT);
    public static final TCommand cmExit       = new TCommand(TCommand.Type.EXIT);
    public static final TCommand cmQuit       = new TCommand(TCommand.Type.EXIT);
    public static final TCommand cmOpen       = new TCommand(TCommand.Type.OPEN);
    public static final TCommand cmShell      = new TCommand(TCommand.Type.SHELL);
    public static final TCommand cmCut        = new TCommand(TCommand.Type.CUT);
    public static final TCommand cmCopy       = new TCommand(TCommand.Type.COPY);
    public static final TCommand cmPaste      = new TCommand(TCommand.Type.PASTE);
    public static final TCommand cmClear      = new TCommand(TCommand.Type.CLEAR);
    public static final TCommand cmTile       = new TCommand(TCommand.Type.TILE);
    public static final TCommand cmCascade    = new TCommand(TCommand.Type.CASCADE);
    public static final TCommand cmCloseAll   = new TCommand(TCommand.Type.CLOSE_ALL);
    public static final TCommand cmWindowMove = new TCommand(TCommand.Type.WINDOW_MOVE);
    public static final TCommand cmWindowZoom = new TCommand(TCommand.Type.WINDOW_ZOOM);
    public static final TCommand cmWindowNext = new TCommand(TCommand.Type.WINDOW_NEXT);
    public static final TCommand cmWindowPrevious = new TCommand(TCommand.Type.WINDOW_PREVIOUS);
    public static final TCommand cmWindowClose = new TCommand(TCommand.Type.WINDOW_CLOSE);

}
