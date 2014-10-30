/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlserializationsample;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author c0587637
 */
public class XMLSerializationSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Build a Serializer and use it to Read the XML File
        Serializer s = new Persister();
        List<Employee> employees = null;
        File file = new File("employees.xml");
        try {
            employees = s.read(Employees.class, file).getEmployees();
            // Now that the XML File is Loaded, Sort them Alphabetically by Name
            employees.sort(AToZByName);

            // Output the List of Employees as a JSON Array
            System.out.println("[");
            int i;
            for (i = 0; i < employees.size() - 1; i++) {
                System.out.println(employees.get(i).toJSON() + ",");
            }
            // Print out the last one without a comma at the end
            System.out.println(employees.get(i).toJSON());
            System.out.println("]");
        } catch (Exception ex) {
            Logger.getLogger(XMLSerializationSample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static Comparator<Employee> AToZByName = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (o1.getName().compareTo(o2.getName()));
        }
    };

}
