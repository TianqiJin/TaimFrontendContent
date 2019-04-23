package com.taim.content.mapper;

import com.google.common.base.Converter;
import com.taim.content.model.quotationdetail.QuotationItem;
import com.taim.taimbackendservicemodel.TransactionDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class QuotationItemMapper {

    public QuotationItem map(TransactionDetailDTO transactionDetailDTO) {
        return QuotationItem.builder()
                .sku(transactionDetailDTO.getProduct().getSku())
                .discount(transactionDetailDTO.getDiscount())
                .displayName(transactionDetailDTO.getProduct().getDisplayName())
                .note(transactionDetailDTO.getNote())
                .quantity(transactionDetailDTO.getQuantity())
                .subtotal(transactionDetailDTO.getSubtotal())
                .unitPrice(transactionDetailDTO.getUnitPrice())
                .build();
    }
}
