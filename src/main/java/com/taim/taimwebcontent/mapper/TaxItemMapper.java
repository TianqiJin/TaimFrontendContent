package com.taim.taimwebcontent.mapper;

import com.taim.taimbackendservicemodel.TaxInfoDTO;
import com.taim.taimwebcontent.model.quotationdetail.TaxItem;
import org.springframework.stereotype.Component;

@Component
public class TaxItemMapper {

    public TaxItem map(TaxInfoDTO taxInfoDTO) {
        return TaxItem.builder()
                .taxAmount(taxInfoDTO.getTaxAmount())
                .taxRate(taxInfoDTO.getTaxRate())
                .taxType(taxInfoDTO.getTaxType())
                .build();
    }
}
