package Functions;

import Data.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Verification {
    private String tableno  ;
    public String getTableno() {
        return tableno;
    }
    private String namer ;
    public String getNamer() { return namer; }

    public Restaurant load() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Restaurant restaurant = (Restaurant) unmarshaller.unmarshal(new File("input.xml"));
        return restaurant;
    } // Loads File But Need Catch .

    public Restaurant save2(String X , String Y , String Z ) throws JAXBException {
        Restaurant rest = load();
        List<User> users = rest.getUsers().getUsers();
        List<Table> tables = rest.getTables().getTables();
        List<Dish> dishes = rest.getDishes().getDishes();
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        Restaurant usersNew = new Restaurant();
        Users users1 = new Users();
        Tables tables1 = new Tables();
        Dishes dishes1 = new Dishes();
        User user = new User();
        user.setName(X);
        user.setUsername(Y);
        user.setPassword(Z);
        user.setRole("Client");
        users.add(user);
        users1.setUsers(users);
        tables1.setTables(tables);
        dishes1.setDishes(dishes);
        usersNew.setUsers(users1);
        usersNew.setTables(tables1);
        usersNew.setDishes(dishes1);
        marshaller.marshal(usersNew,new File("input.xml"));
        return usersNew;
    }

    public Restaurant save(String X, String Y, String tim, double Z, int salade, int fries, int grilled, int beef, int soup, int molten, int apple) throws JAXBException  {

        if ( new File("save.xml" ) != null ){
            Restaurant rest = load2();
            List<ReservedTables> reservedTablesList = rest.getTables().getReservedTables();
            JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            Restaurant savedRestaurant = new Restaurant();
            Tables tables = new Tables();
            ReservedTables reservedTables = new ReservedTables();
            reservedTables.setName(X);
            reservedTables.setNumber(Y);
            reservedTables.setReserved("Yes");
            reservedTables.setTime(tim);
            reservedTables.setPaid(Z);
            reservedTables.setSalade(salade);
            reservedTables.setFries(fries);
            reservedTables.setGrilled(grilled);
            reservedTables.setBeef(beef);
            reservedTables.setSoup(soup);
            reservedTables.setMolten(molten);
            reservedTables.setApple(apple);
            reservedTablesList.add(reservedTables);
            tables.setReservedTables(reservedTablesList);
            savedRestaurant.setTables(tables);
            marshaller.marshal(savedRestaurant,new File("save.xml"));
            return  savedRestaurant ;
        }else
        {
            List<ReservedTables> rest = new ArrayList<>();
            JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            Restaurant savedRestaurant = new Restaurant();
            Tables tables = new Tables();
            ReservedTables reservedTables = new ReservedTables();
            reservedTables.setName(X);
            reservedTables.setNumber(Y);
            reservedTables.setReserved("Yes");
            reservedTables.setTime(tim);
            reservedTables.setPaid(Z);
            reservedTables.setSalade(salade);
            reservedTables.setFries(fries);
            reservedTables.setGrilled(grilled);
            reservedTables.setBeef(beef);
            reservedTables.setSoup(soup);
            reservedTables.setMolten(molten);
            reservedTables.setApple(apple);
            rest.add(reservedTables);
            tables.setReservedTables(rest);
            savedRestaurant.setTables(tables);
            marshaller.marshal(savedRestaurant,new File("save.xml"));
            return savedRestaurant;
         }
    }

    public String verify(String User, String Pass) throws JAXBException {
        Restaurant restaurant = load();
        String role = "Empty";
        List<Data.User> users = restaurant.getUsers().getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(User) && users.get(i).getPassword().equals(Pass)) {
                role = users.get(i).getRole();
                namer=users.get(i).getName();
                break;
            }
        }
        return role;
    }//Validates Username And Password .

    public Restaurant load2() throws JAXBException{
        Restaurant restaurant = null ;
        if (new File("save.xml" ) != null ){
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        restaurant = (Restaurant) unmarshaller.unmarshal(new File("save.xml"));}
        return restaurant;
    } // Loads File But Need Catch .

    public void scannerexample() throws FileNotFoundException {
        File text = new File ("save.xml");
        Scanner scnr = new Scanner(text);
        int Line =1 ;
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            System.out.println("Line" + Line + line);
            Line++;
        }
    }
    public String checkTable(String Table, String Seats, String tim) throws JAXBException{
        Restaurant restaurant = load();
        Restaurant savedRestaurant = load2();
        String table = "Not Available";
        List<Table> tables = restaurant.getTables().getTables();
        Collections.sort(tables);
        List<ReservedTables> tables1 = savedRestaurant.getTables().getReservedTables();

        for (int i = 0; i < tables.size(); i++){
            if ( tables.get(i).getSmoking().equals(Table) && tables.get(i).getNumber_of_seats()  >= Integer.parseInt(Seats) )
            {
                table = tables.get(i).getNumber();
                tableno = tables.get(i).getNumber();
                for (int j=0 ; j<tables1.size() ; j++)
                {
                 if (tables1.get(j).getNumber().equals(table) && tables1.get(j).getTime().equals(tim)  )
                 // might remove if error
                 {
                     table = "Not Available";
                     break;
                 }
                }
            }
            if (table != "Not Available")
            {
                break;
            }

        }
        return table;
    }//Checks for available tables  .

}