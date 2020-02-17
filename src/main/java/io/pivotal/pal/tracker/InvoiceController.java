package io.pivotal.pal.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.actuate.metrics.CounterService;
//import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-repo")
public class InvoiceController {
    private static Logger logger = LoggerFactory.getLogger(InvoiceController.class);
    
    private InvoiceRepository invoiceRepository;

    public InvoiceController(
            InvoiceRepository invoiceRepository
    ) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<Invoice> read(@PathVariable Integer id) {
        Invoice invoice = invoiceRepository.find(id);
        if (invoice != null) {
            logger.debug("InvoiceNumber[{}], HttpStatus[{}]", invoice.getInvoiceNumber(), HttpStatus.OK);
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } else {
            logger.debug("InvoiceNumber[null], HttpStatus[{}]", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
