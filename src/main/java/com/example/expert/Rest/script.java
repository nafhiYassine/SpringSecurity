package com.example.expert.Rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class script {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/uploads";
    public static void main (String args[]) throws IOException{
        
        String bureau = System.getProperty("user.home") + "/Desktop";
        File dossier = new File(bureau +"/archivage" );
        Path sourcePath = Paths.get(UPLOAD_DIRECTORY);
        Path destinationPath = Paths.get(bureau +"/archivage");
        if(dossier.exists() && dossier.isDirectory()){ 
            Files.walk(sourcePath).forEach(file -> {
                   Path destinationFile = destinationPath.resolve(sourcePath.relativize(file));
              File  fichier = new File(dossier +"/"+file);
              System.out.println(fichier);
               if(!fichier.exists()){   
                try {
                    Files.copy(file, destinationFile);
                } catch (FileAlreadyExistsException e ) {
                    System.out.println("Directory already exists.");
                } catch (IOException e) {
                     e.printStackTrace();
                }
             }else{System.out.println("dejjjjaaaaaaa existe");}
            });
       
             System.out.println("La copie est terminée !");
        }else{ boolean resultat = dossier.mkdir();}
}
}