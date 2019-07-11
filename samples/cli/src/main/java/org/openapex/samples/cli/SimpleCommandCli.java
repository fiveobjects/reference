package org.openapex.samples.cli;

import picocli.CommandLine;

public class SimpleCommandCli {
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new GetMessage());
        commandLine.parseWithHandler(new CommandLine.RunLast(), args);
    }

    @CommandLine.Command(name = "message")
    public static class GetMessage implements Runnable {
        @CommandLine.Option(names = {"-n", "--name"}, description = "User name")
        public String name;
        @CommandLine.Option(names = {"-g", "--gender"}, description = "User gender")
        public char gender;
        @CommandLine.Option(names = {"-l", "--location"}, description = "User location")
        public String location;

        public void run() {
            StringBuilder message = new StringBuilder();
            message.append("Hello").append(" ");
            message.append(gender=='M'? "Mr.": "Ms.").append(" ");
            message.append(name).append("! ");
            message.append("Good to know that you are from ").append(location);
            System.out.println(message.toString());
        }
    }
}
