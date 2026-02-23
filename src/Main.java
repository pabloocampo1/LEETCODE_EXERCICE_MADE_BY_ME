import Exercice.*;

import javax.lang.model.element.Name;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        Gym gym = new Gym(new CustomerValidator(), new CustomerRepository());

        MembershipByMonth membershipByMonth = new MembershipByMonth( 34 ,List.of("Asignando Rutina Estándar"));
        MembershipByYear membershipByYear = new MembershipByYear( 400 ,List.of("Asignando Rutina VIP con Entrenador Personal"));


        Customer customer1 = new Customer("juan carlos", "carlito@email.com"); // error para el usuario
        Customer customer2 = new Customer("Juan pablo ocampo", "juan@gmail.com");

        gym.registerCustomer(customer1, membershipByMonth);
        gym.registerCustomer(customer2, membershipByYear);
    }
}




// without clen code
//public class Gym {
//    // Método que hace de todo
//    public void reg(String n, String e, int t, double p) {
//        // 1. Validar nombre
//        if (n.equals("")) {
//            System.out.println("Error: nombre vacío");
//            return;
//        }
//
//        // 2. Validar email
//        if (!e.contains("@")) {
//            System.out.println("Email fail");
//            return;
//        }
//
//        // 3. Calcular precio según tipo (1: Mensual, 2: Anual)
//        double total = 0;
//        if (t == 1) {
//            total = p;
//        } else if (t == 2) {
//            total = (p * 12) * 0.80; // 20% descuento por año
//        }
//
//        // 4. Imprimir recibo
//        System.out.println("Cliente: " + n);
//        System.out.println("Total a pagar: " + total);
//
//        // 5. Guardar en "Base de datos"
//        System.out.println("Guardando en DB a " + n);
//
//        // 6. Asignar rutina según objetivo
//        if (total > 500) {
//            System.out.println("Asignando Rutina VIP con Entrenador Personal");
//        } else {
//            System.out.println("Asignando Rutina Estándar");
//        }
//    }
//}




//  VS




// WITH CLEAN CODE APPLY


class Gym {

    private final CustomerValidator  customerValidator;
    private final CustomerRepository customerRepository;

    Gym(CustomerValidator customerValidator, CustomerRepository customerRepository) {
        this.customerValidator = customerValidator;
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(Customer customer, Membership membership) {

        this.customerValidator.validateName(customer.getName());
        this.customerValidator.validateEmail(customer.getEmail());


        // 3. Calcular precio según tipo (1: Mensual, 2: Anual)
        double totalPrice = membership.calculatePrice();

        // 4. Imprimir recibo
        this.printReceipt(customer, totalPrice);

        // 5. Guardar en "Base de datos"
        this.customerRepository.save(customer);

        // 6. Asignar rutina según objetivo
       membership.getRoutine();
    }

    public void printReceipt(Customer customer, double totalPrice){
        customer.getInformation();
        System.out.println("Total a pagar: " + totalPrice);
    }
}

class Customer{
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void getInformation () {
        System.out.println("Nombre completo: " + this.name);
        System.out.println("Email : "+ this.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class CustomerValidator{



    public void validateName(String name){
        if (name.equals("") || name.isEmpty()) throw new IllegalArgumentException("Nombre no valido.");
    }

    public void validateEmail(String email){
        if (!email.contains("@")) throw new IllegalArgumentException("Email no valido");
    }
}

class CustomerRepository{

    public void save(Customer customer){
        System.out.println("Guardando cliente en la base de datos mysql.....");
    }
}


 abstract class Membership{

     private List<String> routine;

     public Membership( List<String> routine) {
         this.routine = routine;
     }

     public abstract Double calculatePrice();

     public  void getRoutine() {
         System.out.println("Rutinas asignadas de la membresia ");
         for (String routine : routine) {
             System.out.println(routine);
         }
     }
}

class MembershipByMonth extends Membership{
    // cada membresia o plan tendra su propio precio
    private double price;

    public MembershipByMonth( double price,List<String> routine) {
        super(routine);
        this.price = price;
    }

    @Override
    public Double calculatePrice() {
        return this.price;
    }


}

class MembershipByYear extends Membership{
    private final double DISCOUNT = 0.80;
    private double price;

    public MembershipByYear(double price, List<String> routine) {
        super(routine) ;
        this.price = price;
    }


    @Override
    public Double calculatePrice() {
        return price * DISCOUNT;
    }

}
