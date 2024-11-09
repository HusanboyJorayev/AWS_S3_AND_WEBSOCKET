package org.example.awss3exzample.print;

import org.springframework.stereotype.Component;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;

@Component
public class PrinterService {

    public void printText(String printerName, String text) {
        PrinterUtil printerUtil = new PrinterUtil();
        PrintService printService = printerUtil.findPrinterByName(printerName);

        if (printService == null) {
            System.out.println("Printer not found.");
            return;
        }

        // Print job yaratish
        DocPrintJob printJob = printService.createPrintJob();
        DocFlavor flavor = DocFlavor.STRING.TEXT_PLAIN;
        Doc doc = new SimpleDoc(text, flavor, null);

        try {
            printJob.print(doc, null);
            System.out.println("Printing job sent successfully.");
        } catch (PrintException e) {
            System.out.println("Printing failed: " + e.getMessage());
        }
    }
}

