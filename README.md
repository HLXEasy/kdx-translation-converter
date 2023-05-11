# Kdx Translation Converter

This is a simple helper tool to handle the data format of the KDX translation data file and the Transifex json format.

Starting the application without any option just shows the following help output:

```bash
    KDX language file converter by Helix

    This tool is able to:
     - split a given KDX language file into separate files or
     - merge different language files into a single file

    Usage: java -jar translationconverter.jar <options>

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
```

Example:

```bash
java -jar translationconverter.jar --merge --folder=../kdx-translation-files/translations
```

But easiest way would be to start it right out of development env like IntelliJ. Just configure a Spring Boot service
with above described parameters and Java 17 and you're ready to go. :-)
