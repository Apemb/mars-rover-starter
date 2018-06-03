package com.rover;

import org.apache.commons.cli.*;

public class CLI {

    private static Options configParameters() {

        Option positionX = Option.builder("x")
                .desc("initial X landing rover position")
                .longOpt("positionX")
                .hasArg()
                .type(Integer.class)
                .required(true)
                .build();

        Option positionY = Option.builder("y")
                .desc("initial Y landing rover position")
                .longOpt("positionY")
                .hasArg()
                .type(Integer.class)
                .required(true)
                .build();

        Option direction = Option.builder("d")
                .desc("initial landing rover direction")
                .longOpt("direction")
                .hasArg()
                .type(String.class)
                .required(true)
                .build();

        Option commands = Option.builder("c")
                .desc("provide an array of commands for the rover to execute")
                .longOpt("commands")
                .hasArgs()
                .type(String[].class)
                .required(true)
                .build();

        /*
        Rover initialization:
        --positionX, -x  initial X landing rover position           [required]
        --positionY, -y  initial Y landing rover position           [required]
        --direction, -d  initial landing rover direction            [required]

        Rover commands:
        --commands, -c  provide an array of commands for the rover to execute [array]

        */


        final Options options = new Options();

        options.addOption(positionX);
        options.addOption(positionY);
        options.addOption(direction);
        options.addOption(commands);

        return options;
    }

    public static void main(String[] args) {
        System.out.println("~~~~~ ROVER INITIALIZATION ~~~~~\n");

        final Options options = configParameters();

        CommandLineParser parser = new DefaultParser();

        try {

            final CommandLine line;
            line = parser.parse(options, args);

            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("initialization of rover", options);

        } catch (ParseException e) {

            System.out.println(e.getMessage() + "\n");

            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar target/rover-1.0-jar-with-dependencies.jar", options);

        }

        System.out.println("\n~~~~~ ROVER TERMINATED ~~~~~\n");
    }
}
