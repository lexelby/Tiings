package tilings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class UpdateChecker
   implements Runnable
{

   public interface IUpdateListener {
      void CheckFailed();
      void UpToDate();
      void UpdateAvailable(String[] update);
   }
   
   private IUpdateListener m_listener;
   private String m_url;
   private int[] m_version;
   private boolean m_running;
   public UpdateChecker(IUpdateListener listener, String url, int[] version) {
      m_listener = listener;
      m_url = url;
      m_version = version;
   }
   
   synchronized public void StartCheck() {
      if(!m_running) {
         m_running = true;
         new Thread(this).start();
      }
   }

   @Override
   public void run() {
      String[] info = CheckUpdate(m_url);
      m_running = false;
      if( info==null ) {
         m_listener.CheckFailed();
         return;
      }
      String v = info[0];
      String[] latestVersion = v.split("\\.");
      boolean same = true;
      if( m_version.length == latestVersion.length) {
         for( int i=0; same && i<m_version.length; i++) {
            if( !latestVersion[i].equals(Integer.toString(m_version[i]))) {
               same = false;
            }
         }
      }else {
         same = false;
      }
      if( same ) {
         m_listener.UpToDate();
      }else {
         m_listener.UpdateAvailable(info);
      }
   }
   
   static public String[] CheckUpdate(String url)  {
      System.out.println("Update Check started");
      URLConnection connection = null;
      ArrayList<String> result = new ArrayList<String>();
      try {
         connection = new URL(url).openConnection();
         connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
         connection.connect();
         BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

         while(result.size()<10) {
            String s = r.readLine();
            if( s==null) break;
            System.out.println(s);
            result.add(s);
         }
      } catch (MalformedURLException e1) {
         e1.printStackTrace();
         result.clear();
      } catch (IOException e1) {
         e1.printStackTrace();
         result.clear();
      } finally {
         System.out.println("Update Check finished");
      }
      return result.isEmpty() ? null: result.toArray(new String[0]);
   }

}
