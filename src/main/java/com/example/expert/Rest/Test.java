package com.example.expert.Rest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



public class Test {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/uploads";
    public static String UPLOAD_DIRECTORY_TEMP = System.getProperty("user.home") +"/Desktop/tessdata-main" ;

    public static void main(String[] args) {
        
        List<String> maliste = new  ArrayList<String>();
        maliste.add("avd");
        maliste.add("bsc");
        maliste.add("BHHcs");
        maliste.add("UPLOAD_DIRECTORY");
        maliste.stream().filter(s ->s.startsWith( "b" )).map(String::toUpperCase).sorted().forEach(System.out::println);
        String yassine ="baXalalalananalla";
        
        System.out.println(yassine.substring(3));
        // System.out.println(UPLOAD_DIRECTORY_TEMP);
        // File imageFile = new File(UPLOAD_DIRECTORY +"/captureTest.png");
        // ITesseract tess = new Tesseract();
        // tess.setDatapath(UPLOAD_DIRECTORY_TEMP); // chemin vers le dossier tessdata qui contient les fichiers de données de Tesseract
        // try {
        //     String result = tess.doOCR(imageFile);
        //     System.out.println(result);
        // } catch (TesseractException e) {
        //     System.err.println(e.getMessage());
        // }

        // int array[] ={1,2,3,5,6,8,9}; 
        // int n=0;   

        // for(int i=0 ; i<array.length; i++){
        //   if(array[i]>n){
        //     n=array[i];
        //   }
          
        // }
        // System.out.println(n);
        // SimpleDateFormat s = new SimpleDateFormat();
        // System.out.println(s.format(System.currentTimeMillis()));
        // File file = new File(UPLOAD_DIRECTORY+"/arabT");
        // System.out.println(file.length());
        // int chr ='à';
        // System.out.println(chr);

        // StringBuilder bs= new StringBuilder("WayToLearnX");
        // System.out.println(bs.reverse());

        // int[] array = {5,1,22,25,6,-1,8,10};
        // int[] sequence = {1,6,8,10,50};
        // boolean x=true ;
        // int compteur=0;
        // int j=0;
        // int size = sequence.length;
        // for (int i = 0; i < array.length; i++) {
        //     if(j<size){
        //         int array2=sequence[j];
        //         if(array2==array[i]){
        //             System.out.println(array2);
        //             compteur=compteur+1;
        //             j++;
        //             x=true;
        //         }
        //     }else{x=false;}
        // }System.out.println(x);
}

        // scan file pdf
        // File pdfFile = new File(UPLOAD_DIRECTORY +"/samplea.png");
        // PDDocument document = PDDocument.load(pdfFile);
        // PDFTextStripper pdfStripper = new PDFTextStripper();
        // String text = pdfStripper.getText(document);
        // System.out.println(text);
        // document.close();

        // LocalDateTime now = LocalDateTime.now();
        // System.out.println(now);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        // String formattedDateTime = now.format(formatter);
        // // String url = "https://www.google.com";
        // // try {
        // //     Desktop.getDesktop().browse(new URI(url));
        // // } catch (IOException | URISyntaxException e) {
        // //     e.printStackTrace();
        // // }
        // if(formattedDateTime.equals("15:25")){
        //     String bureau = System.getProperty("user.home") + "/Desktop";
        //     File dossier = new File(bureau +"/archivage" );
        //     Path sourcePath = Paths.get(UPLOAD_DIRECTORY);
        //     Path destinationPath = Paths.get(bureau +"/archivage");
        //     if(dossier.exists() && dossier.isDirectory()){ 
        //         Files.walk(sourcePath).forEach(file -> {
        //             Path destinationFile = destinationPath.resolve(sourcePath.relativize(file));
        //         File  fichier = new File(dossier +"/"+file);
        //         System.out.println(fichier);
        //         if(!fichier.exists()){   
        //             try {
        //                 Files.copy(file, destinationFile);
        //             } catch (FileAlreadyExistsException e ) {
        //                 System.out.println("Directory already exists.");
        //             } catch (IOException e) {
        //                 e.printStackTrace();
        //             }
        //         }else{System.out.println("dejjjjaaaaaaa existe");}
        //         });
        
        //         System.out.println("La copie est terminée !");
        //     }else{ boolean resultat = dossier.mkdir();}
        // }else{System.out.println("erreur");}



       /* int tab[][] = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        int som = 0;
        for (int i = 0; i <tab.length; ++i)
            for (int j = 0; j <tab[1].length; ++j)
                som = som + tab[i][j];
        System.out.print(som );*/ 
       
           /*boolean contains =false;
            int[] outer = {1,2,3,4};
            int[] inner = {1,4,2};
            List<Integer> result= new ArrayList<Integer>();
            for(int i=0;i<inner.length;i++){
                result.add(inner[i]);
            }
            for(int j=0;j<outer.length;j++){
                if (result.contains(outer[j])) {
                    contains=true;
                }else{ contains=false;}
            }
           System.out.println(contains);*/
           
          
           // initial array of size 10
           /*int n = 10;
           int i;
    int arr[]= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    System.out.println("Initial Array:\n" + Arrays.toString(arr));
    int x = 50;
    int pos = 5;
    arr = insertX(n, arr, x, pos);
    System.out.println("\nArray with " + x
                       + " inserted at position "
                       + pos + ":\n"
                       + Arrays.toString(arr));*/

 
   /*  public static int[] insertX(int n, int arr[],int x, int pos){
        int i;
        int newarr[] = new int[n + 1];
     for(i=0; i<n+1; i++)
     {
            if(n<pos-1){
                newarr[i]=arr[i];
            }else if(i==pos-1){
                newarr[i]=x;
            }else{newarr[i]=arr[i-1];}

     }
            return newarr;
    }
    int[] array = {5,1,22,25,6,-1,8,10};
    int[] sequence = {1,6,8,10};
    boolean x=true ;
    int compteur=0;
    int j=0;
    int size = sequence.length;
    for (int i = 0; i < array.length; i++) {
        if(j<size){
            int array2=sequence[j];
            if(array2==array[i]){
                System.out.println(array2);
                compteur=compteur+1;
                j++;
                x=true;
            }
        }else{x=false;}
    }System.out.println(x);
    

    
    List<String> maListe = Arrays.asList("a1", "a2", "b2", "b1", "c1");
    maListe.stream()
           .filter(s -> s.startsWith("b"))
           .map(String::toUpperCase)
           .sorted()
           .forEach(System.out::println);
   
        
		
           List<String> lang1 = new ArrayList<String>();
           lang1.add("PHP");
           lang1.add("Java");
           lang1.add("C++");
           lang1.add("Python");
           List<String> lang2 = new ArrayList<String>();
           lang2.add("PHP");
           lang2.add("Java");
           lang2.add("C");
           lang2.add("a");
           ArrayList<String> lang3 = new ArrayList<String>();
           for (String l : lang1){
           if(lang2.contains(l)){
            System.out.println(true);
           }else{ System.out.println(false);}
               
           } */
          
        }
          

