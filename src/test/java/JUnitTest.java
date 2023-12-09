
import com.company.quotes.Quote;
import com.company.quotes.QuotesDAO;
import com.company.quotes.QuotesService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

/**
 *
 * @author kirill
 */
public class JUnitTest {
    
    public JUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    String author = "Jack London";
    String author1 = "Mark Twen";
    String quote = "Famous quote from the past";
    String quote1 = "Famous quote from the future";
    String quote2 = "Famous quote from the present";
    String category = "daily";
    String ID = "1";
    String ID1 = "2";
    String ID2 = "3";
    
    @Test
    public void testQuotes() 
    {
        this.printStartMark("testQuotes");
        
        System.out.println("QuotesDAO size is: " + QuotesDAO.getInstance().getModel().size());
        
        Quote q = new Quote();
        
        q.setAuthor(author);
        q.setQuote(quote);
        q.setCategory(category);
        
        System.out.println("Date is: " + q.getDate());
        
        Quote qcopy = null;
        
        System.out.println("\n");
        System.out.println("Adding quote \n");
        QuotesDAO.getInstance().getModel().put(ID, q);
        System.out.println("QuotesDAO size is: " + QuotesDAO.getInstance().getModel().size());
        
        System.out.println("\n");
        System.out.println("Retrieving quote \n");
        qcopy = QuotesDAO.getInstance().getModel().get(ID);
        System.out.println("Author is: " + qcopy.getAuthor());
        System.out.println("Quote is: " + qcopy.getQuote());
        System.out.println("Category is: " + qcopy.getCategory());
        System.out.println("QuotesDAO quote hashcode is: " + QuotesDAO.getInstance().getModel().get(ID).hashCode());
        
        System.out.println("\n");
        System.out.println("Changing quote \n");
        QuotesDAO.getInstance().getModel().get(ID).setQuote(quote1);
        
        System.out.println("\n");
        System.out.println("Retrieving quote \n");
        qcopy = QuotesDAO.getInstance().getModel().get(ID);
        System.out.println("Author is: " + qcopy.getAuthor());
        System.out.println("Quote is: " + qcopy.getQuote());
        System.out.println("Category is: " + qcopy.getCategory());
        System.out.println("QuotesDAO quote hashcode is: " + QuotesDAO.getInstance().getModel().get(ID).hashCode());
        
        
        System.out.println("\n");
        System.out.println("Getting all quotes \n");
        System.out.println("Quotes are: " + QuotesDAO.getInstance().getModel().values());
        
        System.out.println("\n");
        System.out.println("Adding quote \n");
        q.setAuthor(author1);
        q.setQuote(quote2);
        QuotesDAO.getInstance().getModel().put(ID1, q);
        System.out.println("QuotesDAO size is: " + QuotesDAO.getInstance().getModel().size());
        
        System.out.println("\n");
        System.out.println("Retrieving quote \n");
        qcopy = QuotesDAO.getInstance().getModel().get(ID1);
        System.out.println("Author is: " + qcopy.getAuthor());
        System.out.println("Quote is: " + qcopy.getQuote());
        System.out.println("Category is: " + qcopy.getCategory());
        System.out.println("QuotesDAO quote hashcode is: " + QuotesDAO.getInstance().getModel().get(ID).hashCode());
        
        System.out.println("QuotesDAO size is: " + QuotesDAO.getInstance().getModel().size());
        
        System.out.println("Testing List traversal of Quotes: ");
        List<Quote> quotes = new ArrayList<Quote>();
        quotes.addAll(QuotesDAO.getInstance().getModel().values() );
        
        
        for (Quote tmpq : quotes) {
            System.out.println("Quote in List is: " + tmpq.getQuote());
            System.out.println("Author in List is: " + tmpq.getAuthor());
        }
        
        System.out.println("\n");
        System.out.println("Deleting quote \n");
        QuotesDAO.getInstance().getModel().remove(ID, q);
        System.out.println("QuotesDAO size is: " + QuotesDAO.getInstance().getModel().size());
        
        System.out.println("\n");
        System.out.println("Getting all quotes \n");
        System.out.println("Quotes are: " + QuotesDAO.getInstance().getModel().values());
        
        this.printStopMark("testQuotes");
        QuotesDAO.getInstance().getModel();
    }
    
