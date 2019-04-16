package org.dikhim.clickauto.util.logger;

import java.util.function.Consumer;

public class Log {
    private static Printer infoPrinter;
    private static Printer errorPrinter;
    private static Printer outPrinter;

    synchronized public static void info(String string) {
        if (infoPrinter != null) infoPrinter.print(string);
    }

    synchronized public static void info(String string, Object... args) {
        if (infoPrinter != null) infoPrinter.format(string, args);
    }

    synchronized public static void error(String string) {
        if (errorPrinter != null) errorPrinter.print(string);
    }

    synchronized public static void error(String string, Object... args) {
        if (errorPrinter != null) errorPrinter.format(string, args);
    }
    
    synchronized public static void out(String string) {
        if (outPrinter != null) outPrinter.print(string);
    }

    synchronized public static void out(String string, Object... args) {
        if (outPrinter != null) outPrinter.format(string, args);
    }

    synchronized public static void addInfoHandler(Consumer<String> consumer) {
        if (infoPrinter == null) infoPrinter = new SimplePrinter();
        infoPrinter.addHandler(consumer);
    }

    synchronized public static void addErrorHandler(Consumer<String> consumer) {
        if (errorPrinter == null) errorPrinter = new SimplePrinter();
        errorPrinter.addHandler(consumer);
    }
    
    synchronized public static void addOutHandler(Consumer<String> consumer) {
        if (outPrinter == null) outPrinter = new SimplePrinter();
        outPrinter.addHandler(consumer);
    }
}
