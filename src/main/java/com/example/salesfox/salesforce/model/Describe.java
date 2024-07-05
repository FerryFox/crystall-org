package com.example.salesfox.salesforce.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Describe {
    public String custom;
    public List<Fields> fields;
    public String label;
    public String name;
}




/*
    "actionOverrides" : [ {
            "formFactor": "LARGE",
            "isAvailableInTouch": false,
            "name": "View",
            "pageId": "0M0Qy000001t4IYKAY",
            "url": null
        }
    ]
    "activateable": false,
    "associateEntityType": null,
    "associateParentEntity": null,
    "childRelationships": [ {
            "cascadeDelete": true,
            "childSObject": "AIInsightValue",
            "deprecatedAndHidden": false,
            "field": "SobjectLookupValueId",
            "junctionIdListNames": [],
            "junctionReferenceTo": [],
            "relationshipName": null,
            "restrictedDelete": false
        },
    ]
    "compactLayoutable": true,
    "createable": true,
    "custom": true,
    "customSetting": false,
    "deepCloneable": false,
    "defaultImplementation": null,
    "deletable": true,
    "deprecatedAndHidden": false,
    "extendedBy": null,
    "extendsInterfaces": null,
    "feedEnabled": false,
    "fields": [
        {
            "aggregatable": true,
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
        },
    ]
    "hasSubtypes": false,
    "implementedBy": null,
    "implementsInterfaces": null,
    "isInterface": false,
    "isSubtype": false,
    "keyPrefix": "a05",
    "label": "HttpLog",
    "labelPlural": "HttpLog",
    "layoutable": true,
    "listviewable": null,
    "lookupLayoutable": null,
    "mergeable": false,
    "mruEnabled": true,
    "name": "HttpLog__c",
    "namedLayoutInfos": [],
    "networkScopeFieldName": null,
    "queryable": true,
    "recordTypeInfos": [ {
            "active": true,
            "available": true,
            "defaultRecordTypeMapping": true,
            "developerName": "Master",
            "master": true,
            "name": "Master",
            "recordTypeId": "012000000000000AAA",
            "urls": {
                "layout": "/services/data/v61.0/sobjects/HttpLog__c/describe/layouts/012000000000000AAA"
            }
        }
    ],
    "replicateable": true,
    "retrieveable": true,
    "searchLayoutable": true,
    "searchable": true,
    "sobjectDescribeOption": "FULL",
    "supportedScopes": [
        {
            "label": "All httplog",
            "name": "everything"
        },
    ],
    "triggerable": true,
    "undeletable": true,
    "updateable": true,
    "urls": {
        "compactLayouts": "/services/data/v61.0/sobjects/HttpLog__c/describe/compactLayouts",
        "rowTemplate": "/services/data/v61.0/sobjects/HttpLog__c/{ID}",
        "approvalLayouts": "/services/data/v61.0/sobjects/HttpLog__c/describe/approvalLayouts",
        "uiDetailTemplate": "https://resilient-goat-uddb3x-dev-ed.trailblaze.my.salesforce.com/{ID}",
        "uiEditTemplate": "https://resilient-goat-uddb3x-dev-ed.trailblaze.my.salesforce.com/{ID}/e",
        "describe": "/services/data/v61.0/sobjects/HttpLog__c/describe",
        "uiNewRecord": "https://resilient-goat-uddb3x-dev-ed.trailblaze.my.salesforce.com/a05/e",
        "quickActions": "/services/data/v61.0/sobjects/HttpLog__c/quickActions",
        "layouts": "/services/data/v61.0/sobjects/HttpLog__c/describe/layouts",
        "sobject": "/services/data/v61.0/sobjects/HttpLog__c"
    }

 */