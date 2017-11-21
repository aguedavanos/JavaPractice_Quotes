import java.util.*;
import java.time.*;
import java.time.format.*;

public class Opdr7_Quotes {
    String[][] quotes = {
        {"galileo", "eppur si muove"},
        {"archimedes", "eureka!"},
        {"erasmus", "in regione caecorum rex est luscus"},
        {"socrates", "I know nothing except the fact of my ignorance"},
        {"ren\u00E9 descartes", "cogito, ergo sum"},
        {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };

    public static void main(String... args) {
        //TODO
        Opdr7_Quotes o = new Opdr7_Quotes();
        DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("EEEE 'the' d'th of' MMMM");
        int numDaysToPrint = 7;
        LocalDate date = LocalDate.now();

        System.out.println("\n***\n");
        for(int i = 0; i<numDaysToPrint; i++)
        {
            if(i == 1)
            {
                System.out.println("\n***");
                System.out.println("\nSome more days:");
            }
            System.out.println("Quote for " + longFormat.format(date) +":");
            o.printQuote(o.getQuoteIndex(date.getDayOfYear()));
            date = date.plusDays(1);
        }
        
    }

    private void printQuote(int index)
    {
        String name = formatName(quotes[index][0]);
        String quote = formatQuote(quotes[index][1]);
        
        System.out.println("\t" + quote + " -- " + name +"\n");
    }

    private String formatQuote(String quote)
    {   
        quote = quote.trim();
        quote = quote.substring(0,1).toUpperCase() + quote.substring(1).toLowerCase();

        if(!(quote.endsWith(".") || quote.endsWith("!") || quote.endsWith("?")))
        {
            quote = quote+'.';
        }
        return '"'+quote+'"';
    }

    private String formatName(String name)
    {   
        name = name.trim(); //in case there's space in front
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        if(name.contains(" "))
        {
            for(int i = 1; i < name.length(); i++)
            {
                if(name.charAt(i) == (' '))
                {
                    name = name.substring(0, i+1) + name.substring(i+1,i+2).toUpperCase() + name.substring(i+2).toLowerCase();
                }               
            }
        }

        return name;
    }

    private int getQuoteIndex(int day)
    {
        int index = 0;
        int d = 0;

        while(d < day)
            {
                for(int i = 0; i<quotes.length; i++)
                {
                    index = i;
                    d++;
                    if(d >= day)
                    {
                        break;
                    }
                }

            }
        return index;
    }
}