    @Test
    public void testQuotesService() 
    {
        this.printStartMark("testQuotesService");
        
        QuotesService QS = new QuotesService();
        
        Quote q = new Quote();
        
        q.setAuthor(author);
        q.setQuote(quote);
        q.setCategory(category);
        
        Quote qcopy = null;
        
        System.out.println("\n");
        System.out.println("Adding quote \n");
        QS.createQuote(ID, q);
        System.out.println("QuotesDAO size is: " + QS.getSize());
        
        System.out.println("\n");
        System.out.println("Retrieving quote \n");
        qcopy = QuotesDAO.getInstance().getModel().get(ID);
        System.out.println("Author is: " + qcopy.getAuthor());
        System.out.println("Quote is: " + qcopy.getQuote());
        System.out.println("Category is: " + qcopy.getCategory());
        
        
        System.out.println("\n");
        System.out.println("Deleting quote \n");
        QS.deleteQuote(ID);
        System.out.println("QuotesDAO size is: " + QS.getSize());
        
        System.out.println("\n");
        System.out.println("Creating a set of sample quotes \n");
        QS.createSampleQuotes();
        System.out.println("QuotesDAO size is: " + QS.getSize());
        
        System.out.println("\n");
        System.out.println("Deleting all quotes \n");
        QS.deleteAllQuotes();
        System.out.println("QuotesDAO size is: " + QS.getSize());
        
        this.printStopMark("testQuotesService");
    }
    
    @Test
    public void testQuotesService2() 
    {
        this.printStartMark("testQuotesService2");
        
        QuotesService QS = new QuotesService();
        
        QS.createSampleQuotes();
        
        QS.getAllQuotes();
        
        QS.deteleDailyQuotes();
        
        System.out.println("QuotesDAO size is: " + QS.getSize());
        
        this.printStopMark("testQuotesService2");
    }    
    
    
    @Test
    public void testMap() 
    {
        this.printStartMark("testMap");
        Map<Integer, String> map = new HashMap<>();
        
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");
        
        List<String> result = new ArrayList(map.values());
        result.forEach(System.out::println);
        
        this.printNL();
        
        List<String> result1 = new ArrayList<String>();
        result1.addAll(map.values() );
        result1.forEach(System.out::println);
        
        this.printNL();
        
        Collection result2 = map.values();
        result2.forEach(System.out::println);
        
        
        
        this.printStopMark("testMap");
    }
    
    @Test
    public void testMap2() 
    {
        this.printStartMark("testMap2");
        Map<Integer, String> map = new HashMap<>();
        
        
        String value = null;
        value = "apple";
        System.out.println("string value hashcode is: " + value.hashCode());
        
        map.put(10, value);
        value = "orange";
        System.out.println("string value hashcode is: " + value.hashCode());
        map.put(20, value);
        value = "banana";
        System.out.println("string value hashcode is: " + value.hashCode());
        map.put(30, value);
        value = "watermelon";
        System.out.println("string value hashcode is: " + value.hashCode());
        map.put(40, value);
        value = "dragonfruit";
        System.out.println("string value hashcode is: " + value.hashCode());
        map.put(50, value);
        
        List<String> result = new ArrayList(map.values());
        result.forEach(System.out::println);
        
        this.printNL();
        
        List<String> result1 = new ArrayList<String>();
        result1.addAll(map.values() );
        result1.forEach(System.out::println);
        
        this.printNL();
        
        Collection result2 = map.values();
        result2.forEach(System.out::println);
        
        
        
        this.printStopMark("testMap2");
    }
    
    
    @Test
    public void testMap3() 
    {
        this.printStartMark("testMap3");
        Map<Integer, String> map = new HashMap<>();
        
        
        String value = null;
        value = "apple";
        System.out.println("string value hashcode is: " + value.hashCode());
        
        map.put(10, value);
        value = "orange";
        System.out.println("string value hashcode is: " + value.hashCode());
        
        
        List<String> result = new ArrayList(map.values());
        result.forEach(System.out::println);
        
        this.printNL();
        
        List<String> result1 = new ArrayList<String>();
        result1.addAll(map.values() );
        result1.forEach(System.out::println);
        
        this.printNL();
        
        Collection result2 = map.values();
        result2.forEach(System.out::println);
        
        
        
        this.printStopMark("testMap3");
    }
    
