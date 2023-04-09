package org.kaspa.kdx.translationconverter;

public class Help {
    public static void showHelp() {
        System.out.println("""

                KDX language file converter by Helix

                This tool is able to:
                 - split a given KDX language file into separate files or
                 - merge different language files into a single file

                Usage: java -jar translationconverter.jar <optionsEnum>

                Options:
                --help
                  .. Show this help text
                --folder=<path>
                  .. Path to folder where language files are located
                --merge
                  .. Merge all json files found on given folder into one
                     single KDX i18n.data file
                --split
                  .. Split KDX i18n.data language file on given folder into
                     separate json files for each determined language
            """);
//         |<- Position 0                                                 Position 78 ->|
    }
}
