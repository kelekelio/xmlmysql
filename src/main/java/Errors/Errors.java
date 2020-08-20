package Errors;

public class Errors {

    public static void errorHandler(String type, int code, String tableName) {
        // type => sql, code => 1050

        switch (type) {
            case "sql":
                if (code == 1050) {
                    System.out.println(tableName + " already exists.");
                }
                else if (code == 1064) {
                    System.out.println("Syntax error");
                }
                else {
                    System.out.println("Table creation failed. Error: " + code);
                }
            case "xml":

            default:


        }
    }

}
