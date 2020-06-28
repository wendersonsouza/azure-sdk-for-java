// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.documents.indexes.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/** The OcrSkill model. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata\\.type")
@JsonTypeName("#Microsoft.Skills.Vision.OcrSkill")
@JsonFlatten
@Fluent
public class OcrSkill extends SearchIndexerSkill {
    /*
     * A value indicating which language code to use. Default is en.
     */
    @JsonProperty(value = "defaultLanguageCode")
    private OcrSkillLanguage defaultLanguageCode;

    /*
     * A value indicating to turn orientation detection on or not. Default is
     * false.
     */
    @JsonProperty(value = "detectOrientation")
    private Boolean shouldDetectOrientation;

    /** Creates an instance of OcrSkill class. */
    @JsonCreator
    public OcrSkill(
            @JsonProperty(value = "inputs") List<InputFieldMappingEntry> inputs,
            @JsonProperty(value = "outputs") List<OutputFieldMappingEntry> outputs) {
        super(inputs, outputs);
    }

    /**
     * Get the defaultLanguageCode property: A value indicating which language code to use. Default is en.
     *
     * @return the defaultLanguageCode value.
     */
    public OcrSkillLanguage getDefaultLanguageCode() {
        return this.defaultLanguageCode;
    }

    /**
     * Set the defaultLanguageCode property: A value indicating which language code to use. Default is en.
     *
     * @param defaultLanguageCode the defaultLanguageCode value to set.
     * @return the OcrSkill object itself.
     */
    public OcrSkill setDefaultLanguageCode(OcrSkillLanguage defaultLanguageCode) {
        this.defaultLanguageCode = defaultLanguageCode;
        return this;
    }

    /**
     * Get the shouldDetectOrientation property: A value indicating to turn orientation detection on or not. Default is
     * false.
     *
     * @return the shouldDetectOrientation value.
     */
    public Boolean isShouldDetectOrientation() {
        return this.shouldDetectOrientation;
    }

    /**
     * Set the shouldDetectOrientation property: A value indicating to turn orientation detection on or not. Default is
     * false.
     *
     * @param shouldDetectOrientation the shouldDetectOrientation value to set.
     * @return the OcrSkill object itself.
     */
    public OcrSkill setShouldDetectOrientation(Boolean shouldDetectOrientation) {
        this.shouldDetectOrientation = shouldDetectOrientation;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
