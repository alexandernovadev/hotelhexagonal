package com.conexionmysql.mysqljdb.labs;

import java.io.BufferedReader;
import java.io.File; // Import the File class
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Abc {

  public static void generateFile(String entity, String entityLower, String file, String title, String type) {

    String typefile = "Controller";
    String path = "controller";

    switch (typefile) {
      case "Service":
        typefile = "Services";
        path = "services";

        break;

      case "Model":
        typefile = "Model";
        path = "models";
        break;

      default:
        break;
    }
    String sourceFileName = "/Users/alex/Downloads/mysqljdb/src/main/java/com/conexionmysql/mysqljdb/labs/template"
        + typefile + ".java";
    String destFileName = "/Users/alex/Downloads/mysqljdb/src/main/java/com/conexionmysql/mysqljdb/"
        + path + "/" + title + ".java";

    File sourceFile = new File(sourceFileName);
    try {
      BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
      FileWriter writer = new FileWriter(destFileName);

      // Copiar el contenido del archivo de origen en el archivo de destino
      String line;
      while ((line = reader.readLine()) != null) {
        line = line.replace("$TITLE$", file);
        line = line.replace("$NAMETABLEF$", entity);
        line = line.replace("$NAMETABLE$", entityLower);
        writer.write(line + "\n");
      }

      // Cerrar los objetos reader y writer
      reader.close();
      writer.close();

      System.out.println("El " + title + " ha sido copiado exitosamente.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {

    generateFile("User", "user", "UserController", "UserController", "Controller");
  }
}