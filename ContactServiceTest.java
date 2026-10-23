package com.pruebaDinamica.mod3;

// crear un servicio y contacto nuevos antes de cada prueba con beforeeach
// cada prueba JUnit es independiente y el resultado de una no altera las demas
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	private ContactService contactService;
	private Contact contact;
	
	// Testeo usando beforeeach para que sean independientes unos de otro
	@BeforeEach
	void setUp() {
		
		contactService = new ContactService();
		
		contact = new Contact(
                "1234567890",
                "Bastian",
                "Garcia",
                "1234567890",
                "Temuco Chile"
        );
	}
	
	// verificamos adicion y getter usando ID
	@Test
	void testAddContact() {

        contactService.addContact(contact);

        Contact storedContact = contactService.getContact("1234567890");

        assertNotNull(storedContact);
        assertEquals("Bastian", storedContact.getFirstName());
        assertEquals("Garcia", storedContact.getLastName());
    }
	
	// Verificamos que no se use el mismo ID
	@Test
    void testCannotAddDuplicateContactId() {

        contactService.addContact(contact);

        Contact duplicateContact = new Contact(
                "1234567890",
                "Juan",
                "Perez",
                "0987654321",
                "Santiago Chile"
        );

        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(duplicateContact));
    }
	
	// verificamos que un contacto null no se pueda agregar
    @Test
    void testCannotAddNullContact() {

        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(null));
    }
    
    // verificamos que podemos eliminar usando ID
    @Test
    void testDeleteContact() {

        contactService.addContact(contact);

        contactService.deleteContact("1234567890");

        assertNull(
                contactService.getContact("1234567890")
        );
    }
	
	// Verificamos que no podemos eliminar un contacto inexistente
    @Test
    void testDeleteNonExistingContact() {

        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("999"));
    }
    
    
    
    // Verificamos actualizaciones con campos correctos para cada campo
    @Test
    void testUpdateFirstName() {

        contactService.addContact(contact);

        contactService.updateFirstName(
                "1234567890",
                "Sebastian"
        );

        assertEquals("Sebastian", contactService.getContact("1234567890").getFirstName());
    }

    @Test
    void testUpdateLastName() {

        contactService.addContact(contact);

        contactService.updateLastName(
                "1234567890",
                "Perez"
        );

        assertEquals("Perez", contactService.getContact("1234567890").getLastName());
    }

    @Test
    void testUpdatePhone() {

        contactService.addContact(contact);

        contactService.updatePhone(
                "1234567890",
                "0987654321"
        );

        assertEquals("0987654321", contactService.getContact("1234567890").getPhone());
    }

    @Test
    void testUpdateAddress() {

        contactService.addContact(contact);

        contactService.updateAddress(
                "1234567890",
                "Santiago Chile"
        );

        assertEquals("Santiago Chile", contactService.getContact("1234567890").getAddress());
    }
    
    // Verificamos existencia de contacto antes de actualizar
    @Test
    void testCannotUpdateNonExistingContact() {

        assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("999", "Sebastian"));
    }
    
    
    
    // Verificamos el rechazo de cada campo al ingresar campos invalidos
    
    @Test
    void testCannotUpdateWithInvalidFirstName() {

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("1234567890", "VeryLongName"));
    }

    @Test
    void testCannotUpdateWithInvalidLastName() {

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> contactService.updateLastName("1234567890","VeryLongLastName"));
    }

    @Test
    void testCannotUpdateWithInvalidPhone() {

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("1234567890", "12345"));
    }

    @Test
    void testCannotUpdateWithInvalidAddress() {

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> contactService.updateAddress("1234567890", "Esta direccion es mas larga que treinta caracteres"));
    }
    
}

