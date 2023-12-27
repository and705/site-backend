package com.nd705.suppointspb.service.site;

import com.nd705.suppointspb.entity.site.Faq;
import com.nd705.suppointspb.model.site.FaqDto;


import java.util.List;

public interface FaqService {
    FaqDto addFaq(FaqDto faqDto);

    FaqDto getFaq(Long FaqId);

    List<FaqDto> getAllFaqs();

    FaqDto updateFaq(FaqDto faqDto, Long FaqId);

    void deleteFaq(Long FaqId);
}
