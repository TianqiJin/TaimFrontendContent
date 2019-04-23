package com.taim.content.controller;

import com.taim.content.model.quotationdetail.QuotationCustomer;
import com.taim.content.model.quotationdetail.QuotationDetail;
import com.taim.content.model.quotationdetail.QuotationSummary;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@RestController
public class QuotationResourceController {

    private static final Integer QUOTATION_ID_COUNT = 12;
    @GetMapping(value = "/quotations/init")
    @CrossOrigin
    public QuotationDetail initNewQuotation() {
        QuotationDetail quotationDetail = new QuotationDetail();
        quotationDetail.setQuotationCustomer(new QuotationCustomer());
        quotationDetail.setQuotationSummary(new QuotationSummary());
        quotationDetail.setQuotationItems(new ArrayList<>());
        quotationDetail.getQuotationSummary().setCreateDate(new Date());

        quotationDetail.getQuotationSummary().setQuotationId("Q" + RandomStringUtils.randomAlphabetic(QUOTATION_ID_COUNT));

        return quotationDetail;
    }
}
