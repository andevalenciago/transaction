package com.tns.analizer;

import com.sun.rowset.internal.Row;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


import javafx.scene.control.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BankTransactionAnalyzerSimple {

    private static final String FILE = "src/test/resources/transactions.csv";
    public static final String SEPARATOR="," ;
    public static final String SEPARATOR2="-" ;
    public static final String QUOTE="\"";
    BufferedReader br = null;
    public int suma = 0;
    public String m;
    public String c;
    public int suma3= 0;
    public int suma2=0;
    public int mes;
    public String s;


    
    public  void extrae(){

    }
    public int obtenerMes(Date date){

        if (null == date){

            return 0;

        }
        else{

            String formato="MM";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return  Integer.parseInt(dateFormat.format(date));

        }

    }


    public void execute() {
            try {

                br =new BufferedReader(new FileReader(FILE));
                String line = br.readLine();
                Integer min = null;
                
                while (null!=line) {
                    String[] fields = line.split(SEPARATOR);
                    int y = Integer.parseInt(fields[1]);
                    if(min == null){
                        min = y;
                    }
                    suma = suma + y;
                    m = fields[0];
                    c = fields[2];

                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    Date fechaDate = null;
                    fechaDate = formato.parse(m);
                    mes = obtenerMes(fechaDate);

                    if (mes == 1) {
                        suma2 += y;
                    }

                    if (y<min) {
                        min = y;
                        s = fields[2];
                    }


                    line = br.readLine();
                }
                    System.out.println("Monto total de enero: $" + suma2);

                    System.out.println("la categoria con mayor gasto es "+ s+ " con un gasto igual " + min);

                    if (suma >= 0) {
                        System.out.println("El monto de la cuenta es positivo: $" + suma);
                    } else {
                        System.out.println("El monto de la cuenta es negativo: $" + suma);
                    }



        }catch (Exception e) {
                System.out.println("Error...");
                System.out.println(e.getMessage());
            }

        }

    }








