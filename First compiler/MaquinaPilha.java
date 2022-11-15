import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaquinaPilha {

	public static void main(String[]args) throws IOException
	{
        String fileName = "testeparamaquina.txt";

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        
        List<Integer> list = new ArrayList();
        List<String> list2 = new ArrayList();

        try {
            String line;
            String[] a;
            int result = -99;

            while ((line = reader.readLine()) != null) {
                if (line.contains("PUSH")) {
                    a = line.split(" ");
                    list.add(Integer.parseInt(a[1]));
                } else if (!line.contains("PRINT")) {
                    list2.add(line);

                    if (list2.size() >= 1) {
                        if (result == -99) {
                            result = list.get(list.size() - 2);
                            list.remove(list.size() - 2);
                        }

                        if (line.intern() == "DIV") {
                            System.out.println("Resultado parcial: " + result + " / " + list.get(list.size() - 1));
                            result /= list.get(list.size() - 1);
                        } else if (line.intern() == "MULT") {
                            System.out.println("Resultado parcial: " + list.get(list.size() - 1) + " * " + result);
                            result *= list.get(list.size() - 1);
                        } else if (line.intern() == "SUM") {
                            System.out.println("Resultado parcial: " + list.get(list.size() - 1) + " + " + result);
                            result += list.get(list.size() - 1);
                        } else {
                            System.out.println("Resultado parcial: " + result + " - " + list.get(list.size() - 1));
                            result = result - list.get(list.size() - 1);
                        }
                        list.remove(list.size() - 1);
                    }
                }
            }
            Collections.reverse(list);
            System.out.println("Resultado: " + result);
        } finally {
            fileReader.close();
        }
    }
}