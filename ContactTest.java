package com.pruebaDinamica.mod3;

// Importamos test y metodos de assert
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
	// Verificamos valides de campos correctos al crear contacto
	@Test
	void testContactCreation() {

        Contact contact = new Contact(
                "1234567890",
                "Bastian",
                "Garcia",
                "1234567890",
                "Temuco Chile"
        );

        assertEquals("1234567890", contact.getContactId());
        assertEquals("Bastian", contact.getFirstName());
        assertEquals("Garcia", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("Temuco Chile", contact.getAddress());
    }
	
	// Verificamos si los campos rechazan el null
	@Test
	void testFieldsCannotBeNull() {
		
		// Las agrupamos con assertall para comprobar en conjunto aunque alguna falle
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact (
				null,
				"Bastian",
				"Garcia",
				"1234567890",
				"Temuco Chile"
				)
			),
				
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
                        "123",
                        null,
                        "Garcia",
                        "1234567890",
                        "Temuco Chile"
                )
            ),

				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
                        "123",
                        "Bastian",
                        null,
                        "1234567890",
                        "Temuco Chile"
                )
            ),

				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
                        "123",
                        "Bastian",
                        "Garcia",
                        null,
                        "Temuco Chile"
                )
            ),

				() -> assertThrows(IllegalArgumentException.class, () -> new Contact(
                        "123",
                        "Bastian",
                        "Garcia",
                        "1234567890",
                        null
                )
            )		
		);
	}
	
	// Verificamos que no se excedan los caracteres
	@Test
	void testFieldsCannotExceedMaximumLength() {
		
		assertAll(
	            () -> assertThrows(IllegalArgumentException.class, () -> new Contact(
	                        "12345678901",
	                        "Bastian",
	                        "Garcia",
	                        "1234567890",
	                        "Temuco Chile"
	                )
	            ),

	            () -> assertThrows(IllegalArgumentException.class, () -> new Contact(
	                        "123",
	                        "BastianJose",
	                        "Garcia",
	                        "1234567890",
	                        "Temuco Chile"
	                )
	            ),

	            () -> assertThrows(IllegalArgumentException.class, () -> new Contact(
	                        "123",
	                        "Bastian",
	                        "GarciaPerez",
	                        "1234567890",
	                        "Temuco Chile"
	                )
	            ),

	            () -> assertThrows(IllegalArgumentException.class, () -> new Contact(
	                        "123",
	                        "Bastian",
	                        "Garcia",
	                        "1234567890",
	                        "Esta direccion es mas larga que treinta caracteres"
	                )
	            )
	        );
	}
	
	// Testeamos formato del numero de telefono
	@Test
	void testPhoneRequirements() {
		assertAll(
	            () -> assertThrows(IllegalArgumentException.class, () -> new Contact(
	                        "123",
	                        "Bastian",
	                        "Garcia",
	                        "123456789",
	                        "Temuco Chile"
	                )
	            ),

	            () -> assertThrows(IllegalArgumentException.class, () -> new Contact(
	                        "123",
	                        "Bastian",
	                        "Garcia",
	                        "12345678901",
	                        "Temuco Chile"
	                )
	            ),

	            () -> assertThrows(IllegalArgumentException.class, () -> new Contact(
	                        "123",
	                        "Bastian",
	                        "Garcia",
	                        "12345abcde",
	                        "Temuco Chile"
	                )
	            )
	        );
	}
	
	// Verificamos que se puedan actualizar los campos correctamente
	@Test
    void testContactFieldsCanBeUpdated() {

        Contact contact = new Contact(
                "123",
                "Bastian",
                "Garcia",
                "1234567890",
                "Temuco Chile"
        );

        contact.setFirstName("Sebastian");
        contact.setLastName("Perez");
        contact.setPhone("0987654321");
        contact.setAddress("Santiago Chile");
        
        assertAll(
                () -> assertEquals("Sebastian", contact.getFirstName()),
                () -> assertEquals("Perez", contact.getLastName()),
                () -> assertEquals("0987654321", contact.getPhone()),
                () -> assertEquals("Santiago Chile", contact.getAddress())
            );
        
	}
	
	// Verificamos que se rechacen valores erroneos al actualizar
	 @Test
	    void testInvalidUpdatesAreRejected() {

	        Contact contact = new Contact(
	                "123",
	                "Bastian",
	                "Garcia",
	                "1234567890",
	                "Temuco Chile"
	        );

	        assertAll(
	            () -> assertThrows(IllegalArgumentException.class, () ->
	                contact.setFirstName(null)),

	            () -> assertThrows(IllegalArgumentException.class, () ->
	                contact.setLastName("VeryLongLastName")),

	            () -> assertThrows(IllegalArgumentException.class, () ->
	                contact.setPhone("12345")),

	            () -> assertThrows(IllegalArgumentException.class, () ->
	                contact.setAddress("Esta direccion es mas larga que treinta caracteres"))
	        );
	    }
}

