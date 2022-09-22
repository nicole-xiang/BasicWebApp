package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("NX-Team"));
    }
// what%20is%2014%20plus%201
    @Test
    public void howToSplitStrings() {
    String input = "hello-to-everyone";

    String[] parts = input.split("-");

    assertThat(parts[0], is("hello"));
    assertThat(parts[1], is("to"));
    assertThat(parts[2], is("everyone"));
    }

    @Test
    public void usingRegexInJava() {
    String input = "Today is 22 September";

    Pattern regex = Pattern.compile("Today is (\\d+) \\w+");

    Matcher matcher = regex.matcher(input);

    assertTrue(matcher.matches());
    assertThat(matcher.group(1), is("22"));
    }

    @Test
    public void convertingStringNumbersToIntegers() {
        String input = "313";
        int number = Integer.parseInt(input);
        assertThat(number + 1, is(314));
    }

    @Test
    public void parsingNonNumbersAsIntegersThrowsException() {
    try {
        String badInput = "word";
        Integer.parseInt(badInput);
        fail("won't get here");
    } catch (NumberFormatException nfe) {
        assertThat(nfe.getMessage(), containsString("word"));
    }
    }
}
