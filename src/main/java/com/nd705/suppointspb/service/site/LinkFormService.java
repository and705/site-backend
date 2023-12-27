package com.nd705.suppointspb.service.site;

import com.nd705.suppointspb.model.site.FaqDto;
import com.nd705.suppointspb.model.site.LinkFormDto;

import java.util.List;

public interface LinkFormService {
    LinkFormDto addLinkForm(LinkFormDto linkFormDto);

    LinkFormDto getLinkForm(Long LinkFormDtoId);

    List<LinkFormDto> getAllLinkForm();

    LinkFormDto updateLinkForm(LinkFormDto linkFormDto, Long LinkFormDtoId);

    void deleteLinkForm(Long LinkFormDtoId);
}
