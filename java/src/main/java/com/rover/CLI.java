package com.rover;

import org.apache.commons.cli.*;

public class CLI {

    private static Options configParameters() {

        Option logfile = Option.builder("file")
                .required(true)
                .hasArg()
                .longOpt("arg-name")
                .build();

        final Options options = new Options();

        options.addOption(logfile);

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
            formatter.printHelp("rover", options);

        } catch (ParseException e) {

            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("rover", options);

            e.printStackTrace();
        }

        System.out.println("\n~~~~~ ROVER TERMINATED ~~~~~\n");
    }
}
