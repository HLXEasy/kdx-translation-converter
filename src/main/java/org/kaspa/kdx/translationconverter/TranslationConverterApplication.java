package org.kaspa.kdx.translationconverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Objects;

@SpringBootApplication
public class TranslationConverterApplication implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TranslationConverterApplication.class);

    @Value("folder")
    private String translationFileFolder = "";

    @Value("split")
    private String splitLanguageFiles;
    private Boolean doSplit = false;

    @Value("merge")
    private String mergeLanguageFiles;
    private Boolean doMerge = false;

    @Value("help")
    private String help;

    /**
     * The main method for starting the converter application.
     * It initializes the logging, starts the Spring application, and logs when the converter finishes.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        LOG.info("Starting converter");
        SpringApplication.run(TranslationConverterApplication.class, args);
        LOG.info("Converter finished");
    }


    /**
     * Runs the application with the given command-line arguments.
     *
     * @param args The command-line arguments passed to the program.
     * @throws Exception If an exception occurs while running the application.
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        LOG.info("NonOptionArgs: {}", args.getNonOptionArgs());
        LOG.info("OptionArgs:    {}", args.getOptionNames());

        // We need some options to work properly
        if (args.getOptionNames().isEmpty()) {
            Help.showHelp();
            return;
        }

        // User wants to see the help content
        if (args.containsOption(OptionsEnum.SHOW_HELP.getOption())) {
            Help.showHelp();
            return;
        }

        if (!args.containsOption(OptionsEnum.TRANSLATION_FILE_FOLDER.getOption())) {
            translationFileFolder = OptionsEnum.TRANSLATION_FILE_FOLDER.getDefaultValue();
        }

        // Get given options
        for (String currentOption : args.getOptionNames()) {
            OptionsEnum currentOptionEnum = OptionsEnum.getOptionByName(currentOption);
            switch (Objects.requireNonNull(currentOptionEnum)) {
                case MERGE_FILES -> doMerge = true;
                case SPLIT_FILES -> doSplit = true;
                case TRANSLATION_FILE_FOLDER -> translationFileFolder = args.getOptionValues(currentOption).get(0);
                default -> {
                    Help.showHelp();
                    return;
                }
            }
        }

        // Evaluate given options and parameters
        if (doSplit && doMerge) {
            System.out.println("\nIt's not possible to use split and merge at the same time!");
            Help.showHelp();
            return;
        }

        // Show a summary before starting the main work
        System.out.println("\nPerformed operation: " + (doMerge ? "merge" : doSplit ? "split" : "unknown") +
            "\nUsed folder:         " + translationFileFolder +
            "\n");

        // Now just do it!
        if (doSplit) {
            LangFileSplitter langFileSplitter = new LangFileSplitter(translationFileFolder);
            langFileSplitter.doSplit();
        } else if (doMerge) {
            LangFileMerger langFileMerger = new LangFileMerger(translationFileFolder);
            langFileMerger.doMerge();
        } else {
            System.out.println("\nNo valid combination of options given");
            Help.showHelp();
        }
    }
}
