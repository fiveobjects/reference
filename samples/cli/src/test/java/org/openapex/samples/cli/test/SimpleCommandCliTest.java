package org.openapex.samples.cli.test;

import org.junit.Test;
import org.openapex.samples.cli.SimpleCommandCli;

public class SimpleCommandCliTest {
    @Test
    public void testCommandWithAllOptions(){
        SimpleCommandCli.main(new String[]{"-n", "Mrityunjoy", "-g", "M", "-l", "India"});
    }

}