    @Test
    public void testMap4() 
    {
        this.printStartMark("testMap4");
        
        Map<String, Quote> map = new HashMap<>();
        
        Quote q = new Quote();
        Quote q1 = new Quote();
        Quote q2 = new Quote();
        
        q.setAuthor(author);
        q.setQuote(quote);
        q.setCategory(category);
        
        Quote qcopy = null;
        
        System.out.println("\n");
        System.out.println("Adding quote \n");
        map.put(ID, q);
        System.out.println("Quotes map size is: " + map.size());
        
        System.out.println("\n");
        System.out.println("Adding quote \n");
        q1.setAuthor(author1);
        q1.setQuote(quote2);
        map.put(ID1, q1);
        System.out.println("Quotes map size is: " + map.size());
        
        
        System.out.println("\n");
        System.out.println("Adding quote \n");
        q2.setAuthor(author);
        q2.setQuote(quote1);
        map.put(ID2, q2);
        System.out.println("Quotes map size is: " + map.size());
//        List<String> result = new ArrayList(map.values());
//        result.forEach(System.out::println);
//        
//        this.printNL();
        
        
        List<Quote> quotes = new ArrayList<Quote>();
        
        quotes.addAll(map.values() );
        
        quotes.forEach(System.out::println);
        
        this.printNL();
        
        Collection result2 = map.values();
        result2.forEach(System.out::println);
        
        System.out.println("Quote in list is: " + quotes.get(0).getQuote() );
        System.out.println("Quote in list is: " + quotes.get(1).getQuote() );
        System.out.println("Quote in list is: " + quotes.get(2).getQuote() );
        
        
        this.printStopMark("testMap4");
    }
    
    
    @Test
    public void testRandom() 
    {
        this.printStartMark("testRandom");
        
        int min = 0;
        int max = 5;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        
        System.out.println("random number is: " +  randomNum);
        
        this.printStopMark("testRandom");
    }    
    
    @Test
    public void testTime() 
    {
        this.printStartMark("testTime");
        
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        
        System.out.println("Date is: " +  date);
        
        System.out.println("Timestamp is: " +  ts);
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Date date1 = new Date();
        
        System.out.println("Date is: " +  date1);
        
        boolean ret = date1.after(date);
        System.out.println("comparison is: " +  ret);
        
        ts.before(date1);
        
        LocalDate currDate = LocalDate.now();
        
        System.out.println("local Date is: " +  currDate);
        
        LocalDate PastDate = LocalDate.of(2012, 6, 30);
        
        System.out.println("local Date 1 is: " +  PastDate);
        
        ret = PastDate.isAfter(currDate);
        System.out.println("comparison is: " +  ret);
        
        ret = currDate.isAfter(PastDate);
        System.out.println("comparison is: " +  ret);
        
        this.printStopMark("testTime");
    } 
    
    
    private void printStartMark(String tag)
    {
        String dash = "----------------------------";
        System.out.println("START " +  tag + dash + "\n");
    }
    
    private void printStopMark(String tag)
    {
        String dash = "----------------------------";
        System.out.println("STOP " +  tag + dash + "\n");
    }
    
    private void printNL()
    {
        String dash = "----------------------------";
        System.out.println("\n");
    }
}
