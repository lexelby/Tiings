package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_220
   extends TilingType
   implements IFunction
{
   private double b,c;
   public TilingTypeNC5_220(){
      super( "NC5-220", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,4, 0,3,0, 1},
            {2, 0,1, 1,2,1, 1},
            {2, 2,0, 2,0,2, 1},
            {1, 2,1, 3,0,1, 1},
            {0, 3,0, 4,2,4, 0},

            {0, 0,1, 4,1,0, 1},
            {1, 2,4, 6,3,0, 0},
            {2, 0,1, 7,2,1, 0},
            {2, 2,0, 8,0,2, 0},
            {1, 2,1, 9,0,1, 0},
            {0, 3,0,10,2,4, 1},
      };
      info = "a=d=e\nb=c=2a\nA+2B+E=360\nD+E=360\n(A+B+C=180)";
   }
   public void initialiseImpl(){
      double dg = Functions.BisectionMethod(this, 0.5, 1.5, 0.0001);
      double anga1 = calcAngle( 1.0, dg, 0.5);
      double anga2 = Math.acos(dg / 2) / DEG2RAD;
      b = 180 - anga2*2;
      c = anga2 - anga1;
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double x2 = 2*ln + 2*ln*Math.cos( (180-b) * DEG2RAD);
      double y2 =        2*ln*Math.sin( (180-b) * DEG2RAD);
      double x3 = x2   + ln*Math.cos( (-b-c) * DEG2RAD);
      double y3 = y2   + ln*Math.sin( (-b-c) * DEG2RAD);
      double x4 = x2 - x3;
      double y4 = y2 - y3;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, 2*ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[5].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[10].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[10].getY(0)-tiles[0].getY(1);
   }

   public double calculate(double lnd){
      double anga1 = calcAngle( 1.0, lnd, 0.5);
      double ange = calcAngle( 0.5, 1.0, lnd);
      double anga2 = Math.acos(lnd / 2) / DEG2RAD;
      double angb = 180 - anga2*2;
      return anga1+anga2 + 2*angb + ange - 360;
   }
}
