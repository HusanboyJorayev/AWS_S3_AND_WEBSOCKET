package org.example.awss3exzample.print;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class PrinterUtil {
    public PrintService findPrinterByName(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            if (printService.getName().equalsIgnoreCase(printerName)) {
                return printService;
            }
        }
        System.out.println("Printer not found: " + printerName);
        return null;
    }
}

