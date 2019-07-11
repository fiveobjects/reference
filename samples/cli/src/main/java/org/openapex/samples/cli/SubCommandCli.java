package org.openapex.samples.cli;

import jdk.nashorn.internal.codegen.CompilerConstants;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command
public class SubCommandCli implements Callable<Void> {
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new SubCommandCli());
        commandLine.addSubcommand(new Git());
        commandLine.setExecutionStrategy(new CommandLine.RunLast());
        commandLine.execute(args);
    }
    public Void call(){
        return null;
    }
    @CommandLine.Command(name="git", description = "The git cli")
    public static class Git implements Callable<Void> {
        @CommandLine.Command(name="status")
        public void status(){
            System.out.println("On branch. Workspace clean.");
        }
        @CommandLine.Command(name="version")
        public void version(){
            System.out.println("1.0");
        }
        @CommandLine.Command(name="commit")
        public void commit(){
            System.out.println("Created a new commit.");
        }

        @Override
        public Void call() throws Exception {
            System.out.println("Running git commands");
            return null;
        }
    }
}
