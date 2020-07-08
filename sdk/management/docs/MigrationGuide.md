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

While conforming to the new guideline, we have tried our best to minimize the breaking changes. Most of the interfaces / classes / methods have stayed the same to offer user an easier migration experience.

Some of the important breaking changes are listed in the following sections:

### Authentication

In old version (`com.microsoft.azure-mgmt-**`), ApplicationTokenCredentials is created with all the credential parameters.

In new version (`com.azure.resourcemanager.**`), in order to provide an unified authentication based on Azure Identity for all Azure Java SDKs, the authentication mechanism has been re-designed and improved to offer a simpler interface. 

To the show the code snippets for the change:

**In old version (`com.microsoft.azure-mgmt-**`)**

```java
ApplicationTokenCredentials = new ApplicationTokenCredentials("<ClientId>", "<TenantId>", "<ClientSecret>", AzureEnvironment.AZURE)
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

In addition to this change, the **support for using auth file has been removed**. In old version, the user can choose to authenticate via the auth file, like this:

**In old version (`com.microsoft.azure-mgmt-**`)**

```java
Azure azure = Azure.authenticate(new File("my.azureauth")).withDefaultSubscription();
```
**In new version, this feature has been removed.** If this creates concern on your side, please file an issue to let us know.

For detailed information on the benefits of using the new authentication classes, please refer to [this page](https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/management/docs/AUTH.md)

## Customized Policy

Because of adopting Azure Core which is a shared library across all Azure SDKs, there is also a minor change regarding how customized policy in configured. 

In old version (`com.microsoft.azure-mgmt-**`), we use `withInterceptor` and pass the customized interceptor class to the Azure object 

In new version (`com.azure.resourcemanager.**`), we use `WithPolicy` instead and pass the customized policy to the Azure object 

So:

**In old version (`com.microsoft.azure-mgmt-**`)**

```java
Azure azure = Azure.configure()
    .withInterceptor(new Continue504PollingInterceptor())
    .authenticate(credential)
    .withDefaultSubscription();
```

**Equivalent in new version (`com.azure.resourcemanager.**`)**

```java
Azure azure = Azure.configure()
    .withPolicy(new Continue504PollingInterceptor())
    .authenticate(credential, profile)
    .withDefaultSubscription();
```

## Custom HTTP Client

Similar to the customized policy, there are changes regarding how the custom HTTP client is configured as well. The re-designed HTTP client builder in the new version is more flexible and the user can choose their own implementation of HTTP client and plug in what they need into the configuration.

**In old version (`com.microsoft.azure-mgmt-**`)**
OkHttpClient.Builder builder = new OkHttpClient.Builder().proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888)));
RestClient client = new RestClient.Builder(builder, new Retrofit.Builder())
    .withCredentials(credential)
    .build();

Azure azure = Azure.authenticate(client, "<TenantId>")
    .withDefaultSubscription();

**Equivalent in new version (`com.azure.resourcemanager.**`)**

HttpClient client = new OkHttpAsyncHttpClientBuilder()
    .proxy(new ProxyOptions(ProxyOptions.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888)))
    .build();

Azure azure = Azure.configure()
    .withHttpClient(client)
    .authenticate(credential, profile)
    .withDefaultSubscription();
    
## Error Handling

There is a minor namespace change in the exception class. To be specific, the previous `CloudException` has been re-named to `ManagementException`. 

**In old version (`com.microsoft.azure-mgmt-**`)**

```java
final String resourceGroupName = random(8);
try {
    ResourceGroup resourceGroup = azure.resourceGroups().getByName(resourceGroupName);
} catch (CloudException e) {
    System.err.printf("Response code: %s%n", e.body().code());
    System.err.printf("Response message: %s%n", e.body().message());
}
```

**Equivalent in new version (`com.azure.resourcemanager.**`)**

```java
final String resourceGroupName = randomString("rg", 8);
try {
    ResourceGroup resourceGroup = azure.resourceGroups().getByName(resourceGroupName);
} catch (ManagementException e) {
    System.err.printf("Response code: %s%n", e.getValue().getCode());
    System.err.printf("Response message: %s%n", e.getValue().getMessage());
}
```

## rxJava -> Reactor

In old version (`com.microsoft.azure-mgmt-**`), `rxJava` is used for non-blocking applications

In new version (`com.azure.resourcemanager.**`), we have adopted `Reactor` as the main library in replacement of `rxJava`

The detailed usage can be found in the sample link below:

**In old version (`com.microsoft.azure-mgmt-**`)**
[Sample](https://github.com/Azure/azure-libraries-for-java/blob/master/azure-samples/src/main/java/com/microsoft/azure/management/compute/samples/ManageVirtualMachineScaleSetAsync.java#L100)

**Equivalent in new version (`com.azure.resourcemanager.**`)**
[Sample](https://github.com/Azure/azure-sdk-for-java/blob/7beda69/sdk/management/samples/src/main/java/com/azure/resourcemanager/compute/samples/ManageVirtualMachineScaleSetAsync.java#L98)

## Additional Samples 

More samples can be found at :
- [README for new version of SDK](http://aka.ms/azure-sdk-java-mgmt)
- [Code Samples for Resource Management Libraries](https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/management/docs/SAMPLE.md)
- [Authentication Documentation](https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/management/docs/AUTH.md)
