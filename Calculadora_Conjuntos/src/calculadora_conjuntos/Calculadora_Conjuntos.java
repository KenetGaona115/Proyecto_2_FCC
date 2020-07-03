package calculadora_conjuntos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldrin Kenet Gaona Montes
 */
public class Calculadora_Conjuntos {

    /**
     * @param args the command line arguments
     */
    static List<String> Universo = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = -1;
        String Conjunto_1 = "";
        String Conjunto_2 = "";

        //Leemos o generamos los conjuntos
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "GENERAR CONJUTOS ALEATORIOS >>1\n"
                + "INTRODUCIR A MANO >>2"));
        if (opcion == 1) {
            int a = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el tamaño del conjunto A\n"));
            for (int i = 0; i < a; i++) {
                int b = (int) Math.floor(Math.random() * 101 + 1);
                Conjunto_1 += "" + b + ",";
            }

            int c = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el tamaño del conjunto B\n"));
            for (int i = 0; i < c; i++) {
                int b = (int) Math.floor(Math.random() * 101 + 1);
                Conjunto_2 += "" + b + ",";
            }

        } else {
            Conjunto_1 =JOptionPane.showInputDialog(null, "ingrese el conjunto A\n");
            Conjunto_2 =JOptionPane.showInputDialog(null, "ingrese el conjunto B\n");
        }

        //Convertimos a lista para manejarlo de una manera mas facil
        String str[] = Conjunto_1.split(",");
        String str_2[] = Conjunto_2.split(",");
        List<String> A = new ArrayList<>();
        A = Arrays.asList(str);
        List<String> B = new ArrayList<>();
        B = Arrays.asList(str_2);
        
        //IMPRECION DE LOS CONJUNTOS
        System.out.println("Conjunto A");
        PrintResult(A);
        System.out.println("Conjunto B");
        PrintResult(B);
        
        //LLAMAMOS A LAS OPERACIONES
        System.out.println("universo");
        GetUniverse();
        Interseccion(A, B);
        Union(A, B);
       
        System.out.println("Diferencia A-B");
        DiferenciaA(A, B);

        System.out.println("Diferencia B-A");
        DiferenciaB(B, A);

        System.out.println("Diferencia simetrica");
        DiferenciaSimetrica(A, B);

        System.out.println("Complemento A");
        Complemento(A);

        System.out.println("Complemento B");
        Complemento(B);

        System.out.println("Producto carteciano AxB");
        PrintResult(ProductoCarteciano(A, B));

        System.out.println("Producto carteciano BxA");
        PrintResult(ProductoCarteciano(B, A));

        System.out.println("Producto carteciano AxA");
        PrintResult(ProductoCarteciano(A, A));

        System.out.println("Producto carteciano BxB");
        PrintResult(ProductoCarteciano(B, B));

        System.out.println("Conjunto potencia P(A)");
        PrintResult(ConjuntoPotencia(A));

        System.out.println("Conjunto potencia P(B)");
        PrintResult(ConjuntoPotencia(B));

        System.out.print("Cardinalidad de A: ");
        Cardinalidad(A);

        System.out.print("Cardinalidad de B: ");
        Cardinalidad(B);

        System.out.println("FIN DEL PROGRAMA");;

        /*
         while (opcion != 0) {
         opcion = Integer.parseInt(JOptionPane.showInputDialog("ELIGE UNA OPCION\n"
         + "1.-Interseccion\n"
         + "2.-Union\n"
         + "3.-Diferencia A-B\n"
         + "4.-Diferencia B-A\n"
         + "5.-Diferencia simetrica A▲B\n"
         + "6.-Complemento A\n"
         + "7.-Complemento B\n"
         + "8.-Producto carteciano AxB\n"
         + "9.-Producto carteciano BxA\n"
         + "10.-Producto carteciano AxA\n"
         + "11.-Producto carteciano BxB\n"
         + "12.-Conjunto potencia P(A)\n"
         + "13.-Conjunto potencia P(B)\n"
         + "14.-Cardinalidad |A|\n"
         + "15.-Cardinalidad |b|\n"
         + "SALIR >>0"));

         //Llamamos a las funciones con las operaciones de cada uno de los conjuntos
         switch (opcion) {
         case 1:
         Interseccion(A, B);
         break;

         case 2:
         Union(A, B);
         break;

         case 3:
         System.out.println("Diferencia A-B");
         DiferenciaA(A, B);
         break;

         case 4:
         System.out.println("Diferencia B-A");
         DiferenciaB(B, A);

         break;
         case 5:
         System.out.println("Diferencia simetrica");
         DiferenciaSimetrica(A, B);
         break;

         case 6:
         System.out.println("Complemento A");
         Complemento(A);
         break;

         case 7:
         System.out.println("Complemento B");
         Complemento(B);
         break;

         case 8:
         System.out.println("Producto carteciano AxB");
         PrintResult(ProductoCarteciano(A, B));
         break;

         case 9:
         System.out.println("Producto carteciano BxA");
         PrintResult(ProductoCarteciano(B, A));
         break;

         case 10:
         System.out.println("Producto carteciano AxA");
         PrintResult(ProductoCarteciano(A, A));
         break;

         case 11:
         System.out.println("Producto carteciano BxB");
         PrintResult(ProductoCarteciano(B, B));
         break;

         case 12:
         System.out.println("Conjunto potencia P(A)");
         PrintResult(ConjuntoPotencia(A));
         break;

         case 13:
         System.out.println("Conjunto potencia P(B)");
         PrintResult(ConjuntoPotencia(B));
         break;

         case 14:
         System.out.print("Cardinalidad de A: ");
         Cardinalidad(A);
         break;

         case 15:
         System.out.print("Cardinalidad de B: ");
         Cardinalidad(B);
         break;
         default:
         System.out.println("FIN DEL PROGRAMA");;
         }
         }
         */
    }

    //DECLARAMOS LAS FUNCIONES
    public static void GetUniverse() {
        for (int i = 1; i <= 100; i++) {
            Universo.add("" + i);
        }
    }

    public static void Interseccion(List<String> A, List<String> B) {
        System.out.println("Resultado de la interseccion");
        PrintResult(GetDuplicates(A, B));
    }

    public static void Union(List<String> A, List<String> B) {
        List<String> result = new ArrayList<>();

        for (String A1 : A) {
            result.add(A1);
        }
        for (String B1 : B) {
            result.add(B1);
        }

        result = DeleteDuplicates(result);
        System.out.println("Resultado de la union");
        PrintResult(result);
    }

    public static void DiferenciaA(List<String> A, List<String> B) {
        List<String> repetidos = new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.addAll(A);
        repetidos = GetDuplicates(A, B);

        result = DeleteDuplicates(result);
        //Eliminamos los elementos que son iguales entre los conjuntos
        result = DeleteDuplicatesFromSets(result, repetidos);

        PrintResult(result);
    }

    public static void DiferenciaB(List<String> A, List<String> B) {
        List<String> repetidos = new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.addAll(A);
        repetidos = GetDuplicates(A, B);
        result = DeleteDuplicates(result);

        //Eliminamos los elementos que son iguales entre los conjuntos
        result = DeleteDuplicatesFromSets(result, repetidos);

        PrintResult(result);
    }

    public static void DiferenciaSimetrica(List<String> A, List<String> B) {
        List<String> repetidos = new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.addAll(A);
        result.addAll(B);
        result = DeleteDuplicates(result);
        repetidos = GetDuplicates(A, B);
        result = DeleteDuplicatesFromSets(result, repetidos);
        PrintResult(result);

    }

    public static void Complemento(List<String> A) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < Universo.size(); j++) {
                if (!A.get(i).equals(Universo.get(j))) {
                    result.add(Universo.get(j));
                }
            }
        }
        PrintResult(result);

    }

    public static List ProductoCarteciano(List<String> A, List<String> B) {
        List<String> a = new ArrayList<>();
        a = DeleteDuplicates(A);
        List<String> b = new ArrayList<>();
        b = DeleteDuplicates(B);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                result.add(a.get(i) + "," + b.get(j));
            }
        }
        return result;
    }

    public static List ConjuntoPotencia(List<String> A) {
        List<String> result = new ArrayList<String>();

        result.add("{}");
        for (String a : A) {
            result.add(a);
        }

        for (int i = 0; i < A.size() - 1; i++) {
            String head = A.get(i);
            for (int j = i; j < A.size(); j++) {
                if (!(head == A.get(j))) {
                    head += "," + A.get(j);
                }
                for (int k = j + 1; k < A.size(); k++) {
                    result.add(head + "," + A.get(k));
                }
            }
        }

        return result;
    }

    public static void Cardinalidad(List<String> A) {
        A = new ArrayList(new LinkedHashSet(A));
        System.out.println(A.size());
    }

    //FUNCIONES PARA LAS OPERACIONES
    private static void PrintResult(List<String> A) {
        for (String B1 : A) {
            System.out.print("{");
            System.out.print(B1);
            System.out.print("},");
        }
        System.out.println("");
    }

    private static List GetDuplicates(List<String> A, List<String> B) {
        //Declaramos una variable temporal
        List<String> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                if (A.get(i).equals(B.get(j))) {
                    result.add(B.get(j));
                }
            }
        }
        return DeleteDuplicates(result);
    }

    private static List DeleteDuplicates(List<String> A) {
        List<String> result = new ArrayList<>();
        result.addAll(A);
        return result = new ArrayList(new LinkedHashSet(result));
    }

    private static List DeleteDuplicatesFromSets(List<String> A, List<String> B) {
        List<String> A_c = new ArrayList<>();
        A_c.addAll(A);
        List<String> B_c = new ArrayList<>();
        B_c.addAll(B);

        for (String b : B_c) {
            if (A_c.contains(b)) {
                A_c.remove(b);
            }
        }
        return A_c;
    }

}
