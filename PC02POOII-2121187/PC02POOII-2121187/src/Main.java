import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        //NO SABÍA SI HACER UNA LISTA POR CADA PREGUNTA
        //O UNA SOLA LISTA PARA TODA, ASÍ QUE MEJOR CREO
        // UNA PARA CADA UNA , espero esté bien


        //PREGUNTA 1
        List<Integer> numeros1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("--------------Pregunta 1:--------------");
        numeros1.stream()
                .filter(numero -> numero % 2 == 0)
                .forEach(System.out::println);

        //PREGUNTA 2
        List<Integer> numeros2 = Arrays.asList(51,23,57,5,94,505,62,8,159);
        System.out.println("--------------Pregunta 2:--------------");
        numeros2.stream()
                .filter(numero -> numero.toString().startsWith("5"))
                .forEach(System.out::println);

        //PREGUNTA 3
        List<Integer> numeros3 = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 5, 7, 8, 9, 9, 10);
        System.out.println("--------------Pregunta 3:--------------");
        List<Integer> duplicados = numeros3.stream()
                .collect(Collectors.groupingBy(n->n))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
        duplicados.forEach(System.out::println);

        //PREGUNTA 4 (ACÁ si agarré la pregunta 1 ) :)
        long totalElementos = numeros1.stream().count();
        System.out.println("--------------Pregunta 4:--------------");
        System.out.println("El número total de elementos es: " + totalElementos);

        //PREGUNTA 5 (TAMBIÉN AGARRÉ LA LISTA DE LA PREGUNTA 1)  :)
        List<Integer> ordenDescendente = numeros1.stream()
                .sorted((a, b) -> Integer.compare(b, a))
                .collect(Collectors.toList());

        ordenDescendente.forEach(System.out::println);

        //PREGUNTA 6 LA OTRA PARTE DE LA PREGUNTA ESTA AL FINAL
        int[] numeros = {1, 2, 3, 4, 1, 5, 6, 2, 7, 8, 9, 1};
        boolean hayRepetidos = repetidos(numeros);
        System.out.println("¿Hay valores repetidos al menos tres veces? " + hayRepetidos);

        //PREGUNTA 7 TAMBIEN LA OTRA PARTE DE LA PREGUNTA LA PUSE AL FINAL
        String[] A = {"1", "2", "3", "4", "5", "8", "23"};
        String[] B = {"4", "6", "8", "0", "2"};

        String[] AB = CONCATENAR(A, B);
        System.out.println("Resultado: " + Arrays.toString(AB));

        //PREGUNTA 8 AGARRÉ LA LISTA DE LA PREGUNTA 1 TAMBIÉN JEJE
        List<Integer> resultado = numeros1.stream()
                .map(numero -> numero * numero * numero)
                .filter(cubo -> cubo > 50)
                .collect(Collectors.toList());
        System.out.println("Cubo de números mayores a 50: " + resultado);

        //PREGUNTA 9
        String[] arregloCadenas = {"holis what are u doing", "Thuersday", "Otro dia"};

        long totalPalabras = Arrays.stream(arregloCadenas)
                .flatMap(cadena -> Arrays.stream(cadena.split("\\s+")))
                .count();
        System.out.println("Total de palabras: " + totalPalabras);

        //PREGUNTA 10
        String[] arrayCadenas = {"apple", "banana", "orange", "apple", "grape", "banana", "apple", "banana"};

        Map<String, Long> duplicados1 = Arrays.stream(arrayCadenas)
                .collect(Collectors.groupingBy(cadena -> cadena, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        duplicados1.forEach((cadena, frecuencia) ->
                System.out.println("Elemento: " + cadena + ", Frecuencia: " + frecuencia));




    }

    private static boolean repetidos(int[] array) {  //ESTE BOLEANO ES PARTE DE LA PREGUNTA 6, NO SABÍA COMO COLOCARLO EN OTRA PARTE
        Map<Integer, Long> conteo = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return conteo.values().stream().anyMatch(count -> count >= 3);
    }

    private static String[] CONCATENAR(String[] A, String[] B) {
        int n = A.length;
        int m = B.length;

        String[] result = new String[n + m];

        System.arraycopy(A, 0, result, 0, n);
        System.arraycopy(B, 0, result, n, m);

        return result;
    }
}
