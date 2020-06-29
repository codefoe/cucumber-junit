function fn() {
 var File = Java.type("java.io.File");
 var file = new File("src/config.json");
    var BufferedReader  =Java.type("java.io.BufferedReader");
    var FileReader = Java.type("java.io.FileReader");
   var reader =  new BufferedReader(new FileReader(file));
   var st;
           while ((st = reader.readLine()) !== null) {
             print(st);
           }

return st;
}