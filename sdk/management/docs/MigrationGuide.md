## Guide for migrating to `com.azure.resourcemanager.**` from `com.microsoft.azure-mgmt-**`

This document is intended for users that are familiar with an older version of the Java SDK for managment libraries (`com.microsoft.azure-mgmt-**`) ad wish to migrate their application 
to the next version of Azure resource management libraries (`com.microsoft.azure-mgmt-**`)

For users new to the Java SDK for resource management libraries, please see the [README for 'com.azure.resourcemanager.*`](http://aka.ms/azure-sdk-java-mgmt)

## Table of contents
* Prerequisites
* Updated Maven depedencies
* General Changes
  * Converting core classes
  * Authentication
* Migration Samples
* Additional Samples

## Prerequisites

Java Development Kit (JDK) with version 8 or above.

## Updated Maven dependencies

The latest dependencies for resource management libraries are [available here](https://azure.github.io/azure-sdk/releases/latest/all/java.html). Please look for packages that contains "azure-resourcemanager" in the namespace.

## General Changes

The latest Azure Java SDK for management libraries is a result of our efforts to create a resource management client library that is user-friendly and idiomatic to the Java ecosystem.

Apart from redesigns resulting from the [new Azure SDK Design Guidelines for Java](https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/management/docs/DESIGN.md), the latest version improves on several areas from old version.

### Authentication

To provide an unified authentication based on Azure Identity for all Azure Java SDKs, the authentication mechanism has been re-designed and improved. 

**In old version (`com.microsoft.azure-mgmt-**`)**

```java
new ApplicationTokenCredentials("<ClientId>" ,"<TenantId>", "<ClientSecret>", AzureEnvironment.AZURE)
        .withDefaultSubscriptionId("<SubscriptionId>");
```        

**Equivalent in new version (`com.azure.resourcemanager.**`)**

```java
 TokenCredential credential = new ClientSecretCredentialBuilder()
                .clientId("<ClientId>")
                .clientSecret("<ClientSecret>")
                .tenantId("<TenantId>")
                .build();
        AzureProfile profile = new AzureProfile("<TenantId>", "<SubscriptionId>", AzureEnvironment.AZURE);
``` 
For detailed information on the benefits of using the new authentication classes, please refer to [this page](https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/management/docs/AUTH.md)

### Converting core classes

List all the core class changes and list 

| In old version (`com.microsoft.azure-mgmt-**`) | Equivalent in new version (`com.azure.resourcemanager.**`) | Sample Link |
|------------------------------------------------|------------------------------------------------------------|-------------|
|                                                |                                                            |     [link to existing sample](/)        |
|                                                |                                                            |             |
|                                                |                                                            |             |

## Migration Code Samples
* Migrating Azure **  to Azure **
* Migrating Authentication to AzureDefaultAuthentication 
* Migrating Iterable classes to PagedIterable classes
* Migrating xxx to xxx

### Migrating Azure **  to Azure **

In old version (`com.microsoft.azure-mgmt-**`), the classes are designed like this: xxxx
In new version (`com.azure.resourcemanager.**`), the classes are re-designed like this: xxxx

So in old version (Code sample):
```java

OldClass class = new OldClass();

```


in new version (code sample)

```java

NewClass class = new NewClass();

```

## Additional Samples 

More samples can be found at :
- [Code Samples for Resource Management Libraries](https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/management/docs/SAMPLE.md)
- [Authentication Documentation](https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/management/docs/AUTH.md)
