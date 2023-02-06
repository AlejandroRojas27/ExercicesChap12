import java.io.File;

public class Ejercicio_12_26_CreateADirectory {
    public static void main(String[] args) {

        String directoryName = "src/Directory";

        File directory = new File(directoryName);

        if(directory.exists()){
            System.out.println("Directory already exist");
        }else {
            directory.mkdirs();
            System.out.println("Directory was created successfully");
        }






    }
}
