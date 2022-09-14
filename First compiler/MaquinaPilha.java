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

            while ((line = reader.readLine()) != null) {
                if (line.contains("PUSH")) {
                    a = line.split(" ");
                    list.add(Integer.parseInt(a[1]));
                } else if (!line.contains("PRINT")) {
                    list2.add(line);
                }
            }
            Collections.reverse(list);
        } finally {
            fileReader.close();
        }

        int result = list.get(0);
        list.remove(0);
        for (int i = 0; i < list2.size(); i++) {

            if (list2.get(i).intern() == "DIV") {
                result = list.get(0) / result;
            } else if (list2.get(i).intern() == "MULT") {
                result *= list.get(0);
            } else if (list2.get(i).intern() == "SUM") {
                result += list.get(0);
            } else {
                result = list.get(0) - result;
            }
            list.remove(0);
        }
        System.out.println("Resultado: " + result);
    }
}