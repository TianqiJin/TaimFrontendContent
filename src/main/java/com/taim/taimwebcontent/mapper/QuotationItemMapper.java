package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.TransactionDetailDTO;
import com.taim.taimwebcontent.model.quotationdetail.QuotationItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuotationItemMapper {

    private final TaxItemMapper taxItemMapper;

    public QuotationItemMapper(TaxItemMapper taxItemMapper) {
        this.taxItemMapper = taxItemMapper;
    }

    public QuotationItem map(TransactionDetailDTO transactionDetailDTO) {
        return QuotationItem.builder()
                .sku(transactionDetailDTO.getProduct().getSku())
                .discount(transactionDetailDTO.getDiscount())
                .displayName(transactionDetailDTO.getProduct().getDisplayName())
                .note(transactionDetailDTO.getNote())
                .quantity(transactionDetailDTO.getQuantity())
                .subtotal(transactionDetailDTO.getSubtotal())
                .unitPrice(transactionDetailDTO.getUnitPrice())
                .taxItems(transactionDetailDTO.getTaxInfos().stream()
                        .map(this.taxItemMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
