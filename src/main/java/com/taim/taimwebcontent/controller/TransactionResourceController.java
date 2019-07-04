package com.taim.taimwebcontent.controller;

import com.taim.taimwebcontent.manager.TransactionManager;
import com.taim.taimwebcontent.model.CreateQuotationInput;
import com.taim.taimwebcontent.model.QuotationOverviewView;
import com.taim.taimwebcontent.model.quotationdetail.QuotationDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionResourceController {

    private final TransactionManager transactionManager;


    @Autowired
    public TransactionResourceController(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @GetMapping(
            value = "/quotations",
            params = "action=init"
    )
    public QuotationDetail initNewQuotation() {
        return this.transactionManager.initNewQuotation();
    }

    @PostMapping(
            value = "/quotations",
            params = "action=save"
    )
    public void saveQuotation(@RequestBody CreateQuotationInput createQuotationInput) {
        this.transactionManager.createNewQuotation(createQuotationInput);
    }

    @GetMapping(
            value = "/quotations",
            params = "action=getByCustomerId"
    )
    public List<QuotationOverviewView> getQuotationOverviewViewsByCustomerId(
            @RequestParam("customerId") Long customerId) {
        return this.transactionManager.getQuotationOverviewViewByCustomerId(customerId);
    }

    @GetMapping(
            value = "/quotations",
            params = "action=getAll"
    )
    public List<QuotationOverviewView> getAllQuotationOverviewViews() {
        return this.transactionManager.getAllQuotationOverviewViews();
    }

    @GetMapping(
            value = "/quotations",
            params = "action=getQuotationDetailByQuotationId"
    )
    public QuotationDetail getQuotationDetailByQuotationId(@RequestParam("quotationId") String quotationId) {
        return this.transactionManager.getQuotationDetailByQuotationId(quotationId);
    }
}
