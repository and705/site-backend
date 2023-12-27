package com.nd705.suppointspb.controller.site;

import com.nd705.suppointspb.entity.site.Faq;
import com.nd705.suppointspb.model.blog.CategoryDto;
import com.nd705.suppointspb.model.site.FaqDto;
import com.nd705.suppointspb.service.site.FaqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faq")
@Tag(
        name = "CRUD REST APIs for Faq Resource"
)
@AllArgsConstructor
public class FaqController {
    private FaqService faqService;

    @Operation(
            summary = "Create Faq REST API",
            description = "Create Faq REST API is used to save FAQ into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FaqDto> addCategory(@RequestBody FaqDto faqDto){
        FaqDto savedFaq = faqService.addFaq(faqDto);
        return new ResponseEntity<>(savedFaq, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get FAQ By Id REST API",
            description = "Get FAQ By Id REST API is used to get single FAQ from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    // Build Get Category REST API
    @GetMapping("{id}")
    public ResponseEntity<FaqDto> getCategory(@PathVariable("id") Long faqId){
        FaqDto faqDto = faqService.getFaq(faqId);
        return ResponseEntity.ok(faqDto);
    }


    @Operation(
            summary = "Get All FAQ REST API",
            description = "Get All FAQ REST API is used to fetch all the FAQ from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    // Build Get All Categories REST API
    @GetMapping
    public ResponseEntity<List<FaqDto>> getFaqs(){
        return ResponseEntity.ok(faqService.getAllFaqs());
    }


    @Operation(
            summary = "update FAQ REST API",
            description = "Update FAQ REST API is used to update a particular FAQ in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // Build Update Category REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<FaqDto> updateFaq(@RequestBody FaqDto faqDto,
                                                      @PathVariable("id") Long faqId){
        return ResponseEntity.ok(faqService.updateFaq(faqDto, faqId));
    }

    @Operation(
            summary = "Delete FAQ REST API",
            description = "Delete FAQ REST API is used to delete a particular FAQ from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    // Build Delete Category REST API
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFaq(@PathVariable("id") Long faqId){
        faqService.deleteFaq(faqId);
        return ResponseEntity.ok("FAQ deleted successfully!.");
    }

}
