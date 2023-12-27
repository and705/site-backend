package com.nd705.suppointspb.service.site;

import com.nd705.suppointspb.dao.site.FaqRepository;
import com.nd705.suppointspb.entity.blog.Category;
import com.nd705.suppointspb.entity.site.Faq;
import com.nd705.suppointspb.exception.ResourceNotFoundException;
import com.nd705.suppointspb.model.blog.CategoryDto;
import com.nd705.suppointspb.model.site.FaqDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaqServiceImpl implements FaqService {

    private FaqRepository faqRepository;

    private ModelMapper modelMapper = new ModelMapper();
    public FaqServiceImpl(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }
    @Override
    public FaqDto addFaq(FaqDto faqDto) {
        Faq faq = modelMapper.map(faqDto, Faq.class);
        Faq savedFaq = faqRepository.save(faq);
        return modelMapper.map(savedFaq, FaqDto.class);
    }

    @Override
    public FaqDto getFaq(Long FaqId) {
        Faq faq = faqRepository.findById(FaqId)
                .orElseThrow(() -> new ResourceNotFoundException("Faq", "id", FaqId));

        return modelMapper.map(faq, FaqDto.class);
    }

    @Override
    public List<FaqDto> getAllFaqs() {
        List<Faq> faqs = faqRepository.findAll();

        return faqs.stream().map((faq) -> modelMapper.map(faq, FaqDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FaqDto updateFaq(FaqDto faqDto, Long faqId) {
        Faq faq = faqRepository.findById(faqId)
                .orElseThrow(() -> new ResourceNotFoundException("Faq", "id", faqId));

        faq.setId(faqDto.getId());
        faq.setText(faqDto.getText());
        faq.setTitle(faqDto.getTitle());

        Faq updatedFaq = faqRepository.save(faq);

        return modelMapper.map(updatedFaq, FaqDto.class);
    }

    @Override
    public void deleteFaq(Long faqId) {
        Faq faq = faqRepository.findById(faqId)
                .orElseThrow(() -> new ResourceNotFoundException("Faq", "id", faqId));

        faqRepository.delete(faq);

    }
}
