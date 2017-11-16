
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.util.ArrayList;
//import java.util.Objects;

/**
 * Created by Andrew on 11.12.2016.
 */
public class DataSender {


    private String location = null;
    private String Domain;
    private String Postfix;


    /**
     * Creating an instance with specified domain address, postfix and location<br>
     *     entire URL wil be Domain+Postfix. Example:www.servername.net/example/add-cam
     */
    public DataSender(){

    }

    /**
     * Sends given JSON to server
     * @param jsonStr JSON string to send
     * @return
     */
    public boolean SendData (String jsonStr) throws Exception {

        boolean result = false;
        try {

            String urlStr = "http://ppd.cifr.us/api/point/put";


            StringEntity entityJson = new StringEntity(jsonStr);
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(urlStr);

            try {
                System.out.println(entityJson);
                post.setEntity(entityJson);

                HttpResponse response = client.execute(post);

                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    System.out.println(line);
                    //{"success":"true","error":"null"}
                    if ((line.contains("\"success\":\"1\""))||(line.contains("\"success\":\"true\""))||(line.contains("\"success\":true")))
                        result = true;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

/*
    /**
     * Creates JSon string from Data object
     * @param data data to convert
     * @return JSON string with converted data
     */
 /*   private String JSONforCounter(Data data){
        String jsonStr =
                "{\"in\":" + data.getIn() +
                ",\"out\":" + data.getOut() +
                ",\"location\":\"" + location +
                "\",\"time\":\"" + data.getDateString() + "\"}";

        return jsonStr;
    }
*/

//    /**
//     *
//     * @param path Path to "data" folder, example: "folder/folder/"
//     */
//    public void getFileList(String path){
//
//        File[] fileList;
//        File logFolder = new File (path + "data/");
//        fileList = logFolder.listFiles();
//
//        for (File f : fileList){
//            //Path p = Paths.getByKey(f.getName());
//            String filename = f.getName(); //p.getFileName().toString();
//
//            String location;
//            long date;
//
//            //TODO: переробити аналіз назви на регулярки
//            String[] splitName = filename.split("\\.");
//            if (splitName.length == 3){
//                if (!Objects.equals(splitName[1], "0")) {
//                    boolean transmitionOK = false;
//
//                    date = Long.valueOf( splitName[1] );
//                    location = splitName[0];
//
//                    ArrayList<ISendable> dataLog = DataLogger.readData(f.getAbsolutePath());
//
//                    //dataLog = DataLogger.groupByHour(dataLog);
//
//                    for (ISendable d: dataLog){
//                        //if at least 1 is OK - transmission OK
//                        String jsonStr = d.toJSON(location);
//                        try {
//                            transmitionOK = transmitionOK || SendData(jsonStr);
//                        } catch (Exception e) {
//                            userLogger.error("Error, occured while sending data with: " ,e);
//                            e.printStackTrace();
//                        }
//                    }
//
//                    if (transmitionOK) {
//                        String archiveAddress = path + "archive/"+location+"." + date + ".xml";
//                        DataLogger.writeData(dataLog, archiveAddress);
//                        f.delete();
//                    }
//                }
//            }
//        }
//    }
}
