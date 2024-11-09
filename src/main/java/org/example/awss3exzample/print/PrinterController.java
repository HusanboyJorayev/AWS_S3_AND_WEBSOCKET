package org.example.awss3exzample.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrinterController {

    @Autowired
    private PrinterService printerService;

    @PostMapping("/print")
    public String print(@RequestParam String printerName) {
        String text="Assalomu alaykum";
        printerService.printText(printerName, text);
        return "Print job sent to printer: " + printerName;
    }
}
