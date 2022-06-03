import java.util.Locale;
import java.util.Scanner;

public class Logic {
    public static void start() {
        chooseAndCalculatePropertyType();
    }

    private static void chooseAndCalculatePropertyType() {
        System.out.println("Choose property type:");
        System.out.println("(Residential Properties - R, Commercial real estate - C , Industrial real estate - I)");
        choosingTypeOfProperty();
    }

    private static void choosingTypeOfProperty() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String n = in.nextLine().toLowerCase(Locale.ROOT);
            switch (n) {
                case "r" -> calculateResidentialTax();
                case "c" -> calculateCommercialTax();
                case "i" -> calculateIndustrialTax();
                default -> System.out.println("Incorrect input. Try again.");
            }
        }
    }

    private static void calculateIndustrialTax() {
        System.out.println("Enter the total Surface of the Industrial Property");
        Scanner in = new Scanner(System.in);
        double S = in.nextDouble();
        System.out.println("Enter the tax for 1m^2 ($):");
        double T = in.nextDouble();
        double D = 0;

        Property industrialP = new Property(S, "Industrial Real Estate");
        calculateTax(T, D, industrialP);
    }

    private static void calculateCommercialTax() {
        System.out.println("Enter the total Surface of the Commercial Property");
        Scanner in = new Scanner(System.in);
        double S = in.nextDouble();
        System.out.println("Enter the tax for 1m^2 ($):");
        double T = in.nextDouble();
        System.out.println("Enter the amount of annual commercial income($): ");
        double I = ((in.nextDouble()) / 365) * (1 / S);
        if (I < 100) {
            System.out.println("Total income for 1 m^2 is less then 100$/day (" + I + ")");
            System.out.println("There will be no taxes.\n");
        }
        double D = 0;

        Property commercialP = new Property(S, "Commercial Real Estate");
        calculateTax(T, D, commercialP);
    }

    private static void calculateResidentialTax() {
        System.out.println("Enter the total Surface of the Residential Property");
        Scanner in = new Scanner(System.in);
        double S = in.nextDouble();
        System.out.println("Enter the tax for 1m^2 ($):");
        double T = in.nextDouble();
        System.out.println("Is there any real estate owner's subsidies?(Or enter 0 to continue)");
        double D = in.nextDouble();


        Property residentialP = new Property(S, "Residential Property");
        calculateTax(T, D, residentialP);
    }

    private static void calculateTax(double T, double D, Property property) {
        System.out.println("Total taxes for your property will be: ");
        double totalTax = property.getSurface() * T - property.getSurface() * T * D * 0.01;
        System.out.println(property.getSurface() + " * " + T + " - " + property.getSurface() + " * " + T + " * " + D + " * " + 0.01 + " = " + totalTax + "($)");
        System.exit(0);
    }


}
