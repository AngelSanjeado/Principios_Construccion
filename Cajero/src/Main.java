import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ===== OBJETOS BASE =====
        Usuario usuario = new Usuario(
                "Omar", "Sanjeado",
                "Av. Lerdo de Tejada",
                "9212027204",
                "omar@gmail.com"
        );

        Cuenta cuenta1 = new Cuenta("123456789", usuario, TipoCuenta.CORRIENTE, 20000);
        Cuenta cuenta2 = new Cuenta("987654321", usuario, TipoCuenta.AHORRO, 15000);

        Tarjeta tarjeta1 = new Tarjeta("1234123412341234", "08/27", "123", "3080");

        CuentaTarjeta.asociarCuentaTarjeta(tarjeta1, cuenta1);
        CuentaTarjeta.asociarCuentaTarjeta(tarjeta1, cuenta2);

        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);

        int opcionPrincipal;

        // ===== MENÚ PRINCIPAL =====
        do {
            System.out.println("\n===== ATM SANMAR =====");
            System.out.println("1. Con tarjeta");
            System.out.println("2. Sin tarjeta");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    menuConTarjeta(sc, atm, tarjeta1, cuenta1, usuario);
                    break;
                case 2:
                    menuSinTarjeta(sc, atm);
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcionPrincipal != 0);
    }

    // ===== MENÚ CON TARJETA =====
    static void menuConTarjeta(
            Scanner sc,
            ATM atm,
            Tarjeta tarjeta,
            Cuenta cuenta,
            Usuario usuario) {

        System.out.print("Ingrese NIP: ");
        String nip = sc.next();

        if (!atm.validarNIP(tarjeta, nip)) {
            System.out.println("NIP incorrecto");
            return;
        }

        int opcion;

        do {
            System.out.println("\n--- MENÚ CON TARJETA ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Pagar servicio");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Monto a depositar: ");
                    double dep = sc.nextDouble();
                    atm.depositar(cuenta, dep, tarjeta.getNoTarjeta());
                    break;

                case 2:
                    System.out.print("Monto a retirar: ");
                    double ret = sc.nextDouble();
                    atm.retirar(cuenta, ret, tarjeta.getNoTarjeta());
                    break;

                case 3:
                    menuServiciosTarjeta(sc, atm, cuenta, tarjeta, usuario);
                    break;

                case 0:
                    System.out.println("Regresando...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

    // ===== MENÚ SERVICIOS CON TARJETA =====
    static void menuServiciosTarjeta(
            Scanner sc,
            ATM atm,
            Cuenta cuenta,
            Tarjeta tarjeta,
            Usuario usuario) {

        System.out.println("\n--- SERVICIOS ---");
        System.out.println("1. Luz");
        System.out.println("2. Agua");
        System.out.println("3. Internet");
        System.out.print("Opción: ");
        int op = sc.nextInt();

        TipoServicio tipo = TipoServicio.getTipoServicio(op - 1);

        System.out.print("Línea de captura: ");
        String linea = sc.next();

        System.out.print("Monto: ");
        double monto = sc.nextDouble();

        Servicio servicio = new Servicio(tipo, linea, monto);

        atm.pagarServicioTarjeta(
                cuenta,
                servicio,
                linea,
                tarjeta.getNoTarjeta(),
                usuario
        );
    }

    // ===== MENÚ SIN TARJETA =====
    static void menuSinTarjeta(Scanner sc, ATM atm) {

        System.out.println("\n--- PAGO DE SERVICIO SIN TARJETA ---");
        System.out.println("1. Luz");
        System.out.println("2. Agua");
        System.out.println("3. Internet");
        System.out.print("Opción: ");
        int op = sc.nextInt();

        TipoServicio tipo = TipoServicio.getTipoServicio(op - 1);

        System.out.print("Línea de captura: ");
        String linea = sc.next();

        System.out.print("Monto del servicio: ");
        double base = sc.nextDouble();

        Servicio servicio = new Servicio(tipo, linea, base);

        System.out.print("Monto ingresado: ");
        double efectivo = sc.nextDouble();

        atm.pagarServicioEfectivo(servicio, linea, efectivo);
    }
}