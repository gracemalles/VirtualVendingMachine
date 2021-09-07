package com.techelevator;

import com.techelevator.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVLoader {

    private List<Products> productList = new ArrayList<>();

    public CSVLoader() {
        stocking();
    }

    public List<Products> getProductList() {
        return productList;
    }

    public void stocking() {
        Scanner scanner = new Scanner(System.in);
        File vendingMachineFile = new File("vendingmachine.csv");
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(vendingMachineFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (fileScanner.hasNextLine()) {
            String item = fileScanner.nextLine();
            String[] vendingMachineItems = item.split("\\|");
            String code = vendingMachineItems[0];//
            String name = vendingMachineItems[1];
            BigDecimal price = new BigDecimal(vendingMachineItems[2]);
            String type = vendingMachineItems[3];
            if (type.equals("Chip")) {
                Products product = new Chips(code, name, price, type);
                productList.add(product);
            } else if (type.equals("Candy")) {
                Products product = new Candy(code, name, price, type);
                productList.add(product);
            } else if (type.equals("Drink")) {
                Products product = new Drink(code, name, price, type);
                productList.add(product);
            } else if (type.equals("Gum")) {
                Products product = new Gum(code, name, price, type);
                productList.add(product);
            }
        }
    }
}


// switch statement for each type
    // if this type then display options
// list for each type