/*
 * Jexer - Java Text User Interface
 *
 * The MIT License (MIT)
 *
 * Copyright (C) 2019 Kevin Lamonte
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 * @author Kevin Lamonte [kevin.lamonte@gmail.com]
 * @version 1
 */
package jexer.teditor;

import java.util.SortedMap;
import java.util.TreeMap;

import jexer.bits.CellAttributes;
import jexer.bits.Color;

/**
 * Highlighter provides color choices for certain text strings.
 */
public class Highlighter {

    // ------------------------------------------------------------------------
    // Variables --------------------------------------------------------------
    // ------------------------------------------------------------------------

    /**
     * The highlighter colors.
     */
    private SortedMap<String, CellAttributes> colors;

    // ------------------------------------------------------------------------
    // Constructors -----------------------------------------------------------
    // ------------------------------------------------------------------------

    /**
     * Public constructor sets the theme to the default.
     */
    public Highlighter() {
        colors = new TreeMap<String, CellAttributes>();
    }

    // ------------------------------------------------------------------------
    // Highlighter ------------------------------------------------------------
    // ------------------------------------------------------------------------

    /**
     * See if this is a character that should split a word.
     *
     * @param ch the character
     * @return true if the word should be split
     */
    public boolean shouldSplit(final char ch) {
        // For now, split on punctuation
        String punctuation = "'\"\\<>{}[]!@#$%^&*();:.,-+/*?";
        if (punctuation.indexOf(ch) != -1) {
            return true;
        }
        return false;
    }

    /**
     * Retrieve the CellAttributes for a named theme color.
     *
     * @param name theme color name, e.g. "twindow.border"
     * @return color associated with name, e.g. bold yellow on blue
     */
    public CellAttributes getColor(final String name) {
        CellAttributes attr = (CellAttributes) colors.get(name);
        return attr;
    }

    /**
     * Sets to defaults that resemble the Borland IDE colors.
     */
    public void setJavaColors() {
        CellAttributes color;

        String [] keywords = {
            "boolean", "byte", "short", "int", "long", "char", "float",
            "double", "void", "new",
            "static", "final", "volatile", "synchronized", "abstract",
            "public", "private", "protected",
            "class", "interface", "extends", "implements",
            "if", "else", "do", "while", "for", "break", "continue",
            "switch", "case", "default",
        };
        color = new CellAttributes();
        color.setForeColor(Color.WHITE);
        color.setBackColor(Color.BLUE);
        color.setBold(true);
        for (String str: keywords) {
            colors.put(str, color);
        }

        String [] operators = {
            "[", "]", "(", ")", "{", "}",
            "*", "-", "+", "/", "=", "%",
            "^", "&", "!", "<<", ">>", "<<<", ">>>",
            "&&", "||",
            ">", "<", ">=", "<=", "!=", "==",
            ",", ";", ".", "?", ":",
        };
        color = new CellAttributes();
        color.setForeColor(Color.CYAN);
        color.setBackColor(Color.BLUE);
        color.setBold(true);
        for (String str: operators) {
            colors.put(str, color);
        }

        String [] packageKeywords = {
            "package", "import",
        };
        color = new CellAttributes();
        color.setForeColor(Color.GREEN);
        color.setBackColor(Color.BLUE);
        color.setBold(true);
        for (String str: packageKeywords) {
            colors.put(str, color);
        }

    }

}
