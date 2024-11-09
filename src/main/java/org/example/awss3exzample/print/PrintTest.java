package org.example.awss3exzample.print;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import java.awt.*;
import java.awt.print.*;

public class PrintTest {

    public static void main(String[] args) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

        // Mos printerni tanlash
        PrintService printService = null;
        for (PrintService ps : printServices) {
            if (ps.getName().equalsIgnoreCase("Microsoft Print to PDF")) {
                printService = ps;
                break;
            }
        }

        if (printService != null) {
            try {
                // Printable interfeysi orqali chop etish
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintService(printService);
                job.setPrintable(new Printable() {
                    @Override
                    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
                        if (page > 0) { // faqat bitta sahifa chop qilamiz
                            return NO_SUCH_PAGE;
                        }
                        // Matnni chop etish
                        g.drawString("Hello, World!", 100, 100);
                        return PAGE_EXISTS;
                    }
                });

                // Chop etish jarayonini boshlash
                job.print();
                System.out.println("Chop etish muvaffaqiyatli amalga oshirildi.");

            } catch (PrinterException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Tanlangan printer topilmadi.");
        }
    }
}


