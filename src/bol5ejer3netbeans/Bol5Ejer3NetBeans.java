package bol5ejer3netbeans;

import java.util.Scanner;

public class Bol5Ejer3NetBeans {

    public static char letraDni(String dni) throws Exception {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (dni.length() == 8) {
            for (int i = 0; i < 8; i++) {
                if (dni.charAt(i) < '0' || dni.charAt(i) > '9') {
                    throw new Exception("Dni no válido, solo puede contener numeros o separacion de millares");
                }
            }
        } else if (dni.length() == 10) {
            for (int i = 0; i < 10; i++) {
                if (dni.charAt(i) < '0' || dni.charAt(i) > '9') {
                    if (i == 6 || i == 2) {
                        if (dni.charAt(2) == '.' && dni.charAt(6) == '.') {
                            dni = dni.replace(".", "");
                            return letras.charAt(Integer.parseInt(dni) % 23);
                        } else {
                            throw new Exception(
                                    "Dni no válido, solo puede contener numeros o separacion de millares");
                        }
                    } else {
                        throw new Exception(
                                "Dni no válido, solo puede contener numeros o separacion de millares");
                    }
                }
            }
            throw new Exception(
                    "Dni demasiado largo");
        } else {
            throw new Exception("dni demasiado largo o demasiado corto");
        }
        return letras.charAt(Integer.parseInt(dni) % 23);
    }

    public static void main(String[] args) {
        char letra = '.', letraC = '.';
        int opcion;
        boolean error;
        String dni;
        Scanner sc = new Scanner(System.in);
        do {
            System.out
                    .println("Introduce opcion:\n" + "1- Obtener letra del DNI\n" + "2- Comprobar DNI\n" + "3- Salir");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    do {
                        error = false;
                        System.out.println("Introduce dni");
                        dni = sc.nextLine();
                        try {
                            letra = letraDni(dni);
                        } catch (Exception e) {
                            System.out.println(e);
                            error = true;
                        }
                    } while (error);
                    System.out.printf("La letra del DNI es %s, quedando el DNI asi: %s\n\n", letra, dni + letra);
                    break;
                case 2:
                    do {
                        error = false;
                        System.out.println("introduzca DNI con letra");
                        dni = sc.nextLine();
                        try {
                            letraC = letraDni(dni.substring(0, dni.length() - 1));
                        } catch (Exception e) {
                            System.out.println(e);
                            error = true;
                        }
                    } while (error);
                    letra = dni.toUpperCase().charAt(dni.length() - 1);
                    if (letra == letraC) {
                        System.out.println("El DNI existe");
                    } else {
                        System.out.println("El DNI es incorrecto");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 3);
    }

}
