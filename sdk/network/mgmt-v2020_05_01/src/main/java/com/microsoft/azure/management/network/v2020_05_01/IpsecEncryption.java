/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_05_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for IpsecEncryption.
 */
public final class IpsecEncryption extends ExpandableStringEnum<IpsecEncryption> {
    /** Static value None for IpsecEncryption. */
    public static final IpsecEncryption NONE = fromString("None");

    /** Static value DES for IpsecEncryption. */
    public static final IpsecEncryption DES = fromString("DES");

    /** Static value DES3 for IpsecEncryption. */
    public static final IpsecEncryption DES3 = fromString("DES3");

    /** Static value AES128 for IpsecEncryption. */
    public static final IpsecEncryption AES128 = fromString("AES128");

    /** Static value AES192 for IpsecEncryption. */
    public static final IpsecEncryption AES192 = fromString("AES192");

    /** Static value AES256 for IpsecEncryption. */
    public static final IpsecEncryption AES256 = fromString("AES256");

    /** Static value GCMAES128 for IpsecEncryption. */
    public static final IpsecEncryption GCMAES128 = fromString("GCMAES128");

    /** Static value GCMAES192 for IpsecEncryption. */
    public static final IpsecEncryption GCMAES192 = fromString("GCMAES192");

    /** Static value GCMAES256 for IpsecEncryption. */
    public static final IpsecEncryption GCMAES256 = fromString("GCMAES256");

    /**
     * Creates or finds a IpsecEncryption from its string representation.
     * @param name a name to look for
     * @return the corresponding IpsecEncryption
     */
    @JsonCreator
    public static IpsecEncryption fromString(String name) {
        return fromString(name, IpsecEncryption.class);
    }

    /**
     * @return known IpsecEncryption values
     */
    public static Collection<IpsecEncryption> values() {
        return values(IpsecEncryption.class);
    }
}
