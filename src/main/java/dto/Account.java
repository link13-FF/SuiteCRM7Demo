package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public class Account {

    @Builder.Default
    String name = "test";
    @Builder.Default
    String officePhone = "";
    @Builder.Default
    String website = "";
    @Builder.Default
    String fax = "";

    @Builder.Default
    String billingAddressStreet = "";
    @Builder.Default
    String shippingAddressStreet = "";

    @Builder.Default
    String billingAddressCity = "";
    @Builder.Default
    String billingAddressState = "";
    @Builder.Default
    String billingAddressPostalCode = "";
    @Builder.Default
    String billingAddressCountry = "";

    @Builder.Default
    String shippingAddressCity = "";
    @Builder.Default
    String shippingAddressState = "";
    @Builder.Default
    String shippingAddressPostalCode = "";
    @Builder.Default
    String shippingAddressCountry = "";

    @Builder.Default
    String description = "";
    @Builder.Default
    String dropdown;
    @Builder.Default
    String type;
    @Builder.Default
    String industry;
}