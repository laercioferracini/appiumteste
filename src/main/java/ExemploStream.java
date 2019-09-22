import java.io.*;

public class ExemploStream {

    public static void main(String[] args) {

        //Criar o objeto serializado
        Cliente c = new Cliente("Chicó typa", 'M', "12345677000");

        FileOutputStream arquivoSaida = null;
        String path = "/Users/lasicin/IdeaProjects/cliente.dat";
        try {
            arquivoSaida = new FileOutputStream(path);
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoSaida);

            objGravar.writeObject(c);
            objGravar.flush();
            objGravar.close();
            arquivoSaida.flush();
            arquivoSaida.close();
            System.out.println("Arquivo gravado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Recuperando arquivo");
        try {
            FileInputStream arquivoLeitura = new FileInputStream(path);
            ObjectInputStream objLeitura  = new ObjectInputStream(arquivoLeitura);
            System.out.println(objLeitura.readObject());
            objLeitura.close();
            arquivoLeitura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
