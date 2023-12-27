package com.nd705.suppointspb.service.site;

import com.nd705.suppointspb.dao.site.FaqRepository;
import com.nd705.suppointspb.dao.site.LinkFormRepository;
import com.nd705.suppointspb.entity.site.Faq;
import com.nd705.suppointspb.entity.site.LinkForm;
import com.nd705.suppointspb.exception.ResourceNotFoundException;
import com.nd705.suppointspb.model.site.FaqDto;
import com.nd705.suppointspb.model.site.LinkFormDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LinkFormServiceImpl implements LinkFormService {
    private LinkFormRepository linkFormRepository;

    public LinkFormServiceImpl(LinkFormRepository linkFormRepository) {
        this.linkFormRepository = linkFormRepository;
    }

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public LinkFormDto addLinkForm(LinkFormDto linkFormDto) {
        LinkForm linkForm = modelMapper.map(linkFormDto, LinkForm.class);
        LinkForm savedLinkForm = linkFormRepository.save(linkForm);
        return modelMapper.map(savedLinkForm, LinkFormDto.class);
    }

    @Override
    public LinkFormDto getLinkForm(Long linkFormId) {
        LinkForm linkForm = linkFormRepository.findById(linkFormId)
                .orElseThrow(() -> new ResourceNotFoundException("LinkForm", "id", linkFormId));

        return modelMapper.map(linkForm, LinkFormDto.class);
    }

    @Override
    public List<LinkFormDto> getAllLinkForm() {
        List<LinkForm> linkForms = linkFormRepository.findAll();

        return linkForms.stream().map((linkForm) -> modelMapper.map(linkForm, LinkFormDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LinkFormDto updateLinkForm(LinkFormDto linkFormDto, Long linkFormId) {
        LinkForm linkForm = linkFormRepository.findById(linkFormId)
                .orElseThrow(() -> new ResourceNotFoundException("Link Form", "id", linkFormId));

        linkForm.setId(linkFormDto.getId());
        linkForm.setEmail(linkFormDto.getEmail());
        linkForm.setName(linkFormDto.getName());
        linkForm.setMessage(linkFormDto.getMessage());

        LinkForm updatedLinkForm = linkFormRepository.save(linkForm);

        return modelMapper.map(updatedLinkForm, LinkFormDto.class);
    }

    @Override
    public void deleteLinkForm(Long linkFormId) {
        LinkForm linkForm = linkFormRepository.findById(linkFormId)
                .orElseThrow(() -> new ResourceNotFoundException("Link Form", "id", linkFormId));

        linkFormRepository.delete(linkForm);
    }
}
