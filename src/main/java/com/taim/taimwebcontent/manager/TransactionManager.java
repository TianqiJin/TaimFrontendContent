package com.taim.taimwebcontent.manager;

import com.taim.taimwebcontent.model.CreateQuotationInput;
import com.taim.taimwebcontent.model.QuotationOverviewView;
import com.taim.taimwebcontent.model.quotationdetail.QuotationDetail;

import java.util.List;

public interface TransactionManager {
    QuotationDetail initNewQuotation();
    void createNewQuotation(CreateQuotationInput createQuotationInput);
    List<QuotationOverviewView> getQuotationOverviewViewByCustomerId(Long customerId);
    List<QuotationOverviewView> getAllQuotationOverviewViews();
    QuotationDetail getQuotationDetailByQuotationId(String quotationId);

}
