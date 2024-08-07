package com.example.salesfox.salesforce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fields {
    public boolean custom;
    public String label;
    public String name;
}

/*
 *          "aggregatable": true,
            "aiPredictionField": false,
            "autoNumber": false,
            "byteLength": 18,
            "calculated": false,
            "calculatedFormula": null,
            "cascadeDelete": false,
            "caseSensitive": false,
            "compoundFieldName": null,
            "controllerName": null,
            "createable": false,
            "custom": false,
            "defaultValue": null,
            "defaultValueFormula": null,
            "defaultedOnCreate": true,
            "dependentPicklist": false,
            "deprecatedAndHidden": false,
            "digits": 0,
            "displayLocationInDecimal": false,
            "encrypted": false,
            "externalId": false,
            "extraTypeInfo": null,
            "filterable": true,
            "filteredLookupInfo": null,
            "formulaTreatNullNumberAsZero": false,
            "groupable": true,
            "highScaleNumber": false,
            "htmlFormatted": false,
            "idLookup": true,
            "inlineHelpText": null,
            "label": "Record ID",
            "length": 18,
            "mask": null,
            "maskType": null,
            "name": "Id",
            "nameField": false,
            "namePointing": false,
            "nillable": false,
            "permissionable": false,
            "picklistValues": [],
            "polymorphicForeignKey": false,
            "precision": 0,
            "queryByDistance": false,
            "referenceTargetField": null,
            "referenceTo": [],
            "relationshipName": null,
            "relationshipOrder": null,
            "restrictedDelete": false,
            "restrictedPicklist": false,
            "scale": 0,
            "searchPrefilterable": false,
            "soapType": "tns:ID",
            "sortable": true,
            "type": "id",
            "unique": false,
            "updateable": false,
            "writeRequiresMasterRead": false
 */