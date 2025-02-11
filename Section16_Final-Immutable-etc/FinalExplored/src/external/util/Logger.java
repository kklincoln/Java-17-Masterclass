package external.util;

import java.time.LocalDateTime;

public class Logger {


    /// method
    public static void logToConsole(CharSequence message){  //takes either a String or StringBuilder arg
        LocalDateTime dt = LocalDateTime.now();
        System.out.printf("%1$tD %1$tT : %2$s%n", dt, message);
        if (message instanceof StringBuilder sb){   //if instance of StringBuilder, assign to sb
            sb.setLength(0);    //truncates the data in the StringBuilder
        }

    }
}
