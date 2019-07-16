package org.openapex.samples.cli.test;

import org.junit.Assert;
import org.junit.Test;
import org.openapex.samples.cli.SimpleCommandCli;
import picocli.CommandLine;

public class SimpleCommandCliTest {
    @Test
    public void testCommandWithAllOptions() {
        SimpleCommandCli.GetMessage getMessage = new SimpleCommandCli.GetMessage();
        CommandLine.ParseResult result = new CommandLine(getMessage).parseArgs(
                new String[]{"-n", "Mrityunjoy", "-g", "M", "-l", "India"});
        Assert.assertEquals("Mrityunjoy", getMessage.name);
        Assert.assertEquals('M', getMessage.gender);
        Assert.assertEquals("India", getMessage.location);
    }

    @Test
    public void testCommandWithInvalidOption() {
        try {
            CommandLine.ParseResult result = new CommandLine(new SimpleCommandCli.GetMessage()).parseArgs(
                    new String[]{"-n", "Mrityunjoy", "-k", "M", "-l", "India"});
            Assert.fail("Should not reach here");
        } catch (CommandLine.UnmatchedArgumentException ex) {
            Assert.assertTrue(ex.getMessage().contains("Unknown options"));
        }
    }

}
