package tilings;

public final class Functions
{
   public static double BisectionMethod(IFunction f, double low0, double high0, double epsilon){
      double low = low0;
      double high = high0;
      double fl = f.calculate(low);
      double fh = f.calculate(high);
      if( fl*fh>0 )
         throw new RuntimeException("Function values should have different signs! "+fl+" "+fh);

      while( high-low > epsilon ){
         // x = h - fh*(h-l)/(fh-fl)
         double x = (high+low)/2;
         double fx = f.calculate(x);
         if( fx*fl>0 ){
            fl = fx;
            low = x;
         }else{
            fh = fx;
            high = x;
         }
      }
      return (high+low)/2;
   }
}
