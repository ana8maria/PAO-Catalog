
package pao.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditService {


    public static void writeAudit(String functionName, String className,String action) {
        
        
        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                 Date date = new Date(System.currentTimeMillis());
                 SimpleDateFormat formatter= new SimpleDateFormat("dd_MM_yyyy");

                String path="Audits\\"+formatter.format(date)+"_Audit.csv";
        
        
                 File tmp = new File(path);
        
                 if(!tmp.getParentFile().exists())
                 {
                         tmp.getParentFile().mkdirs();
            
                 }

                try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true)))
                {
            
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        out.append(functionName).append(",").append(dateFormat.format(new Date())).append(",").append(className).append(",").append(action).append('\n');
         
                } catch (IOException e) 
                {
                     e.printStackTrace();
                }
            }
        });
        
        t.run();
       
    }
}