package com.nd705.suppointspb.controller.site;

import com.nd705.suppointspb.model.site.FaqDto;
import com.nd705.suppointspb.model.site.LinkFormDto;
import com.nd705.suppointspb.service.site.LinkFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/LinkForm")
@Tag(
        name = "CRUD REST APIs for Link Form Resource"
)
@AllArgsConstructor
public class LinkFormController {

    private LinkFormService linkFormService;

    @Operation(
            summary = "Create Link Form REST API",
            description = "Create Link Form REST API is used to save Link Form into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PostMapping
    public ResponseEntity<LinkFormDto> addCategory(@RequestBody LinkFormDto linkFormDto){
        LinkFormDto savedLinkedForm = linkFormService.addLinkForm(linkFormDto);
        return new ResponseEntity<>(savedLinkedForm, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Link Form By Id REST API",
            description = "Get Link Form By Id REST API is used to get single Link Form from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    // Build Get Category REST API
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<LinkFormDto> getCategory(@PathVariable("id") Long id){
        LinkFormDto linkFormDto = linkFormService.getLinkForm(id);
        return ResponseEntity.ok(linkFormDto);
    }


    @Operation(
            summary = "Get All Link Form REST API",
            description = "Get All Link Form REST API is used to fetch all the Link Form from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    // Build Get All Categories REST API
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<LinkFormDto>> getLinkForm(){
        return ResponseEntity.ok(linkFormService.getAllLinkForm());
    }


    @Operation(
            summary = "update Link Form REST API",
            description = "Update FAQ REST API is used to update a particular Link Form in the database"
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
    public ResponseEntity<LinkFormDto> updateLinkForm(@RequestBody LinkFormDto linkFormDto,
                                            @PathVariable("id") Long id){
        return ResponseEntity.ok(linkFormService.updateLinkForm(linkFormDto, id));
    }

    @Operation(
            summary = "Delete Link Form REST API",
            description = "Delete Link Form REST API is used to delete a particular Link Form from the database"
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
    public ResponseEntity<String> deleteLinkForm(@PathVariable("id") Long id){
        linkFormService.deleteLinkForm(id);
        return ResponseEntity.ok("Link Form deleted successfully!.");
    }
}
