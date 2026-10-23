package com.pruebaDinamica.mod3;

// Representamos cada contacto
public class Contact {
	
	// final porque id no puede ser actualizado despues de crearse
	private final String contactId;
	private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    // Constructor de nuevo contacto con campos validados
    public Contact(String contactId, String firstName, String lastName,
            String phone, String address) {

	 validateContactId(contactId);
	 validateFirstName(firstName);
	 validateLastName(lastName);
	 validatePhone(phone);
	 validateAddress(address);
	
	 this.contactId = contactId;
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.phone = phone;
	 this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    
    // Setters para campos actualizables
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }
    
    // Metodos para la validacion de datos
    
    // id no null y menor o igual a 10 caracteres
    private void validateContactId(String contactId) {
    	if (contactId == null || contactId.length() > 10) {
    		throw new IllegalArgumentException("El ID no puede ser NULL o mas largo de 10 caracteres.");
    	}
    }
    
    // nombre
    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("El nombre no puede ser NULL o mas largo de 10 caracteres.");
        }
    }
    
    // apellido
    private void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("El apellido no puede ser NULL o mas largo de 10 caracteres.");
        }
    }
    
    // largo de numero
    private void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El numero de telefono debe tener 10 digitos.");
        }
    }
    
    // direccion hasta 30 caracteres
    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("La direccion no puede ser NULL o mas largo de 30 caracteres.");
        }
    }
}
