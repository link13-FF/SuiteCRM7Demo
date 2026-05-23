package dto;

import com.github.javafaker.Faker;

public class ContactFactory {

    public static Contact getContact() {

        Faker faker = new Faker();
        return new Contact(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().phoneNumber(),
                faker.job().title(),
                faker.phoneNumber().phoneNumber(),
                faker.job().position(),
                faker.phoneNumber().phoneNumber(),
                faker.address().fullAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country(),
                faker.address().fullAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country()
        );
    }
}


