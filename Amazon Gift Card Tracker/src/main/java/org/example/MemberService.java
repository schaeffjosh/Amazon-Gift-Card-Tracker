package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class MemberService {

    public Map<String, Person> getFamilyList() throws FileNotFoundException {
        Map<String, Person> family = new HashMap();

        File familyFile = new File("C:\\Users\\Student\\workspace\\Amazon Gift Card Tracker\\src\\main\\resources\\Family");

        if (!familyFile.exists()){
            throw new FileNotFoundException(familyFile + " doesn't exist");
        } else if(!familyFile.isFile()){
            throw new FileNotFoundException(familyFile + " is not a file");
        }

        try(Scanner scanner = new Scanner(familyFile)){
            while(scanner.hasNextLine()){
                String[] arr = scanner.next().split(",");

                Person person = new Person(arr[0], Integer.parseInt(arr[1]), BigDecimal.valueOf(Double.parseDouble(arr[2])));

                family.put(person.getName(), person);
            }
        } catch(FileNotFoundException e){
            throw new FileNotFoundException("File not found");
        }
        return family;
    }

    public void recordChanges(Map<String, Person> family) throws FileNotFoundException {
        File familyFile = new File("C:\\Users\\Student\\workspace\\Amazon Gift Card Tracker\\src\\main\\resources\\Family");

        if (!familyFile.exists()){
            throw new FileNotFoundException(familyFile + " doesn't exist");
        } else if(!familyFile.isFile()){
            throw new FileNotFoundException(familyFile + " is not a file");
        }

        try(PrintWriter writer = new PrintWriter(familyFile)){
            for (int i = 0; i <= family.size(); i++) {
                for(Map.Entry<String, Person> entry : family.entrySet()) {
                    if(entry.getValue().getId() == i) {
                        Person p = entry.getValue();
                        writer.println();
                        writer.print(p.getName() + "," + p.getId() + "," + p.getGcBalance());
                    }
                }
            }
        } catch(FileNotFoundException e){
            throw new FileNotFoundException("File not found");
        }
    }


}
