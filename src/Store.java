/*
* File: Store.java
* Author: Vámosi László Ádám
* Copyright: 2025, Vámosi László Ádám
* Group: I-N
* Date: 2025-03-10
* GitHub: https://github.com/vamosilaszloadam/
* Licenc: MIT
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    public static ArrayList<Employee> readFile() {
        try {
            return tryReadFile();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található!");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<Employee> tryReadFile() throws FileNotFoundException {
        ArrayList<Employee> empList = new ArrayList<>();
        File file = new File("kontenerkft.txt");
        try(Scanner sc = new Scanner(file, "utf8")){
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                // System.out.println(line);
                String[] lineArray = line.split("#");
                Employee emp = new Employee();
                emp.setName(lineArray[0]);
                emp.setCity(lineArray[1]);
                emp.setAddress(lineArray[2]);
                String[] birthArray = lineArray[3].split("-");
                int year = Integer.parseInt(birthArray[0]);
                int month = Integer.parseInt(birthArray[1]);
                int day = Integer.parseInt(birthArray[2]);
                // emp.setBirth(LocalDate.parse(lineArray[3]));
                // new LocalDate()
                emp.setBirth(LocalDate.of(year, month, day));
                // System.out.println(year+" "+month+" "+day);
                // System.out.println(emp.getBirth());
                emp.setSalary(Double.parseDouble(lineArray[4]));
                empList.add(emp);
            }
        }
        return empList;
    }
}
