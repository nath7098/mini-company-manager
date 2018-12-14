package central.model.company;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    /**
     * writes a line to a file
     *
     * @param w the writer
     * @param values the list of values to write
     * @throws IOException if can't write line
     */
    static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w,values,DEFAULT_SEPARATOR,' ');
    }

    /**
     * reads a line from a file
     *
     * @param csvLine the line to read
     * @return the list of values of a line
     */
    static List<String> readLine(String csvLine) {
        return readLine(csvLine,DEFAULT_SEPARATOR,DEFAULT_QUOTE);
    }

    /**
     * turns a string to a csv formatted string
     *
     * @param value the string  to format
     * @return the formatted string
     */
    static String followCSVFormat(String value) {

        String result = value;
        if(result.contains("\"")){
            result = result.replace("\"","\"\"");
        }
        return result;
    }

    /**
     * writes a line to a file
     *
     * @param w the writer
     * @param values the lilst of values to write
     * @param separator the separator between values
     * @param customQuote the type of quotes surrounding values
     * @throws IOException if can't write line
     */
    private static void writeLine(Writer w, List<String> values, char separator, char customQuote) throws IOException {

        boolean first = true;
        if(separator==' '){
            separator = DEFAULT_SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        for(String value : values) {
            if(!first) {
                sb.append(separator);
            }
            if(customQuote == ' ') {
                sb.append(followCSVFormat(value));
            }
            else {
                sb.append(customQuote).append(followCSVFormat(value)).append(customQuote);
            }
            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }

    /**
     * reads a line from a file
     *
     * @param cvsLine the line to read
     * @param separators the separator between values
     * @param customQuote the type of quotes surrounding values
     * @return the list of values of a line
     */
    private static List<String> readLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    continue;
                } else if (ch == '\n') {
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }


}
