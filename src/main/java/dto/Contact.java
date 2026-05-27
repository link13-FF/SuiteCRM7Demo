package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
@Builder
public class Contact {

    @Builder.Default
    String firstName = "";
    @Builder.Default
    String lastName = "test";
    @Builder.Default
    String officePhone = "";
    @Builder.Default
    String jobTitle = "";
    @Builder.Default
    String mobile = "";
    @Builder.Default
    String department = "";
    @Builder.Default
    String fax = "";
    @Builder.Default
    String primaryAddress = "";
    @Builder.Default
    String primaryCity = "";
    @Builder.Default
    String primaryState = "";
    @Builder.Default
    String primaryPostalCode = "";
    @Builder.Default
    String primaryCountry = "";
    @Builder.Default
    String otherAddress = "";
    @Builder.Default
    String otherCity = "";
    @Builder.Default
    String otherState = "";
    @Builder.Default
    String otherPostalCode = "";
    @Builder.Default
    String otherCountry = "";
    }
