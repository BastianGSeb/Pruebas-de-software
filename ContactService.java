package com.pruebaDinamica.mod3;

// Utilizamos hashmap para agregar, buscar, eliminar y actualizar contactos por identificador.
import java.util.HashMap;
import java.util.Map;

public class ContactService {

	// Almacenamos contactos en memoria usando ID como llave
	private final Map<String, Contact> contacts;
	
	// Inicializamos
	public ContactService() {
		contacts = new HashMap<>();
	}
	
	// Nuevo contacto unico
	public void addContact(Contact contact) {
		
		// Prevenimos null
		if (contact == null) {
			throw new IllegalArgumentException("El contacto no puede ser NULL.");
		}
		
		// Prevenimos copias usando .containskey
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("El ID del contacto ya existe.");
		}
		
		contacts.put(contact.getContactId(), contact);
	}
	
    // borramos contacto con ID
    public void deleteContact(String contactId) {

        // Primero se verifica si existe
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("El ID del contacto no fue encontrado.");
        }

        contacts.remove(contactId);
    }
    
    // Actualizamos nombre
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getExistingContact(contactId);
        contact.setFirstName(firstName);
    }

    // Actualizamos apellido
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getExistingContact(contactId);
        contact.setLastName(lastName);
    }

    // Actualizamos numero
    public void updatePhone(String contactId, String phone) {
        Contact contact = getExistingContact(contactId);
        contact.setPhone(phone);
    }

    // Actualizamos direccion
    public void updateAddress(String contactId, String address) {
        Contact contact = getExistingContact(contactId);
        contact.setAddress(address);
    }
    
    // Retorna contacto o null si id no existe
    public Contact getContact(String contactId) {
    	return contacts.get(contactId);
    }
    
    // Metodo auxiliar para los metodos de actualizacion
    private Contact getExistingContact(String contactId) {
    	Contact contact = contacts.get(contactId);
    	
    	// Excepcion en caso de no encontrar nada
    	if (contact == null) {
    		throw new IllegalArgumentException("No se ha encontrado el ID del contacto.");
    	}
    	
    	return contact;
    }
}

