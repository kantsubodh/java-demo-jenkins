package java_demo.jenkins;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println(printMsg("Hello World"));
    }
    
    private static String printMsg(String input) {
    	return Optional.ofNullable(input).orElse("No input provided.");
    }
}
