/*
* File: Solution.java
* Author: Vámosi László Ádám
* Copyright: 2025, Vámosi László Ádám
* Group: I-N
* Date: 2025-03-10
* GitHub: https://github.com/vamosilaszloadam/
* Licenc: MIT
*/

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Solution {

    public static void startSolution() {
        ArrayList<Employee> empList = Store.readFile();
        // System.out.println(empList.get(1).getName());
        task01(empList);
        task02(empList);
        task03(empList);
    }
    public static void task01(ArrayList<Employee> empList) {
        try {
            tryTask01(empList);
        } catch (IOException e) {
            System.err.println("Hiba! A fájl nem írható!");
            System.err.println(e.getMessage());
        }
    }
    //writeHatvanSzolnok()
    public static void tryTask01(ArrayList<Employee> empList) throws IOException {
        System.out.println("Hatvani és szolnoki névsor fájlba...");
        FileWriter writer = new FileWriter("hatszol.txt", Charset.forName("utf8"));
        for(Employee emp : empList ) {
            if(
                emp.getCity().equals("Hatvan")
                || emp.getCity().equals("Szolnok")
                
            ) {
            }
            writer.write(emp.getName());
            writer.write("\n");
        }
        writer.close();
    }
    public static void task02(ArrayList<Employee> empList) {
        int hatvaniDarab = 0;
        double hatvaniOsszeg = 0;
        int szolnokiDarab = 0;
        double szolnokiOsszeg = 0;
        for(Employee emp : empList ) {
            if(emp.getCity().equals("Hatvan")) {
                hatvaniDarab++;
                hatvaniOsszeg += emp.getSalary();
            }
            if(emp.getCity().equals("Szolnok")) {
                szolnokiDarab++;
                szolnokiOsszeg += emp.getSalary();
            }
        }
        double hatvaniAtlag = hatvaniOsszeg / hatvaniDarab;
        double szolnokiAtlag = szolnokiOsszeg / szolnokiDarab;
        System.out.printf("Hatvani átlag: %.2f\nSzolnoki átlag: %.2f\n", hatvaniAtlag, szolnokiAtlag);
    }
    public static void task03(ArrayList<Employee> empList) {
        
        boolean elsoHatvani = false;
        boolean elsoSzolnoki = false;

        Employee hatvaniMax = null;
        Employee szolnokiMax = null;
        Employee hatvaniMin = null;
        Employee szolnokiMin = null;

        
        for(Employee emp : empList ) {
            if(emp.getCity().equals("Hatvan")) {
                if(!elsoHatvani) {
                    hatvaniMax = emp;
                    hatvaniMin = emp;
                    elsoHatvani = true;
                }
                if(emp.getBirth().isAfter(hatvaniMax.getBirth())) {
                    hatvaniMax = emp;
                }
                if(emp.getBirth().isBefore(hatvaniMin.getBirth())) {
                    hatvaniMin = emp;
                }
            }
            if(emp.getCity().equals("Szolnok")) {
                if(!elsoSzolnoki) {
                    szolnokiMax = emp;
                    szolnokiMin = emp;
                    elsoSzolnoki = true;
                }
                if(emp.getBirth().isAfter(szolnokiMax.getBirth())) {
                    szolnokiMax = emp;
                }
                if(emp.getBirth().isBefore(szolnokiMin.getBirth())) {
                    szolnokiMin = emp;
                }
            }
        }
        System.out.println("Hatvani");
        System.out.println("Legfiatalabb: " + hatvaniMax.getName());
        System.out.println("Legidősebb: " + hatvaniMin.getName());
        System.out.println("Szolnoki");
        System.out.println("Legfiatalabb: " + szolnokiMax.getName());
        System.out.println("Legidősebb: " + szolnokiMin.getName());

    }
}
