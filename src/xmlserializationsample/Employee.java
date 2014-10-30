/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlserializationsample;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author c0587637
 */
@Root
public class Employee {

    @Element
    private String name;
    @Element
    private String phone;
    @Element
    private String email;

    public Employee() {
    }

    public Employee(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toJSON() {
        return String.format("{ \"name\" : \"%s\",\n"
                + "  \"phone\" : \"%s\",\n"
                + "  \"email\" : \"%s\" }", name, phone, email);
        
    }

}
